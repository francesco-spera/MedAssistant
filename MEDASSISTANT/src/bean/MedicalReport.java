package bean;

public class MedicalReport {
	
	public int getIdReport() {
		return idReport;
	}
	
	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}
	
	public int getDoctor() {
		return doctor;
	}
	
	public void setDoctor(int doctor) {
		this.doctor = doctor;
	}
	
	public String getObject() {
		return object;
	}
	
	public void setObject(String object) {
		this.object = object;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	private int idReport, doctor;
	private String object, description;
}
