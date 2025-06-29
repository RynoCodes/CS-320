package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {
	//test if created object is correct
	@Test
	void testContact() {
		Contact contact = new Contact("1", "First", "Last", "5551234567", "123 Test Street");
		assertTrue(contact.getContactID().equals("1"));
		assertTrue(contact.getFirstName().equals("First"));
		assertTrue(contact.getLastName().equals("Last"));
		assertTrue(contact.getPhoneNumber().equals("5551234567"));
		assertTrue(contact.getAddress().equals("123 Test Street"));	
	}
	//Tests to assure contact throws necessary exceptions
	@Test
	void testContactNotNull() {
		assertThrows(IllegalArgumentException.class, () -> 
			{Contact contact = new Contact(null, null, null, null, null);
		});
	}
	
	@Test
	void testIDNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () ->
		{Contact contact = new Contact(null, "First", "Last", "1234567890", "123 Test Street");
		});
		String expectedMessage= "Invalid ID";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testFirstNameNotNull() {
		Exception exception = 
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1", null, "Last", "5551234567", "123 Test Street");
		});
		String expectedMessage="Invalid First Name";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testLastNameNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () ->
		{Contact contact = new Contact("1", "First", null, "5551234567", "123 Test Street");
		});
		String expectedMessage="Invalid Last Name";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test 
	void testPhoneNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () ->
		{Contact contact = new Contact("1", "First", "Last", null, "123 Test Street");
		});
		String expectedMessage="Invalid Phone Number";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testAddressNotNull() {
		Exception exception = 
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1", "First", "Last", "5551234567", null);
		});
		String expectedMessage="Invalid Address";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	//Test to ensure contact does not allow out of bounds input
	//Test ID Length greater than 10 characters
	@Test
	void testIDLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("12345678901", "First", "Last", "5551234567", "123 Test Street");
		});
		String expectedMessage = "ID Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	//Test First Name Length
	@Test
	void testFirstNameLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1234567890", "FirstNameTooLong", "Last", "5551234567", "123 Test Street");
		});
		String expectedMessage = "First Name Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	//test Last Name Length
	@Test
	void testLastNameLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1234567890", "First", "LastNameTooLong", "5551234567", "123 Test Street");
		});
		String expectedMessage = "Last Name Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	//test long phone number
	@Test
	void testPhoneNumberLong() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1234567890", "First", "Last", "12345678901", "123 Test Street");
		});
		String expectedMessage = "Phone Number Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	//test short phone number
	@Test
	void testPhoneNumberShort() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1234567890", "First", "Last", "123456789", "123 Test Street");
		});
		String expectedMessage = "Phone Number Too Short";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	//test address length
	@Test
	void testAddressLengh() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,() ->
		{Contact contact = new Contact("1234567890", "First", "Last", "1234567890", "123 Test Street This addresss is too long");
		});
		String expectedMessage = "Address Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}

