package com.zensar.prolm.exception;

@SuppressWarnings("serial")
public class DescriptionLengthException extends Exception {

	public DescriptionLengthException() {
	// TODO Auto-generated constructor stub
	super("Please describe in less than 500 characters...TRY AGAIN");
}
}
