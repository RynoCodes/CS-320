package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import task.Task;

class TaskTest {

	//Test task constructor
	@Test
	void testTaskConstructor() {
	Task task = new Task ("1234567890", "First Last", "Description");
	assertTrue(task.getID().equals("1234567890"));
	assertTrue(task.getName().equals("First Last"));
	assertTrue(task.getDescrpiption().equals("Description"));
	}

//test task throws correct exceptions
	@Test
	void testNullTask() {
	assertThrows(IllegalArgumentException.class, ()->
		{Task task = new Task(null, null, null);
		});
	}
	@Test
	void testIDNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Task task = new Task(null, "First Last", "description");
		});
		String expectedMessage = "Invalid ID";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void testNameNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Task task = new Task("1234567890", null, "description");
		});
		String expectedMessage = "Invalid Name";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void testDescriptionNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Task task = new Task("1234567890", "First Last", null);
		});
		String expectedMessage = "Invalid Description";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	//assert task throws length exceptions
	@Test
	void testIDLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Task task = new Task("12345678901", "First Last", "description");
		});
		String expectedMessage = "ID Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void testNameLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Task task = new Task("1234567890", "LongFirst 123456789 01234567890 LongLast", "description");
		});
		String expectedMessage = "Name Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void testDescriptionLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Task task = new Task("1234567890", "First Last", "Too Long Description 1234567890 1234567890 1234567890 1234567890 1234567890");
		});
		String expectedMessage = "Description Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
