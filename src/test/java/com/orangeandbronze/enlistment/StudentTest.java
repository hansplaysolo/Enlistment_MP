package com.orangeandbronze.enlistment;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
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
		
		Schedule schedule1 = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		Schedule schedule2 = new Schedule(Days.TUE_FRI, Time.H1000, Time.H1200);
		Schedule schedule3 = new Schedule(Days.WED_SAT, Time.H1200, Time.H1400);
		Schedule schedule4 = new Schedule(Days.MON_THU, Time.H1400, Time.H1600);
		Schedule schedule5 = new Schedule(Days.TUE_FRI, Time.H1600, Time.H1800);
		Schedule schedule6 = new Schedule(Days.WED_SAT, Time.H0800, Time.H1000);
		
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
		
		
//		student.enlist(IE);
//		student.enlist(IF);
//		student.enlist(IG);
		
	}
	
	@Test
	public void enlist_Onesection(){
		Student student = new Student(1);
		
		Collection<String> prerequisites1 = new ArrayList();
		Subject math1 = new Subject("MATH1", prerequisites1);
		
		Semester semester = new Semester(2017, SemesterType.FIRSTSEMESTER);
		Schedule schedule = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		Room room = new Room("1A", 10);
		
		Section section1 = new Section("ABC123", math1, semester, schedule, room);
		
		student.enlist(section1);
		
		assertEquals(1,student.getStudentSemesterRecords().size());
	}
	
	@Test(expected=SubjectConflictException.class)
	public void enlist_Onesection_withUntakenPrerequisite(){
		Student student = new Student(1);
		
		Collection<String> prerequisites1 = new ArrayList();
		
		//Subject math1 = new Subject("ENG2", prerequisites1);
		prerequisites1.add("ENG1");
		Subject math2 = new Subject("ENG2", prerequisites1);
		Semester semester = new Semester(2017, SemesterType.FIRSTSEMESTER);
		Schedule schedule = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		Room room = new Room("1A", 10);
		
		Section section1 = new Section("ABC123", math2, semester, schedule, room);
		
		student.enlist(section1);
	}
	
	
	@Test
	@Ignore
	public void enlist_TwoSection_SameSemester_withOneIsPrerequisitetoTheOther(){
		Student student = new Student(1);
		
		Collection<String> prerequisites1 = new ArrayList();
		
		Subject eng1 = new Subject("ENG1", prerequisites1);
		prerequisites1.add("ENG1");
		Subject math2 = new Subject("ENG2", prerequisites1);
		
		Semester semester1 = new Semester(2017, SemesterType.FIRSTSEMESTER);
		Semester semester2 = new Semester(2017, SemesterType.SECONDSEMESTER);

		Schedule schedule = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		
		Room room = new Room("1A", 10);
		
		
		
		Section section1 = new Section("ABC123", eng1, semester1, schedule, room);
		Section section2 = new Section("DEF456", math2, semester2, schedule, room);

		student.enlist(section1);
		student.enlist(section2);
	}

}
