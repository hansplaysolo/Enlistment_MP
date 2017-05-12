package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class Subject {
	
	private final String subjectID;
	private final Collection<String> prerequisite = new HashSet<String>();
	
	public Subject(String subjectID, Collection<String> prerequisite){
		if(!subjectID.matches("[a-zA-Z0-9]+")){
			throw new IllegalArgumentException("Should have an alphanumeric subjectID. Was: " + subjectID);
		}
		
		this.subjectID = subjectID.toUpperCase();
		if (prerequisite.isEmpty()){
			prerequisite = new HashSet<String>();
			prerequisite.add("NONE");
		}
		
		for (String s : prerequisite) {
			this.prerequisite.add(s.toUpperCase());
		}
	}
	
	public String getSubjectID(){
		return subjectID;
	}
	
	public Collection<String> getPrequisite(){
		return new HashSet<>(this.prerequisite);
	}
	
	public void conflictWith(Subject other){
		
		if (this.subjectID.equals(other.subjectID)) {
			throw new SubjectConflictException("This " + this + " is in confict with " + other);
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prerequisite == null) ? 0 : prerequisite.hashCode());
		result = prime * result + ((subjectID == null) ? 0 : subjectID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (prerequisite == null) {
			if (other.prerequisite != null)
				return false;
		} else if (!prerequisite.equals(other.prerequisite))
			return false;
		if (subjectID == null) {
			if (other.subjectID != null)
				return false;
		} else if (!subjectID.equals(other.subjectID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return subjectID;
	}

}
