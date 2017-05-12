package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleTest {

	@Test(expected=ScheduleConflictException.class)
	public void conflictingSchedule() {
		Schedule schedule1 = new Schedule(Days.MON_THU, Time.H0800, Time.H1000);
		Schedule schedule2 = new Schedule(Days.MON_THU, Time.H1000, Time.H1200);
		
		schedule1.conflictWith(schedule2);
	}
}
