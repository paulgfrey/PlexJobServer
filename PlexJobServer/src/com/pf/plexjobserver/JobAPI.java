package com.pf.plexjobserver;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class JobAPI
 */
@WebServlet(description = "Rest Plex Job API", urlPatterns = { "/JobAPI" })
public class JobAPI extends HttpServlet {
	private static Logger LOG = Logger.getLogger(JobAPI.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobAPI() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			performTask(request, response);
		}
		catch(Exception e) {
			LOG.error(e);
			throw(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}
	
	private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		String file = null;
		String event = null;
		String username = "paulf";
		
		file = request.getParameter("file");
		event = request.getParameter("event");
		if(file == null) {
			throw(new ServletException("Missing file parameter!"));
		}
		if(event == null) {
			throw(new ServletException("Missing event parameter!"));
		}
		String hostname = InetAddress.getLocalHost().getHostName();
		LOG.info("hostname=" + hostname);
		if(hostname.toLowerCase().contains("odroid")) {
			username = "odroid";
		}
		LOG.info("file=" + file + ", event=" + event);
		JobExecutor job = new JobExecutor(username, file, event);
		try {
			job.execute();
		}
		catch(Exception e) {
        	LOG.error("error = " + job.getStdErrStr());
        	throw(new ServletException(job.getStdErrStr()));
		}
    	out.println("<PRE>");
    	out.println(job.getStdOutStr());
    	LOG.debug("Output = " + job.getStdOutStr());
    	out.println("</PRE>");
	}
}
