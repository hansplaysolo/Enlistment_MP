package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class StudentTest {
	
	//this part of test have not been refined.
	@Test
	public void prequisiteTest(){
		Semester semester1 = new Semester(2017, SemesterType.FIRSTSEMESTER);
		Semester semester2 = new Semester(2017, SemesterType.SECONDSEMESTER);
		Semester semester3 = new Semester(2017, SemesterType.FIRSTSEMESTER);
		
		Student student = new Student(1);
		
		Subject subjectMath = new Subject("Math01", Arrays.asList("NONE"));
		Subject subjectEng = new Subject("ENGLISH01", Arrays.asList("NONE"));
		Subject subjectPE = new Subject("PE01", Arrays.asList("NONE"));
		
		Subject subjectMath2 = new Subject("Math02", Arrays.asList("MATH01"));
		Subject subjectEng2 = new Subject("ENGLISH02", Arrays.asList("ENGLISH01"));
		
		Subject subjectPE2 = new Subject("PE02", Arrays.asList("PE01"));
		
		Subject subjectMath3 = new Subject("Math03", Arrays.asList("MATH01", "MATH02"));
		Subject subjectEng3 = new Subject("English03", Arrays.asList("ENGLISH01", "ENGLISH02"));
		Subject subjectPE3 = new Subject("PE03", Arrays.asList("PE01", "PE02"));
		
		Schedule schedule1 = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		Schedule schedule2 = new Schedule(Days.TUE_FRI, Periods.H1000_H1130);
		Schedule schedule3 = new Schedule(Days.WED_SAT, Periods.H1100_H1430);
		Schedule schedule4 = new Schedule(Days.MON_THU, Periods.H1130_H1100);
		Schedule schedule5 = new Schedule(Days.TUE_FRI, Periods.H1430_H1600);
		Schedule schedule6 = new Schedule(Days.WED_SAT, Periods.H1600_H1730);
		
		Room room1 = new Room("Room1", 5);
		Room room2 = new Room("Room2", 5);
		Room room3 = new Room("Room3", 5);
		
		Section IA = new Section("IA", subjectMath, semester1, schedule1, room1);
		Section IB = new Section("IB", subjectEng, semester1, schedule2, room2);
		Section IC = new Section("IC", subjectPE, semester1, schedule3, room1);
		
		Section IE = new Section("IE", subjectMath2, semester2, schedule1, room1);
		Section IF = new Section("IF", subjectEng2, semester2, schedule5, room2);
		Section IG = new Section("IG", subjectPE2, semester2, schedule6, room3);

		student.enlist(IA);
		student.enlist(IB);
		student.enlist(IC);
		student.close();
		
		student.enlist(IE);
		student.enlist(IF);
		student.enlist(IG);
	}

}
