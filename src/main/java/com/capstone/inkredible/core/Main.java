package com.capstone.inkredible.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.capstone.printify.connector.PrintifyConnector;

import java.util.concurrent.CompletableFuture;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		doSomething();
	}

	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void doSomething() {
		logger.info("This is an info message.");
		logger.error("This is an error message.");
	}

	public static void test() {
		// Create an instance of PrintifyAPIInterface
		PrintifyConnector apiInterface = new PrintifyConnector();

		// Specify the API endpoint you want to access
		String endpoint = "your-api-endpoint-here"; // Replace with the actual endpoint

		// Make an asynchronous API request
		CompletableFuture<String> apiResponse = apiInterface.getApiData(endpoint);

		// Define what to do when the API response is available
		apiResponse.thenAccept(responseBody -> {
			// Handle the API response here
			System.out.println("API Response:");
			System.out.println(responseBody);
		});

		// Continue with other tasks if needed (without blocking)
		System.out.println("Waiting for API response...");

		// Sleep or perform other tasks here while the API response is being fetched
		// asynchronously
		try {
			Thread.sleep(2000); // Sleep for 2 seconds as an example
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
