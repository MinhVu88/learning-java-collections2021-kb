// Sec 7: Map
package com.linkedinlearning.sec7.pt_1_6;

import java.util.HashMap;
import java.util.Map;

public class BadKeyExample {
	public static void main(String[] args) {
		RoomWithBadKey room1 = new RoomWithBadKey("Piccadilly", "Guest Room", 3, 125.00);
		RoomWithBadKey room2 = new RoomWithBadKey("Oxford", "Suite", 5, 225.0);
		
		Guest guest1 = new Guest("John", "Doe", false);
		Guest guest2 = new Guest("Maria", "Doe", true);

		Map<RoomWithBadKey, Guest> assignments = new HashMap<>();

		assignments.put(room1, guest1);
		assignments.put(room2, guest2);
		
		System.out.println("Oxford: " + assignments.get(new RoomWithBadKey("Oxford", "Suite", 5, 225.0)));
		System.out.println("Piccadilly: " + assignments.get(room1));
	}
}
