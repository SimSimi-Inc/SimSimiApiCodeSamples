package com.simsimi.developer;

import java.util.Scanner;

/**
 * Client.java - a client class for requesting service to Simsimi Server.
 * 
 * @Project Simsimi API Example
 * @Date 2014.08.01
 * 
 * 
 */
public class Client {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		// Create SimsimiAPI instance.
		SimsimiAPI simsimiAPI = new SimsimiAPI(); 

		System.out.print("Input Text : ");
		
		// User enters a value for text.
		String text = input.nextLine();
		System.out.print("Input Language : "); 
		
		// User enters a value for language code.
		String languageCode = input.nextLine(); 
		
		// Create RequestParam instance.
		RequestParam requestParam = new RequestParam();
		
		requestParam.setText(text);
		requestParam.setLc(languageCode);
		
		// A response for requesting information. Response consists of JSON format.
		String response = simsimiAPI.request(requestParam);

		
		// Exception handling
		if (response == null) {
			System.out.println("Exception is generated.");
		} else {
			System.out.println(response);
		}

		input.close();

	}

}
