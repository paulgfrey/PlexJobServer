package com.pf.plexjobserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.PropertyValueEncryptionUtils;

/**
 * Servlet implementation class SendEmailTLS
 */
@WebServlet(
		urlPatterns = { "/SendEmailTLS" }, 
		initParams = { 
				@WebInitParam(name = "mail.smtp.host", value = "smtp.gmail.com"), 
				@WebInitParam(name = "mail.smtp.port", value = "587"),
				@WebInitParam(name = "mail.smtp.auth", value = "true"),
				@WebInitParam(name = "mail.smtp.starttls.enable", value = "true")
		})
@MultipartConfig
public class SendEmailTLS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger LOG = Logger.getLogger(SendEmailTLS.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendEmailTLS() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Properties prop = new Properties();
		for(String name : Collections.list(getInitParameterNames())) {
			prop.setProperty(name, getInitParameter(name));
		}
		String key = request.getParameter("k");
		String u = request.getParameter("u");
		String username = "paulgfrey@gmail.com";
		String p = request.getParameter("p");
		String password = "";

		// Get parts 
		String to = "paulgfrey@gmail.com";
		String from = "paulgfrey@gmail.com";
		String subject = "None";
		StringBuffer body = new StringBuffer();
		for(Part part : request.getParts()) {
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream()))) {
				String line;
				while((line = reader.readLine()) != null) {
					if(line.startsWith("U:")) {
						u = getGroup(line, "U: (.*)", 1).trim();
					}
					else if(line.startsWith("P:")) {
						p = getGroup(line, "P: (.*)", 1).trim();
					}
					else if(line.startsWith("K:")) {
						key = getGroup(line, "K: (.*)", 1).trim();
					}
					else if(line.startsWith("To:")) {
						to = getGroup(line, "To: (.*)", 1).trim();
					}
					else if(line.startsWith("From:")) {
						from = getGroup(line, "From: (.*)", 1).trim();
					}
					else if(line.startsWith("Subject:")) {
						subject = getGroup(line, "Subject: (.*)", 1).trim();
					}
					else {
						body.append(line + "\n");
					}
				}
			}
		}
		if(! StringUtils.isAllEmpty(key)) {
			PBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
			encryptor.setPassword(key);	
			username = PropertyValueEncryptionUtils.decrypt(u, encryptor);
			password = PropertyValueEncryptionUtils.decrypt(p, encryptor);
		}
		else {
			username = u;
			password = p;
		}
		
		final String user = username;
		final String pass = password;
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, pass);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );
            message.setSubject(subject);
            message.setText(body.toString());

            Transport.send(message);

            response.getOutputStream().println("Sent");
        } catch (MessagingException e) {
        	LOG.error(String.format("Unable to send email with subject: %s error: %s!", subject, e.getMessage()), e);
            response.sendError(500, e.getMessage());
        }
	}
	
	private String getGroup(String content, String regex, int group) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		matcher.find();
		
		return matcher.group(group);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
