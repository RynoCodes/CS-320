package test;

import static org.junit.jupiter.api.Assertions.*;

import javax.xml.bind.ValidationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {

	@Test
	//clears database before test
		@BeforeEach
		void init() {
			AppointmentService.getInstance().database.clear();
		}
	//tests if instance is created
		@Test
		void testGetInstance() {
			assertNotNull(AppointmentService.getInstance());
		}
		@Test
		void testAdd() throws ValidationException {
			Appointment appointment = new Appointment ("1234567890", new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(), "Description");
			assertTrue(AppointmentService.getInstance().addAppointment(appointment));
			assertTrue(AppointmentService.getInstance().database.containsKey("1234567890"));
		}
		@Test 
		void testDelete() throws ValidationException{
			Appointment appointment = new Appointment ("1234567890", new GregorianCalendar(2033,Calendar.JANUARY,1).getTime(), "Description");
			assertTrue(AppointmentService.getInstance().addAppointment(appointment));
			assertTrue(AppointmentService.getInstance().database.containsKey("1234567890"));
			assertTrue(AppointmentService.getInstance().deleteAppointment("1234567890"));
			assertFalse(AppointmentService.getInstance().database.containsKey("1234567890"));
		}
}

