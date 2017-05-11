package com.orangeandbronze.enlistment;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	@Test(expected=IllegalArgumentException.class)
	public void createRoom_notAlphanumeric() {
		new Room("!@#$$%^^&", 10);
	}

}
