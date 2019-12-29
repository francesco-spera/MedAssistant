package bean;

import java.util.GregorianCalendar;

public class Appointment {
	
	public int getIdAppointment() {
		return idAppointment;
	}
	
	public void setIdAppointment(int idAppointment) {
		this.idAppointment = idAppointment;
	}
	
	public int getDoctor() {
		return doctor;
	}
	
	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}
	
	public GregorianCalendar getDate() {
		return date;
	}
	
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	
	private int idAppointment, doctor;
	private GregorianCalendar date;
	private String time;
}
