package com.orangeandbronze.enlistment;

@SuppressWarnings("serial")
public class ScheduleConflictingException extends RuntimeException{
	
	public ScheduleConflictingException (String message){
		super(message);
	}
	
}
