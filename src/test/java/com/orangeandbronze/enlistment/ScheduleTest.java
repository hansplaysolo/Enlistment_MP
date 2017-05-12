package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleTest {

	@Test(expected=ScheduleConflictException.class)
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
	
}
