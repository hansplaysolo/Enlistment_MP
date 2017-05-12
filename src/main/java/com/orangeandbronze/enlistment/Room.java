package com.orangeandbronze.enlistment;

public class Room {
	
	private final String name;
	private final int capacity;
	
	public Room(String name, int capacity){
		if (!name.matches("[A-Za-z0-9]+")) {
			throw new IllegalArgumentException("\n" + 
											   "Room name should be alpha-numeric. " +
											   "\n" + 
											   "Room name input: " + name);
		}
		
		this.name = name;
		this.capacity = capacity;
	}
	
	public void exceedCapacity(int size){
		if (size >= this.capacity) {
			throw new RoomExceedCapacityException("\n" + 
												  "Cannot add more students inside this " + 
												  name + " room. " + 
												  "\n" + 
												  "Current capacity: " + size + " Room Capacity: " + capacity + 
												  "\n");
		}
	}

	@Override
	public String toString() {
		return "Room name: " + name + ", Room capacity: " + capacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Room other = (Room) obj;
		if (capacity != other.capacity)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
