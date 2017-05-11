package com.orangeandbronze.enlistment.service;

import com.orangeandbronze.enlistment.Section;
import com.orangeandbronze.enlistment.Student;
import com.orangeandbronze.enlistment.DAO.SectionDAO;
import com.orangeandbronze.enlistment.DAO.StudentDAO;

public class EnlistmentService {
	
	private StudentDAO studentDAO;
	private SectionDAO sectionDAO;
	
	public void enlist(int studentNumber, String sectionID){
		Student student = studentDAO.findByStudentNumber(studentNumber);
		Section sectionEnlist = sectionDAO.findBySectionID(sectionID);
		
		student.enlist(sectionEnlist);
		
		studentDAO.save(student);
		sectionDAO.save(sectionEnlist);
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public SectionDAO getSectionDAO() {
		return sectionDAO;
	}

	public void setSectionDAO(SectionDAO sectionDAO) {
		this.sectionDAO = sectionDAO;
	}

}
