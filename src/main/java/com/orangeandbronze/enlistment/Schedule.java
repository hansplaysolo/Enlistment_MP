package com.orangeandbronze.enlistment;

public class Schedule {

	private final Days days;
	private final Time startTime;
	private final Time endTime;
	
	public Schedule(Days days, Time startTime, Time endTime){
		if(startTime.ordinal() >= endTime.ordinal()){
			throw new ScheduleConflictException("");
		}
		
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void conflictWith(Schedule other){
		int thisST = this.startTime.ordinal();
		int thisET = this.endTime.ordinal();
		
		int otherST = other.startTime.ordinal();
		int otherET = other.endTime.ordinal();
		
		if (this.equals(other)) {
			throw new ScheduleConflictException("");
		}
		
		if (otherST > thisST && otherST < thisET ) {
			throw new ScheduleConflictException("");
		}
		
		if (otherET > thisST && otherET < thisET ) {
			throw new ScheduleConflictException("");
		}

		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Schedule other = (Schedule) obj;
		if (days != other.days)
			return false;
		if (startTime != other.startTime && endTime != other.endTime)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Schedule day: " + days + " Time: " + startTime + "-" + endTime;
	}
	
}
