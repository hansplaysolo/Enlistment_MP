package com.orangeandbronze.enlistment;

public class Schedule {
	private final Days days;
	private final Periods periods;
	
	public Schedule(Days days, Periods periods) {
		this.days = days;
		this.periods = periods;
	}
	
	public void conflictWith(Schedule other){
		if (this.equals(other)) {
			throw new ScheduleConflictingException("This " + this + " is in confict with " + other);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((days == null) ? 0 : days.hashCode());
		result = prime * result + ((periods == null) ? 0 : periods.hashCode());
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
		if (periods != other.periods)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Schedule [days=" + days + ", periods=" + periods + "]";
	}
}
