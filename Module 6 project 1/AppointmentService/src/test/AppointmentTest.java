/**********
 * Name: Juilianne Takaya
 * Class: CS 320
 * Description: This is the AppointmentTest Class for the AppointmentService project for Module 5
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
import appointment.Appointment;

class AppointmentTest {

	@Test
	void testAppointmentNotNull() {
		//test constructor throws null exception
		assertThrows(IllegalArgumentException.class, () -> 
			{Appointment appointment = new Appointment(null, null, null);
		});
	}
	@Test
	void testIDNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Appointment appointment = new Appointment(null, new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(), "description");
		});
		String expectedMessage = "Invalid ID";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
		
	@Test
	void testDateNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Appointment appointment = new Appointment("UniqueID", null, "description");
		});
		String expectedMessage = "Invalid Date";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void TestDescriptionNotNull() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,()->
			{Appointment appointment = new Appointment("UniqueId",new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(),null);
		});
		String expectedMessage = "Invalid Description";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void TestIDLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class, () -> 
			{Appointment appointment = new Appointment("1234567890 Long ID", new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(), "description");
		});
		String expectedMessage = "ID Must contain fewer than 10 characters";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void TestDateNotBeforeCurrentDate() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,()->
			{Appointment appointment = new Appointment("UniqueId", new GregorianCalendar(1900,Calendar.JANUARY,1).getTime(),"Description");
		});
		String expectedMessage = "Date cannot be in the past";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	@Test
	void TestDescriptionLength() {
		Exception exception =
		assertThrows(IllegalArgumentException.class,()->
			{Appointment appointment = new Appointment("Unique Id", new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(),"1234567890 This Description is longer than fifty characters");
		});
		String expectedMessage = "Description Too Long";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}	
	@Test
	void TestAppointmentConstructor() {
		Appointment appointment = new Appointment("1234567890", new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(),"Description");
		assertTrue(appointment.getAppointmentId().equals("1234567890"));
		assertTrue(appointment.getAppointmentDate().equals(new GregorianCalendar(2033,Calendar.JANUARY,1).getTime()));
		assertTrue(appointment.getAppointmentDescription().equals("Description"));
	}
}

