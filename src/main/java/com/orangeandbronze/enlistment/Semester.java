package com.orangeandbronze.enlistment;

public class Semester {
	
	private int schoolYear;
	private Term term; 
	
	public Semester(int schoolYear, Term term){
		this.schoolYear = schoolYear;
		this.term = term;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + schoolYear;
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		if (term != other.term)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Semester [schoolYear=" + schoolYear + ", term=" + term + "]";
	}
}
