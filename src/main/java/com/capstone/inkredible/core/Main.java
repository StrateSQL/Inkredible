package com.capstone.inkredible.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
