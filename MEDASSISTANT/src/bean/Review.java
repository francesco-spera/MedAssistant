package bean;

import java.util.GregorianCalendar;

public class Review {
	
	public int getIdReview() {
		return idReview;
	}
	
	public void setIdReview(int idReview) {
		this.idReview = idReview;
	}
	
	public int getPatient() {
		return patient;
	}
	
	public void setPatient(int patient) {
		this.patient = patient;
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
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	private int idReview, patient, doctor;
	private GregorianCalendar date;
	private float rating;
}
