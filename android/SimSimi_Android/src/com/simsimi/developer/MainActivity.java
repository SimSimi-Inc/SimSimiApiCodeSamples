package com.simsimi.developer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView message; // This is a message which will be changed by
								// client's request.
	TextView text; // Text
	TextView lc; // Language code
	private EditText text_editText; // Input text
	private EditText lc_editText; // Input LC(Language Code)
	Button request_button; // Request Button
	private SimsimiAPI simsimiAPI; // a class represents for requesting
									// information to Server.(AsyncTask)
	private String result = "Fail";
	private BufferedReader bufferReader = null;
	private InputStreamReader inputStreamReader = null;
	private String buffer = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		text = (TextView) findViewById(R.id.text);
		lc = (TextView) findViewById(R.id.lc);
		request_button = (Button) findViewById(R.id.request_button);
		text_editText = (EditText) findViewById(R.id.text_editText);
		lc_editText = (EditText) findViewById(R.id.lc_editText);
		simsimiAPI = new SimsimiAPI();

	}

	/**
	 * @param v
	 *            A variable of type View.
	 * 
	 */
	public void OnGetClick(View v) {
		message = (TextView) findViewById(R.id.message);
		simsimiAPI.execute(message);

	}

	/**
	 * SimsimiAPI extends AsyncTask because we can process background work
	 * easily.
	 * 
	 */
	public class SimsimiAPI extends AsyncTask<TextView, Void, String> {

		private TextView response;

		// process background work
		protected String doInBackground(TextView... params) {

			this.response = params[0];
			return makeHttpRequest();

		}

		// request information to Simsimi Server
		final String makeHttpRequest() {
			String key = "d6bbfd1b-7cb3-4cfe-87b1-261e4d210d19";
			String lc = lc_editText.getText().toString();
			double ft = 0.0;

			try {

				String text = URLEncoder.encode(text_editText.getText()
						.toString(), "UTF-8");
				String url = "http://sandbox.api.simsimi.com/request.p?key="
						+ key + "&lc=" + lc + "&ft=" + ft + "&text=" + text;
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpRequest = new HttpGet(url);

				HttpResponse response = httpClient.execute(httpRequest);

				inputStreamReader = new InputStreamReader(response.getEntity()
						.getContent());
				bufferReader = new BufferedReader(inputStreamReader);

				while ((buffer = bufferReader.readLine()) != null) {
					if (buffer.length() > 1) {
						result = buffer;
					}
				}
			} catch (UnsupportedEncodingException e) {
				System.out
						.println("UnsupportedEncodingException is generated.");
			} catch (IOException e) {

				System.out.println("IOException is generated.");

			} finally {

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
			}

			return result; // return Server's response information which
							// consists of JSON Format.

		} // end of makeHttpRequest method

		/**
		 * After background works finisheds, This method is called. Result of
		 * doInBackground method is transmitted to onPostExecute's parameter
		 */
		protected void onPostExecute(String page) {
			response.setText(page);
		}
	}

	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
