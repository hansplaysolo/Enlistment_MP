package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class EnlistmentForSemester {

	private SemesterState semesterState;
	private final Collection<Section> enlistedSection = new HashSet<>();
	private Semester semester;
	
	public EnlistmentForSemester(SemesterState semesterState) {
		this.semesterState = semesterState;
	}
	
//	public EnlistmentForSemester(Semester semester){
//		this.semester = semester;
//	}
	
	public Collection<Section> getEnlistedSection(){
		
		return new HashSet<>(enlistedSection);
		
	}
	
	
	public boolean isOpen(){
		if (semesterState == SemesterState.OPEN) {
			return true;
		}else{
			return false;
		}
	}
	
	public void addStudentSection(Student student, Section section){
		
		if (this.enlistedSection.contains(section)) {
			throw new EnlistmentConflictingException("This " + section + " is already inside of " + this);
		}
		
		boolean matchSuccess = false;
		for (EnlistmentForSemester en : student.getStudentSemesterRecords()) {
			if (en.semesterState == SemesterState.CLOSED) {
				for (Section sc : en.getEnlistedSection()) {
					sc.hasSemesterConflict(section);
					sc.hasSubjectConflict(section);
					matchSuccess = sc.checkSubjectPrerequisite(en.getEnlistedSection(), section);
				}
			}
		}
		
		section.checkSubjectPrerequisiteMatchSuccess(matchSuccess);
		
		for (Section sc: this.enlistedSection) {
			sc.hasConflict(section);
		}
		
		section.incrementNumberOfStudents(student);
		this.enlistedSection.add(section);
		
	}
	
	public void closeSemester(){
		this.semesterState = semesterState.CLOSED;
	}
	
	@Override
	public String toString() {
		return "EnlistmentForSemester [semesterState=" + semesterState + ", enlistedSection=" + enlistedSection + "]";
	}

}
