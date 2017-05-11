package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
	
	@Test
	public void prequisiteTest(){
		Student student = new Student(1);
		
		Subject subject1 = new Subject("Math01", "NONE");
		Subject subject2 = new Subject("Math02", "Math01");
		Subject subject3 = new Subject("Math03", "Math02");
		
		Schedule schedule1 = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		Schedule schedule2 = new Schedule(Days.MON_THU, Periods.H1000_H1130);
		Schedule schedule3 = new Schedule(Days.MON_THU, Periods.H1100_H1430);
		
		Room room1 = new Room("Room1", 5);
		Room room2 = new Room("Room2", 5);
		Room room3 = new Room("Room3", 5);
		
		Section IA = new Section("IA", subject1, schedule1, room1);
		Section IB = new Section("IB", subject1, schedule2, room2);
		Section IC = new Section("IC", subject2, schedule3, room3);
		
		Semester semester1 = new Semester(2017, Term.FIRSTSEMESTER);
		
		student.createEnlistmentForSemester(semester1);
		student.enlist(IA);
		student.enlist(IB);
		//student.enlist(IC);
	}

}
