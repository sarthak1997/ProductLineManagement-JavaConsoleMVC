package com.zensar.prolm.exception;

@SuppressWarnings("serial")
public class InvalidNameException extends Exception {

	public InvalidNameException() {
		// TODO Auto-generated constructor stub
		
		super("Product Name can't start with a digiit...TRY AGAIN");
	}
}
