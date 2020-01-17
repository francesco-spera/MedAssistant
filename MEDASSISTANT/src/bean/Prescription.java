package bean;

import java.sql.Blob;

public class Prescription {

	public String getDoctor() {
		return doctor;
	}
	
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	
	public String getPatient() {
		return patient;
	}
	
	public void setPatient(String patient) {
		this.patient = patient;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getMedicalreport() {
		return medicalreport;
	}
	
	public void setMedicalreport(int medicalreport) {
		this.medicalreport = medicalreport;
	}
	
	public Blob getPrescription() {
		return prescription;
	}
	
	public void setPrescription(Blob prescription) {
		this.prescription = prescription;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	private String doctor,patient,date;
	private int ID, medicalreport;
	private Blob prescription;
}
