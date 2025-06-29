/**********
 * Name: Juilianne Takaya
 * Class: CS 320
 * Description: This is the Appointment Class for the AppointmentService project for Module 5
 */

package appointment;

import java.util.Date;

public class Appointment {
	
	private final String appointmentId;
	private Date appointmentDate;
	private String description;
	

	// Constructors:

	public Appointment(String appointmentID, Date appointmentDate, String description) {
	
		//appointment ID throws exception if it is null or longer than 10 characters
	if (appointmentID == null) {
		throw new IllegalArgumentException("Invalid ID");
	}else if(appointmentID.length()>10) {
			throw new IllegalArgumentException("ID Must contain fewer than 10 characters");
	}else {
		this.appointmentId = appointmentID;
		}
	
	//Date throws exception if it is null or before current date
	if (appointmentDate == null) {
		throw new IllegalArgumentException("Invalid Date");
	}else if(appointmentDate.before(new Date())) {
		throw new IllegalArgumentException("Date cannot be in the past");
	}else {
		this.appointmentDate = appointmentDate;
	}
		
	// description throws exception if it is null or longer than 50 characters
	if (description == null) {
		throw new IllegalArgumentException("Invalid Description");
	}else if(description.length()>50) {
		throw new IllegalArgumentException("Description Too Long");
	}else {
		this.description = description;
	}
}
	//getters
	public String getAppointmentId() {
		return appointmentId;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public String getAppointmentDescription() {
		return description;
	}
	
	//setters
	
	//no setter for appointment ID, making it impossible to change once set
	public void setAppointmentDate(Date appointmentDate) {
		
		if (appointmentDate == null) {
			throw new IllegalArgumentException("Invalid Date");
		}else if(appointmentDate.before(new Date())) {
			throw new IllegalArgumentException("Date cannot be in the past");
		}else {
			this.appointmentDate = appointmentDate;
		}
	}
	public void setAppointmentDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Invalid Description");
		}else if(description.length()>50) {
			throw new IllegalArgumentException("Description too long");
		}else {
			this.description = description;
		}
	}
}
