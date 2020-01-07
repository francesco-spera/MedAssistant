package bean;

public class Link {
	
	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}


	private String patient, doctor;
	private int state;
	
	
	//state = 0 in attesa
	//state = 1 confermato
	//state = 2 rifiutato
}
