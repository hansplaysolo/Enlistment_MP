package com.orangeandbronze.enlistment.DAO;

import com.orangeandbronze.enlistment.Student;

public interface StudentDAO {
	
	Student findByStudentNumber(int studentNumber);
	void save(Student student);
	
}
