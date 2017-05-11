package com.orangeandbronze.enlistment;

public class Subject {
	
	private String subjectID;
	private String prequisite;

	public Subject(String subjectID, String prequisite){
		if(!subjectID.matches("[a-zA-Z0-9]")){
			throw new IllegalArgumentException("Should have an alphanumeric subjectID. Was: " + subjectID);
		}
		
		this.subjectID = subjectID;
		this.prequisite = prequisite;
	}
}
