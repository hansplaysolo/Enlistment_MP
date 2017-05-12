package com.orangeandbronze.enlistment;

public class Semester {
	
	private final int schoolYear;
	private final SemesterType type; 
	
	public Semester(int schoolYear, SemesterType term){
		this.schoolYear = schoolYear;
		this.type = term;
	}
	
	public void conflictWith(Semester other){
		if (this.equals(other)) {
			throw new SemesterConflictException("This " + this + " is in confict with " + other);
		}
	}
	
	@Override
	public String toString() {
		return type + ", School year: " + schoolYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schoolYear;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Semester other = (Semester) obj;
		if (schoolYear != other.schoolYear)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
