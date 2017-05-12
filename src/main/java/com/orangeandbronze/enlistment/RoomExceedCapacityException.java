package com.orangeandbronze.enlistment;

@SuppressWarnings("serial")
public class RoomExceedCapacityException extends RuntimeException{
	public RoomExceedCapacityException (String message){
		super(message);
	}
}
