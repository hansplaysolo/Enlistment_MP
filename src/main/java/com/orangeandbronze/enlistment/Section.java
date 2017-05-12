package com.orangeandbronze.enlistment;

import java.util.Collection;
import java.util.HashSet;

public class Section {
	
	private final String sectionID;
	private final Subject subject;
	private final Schedule schedule;
	private final Room room;
	private final Semester semester;
	private Collection<Student> students = new HashSet<Student>(); 
	
	public Section(String sectionID, Subject subject, Semester semester, Schedule schedule, Room room) {
		
		if (!sectionID.matches("[a-zA-Z0-9]+")) {
			throw new IllegalArgumentException("Section ID should be alpha-numeric. Was: " + sectionID);
		}
		this.sectionID = sectionID;
		this.subject = subject;
		this.schedule = schedule;
		this.room = room;
		this.semester = semester;
		
	}
	
	public void incrementNumberOfStudents(Student student){
		
		if (students.size() >= room.getCapacity()) {
			throw new RoomCapacityException("Cannot add more students inside this " + 
											room.getName() + " room. Section Capacity: " + 
											students.size() + " Room Capacity: " + 
											room.getCapacity());
		}
		students.add(student);
		
	}
	
	public void hasSemesterSubjectConflict(Section other){
		this.semester.conflictWith(other.semester);
	}
	
	public void hasSemesterConflict(Section other){
		this.semester.conflictWith(other.semester);
	}
	
	public void hasSubjectConflict(Section other){
		this.subject.conflictWith(other.subject);
	}
	
	public void hasScheduleConflict(Section other){
		this.schedule.conflictWith(other.schedule);
	}
	
	public boolean checkSubjectPrerequisite(Collection<Section> enlistedSection, Section other){
		
		int successValue = 0;
		Collection<String> otherPrerequisite = other.subject.getPrequisite();
				
		for (Section section : enlistedSection) {
			for (String requirements : otherPrerequisite) {	
				if (!requirements.equals("NONE")) {
					if (section.subject.getSubjectID().equals(requirements)) {
						successValue += 1;
					}
				}
			}
		}
		
		if (successValue == otherPrerequisite.size()) {
			return true;
		}else{
			return false;
		}
		
	}
	
	public void checkSubjectPrerequisiteMatchSuccess(boolean matchSuccess){
		for (String requirements : this.subject.getPrequisite()) {
			if (!requirements.equals("NONE")) {
				if (!matchSuccess) {
					throw new SubjectException("The student does not have this prerequisite subject: " + this.subject.getPrequisite());
				}
			}
		}
	}
	
	public void hasConflict(Section other){
		hasSubjectConflict(other);
		hasScheduleConflict(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sectionID == null) ? 0 : sectionID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Section other = (Section) obj;
		if (sectionID == null) {
			if (other.sectionID != null)
				return false;
		} else if (!sectionID.equals(other.sectionID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Section [sectionID=" + sectionID + ", subject=" + subject + "]";
	}
	
	
	
}
