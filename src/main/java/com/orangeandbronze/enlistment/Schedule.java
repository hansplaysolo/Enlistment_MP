package com.orangeandbronze.enlistment;

public class Schedule {

	private final Days days;
	private final Time startTime;
	private final Time endTime;
	
	public Schedule(Days days, Time startTime, Time endTime){
		if(startTime.ordinal() >= endTime.ordinal()){
			throw new ScheduleConflictException("End time: " + endTime +"must be later than start time: " + startTime);
		}
		
		this.days = days;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public void conflictWith(Schedule other){
		if (this.equals(other)) {

			
			
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
		if (endTime != other.endTime)
			return false;
		if (startTime != other.startTime)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Schedule day: " + days + " Time: " + startTime + "-" + endTime;
	}
	
}
