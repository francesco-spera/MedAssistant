package bean;

public class Doctor {

		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getStudioAddress() {
		return studioAddress;
	}
	
	public void setStudioAddress(String studioAddress) {
		this.studioAddress = studioAddress;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public float getAvgReviews() {
		return avgReviews;
	}
	
	public void setAvgReviews(float avgReviews) {
		this.avgReviews = avgReviews;
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
	
	private String phoneNumber, studioAddress, type, email, password;
	private float avgReviews;
}
