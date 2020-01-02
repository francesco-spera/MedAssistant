package bean;

public class Appointment {
	
	public int getIdAppointment() {
		return idAppointment;
	}
	
	public void setIdAppointment(int idAppointment) {
		this.idAppointment = idAppointment;
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	
	private int idAppointment;
	private String time, doctor, date;
}
