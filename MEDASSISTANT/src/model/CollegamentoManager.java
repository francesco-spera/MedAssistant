package model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import bean.Patient;
import bean.Doctor;
import connectionPool.DriverManagerConnectionPool;

public class CollegamentoManager {



	/*
	 * 
	 * @param email del paziente collegato ad un account
	 * @return null se non esiste alcun account associato all' email o il paziente se ha trovato l'account associato
	 * @throws SQLException
	 * 
	 * 
	 * */
	
	public static Patient doRetrieveByPazienteCollegato(String email) throws SQLException {


		PreparedStatement ps = null;
		Connection con = null;
		Patient p = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM patient, account WHERE account.email = p.email AND account.email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Patient();
				p.setEmail(rs.getString(1));
				p.setPassword(rs.getString(2));
				p.setDomicile(rs.getString(3));
				p.setResidence(rs.getString(4));
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
		return p;



	}
	
	/*
	 * 
	 * @param email del medico collegato ad un account
	 * @return null se non esiste alcun account associato all' email o il medico se ha trovato l'account associato
	 * @throws SQLException 
	 * 
	 * */
	
	public static Doctor doRetrieveByMedicoCollegato(String email) throws SQLException {

	
		PreparedStatement ps = null;
		Connection con = null;
		Doctor d = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM doctor, account WHERE account.email = doctor.email AND account.email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				d = new Doctor();
				d.setEmail(rs.getString(1));
				d.setPassword(rs.getString(2));
				d.setPhoneNumber(rs.getString(3));
				d.setStudioAddress(rs.getString(4));
				d.setAvgReviews(rs.getFloat(5));
				d.setType(rs.getString(6));

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
		return d;

	}

	
	/*
	 * 
	 * @param email del paziente di cui si vuole visualizzare la lista dei medici collegati
	 * @return null se non esiste alcun paziente o medici che mostra la lista dei medici se esiste il paziente collegato
	 * @throws SQLException 
	 * 
	 * */
	

	public static ArrayList<Doctor> doRetrieveAll(String email) throws SQLException {

	
		PreparedStatement ps = null;
		Connection con = null;
		Doctor d = null;
		ArrayList<Doctor> medici = null;

		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT d.email, d.password, d.phonenumber, d.studioaddress, d.avgreviews, d.type FROM patient p, doctor d, link l WHERE p.email = l.patient AND l.doctor = d.email AND p.email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			medici = new ArrayList<>();
			if(rs.next()) {
				d = new Doctor();
				d.setEmail(rs.getString(1));
				d.setPassword(rs.getString(2));
				d.setPhoneNumber(rs.getString(3));
				d.setStudioAddress(rs.getString(4));
				d.setAvgReviews(rs.getFloat(5));
				d.setType(rs.getString(6));
				medici.add(d);
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
		return medici;

	}



	/*
	 * 
	 * @param paziente il paziente da collegare al medico
	 * @param medico il medico da collegare al paziente
	 * @param state 
	 * @return false se non crea un collegamento o true se il collegamento viene creato correttamente
	 * @throws SQLException 
	 * 
	 * */
	

	public static boolean creaCollegamento(String paziente, String medico, int state) throws SQLException {

	
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO link(Patient, Doctor, State)"
							+ "VALUES(?,?,?);");
			ps.setString(1, paziente);
			ps.setString(2, medico);
			ps.setInt(3, state);
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
	 * 
	 * @param paziente il paziente da collegare al medico
	 * @param medico il medico da collegare al paziente
	 * @param state 
	 * @return false se il collegamento non è stato modificato correttamente o true se il collegamento viene modificato correttamente
	 * @throws SQLException 
	 * 
	 * 
	 * */
	
	
	public static boolean modificaStatoCollegamento(String paziente, String medico, int state) throws SQLException {

		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("UPDATE link SET state = ? where patient=? and doctor=?;");
			ps.setInt(1, state);
			ps.setString(2, paziente);
			ps.setString(3, medico);
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
	
	public static boolean controlloCollegamento(String patient, String doctor) throws SQLException, ParseException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM link WHERE Doctor=? AND Patient=?");
			ps.setString(1, doctor);
			ps.setString(2, patient);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("State")==0 || rs.getInt("State")==1) {
					return true;
				}
			}
				
			return false;
			
		}finally {
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
