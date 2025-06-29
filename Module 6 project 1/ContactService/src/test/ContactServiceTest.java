package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	//clears database before test
	@BeforeEach
	void init() {
		ContactService.getInstance().database.clear();
	}
//tests if instance is created
	@Test
	void testGetInstance() {
		assertNotNull(ContactService.getInstance());
	}
//test add method
	@Test
	void testAdd() throws ValidationException {
		Contact contact = new Contact("12345", "First", "Last", "5551234567", "123 Test Street");
		assertTrue(ContactService.getInstance().add(contact));
		assertTrue(ContactService.getInstance().database.containsKey("12345"));
	}
	//test delete method
	@Test
	void testDelete() throws ValidationException {
		Contact contact = new Contact("12345", "First", "Last", "5551234567", "123 Test Street");
		assertTrue(ContactService.getInstance().add(contact));
		assertTrue(ContactService.getInstance().delete("12345"));
		assertFalse(ContactService.getInstance().database.containsKey("12345"));
	}
	//test update
	@Test
	void testUpdate() throws ValidationException {
		//add contact1
		Contact contact = new Contact("12345", "First", "Last", "5551234567", "123 Test Street");
		assertTrue(ContactService.getInstance().add(contact));
		assertTrue(ContactService.getInstance().database.containsKey("12345"));
		//add contact2
		Contact updated = new Contact("54321", "Bruce", "Wayne", "5558675309", "123 Gotham Street");
		assertTrue(ContactService.getInstance().add(updated));
		assertTrue(ContactService.getInstance().database.containsKey("54321"));
		//assert contacts are not equal
		assertNotEquals(ContactService.getInstance().database.get("12345").getFirstName(),ContactService.getInstance().database.get("54321").getFirstName());
		assertNotEquals(ContactService.getInstance().database.get("12345").getLastName(),ContactService.getInstance().database.get("54321").getLastName());
		assertNotEquals(ContactService.getInstance().database.get("12345").getPhoneNumber(),ContactService.getInstance().database.get("54321").getPhoneNumber());
		assertNotEquals(ContactService.getInstance().database.get("12345").getAddress(),ContactService.getInstance().database.get("54321").getAddress());
		//update contact
		assertTrue(ContactService.getInstance().update("12345", updated));
		//assert contacts are equal
		assertEquals(ContactService.getInstance().database.get("12345").getFirstName(),ContactService.getInstance().database.get("54321").getFirstName());
		assertEquals(ContactService.getInstance().database.get("12345").getLastName(),ContactService.getInstance().database.get("54321").getLastName());
		assertEquals(ContactService.getInstance().database.get("12345").getPhoneNumber(),ContactService.getInstance().database.get("54321").getPhoneNumber());
		assertEquals(ContactService.getInstance().database.get("12345").getAddress(),ContactService.getInstance().database.get("54321").getAddress());
	}
}
