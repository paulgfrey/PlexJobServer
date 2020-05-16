package com.pf.plexjobserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

/**
 * This class is just a wrapper for running the Linux script: <SCRIPTDIR>/plex_video_iwatch.sh
 *
 */
public class JobExecutor {
	private static Logger LOG = Logger.getLogger(JobExecutor.class);
	private final static String SCRIPTDIR = "/mnt/htpcdrive/plex/conv/scripts";
	private String stdOutStr;
	private String stdErrStr;
	private String user;
	private String videoFile;
	private String event;

	public JobExecutor(String user, String videoFile, String event) {
		this.user = user;
		this.videoFile = videoFile;
		this.event = event;
	}
	
	public void execute() throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ByteArrayOutputStream error = new ByteArrayOutputStream();
		ProcessBuilder processBuilder = new ProcessBuilder("sudo", "-u", user, "-i",
														SCRIPTDIR + "/plex_video_iwatch.sh",
														videoFile,
														event);
		LOG.info("ProcessBuilder = " + processBuilder.command());
		Process process = processBuilder.start();
        copy(process.getInputStream(), output);
        copy(process.getErrorStream(), error);
        stdOutStr = new String(output.toByteArray());
        stdErrStr = new String(error.toByteArray());
        try {
			process.waitFor();
		} catch (InterruptedException e) {
			throw(new IOException(e));
		}
        if(process.exitValue() != 0) {
        	LOG.error("process.exitValue = " + process.exitValue());
        	LOG.error("error = " + stdErrStr);
        	throw(new IOException(stdErrStr));
        }
        else {
        	LOG.debug("Output = " + stdOutStr);
        }
	}
		
	private static void copy(InputStream in, OutputStream out) throws IOException {
        while (true) {
            int c = in.read();
            if (c == -1) {
                break;
            }
            out.write((char) c);
        }
    }

	public String getStdOutStr() {
		return stdOutStr;
	}

	public String getStdErrStr() {
		return stdErrStr;
	}
}
