package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
	@Test
	public void studentTest_ExceedRoomCapacity() {
		Student student = new Student(10);
		Student student1 = new Student(10);
		Student student2 = new Student(10);
		Student student3 = new Student(10);
		Student student4 = new Student(10);
		
		Schedule schedule1 = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		Room room1 = new Room("SEC01", 3);
		
		Section section1 = new Section("SEC01", schedule1, room1);
		
		student.enlist(section1);
		student1.enlist(section1);
		student2.enlist(section1);
		//student3.enlist(section1);
		//student4.enlist(section1);
	}

}
