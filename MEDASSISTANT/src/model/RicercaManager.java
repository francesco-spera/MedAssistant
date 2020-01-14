package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import connectionPool.DriverManagerConnectionPool;

public class RicercaManager {

	public static ArrayList<Doctor> cercaMedicoZonaTipo(String zona, String tipo) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Doctor> doc = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT email, phonenumber, studioaddress, avgreviews, type FROM doctor d WHERE d.type = ? AND d.municipalityAddress = ?;");
			ps.setString(1, tipo);
			ps.setString(2, zona);
			ResultSet rs = ps.executeQuery();
			doc = new ArrayList<Doctor>();
			while(rs.next()) {
				Doctor m = new Doctor();
				m.setEmail(rs.getString(1));
				m.setPhoneNumber(rs.getString(2));
				m.setStudioAddress(rs.getString(3));
				m.setAvgReviews(rs.getFloat(4));
				m.setType(rs.getString(5));
				doc.add(m);
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
		return doc;
	}
	
	public static ArrayList<Doctor> cercaMedicoNome(String name, String surname) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Doctor> doc = new ArrayList<Doctor>();
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT email, phonenumber, studioaddress, avgreviews, type FROM doctor d, account a WHERE d.email = a.doctor AND CONCAT( name,  ' ', surname ) LIKE ?;");
			ps.setString(1,"%" + name + " " +surname+ "%") ;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Doctor m = new Doctor();
				m.setEmail(rs.getString(1));
				m.setPhoneNumber(rs.getString(2));
				m.setStudioAddress(rs.getString(3));
				m.setAvgReviews(rs.getFloat(4));
				m.setType(rs.getString(5));
				doc.add(m);
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
		return doc;
	}
	
	public static ArrayList<Patient> cercaPazienteNome(String name, String surname) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		Patient p = null;
		ArrayList<Patient> pat = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			if(surname.isEmpty()) {
				ps = con.prepareStatement("SELECT email FROM patient p, account a WHERE p.email = a.patient AND name LIKE ?;");
				ps.setString(1,"%"+name+ "%") ;
			} else if(name.isEmpty()) {
					  ps = con.prepareStatement("SELECT email FROM patient p, account a WHERE p.email = a.patient AND surname LIKE ?;");
					  ps.setString(1,"%"+surname+ "%") ;
				  }
				  else {
					ps = con.prepareStatement("SELECT email, domicile, residence FROM patient p, account a WHERE p.email = a.patient AND CONCAT( name,  ' ', surname ) LIKE ?;");
					  ps.setString(1,"%" + name + " "+surname+ "%") ; //%name surname%
				  }
					  		 
				ResultSet rs = ps.executeQuery();
				pat = new ArrayList<>();
				while(rs.next()) {
					p = new Patient();
					p.setEmail(rs.getString(1));
					pat.add(p);
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
			return pat;
	}

	public static ArrayList<Account> getMedici(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Account> doc = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT name, surname, doctor FROM account a WHERE a.doctor = (SELECT doctor FROM link l WHERE l.patient = ?);");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			doc = new ArrayList<>();
			while(rs.next()) {
				Account m = new Account();
				m.setName(rs.getString(1));
				m.setSurname(rs.getString(2));
				m.setDoctor(rs.getString(3));
				doc.add(m);
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
		return doc;
	}
	
	public static ArrayList<Account> getPazienti(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Account> pat = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT name, surname, patient FROM account a WHERE a.patient = (SELECT patient FROM link l WHERE l.doctor = ?);");
			ps.setString(1, email);
			ps.executeQuery();
			ResultSet rs = ps.executeQuery();
			pat = new ArrayList<>();
			while(rs.next()) {
				Account p = new Account();
				p.setName(rs.getString(1));
				p.setSurname(rs.getString(2));
				p.setPatient(rs.getString(3));
				pat.add(p);
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
		return pat;
	}	

	public static Account cercaAccountMedico(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		Account m = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT name, surname, birthdate, photo FROM account a WHERE a.doctor = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				m = new Account();
				m.setName(rs.getString(1));
				m.setSurname(rs.getString(2));
				m.setBirthDate(rs.getString(3));
				m.setPhoto(rs.getBlob(4));
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
		return m;
	}

	public static Doctor cercaMedico(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		Doctor m = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT email, phonenumber, studioaddress, avgreviews, type, municipalityaddress FROM doctor d WHERE d.email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				m = new Doctor();
				m.setEmail(rs.getString(1));
				m.setPhoneNumber(rs.getString(2));
				m.setStudioAddress(rs.getString(3));
				m.setAvgReviews(rs.getFloat(4));
				m.setType(rs.getString(5));
				m.setMunicipalityAddress(rs.getString(6));
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
		return m;
	}

	public static Account cercaAccountPaziente(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		Account p = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT name, surname, cf, birthdate, photo FROM account a WHERE a.patient = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Account();
				p.setName(rs.getString(1));
				p.setSurname(rs.getString(2));
				p.setCf(rs.getString(3));
				p.setBirthDate(rs.getString(4));
				p.setPhoto(rs.getBlob(5));
				p.setPatient(email);
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
	
	public static Patient cercaPaziente(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		Patient p = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT email, domicile, residence FROM patient p WHERE p.email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Patient();
				p.setEmail(rs.getString(1));
				p.setDomicile(rs.getString(2));
				p.setResidence(rs.getString(3));
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
}