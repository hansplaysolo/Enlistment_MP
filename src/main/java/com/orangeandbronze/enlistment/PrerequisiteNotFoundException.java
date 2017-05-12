package com.orangeandbronze.enlistment;

@SuppressWarnings("serial")
public class PrerequisiteNotFoundException extends RuntimeException{
	public PrerequisiteNotFoundException(String message){
		super(message);
	}
}
