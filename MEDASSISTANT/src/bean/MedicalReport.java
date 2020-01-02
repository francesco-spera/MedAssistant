package bean;

public class MedicalReport {
	
	public int getIdReport() {
		return idReport;
	}
	
	public void setIdReport(int idReport) {
		this.idReport = idReport;
	}
	
	public String getDoctor() {
		return doctor;
	}
	
	public void setDoctor(String doctor) {
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
	
	
	private int idReport;
	private String object, description, doctor;
}
