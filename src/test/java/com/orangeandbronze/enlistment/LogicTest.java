package com.orangeandbronze.enlistment;

import org.junit.Test;

public class LogicTest {

	@Test
	public void test() {
		Student student = new Student(10);
		Schedule schedule1 = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		Room room1 = new Room("SEC01", 3);
		
		//initialize Subjects
		Subject subject1 = new Subject("Math01", "NONE");
		Subject subject2 = new Subject("Math02", "Math02");
		Subject subject3 = new Subject("Math03", "Math03");
		Subject subject4 = new Subject("Math04", "Math04");
		Subject subject5 = new Subject("Math05", "Math05");
		Subject subject6 = new Subject("Math06", "Math06");

		//Initialize Sections
		Section IA = new Section("IA", subject1, schedule1, room1);
		Section IB = new Section("IB", subject2, schedule1, room1);
		Section IC = new Section("IC", subject3, schedule1, room1);
		Section ID = new Section("ID", subject4, schedule1, room1);
		Section IE = new Section("IE", subject5, schedule1, room1);
		Section IF = new Section("IF", subject6, schedule1, room1);
		
		student.enlist(IA);
	
	}

}
