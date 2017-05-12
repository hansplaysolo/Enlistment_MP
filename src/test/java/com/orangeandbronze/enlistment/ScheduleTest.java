package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleTest {

	@Test
	public void sameScheduleConflict() {
		Schedule schedule1 = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		Schedule schedule2 = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		
		//TODO edit conflictWith method
		schedule1.conflictWith(schedule2);
	}

	@Test(expected=ScheduleConflictException.class)
	public void startTime_EndTime_Conflict(){
		new Schedule(Days.MON_THU, Time.H1900, Time.H0800);
	}
	
	@Test
	public void overlappingStartTime_SameDay(){
		Schedule schedule = new Schedule(Days.MON_THU,Time.H0800, Time.H1000);
		Schedule otherSchedule = new Schedule(Days.MON_THU, Time.H0830,Time.H1100);
		
		schedule.conflictWith(otherSchedule);
	}
	
	@Test
	public void overlappingEndTime_SameDay(){
		Schedule schedule = new Schedule(Days.MON_THU,Time.H1000, Time.H1200);
		Schedule otherSchedule = new Schedule(Days.MON_THU, Time.H0800,Time.H1030);
		
		schedule.conflictWith(otherSchedule);
	}
	
	@Test
	public void overlappingStartTime_NotSameDay(){
		Schedule schedule = new Schedule(Days.MON_THU,Time.H0800, Time.H1000);
		Schedule otherSchedule = new Schedule(Days.TUE_FRI, Time.H0830,Time.H1100);
		
		schedule.conflictWith(otherSchedule);
	}
	
}
