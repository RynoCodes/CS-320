package contact;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//create private instance using singleton method
public class ContactService {
private static ContactService INSTANCE;
private ContactService() {}
	//map to store contacts
	public Map<String, Contact> database = new ConcurrentHashMap<>();
public static synchronized ContactService getInstance() {
	if (INSTANCE == null) {
		INSTANCE = new ContactService();
	}
	return INSTANCE;
	}
//add new contact
public boolean add(Contact contact) {
	return database.putIfAbsent(contact.getContactID(), contact) == null;
}
//delete contacts
public boolean delete(String contactID) {
	return database.remove(contactID)!= null;
}
//update contacts
public boolean update(String contactID, Contact updated) {
	Contact existing = database.get(contactID);
	if(existing == null)return false;
	existing.setFirstName(updated.getFirstName());
	existing.setLastName(updated.getLastName());
	existing.setPhoneNumber(updated.getPhoneNumber());
	existing.setAddress(updated.getAddress());
	return true;
}
}
