package com.rest.animal.exception;

public class AnimalNotFoundException extends RuntimeException {

	public AnimalNotFoundException(String message){
		super(message);
	}
}
