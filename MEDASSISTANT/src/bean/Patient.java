package bean;

public class Patient {
	
	public int getIdPatient() {
		return idPatient;
	}
	
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	
	public String getDomicile() {
		return domicile;
	}
	
	public void setDomicile(String domicile) {
		this.domicile = domicile;
	}
	
	public String getResidence() {
		return residence;
	}
	
	public void setResidence(String residence) {
		this.residence = residence;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	private int idPatient;
	private String domicile, residence, email, password;
}
