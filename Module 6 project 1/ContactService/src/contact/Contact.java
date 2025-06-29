package contact;

public class Contact {

	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//input validation
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		if(contactID == null) {
			throw new IllegalArgumentException("Invalid ID");
		}
		else if(contactID.length()>10) {
			throw new IllegalArgumentException("ID Too Long");
		}
		else {this.contactID = contactID;}
		if(firstName == null) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		else if(firstName.length()>10) {
			throw new IllegalArgumentException("First Name Too Long");
		}
		else {this.firstName = firstName;}
		if(lastName == null) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		else if(lastName.length()>10) {
			throw new IllegalArgumentException("Last Name Too Long");
		}
		else {this.lastName = lastName;}
		if(phoneNumber == null) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		else if(phoneNumber.length() < 10) {
			throw new IllegalArgumentException("Phone Number Too Short");
		}
		else if (phoneNumber.length()>10) {
			throw new IllegalArgumentException("Phone Number Too Long");
		}
		else{this.phoneNumber = phoneNumber;}
		if(address == null) {
			throw new IllegalArgumentException("Invalid Address");
		}
		else if(address.length()>30) {
			throw new IllegalArgumentException("Address Too Long");
		}
		else {this.address = address;}
	}

	//getters and setters
	//no setter for contact ID, making it impossible to reset
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
