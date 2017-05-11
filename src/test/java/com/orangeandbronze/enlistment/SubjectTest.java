package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class SubjectTest {

	@Test(expected = IllegalArgumentException.class)
	public void createSubject_notAlphanumeric() {
		new Subject("!@#$%^^%");
	}

}
