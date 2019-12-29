package bean;

public class Prescription {
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public int getMedicalReport() {
		return medicalReport;
	}
	
	public void setMedicalReport(int medicalReport) {
		this.medicalReport = medicalReport;
	}
	
	
	private String path;
	private int medicalReport;
}
