package com.pf.plexapi.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.PropertyValueEncryptionUtils;

public class PlexEncryptedStringXmlAdapter extends XmlAdapter<String, String> {
	private static String keyFile = System.getProperty("user.home") + "/plexapi.txt";
	private Logger logger = LogManager.getLogger(getClass());
	private final PBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

	/**
	 * Constructor. Reads the password from a key file on disk
	 */
	public PlexEncryptedStringXmlAdapter() {
		try {
			String key = FileUtils.readFileToString(new File(keyFile)).replaceAll(System.getProperty("line.separator"), "");
			logger.debug("[key=" + key + "]");
			encryptor.setPassword(key);			
		}
		catch(IOException io) {
			logger.error("Unable to read file " + keyFile + "!", io);
			throw(new RuntimeException("Unable to continue, failure to load " + keyFile + "!", io));
		}
	}

	@Override
	public String unmarshal(String cyphertext) throws Exception {
		// Perform decryption operations as needed and store the new values
		if (PropertyValueEncryptionUtils.isEncryptedValue(cyphertext))
			return PropertyValueEncryptionUtils.decrypt(cyphertext, encryptor);

		return cyphertext;
	}

	@Override
	public String marshal(String plaintext) throws Exception {
		// This encrypts and adds the ENC(...)
		return PropertyValueEncryptionUtils.encrypt(plaintext, encryptor);
	}
}
