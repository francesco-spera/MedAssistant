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

	/*
	 * 
	 * @param email insieme alla password serviranno per cercare un account
	 * @param password insieme alla email serviranno per cercare un account
	 * @return user se l'account è stato autenticato con successo, null altrimenti 
	 * @throws SQLException
	 * 
	 * */
	
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
	
	
	/*
	 * 
	 * @param account l'account da registrare
	 * @param patient il paziente da associare all'account da registrare
	 * @return true se la registrazione è avvenuta correttamente, false altrimenti 
	 * @throws SQLException
	 * 
	 * */
	
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
			if(account.getPhoto()!=null) {
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
			} else {
				ps = con.prepareStatement("INSERT INTO account(Name, Surname, BirthDate, CF, Patient)"
						+ "VALUES(?, ?, ?, ?, ?);");
					ps.setString(1, account.getName());
					ps.setString(2, account.getSurname());
					ps.setString(3, account.getBirthDate());
					ps.setString(4, account.getCf());
					ps.setString(5, account.getPatient());
					if (ps.executeUpdate() != 1)
						return false;
					return true;
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
	}
	
	/*
	 * 
	 * @param account l'account da registrare
	 * @param patient il medico da associare all'account da registrare
	 * @return true se la registrazione è avvenuta correttamente, false altrimenti
	 * @throws SQLException 
	 * 
	 * */
	
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
	
	/*
	 * 
	 * @param email l'email delle informazioni del paziente da cercare
	 * @return patient se la ricerca delle informazioni del paziente è avvenuta con successo, null altrimenti
	 * @throws SQLException
	 * 
	 * */
	
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
	
	/*
	 * 
	 * @param email l'email delle informazioni del medico da cercare
	 * @return doctor se la ricerca delle informazioni del medico è avvenuta con successo, null altrimenti
	 * @throws SQLException
	 * 
	 * */
	
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
	
	/*
	 * 
	 * @param account l'account del paziente di cui si vogliono modificare le informazioni personali
	 * @param patient il paziente di cui si vogliono modificare le informazioni
	 * @return true se la modifica delle informazioni del paziente è avvenuta con successo, false altrimenti 
	 * @throws SQLException 
	 * 
	 * */
	
	public static boolean modificaProfilo(Account account, Patient patient) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			if(!account.getName().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Name = ? WHERE patient = ?;");
				ps.setString(1, account.getName());
				ps.setString(2, account.getPatient());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!account.getSurname().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Surname = ? WHERE patient = ?;");
				ps.setString(1, account.getSurname());
				ps.setString(2, account.getPatient());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}			
			if(!account.getBirthDate().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET BirthDate = ? WHERE patient = ?;");
				ps.setString(1, account.getBirthDate());
				ps.setString(2, account.getPatient());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}				
			if(!account.getCf().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET CF = ? WHERE patient = ?;");
				ps.setString(1, account.getCf());
				ps.setString(2, account.getPatient());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!patient.getPassword().isEmpty()) {
				ps = con.prepareStatement("UPDATE patient SET Password = ? WHERE email = ?;");
				ps.setString(1, patient.getPassword());
				ps.setString(2, patient.getEmail());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!patient.getDomicile().isEmpty()) {
				ps = con.prepareStatement("UPDATE patient SET Domicile = ? WHERE email = ?;");
				ps.setString(1, patient.getDomicile());
				ps.setString(2, patient.getEmail());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!patient.getResidence().isEmpty()) {
				ps = con.prepareStatement("UPDATE patient SET Residence = ? WHERE email = ?;");
				ps.setString(1, patient.getResidence());
				ps.setString(2, patient.getEmail());
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
	
	/*
	 * 
	 * @param account l'account del medico di cui si vogliono modificare le informazioni personali
	 * @param doctor il medico di cui si vogliono modificare le informazioni
	 * @return true se la modifica delle informazioni del medico è avvenuta con successo, false altrimenti 
	 * @throws SQLException 
	 * 
	 * */
	
	public static boolean modificaProfilo(Account account, Doctor doctor) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			if(!account.getName().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Name = ? WHERE doctor = ?;");
				ps.setString(1, account.getName());
				ps.setString(2, account.getDoctor());
				if (ps.executeUpdate() != 1)
					return false;
				ps.close();
			}
			if(!account.getSurname().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET Surname = ? WHERE doctor = ?;");
				ps.setString(1, account.getSurname());
				ps.setString(2, account.getDoctor());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}			
			if(!account.getBirthDate().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET BirthDate = ? WHERE doctor = ?;");
				ps.setString(1, account.getBirthDate());
				ps.setString(2, account.getDoctor());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}		
			if(!account.getCf().isEmpty()) {
				ps = con.prepareStatement("UPDATE account SET CF = ? WHERE doctor = ?;");
				ps.setString(1, account.getCf());
				ps.setString(2, account.getDoctor());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!doctor.getPassword().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET Password = ? WHERE email = ?;");
				ps.setString(1, doctor.getPassword());
				ps.setString(2, doctor.getEmail());
				if (ps.executeUpdate() != 1)
					return false;
				ps.close();
			}
			if(!doctor.getPhoneNumber().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET PhoneNumber = ? WHERE email = ?;");
				ps.setString(1, doctor.getPhoneNumber());
				ps.setString(2, doctor.getEmail());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!doctor.getStudioAddress().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET StudioAddress = ? WHERE email = ?;");
				ps.setString(1, doctor.getStudioAddress());
				ps.setString(2, doctor.getEmail());
				if (ps.executeUpdate() != 1)
					return false;				
				ps.close();
			}
			if(!doctor.getMunicipalityAddress().isEmpty()) {
				ps = con.prepareStatement("UPDATE doctor SET MunicipalityAddress = ? WHERE email = ?;");
				ps.setString(1, doctor.getMunicipalityAddress());
				ps.setString(2, doctor.getEmail());
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
	
	/*
	 * 
	 * @param email l'email dell'account da cercare
	 * @return true se la ricerca è avvenuta con successo, null altrimenti 
	 * @throws SQLException
	 * 
	 * */
	
	public static boolean cercaAccount(String email) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT name FROM account WHERE patient = ? OR doctor = ?;");
			ps.setString(1, email);
			ps.setString(2, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
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
