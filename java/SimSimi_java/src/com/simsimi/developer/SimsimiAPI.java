package com.simsimi.developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * SimsimiAPI.java - a class represents for requesting information to Server.
 * 
 * @Project Simsimi API Example
 * @Date 2014.08.01
 * 
 */
public class SimsimiAPI {

	private BufferedReader bufferReader;
	private HttpURLConnection httpConn;
	private InputStreamReader inputStreamReader;
	private InputStream stream;
	private String buffer;
	private String result;
	private final String url = "http://sandbox.api.simsimi.com/request.p";

	public SimsimiAPI() {
		bufferReader = null;
		httpConn = null;
		buffer = null;
		result = null;
	}

	/**
	 * @param requestParam
	 *            for receiving request information.
	 * @return A String data type.
	 * @exception UnsupportedEncodingException
	 *                if the Encoding doesn't have correct Encoding-value.
	 */
	public String request(RequestParam requestParam) {
		try {
			
			String key = requestParam.getKey();
			String lc = requestParam.getLc();
			double ft = requestParam.getFt();
			
			// Because of supporting 45 Languages, Encoding is UTF-8.
			String text = URLEncoder.encode(requestParam.getText(), "UTF-8");

			String requestURL = url + "?key=" + key + "&lc=" + lc + "&ft=" + ft
					+ "&text=" + text;

			URL openURL = new URL(requestURL);
			httpConn = (HttpURLConnection) openURL.openConnection();

			// set RequestMethod "GET", requesting information to Server.
			httpConn.setRequestMethod("GET");

			httpConn.connect(); // Network connection for URL's designated
								// resource.
			
			stream = openURL.openStream();
			inputStreamReader = new InputStreamReader(stream, "UTF-8");
			bufferReader = new BufferedReader(inputStreamReader);

			while ((buffer = bufferReader.readLine()) != null) {
				if (buffer.length() > 1) {
					result = buffer;
				}
			}
		} catch (UnsupportedEncodingException e) {
			System.out.println("UnsupportedEncodingException is generated.");
		} catch (IOException e) {
			System.out.println("IOException is generated.");
		} finally {

			// InputStream is closed.
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					System.out.println("InputStream is not closed.");
				}
			}

			// InputStreamReader is closed.
			if (inputStreamReader != null)
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					System.out.println("InputStreamReader is not closed.");
				}

			// BufferedReader is closed.
			if (bufferReader != null)
				try {
					bufferReader.close();
				} catch (IOException e) {
					System.out.println("BufferedReader is not closed.");
				}
			
			// HttpURLConnection is disconnected.
			if (httpConn != null)
				try {
					httpConn.disconnect();
				} catch (Exception e) {
					System.out.println("HttpURLConnection is not closed.");
				}
		}

		return result; // return Server's response information which consists of
						// JSON Format.
	}

}
