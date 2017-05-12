package com.orangeandbronze.enlistment;

@SuppressWarnings("serial")
public class SubjectPrerequisiteNotFoundException extends RuntimeException{
	public SubjectPrerequisiteNotFoundException(String message){
		super(message);
	}
}
