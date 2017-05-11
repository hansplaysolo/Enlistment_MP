package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class Student {
	
	private final int studentNumber;
	private Collection<String> finishedSubjects = new HashSet<>();
	private EnlistmentForSemester enlistmentForSemester;
	
	public Student (int studentNumber) {
		
		if (studentNumber < 0) {
			throw new IllegalArgumentException("Student Number cannot be negative. Was: " +  studentNumber);
		}
		
		this.studentNumber = studentNumber;
	}
	
	public Collection<String> getFinishedSubjects() {
		return new HashSet<>(this.finishedSubjects);
	}
	
	public void addFinishSubject(String subjectName) {
		finishedSubjects.add(subjectName);
	}
	
	public EnlistmentForSemester getEnlistmentForSemester(){
		return enlistmentForSemester;
	}
	
	public void createEnlistmentForSemester(Semester semester){
		enlistmentForSemester = new EnlistmentForSemester(semester);
	}
	
	public void enlist(Section section){
		if (enlistmentForSemester == null) {
			throw new NullEnlistmentForSemesterException("You did not create an enlistmentForSemester Object");
		}
		enlistmentForSemester.addStudentSection(this, section);
	}
}
