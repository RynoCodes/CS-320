package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

class TaskServiceTest {

//clears database before test
@BeforeEach
void init() {
	TaskService.getInstance().database.clear();
	}

	//tests if instance is created
	@Test
	void testGetInstance() {
		assertNotNull(TaskService.getInstance());
		}
	//test add method
	@Test
	void testAdd() throws ValidationException {
		Task task = new Task("193927", "Bruce Wayne", "Alias:Batman");
		assertTrue(TaskService.getInstance().add(task));
		assertTrue(TaskService.getInstance().database.containsKey("193927"));
		}

	//test delete method
	@Test
	void testDelete()throws ValidationException {
		Task task = new Task ("193927", "Bruce Wayne", "Alias:Batman");
		assertTrue(TaskService.getInstance().add(task));
		assertTrue(TaskService.getInstance().database.containsKey("193927"));
		assertTrue(TaskService.getInstance().delete("193927"));
		assertFalse(TaskService.getInstance().database.containsKey("193927"));
	}
	
	//test update method
	@Test
	void testUpdate() throws ValidationException{
		//add first task and validate it is in database
		Task task = new Task ("193927", "Bruce Wayne", "Alias:Batman");
		assertTrue(TaskService.getInstance().add(task));
		assertTrue(TaskService.getInstance().database.containsKey("193927"));
		//add second task and validate it is in database
		Task task2 = new Task ("1939", "Bruce T Wayne", "Alias: Not Batman");
		assertTrue(TaskService.getInstance().add(task2));
		assertTrue(TaskService.getInstance().database.containsKey("1939"));
		//assert the tasks are not the same
		assertNotEquals(TaskService.getInstance().database.get("193927").getName(),TaskService.getInstance().database.get("1939").getName());
		assertNotEquals(TaskService.getInstance().database.get("193927").getDescrpiption(), TaskService.getInstance().database.get("1939").getDescrpiption());
		//update task2
		assertTrue(TaskService.getInstance().update("193927", task2));
		//assert tasks are the same
		assertEquals(TaskService.getInstance().database.get("193927").getName(),TaskService.getInstance().database.get("1939").getName());
		assertEquals(TaskService.getInstance().database.get("193927").getDescrpiption(), TaskService.getInstance().database.get("1939").getDescrpiption());
		}
	}