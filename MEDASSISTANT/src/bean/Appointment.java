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
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


	private int idAppointment, state;
	private String time, doctor, date;
	
	//state = 0 in attesa
	//state = 1 confermato
	//state = 2 completato
	//state = 3 rinviato
}
