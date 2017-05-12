package com.orangeandbronze.enlistment.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.orangeandbronze.enlistment.Days;
import com.orangeandbronze.enlistment.Periods;
import com.orangeandbronze.enlistment.Room;
import com.orangeandbronze.enlistment.Schedule;
import com.orangeandbronze.enlistment.Section;
import com.orangeandbronze.enlistment.Semester;
import com.orangeandbronze.enlistment.Student;
import com.orangeandbronze.enlistment.Subject;
import com.orangeandbronze.enlistment.Time;
import com.orangeandbronze.enlistment.SemesterType;
import com.orangeandbronze.enlistment.DAO.SectionDAO;
import com.orangeandbronze.enlistment.DAO.StudentDAO;

public class EnlistmentServiceTest {

	@Test
	public void successfulEnlistment() {
		
		Student student = new Student(1);
		Schedule schedule_SEC01 = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		Room room_SEC01 = new Room("SEC01", 30);
		
		Subject subject1 = new Subject("math01", Arrays.asList("NONE"));
		Semester semester1 = new Semester(2017, SemesterType.FIRSTSEMESTER);
		Section section_SEC01 = new Section("SEC01", subject1, semester1, schedule_SEC01, room_SEC01);
		
		EnlistmentService enlistmentService = new EnlistmentService();
		
		StudentDAO studentDAO = mock(StudentDAO.class);
		SectionDAO sectionDAO = mock(SectionDAO.class);
		
		enlistmentService.setStudentDAO(studentDAO);
		enlistmentService.setSectionDAO(sectionDAO);
		
		when(studentDAO.findByStudentNumber(1)).thenReturn(student);
		when(sectionDAO.findBySectionID("SEC01")).thenReturn(section_SEC01);

		enlistmentService.enlist(1, "SEC01");
		
		verify(studentDAO).save(student);
		verify(sectionDAO).save(section_SEC01);
		
	}

}
