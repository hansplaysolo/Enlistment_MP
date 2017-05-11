package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class Student {
	
	private final int studentNumber;
	private Collection<Section> enlistedSection = new HashSet<>();
	
	//private Collection<String> finishEnlistedSubjects = new HashSet<>();
	
	public Student (int studentNumber) {
		
		if (studentNumber < 0) {
			throw new IllegalArgumentException("Student Number cannot be negative. Was: " +  studentNumber);
		}
		
		this.studentNumber = studentNumber;
	}
	
	public Collection<Section> getEnlistedSection() {
		return new HashSet<>(this.enlistedSection);
	}
	
	public void enlist(Section section){
		if (this.enlistedSection.contains(section)) {
			throw new RuntimeException("Enlisted already inside section: " + section);
		}
		
		for (Section s: this.enlistedSection) {
			s.hasConflict(section);
		}
		
		section.incrementNumberOfStudents();
		this.enlistedSection.add(section);
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", enlistedSection=" + enlistedSection + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enlistedSection == null) ? 0 : enlistedSection.hashCode());
		result = prime * result + studentNumber;
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
		Student other = (Student) obj;
		if (enlistedSection == null) {
			if (other.enlistedSection != null)
				return false;
		} else if (!enlistedSection.equals(other.enlistedSection))
			return false;
		if (studentNumber != other.studentNumber)
			return false;
		return true;
	}
	

}
