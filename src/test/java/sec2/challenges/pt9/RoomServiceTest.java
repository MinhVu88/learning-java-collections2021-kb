package sec2.challenges.pt9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.linkedinlearning.sec2.challenges.pt9.Room;
import com.linkedinlearning.sec2.challenges.pt9.RoomService;

public class RoomServiceTest {
	RoomService service;

	Room room1 = new Room("Cambridge", "Premiere Room", 4, 175.00);
	Room room2 = new Room("Manchester", "Suite", 5, 250.00);
	Room room3 = new Room("Piccadilly", "Guest Room", 3, 125.00);
	Room room4 = new Room("Oxford", "Suite", 5, 225.0);
	Room room5 = new Room("Victoria", "Suite", 5, 225.00);
	Room room6 = new Room("Westminister", "Premiere Room", 4, 200.00);

	@BeforeEach
	void setUp() throws Exception {
		this.service = new RoomService();

		this.service.createRoom("Piccadilly", "Guest Room", 3, 125.00);
		this.service.createRoom("Cambridge", "Premiere Room", 3, 175.00);
		this.service.createRoom("Victoria", "Suite", 5, 225.00);
	}

	@Test
	void testCreateRoom() {
		this.service.createRoom("Westminister", "Premiere Room", 4, 200.00);

		assertEquals(4, this.service.getInventory().size());
	}

	@Test
	void testCreateRooms() {
		Room[] newRooms = { this.room6, this.room4, this.room2 };

		this.service.createRooms(newRooms);

		assertEquals(6, this.service.getInventory().size());
	}

	@Test
	void testRemoveRoom() {
		this.service.removeRoom(new Room("Victoria", "Suite", 5, 225.00));

		assertEquals(2, this.service.getInventory().size());
		assertFalse(this.service.getInventory().contains(room5));
	}

	@Test
	void testGetInventory() {
		assertNotNull(this.service.getInventory());
	}
}
