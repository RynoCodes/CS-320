package task;

public class Task {

	private String ID;
	private String name;
	private String description;
	
	//constructor
	public Task(String ID, String name, String description) {
		if(ID == null) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else if(ID.length() > 10) {
			throw new IllegalArgumentException("ID Too Long");
		}
		else if(name == null) {
			throw new IllegalArgumentException("Invalid Name");
		}
		else if(name.length() > 20) {
			throw new IllegalArgumentException("Name Too Long");
		}
		else if(description == null) {
			throw new IllegalArgumentException("Invalid Description");
		}
		else if(description.length() > 50) {
			throw new IllegalArgumentException("Description Too Long");
		}
		else {
		this.ID = ID;
		this.name = name;
		this.description = description;
		}
	}
	//getters
	
	public String getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getDescrpiption() {
		return description;
	}
	//setters
	public void setID(String ID) {
		if((ID == null)||(ID.length()>10)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else {
			this.ID = ID;
			}
		}

	public void setName(String name) {
		if((name == null)||(name.length()>20)) {
			throw new IllegalArgumentException("Invalid name");
		}
		else {
		this.name = name;
		}
	}
	public void setDescription(String description) {
		if((description == null)||(description.length()>50)) {
			throw new IllegalArgumentException("Invalid description");
		}
		else {
		this.description = description;
		}
	}
}
