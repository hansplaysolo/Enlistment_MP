package com.orangeandbronze.enlistment;

public class Subject {
	
	private String subjectID;
	private String prequisite;

	public Subject(String subjectID, String prequisite){
		if(!subjectID.matches("[a-zA-Z0-9]+")){
			throw new IllegalArgumentException("Should have an alphanumeric subjectID. Was: " + subjectID);
		}
		
		this.subjectID = subjectID;
		this.prequisite = prequisite;
	}
	
	public String getSubjectID(){
		return subjectID;
	}
	
	public String getPrequisite(){
		return prequisite;
	}
	
//	public void conflictWith(Subject other){
//		if (this.subjectID.equals(other.subjectID)) {
//			throw new IllegalArgumentException("You cannot enroll the same subject");
//		}
//		
//		if (this.prequisite.equals(other.prequisite)) {
//			throw new IllegalArgumentException("");
//		}
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (subjectID == null) {
			if (other.subjectID != null)
				return false;
		} else if (!subjectID.equals(other.subjectID))
			return false;
		return true;
	}


}
