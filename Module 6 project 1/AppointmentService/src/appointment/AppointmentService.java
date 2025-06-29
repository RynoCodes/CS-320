package appointment;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import appointment.Appointment;

public class AppointmentService {

	private static AppointmentService INSTANCE;
	private AppointmentService() {}
	//map to store appointments
		public Map<String, Appointment> database = new ConcurrentHashMap<>();
	public static synchronized AppointmentService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new AppointmentService();
		}
		return INSTANCE;
		}
	
	//add new appointment
	public boolean addAppointment(Appointment appointment) {
		return database.putIfAbsent(appointment.getAppointmentId(), appointment) == null;
	}
	
	//delete appointment using appointment ID
	public boolean deleteAppointment(String appointmentID) {
		return database.remove(appointmentID)!= null;
	}
}
