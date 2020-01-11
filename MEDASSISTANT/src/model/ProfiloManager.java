package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Account;
import bean.Patient;
import bean.Doctor;
import connectionPool.DriverManagerConnectionPool;

public class ProfiloManager {

	public static Account autenticazione(String email, String password) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Account user = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM patient WHERE email = ? AND password = ?;");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()) {
				ps.close();
				ps = con.prepareStatement("SELECT * FROM account WHERE patient = ?;");
				ps.setString(1, email);
				rs = ps.executeQuery();
				if(rs.next()) {
					user = new Account();
					user.setIdAccount(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setSurname(rs.getString(3));
					user.setBirthDate(rs.getString(4));
					user.setCf(rs.getString(5));
					user.setPhoto(rs.getBlob(6));
					user.setPatient(email);
				}
			} else {
				ps.close();
				rs.close();
				ps = con.prepareStatement("SELECT * FROM doctor WHERE email = ? AND password = ?;");
				ps.setString(1, email);
				ps.setString(2, password);
				rs = ps.executeQuery();
				if(rs.next()) {
					ps.close();
					ps = con.prepareStatement("SELECT * FROM account WHERE doctor = ?;");
					ps.setString(1, email);
					rs = ps.executeQuery();
					if(rs.next()) {
						user = new Account();
						user.setIdAccount(rs.getInt(1));
						user.setName(rs.getString(2));
						user.setSurname(rs.getString(3));
						user.setBirthDate(rs.getString(4));
						user.setCf(rs.getString(5));
						user.setPhoto(rs.getBlob(6));
						user.setDoctor(email);
					}
				}
			}
		} catch(SQLException e) {
			e.getStackTrace();
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return  user;
	}
	
	public static boolean registrazione(Account account, Patient patient) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO patient(Email, Password, Domicile, Residence)"
					+ "VALUES(?, ?, ?, ?);");
			ps.setString(1, patient.getEmail());
			ps.setString(2, patient.getPassword());
			ps.setString(3, patient.getDomicile());
			ps.setString(4, patient.getResidence());
			if (ps.executeUpdate() != 1)
				return false;
			ps.close();
			ps = con.prepareStatement("INSERT INTO account(Name, Surname, BirthDate, CF, Photo, Patient)"
				+ "VALUES(?, ?, ?, ?, ?, ?);");
			ps.setString(1, account.getName());
			ps.setString(2, account.getSurname());
			ps.setString(3, account.getBirthDate());
			ps.setString(4, account.getCf());
			ps.setBlob(5, account.getPhoto());
			ps.setString(6, account.getPatient());
			if (ps.executeUpdate() != 1)
				return false;
			return true;
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
	
	public static boolean registrazione(Account account, Doctor doctor) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO doctor(Email, Password, PhoneNumber, StudioAddress, Type, MunicipalityAddress)"
					+ "VALUES(?, ?, ?, ?, ?, ?);");
			ps.setString(1, doctor.getEmail());
			ps.setString(2, doctor.getPassword());
			ps.setString(3, doctor.getPhoneNumber());
			ps.setString(4, doctor.getStudioAddress());
			ps.setString(5, doctor.getType());
			ps.setString(6, doctor.getMunicipalityAddress());
			if (ps.executeUpdate() != 1)
				return false;
			ps.close();
			ps = con.prepareStatement("INSERT INTO account(Name, Surname, BirthDate, CF, Photo, Doctor)"
				+ "VALUES(?, ?, ?, ?, ?, ?);");
			ps.setString(1, account.getName());
			ps.setString(2, account.getSurname());
			ps.setString(3, account.getBirthDate());
			ps.setString(4, account.getCf());
			ps.setBlob(5, account.getPhoto());
			ps.setString(6, account.getDoctor());
			if (ps.executeUpdate() != 1)
				return false;
			return true;
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
	
	public static Patient visualizzaPaziente(String email) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		Patient patient = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT email, domicile, residence FROM patient WHERE email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				patient = new Patient();
				patient.setEmail(rs.getString(1));
				patient.setDomicile(rs.getString(2));
				patient.setResidence(rs.getString(3));
			}
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return patient;
	}
	
	public static Doctor visualizzaMedico(String email) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		Doctor doctor = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT email, phonenumber, studioaddress, avgReviews, type, municipalityaddress FROM doctor WHERE email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				doctor = new Doctor();
				doctor.setEmail(rs.getString(1));
				doctor.setPhoneNumber(rs.getString(2));
				doctor.setStudioAddress(rs.getString(3));
				doctor.setAvgReviews(rs.getFloat(4));
				doctor.setType(rs.getString(5));
				doctor.setMunicipalityAddress(rs.getString(6));
			}
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		return doctor;
	}
	
	public static boolean modificaProfilo(Account account, Patient patient) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			if(account.getName()!=null || !account.getName().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Name = ?;");
				ps.setString(1, account.getName());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(account.getSurname()!=null || !account.getSurname().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Surname = ?;");
				ps.setString(1, account.getSurname());
				if (ps.executeUpdate() != 1)
					return false;				
			}			
			ps.close();
			if(account.getBirthDate()!=null) {
				ps = con.prepareStatement("UPDATE account SET BirthDate = ?;");
				ps.setString(1, account.getBirthDate());
				if (ps.executeUpdate() != 1)
					return false;				
			}				
			ps.close();
			if(account.getCf()!=null || !account.getCf().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET CF = ?;");
				ps.setString(1, account.getCf());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(account.getPhoto()!=null) {
				ps = con.prepareStatement("UPDATE account SET Photo = ?;");
				ps.setBlob(1, account.getPhoto());
				if (ps.executeUpdate() != 1)
					return false;				
			}			
			ps.close();
			if(patient.getPassword()!=null || !patient.getPassword().isEmpty()) {
				ps = con.prepareStatement("UPDATE patient SET Password = ?;");
				ps.setString(1, patient.getPassword());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(patient.getDomicile()!=null || !patient.getDomicile().isEmpty()) {
				ps = con.prepareStatement("UPDATE patient SET Domicile = ?;");
				ps.setString(1, patient.getDomicile());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(patient.getResidence()!=null || !patient.getResidence().isEmpty()) {
				ps = con.prepareStatement("UPDATE patient SET Residence = ?;");
				ps.setString(1, patient.getResidence());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			return true;
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
	
	public static boolean modificaProfilo(Account account, Doctor doctor) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			if(account.getName()!=null || !account.getName().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Name = ?;");
				ps.setString(1, account.getName());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(account.getSurname()!=null || !account.getSurname().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Surname = ?;");
				ps.setString(1, account.getSurname());
				if (ps.executeUpdate() != 1)
					return false;				
			}			
			ps.close();
			if(account.getBirthDate()!=null) {
				ps = con.prepareStatement("UPDATE account SET BirthDate = ?;");
				ps.setString(1, account.getBirthDate());
				if (ps.executeUpdate() != 1)
					return false;				
			}				
			ps.close();
			if(account.getCf()!=null || !account.getCf().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET CF = ?;");
				ps.setString(1, account.getCf());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(account.getPhoto()!=null) {
				ps = con.prepareStatement("UPDATE account SET Photo = ?;");
				ps.setBlob(1, account.getPhoto());
				if (ps.executeUpdate() != 1)
					return false;				
			}			
			ps.close();
			if(doctor.getPassword()!=null || !doctor.getPassword().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET Password = ?;");
				ps.setString(1, doctor.getPassword());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(doctor.getPhoneNumber()!=null || !doctor.getPhoneNumber().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET PhoneNumber = ?;");
				ps.setString(1, doctor.getPhoneNumber());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(doctor.getStudioAddress()!=null || !doctor.getStudioAddress().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET StudioAddress = ?;");
				ps.setString(1, doctor.getStudioAddress());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(doctor.getType()!=null || !doctor.getType().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET Type = ?;");
				ps.setString(1, doctor.getType());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			ps.close();
			if(doctor.getMunicipalityAddress()!=null || !doctor.getMunicipalityAddress().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET MunicipalityAddress = ?;");
				ps.setString(1, doctor.getMunicipalityAddress());
				if (ps.executeUpdate() != 1)
					return false;				
			}
			return true;
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
	
	public static boolean cercaAccount(String email) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM doctor WHERE email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) {
				ps.close();
				ps = con.prepareStatement("SELECT * FROM patient WHERE email = ?;");
				ps.setString(1, email);
				rs = ps.executeQuery();
				if(rs.next())
					return true;
				else
					return false;
			} else
				return true;
		} finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
	}
}
