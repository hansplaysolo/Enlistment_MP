package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleTest {

	@Test(expected=ScheduleConflictingException.class)
	public void conflictingSchedule() {
		Schedule schedule1 = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		Schedule schedule2 = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		
		schedule1.conflictWith(schedule2);
	}
}
