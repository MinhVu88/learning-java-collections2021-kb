// Sec 3: iterating collections
package com.linkedinlearning.sec3.challenges.pt7;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

import com.linkedinlearning.sec3.pt_1_6.Room;

public class RoomService {
	private Collection<Room> inventory;

	public RoomService() {
		this.inventory = new LinkedHashSet<>();
	}

	public void applyDiscount(final double discount) {
		// Reduces the rate of each room by the provided discount
		this.inventory.forEach(
			room -> room.setRate(
				room.getRate() * (1 - discount)
			)
		);
	}

	public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {
		// Returns a new collection of rooms that meet or exceed the provided capacity
		return this.inventory.stream()
												 .filter(room -> room.getCapacity() >= requiredCapacity)
												 .collect(Collectors.toList());
	}

	public Collection<Room> getRoomByRateAndType(final double rate, final String type) {
		// Returns a new collection of rooms with a rate below the provided rate and that match the provided type
		return this.inventory.stream()
												 .filter(room -> room.getRate() < rate && room.getType().equalsIgnoreCase(type))
												 .collect(Collectors.toList());
	}

	public boolean hasRoom(Room room) {
		return this.inventory.contains(room);
	}

	public Room[] asArray() {
		return this.inventory.toArray(new Room[0]);
	}

	public Collection<Room> getByType(String type) {
		Collection<Room> copiedInventory = new HashSet<>(this.inventory);

		copiedInventory.removeIf(room -> !room.getType().equalsIgnoreCase(type));

		return copiedInventory;
	}

	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory);
	}

	public void createRoom(String name, String type, int capacity, double price) {
		this.inventory.add(new Room(name, type, capacity, price));
	}

	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}
}
