package bean;

public class Voting {
	
	public int getIdVoting() {
		return idVoting;
	}
	
	public void setIdRatingVote(int idVoting) {
		this.idVoting = idVoting;
	}
	
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
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public float getVote() {
		return vote;
	}
	
	public void setVote(float vote) {
		this.vote = vote;
	}
	
	
	private int idVoting;
	private float vote;
	private String patient, doctor, date;
}