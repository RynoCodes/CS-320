package task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import task.TaskService;

public class TaskService {
	//create private instance using singleton method
	private static TaskService INSTANCE;
	private TaskService() {}
	//map to store contacts
	public Map<String, Task> database = new ConcurrentHashMap<>();
	public static synchronized TaskService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new TaskService();
			}
		return INSTANCE;
		}
	//add method
	public boolean add(Task task) {
		return database.putIfAbsent(task.getID(), task) == null;
		}
	//delete method
	public boolean delete(String ID) {
		return database.remove(ID)!=null;
		}
	//update method
	public boolean update(String ID, Task updated) {
		Task existing = database.get(ID);
		if(existing == null)return false;
		existing.setName(updated.getName());
		existing.setDescription(updated.getDescrpiption());
		return true;
		}
	}
