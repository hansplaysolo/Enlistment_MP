package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class EnlistmentForSemester {
	private Semester semester;
	private Collection<Section> enlistedSection = new HashSet<>();
	
	
	public EnlistmentForSemester(Semester semester){
		this.semester = semester;
	}
	
	public void addStudentSection(Student student, Section section){
		if (this.enlistedSection.contains(section)) {
			throw new RuntimeException("Enlisted already inside section: " + section);
		}
		
		for (Section s: this.enlistedSection) {
			s.hasConflict(section);
			if (s.getSubjectID().equals(section.getSubjectID())) {
				throw new RuntimeException("You cannot add the same subject");
			}
		}
		
		if (student.getFinishedSubjects().size() > 0) {
			for (String s: student.getFinishedSubjects()) {
				if (s.equals(section.getSubjectPrerequisite())) {
					throw new RuntimeException("You cannot add this subject because you already finish it");
				}
			}
		}else{
			if (!section.getSubjectPrerequisite().toUpperCase().equals("NONE")) {
				throw new RuntimeException("You cannot add this subject because you haven't finish it");
			}
		}
		
		section.incrementNumberOfStudents();
		this.enlistedSection.add(section);
	}
	
	public void setFinishedSubjects(Student student) {
		for (Section s : enlistedSection) {
			student.addFinishSubject(s.getSubjectID());
		}
	}
}
