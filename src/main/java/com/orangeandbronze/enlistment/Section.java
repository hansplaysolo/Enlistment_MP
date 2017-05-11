package com.orangeandbronze.enlistment;

public class Section {
	
	private final String sectionID;
	private final Subject subject;
	private final Schedule schedule;
	private final Room room;
	private int numberOfStudents;
	
	public Section(String sectionID, Subject subject, Schedule schedule, Room room) {
		if (!sectionID.matches("[A-Za-z0-9]+")) {
			throw new IllegalArgumentException("Section ID should be alpha-numeric. Was: " + sectionID);
		}
		this.sectionID = sectionID;
		this.subject = subject;
		this.schedule = schedule;
		this.room = room;
		this.numberOfStudents = 0;
	}
	
	public void incrementNumberOfStudents(){
		if (numberOfStudents >= room.getCapacity()) {
			throw new RoomCapacityException("Cannot add more students inside this " + room.getName() + " room. Section Capacity: " + numberOfStudents + " Room Capacity: " + room.getCapacity());
		}
		numberOfStudents++;
	}
	
	public String getSubjectID(){
		return subject.getSubjectID();
	}
	
	public String getSubjectPrerequisite(){
		return subject.getPrequisite();
	}
	
	public void hasConflict(Section other){
		this.schedule.conflictWith(other.schedule);
	}

	@Override
	public String toString() {
		return "Section [sectionID=" + sectionID + ", schedule=" + schedule + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
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
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (sectionID == null) {
			if (other.sectionID != null)
				return false;
		} else if (!sectionID.equals(other.sectionID))
			return false;
		return true;
	}

}
