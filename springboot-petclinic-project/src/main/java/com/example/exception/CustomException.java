package com.example.exception;

public class CustomException extends Exception {

	public CustomException() {
		super("No appointment maps to this id, please check ! ");
	}
	
}
