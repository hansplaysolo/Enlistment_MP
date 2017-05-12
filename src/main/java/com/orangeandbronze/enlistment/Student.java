package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Student {
	
	private final int studentNumber;
	private final Collection<EnlistmentForSemester> studentSemesterRecords = new HashSet<>();
	
	public Student (int studentNumber) {
		
		if (studentNumber < 0) {
			throw new IllegalArgumentException("Student number cannot be negative. Was: " +  studentNumber);
		}
		
		this.studentNumber = studentNumber;
		
	}
	
	public Collection<EnlistmentForSemester> getStudentSemesterRecords() {
		
		return new HashSet<>(this.studentSemesterRecords);
		
	}
	
	public void setStudentSemesterRecords(Collection<EnlistmentForSemester> finishedSections){
		studentSemesterRecords.addAll(finishedSections);
	}
	
	public void enlist(Section section){
		
		boolean newSemester = true;
		if (studentSemesterRecords.size() > 0) {
			for (EnlistmentForSemester record : studentSemesterRecords) {
				isNull(record);
				if (record.isOpen()) {
					newSemester = false;
					record.addStudentSection(this, section);
					break;
				}
			}
			
			if (newSemester) {
				addNewEnlistmentForSemester(section);
			}
			
		}else{
			addNewEnlistmentForSemester(section);
		}
		
	}

	private void addNewEnlistmentForSemester(Section section){
		EnlistmentForSemester record = new EnlistmentForSemester(SemesterState.OPEN);
		isNull(record);
		record.addStudentSection(this, section);
		addStudentSemesterRecord(record);
	}
	
	public void addStudentSemesterRecord(EnlistmentForSemester record) {
		studentSemesterRecords.add(record);
	}
	
	private void isNull(EnlistmentForSemester record) {
		if (Objects.isNull(record)) {
			throw new EnlistmentForSemesterNullPointerException("Initialize EnlistmentForSemester record first");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (studentNumber != other.studentNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + "]";
	}
	
	
}
