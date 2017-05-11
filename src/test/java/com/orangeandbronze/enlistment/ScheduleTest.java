package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScheduleTest {

	@Test(expected=ScheduleConflictingException.class)
	public void conflictingSchdule() {
		Schedule schedule = new Schedule(Days.MON_THU, Periods.H0830_H1000);
		
	}

}
