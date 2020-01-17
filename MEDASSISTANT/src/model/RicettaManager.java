package model;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Prescription;
import connectionPool.DriverManagerConnectionPool;

public class RicettaManager {

	public static ArrayList<Prescription> ricercaRicettabyID(int id) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Prescription> ricetta = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM prescription WHERE MedicalReport = ? ORDER BY ID DESC");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			ricetta = new ArrayList<Prescription>();
			while(rs.next()) {
				
				Prescription ric = new Prescription();
				ric.setID(rs.getInt(1));
				ric.setMedicalreport((rs.getInt(2)));
				ric.setPrescription(rs.getBlob(3));
				ric.setDate(rs.getString(4));
				ric.setDoctor(rs.getString(5));
				ric.setPatient(rs.getString(6));
				ric.setState(rs.getInt(7));
				ricetta.add(ric);
			}
		}finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return ricetta;
		
	}
	
	public static boolean caricareRicetta(Prescription ricetta) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO prescription (MedicalReport, prescription,date,Doctor,Patient,state) VALUES (?,?,?,?,?,?)");
			ps.setInt(1,ricetta.getMedicalreport());
			ps.setBlob(2, ricetta.getPrescription());
			ps.setString(3, ricetta.getDate());
			ps.setString(4, ricetta.getDoctor());
			ps.setString(5, ricetta.getPatient());
			ps.setInt(6, ricetta.getState());
			if (ps.executeUpdate() != 1)
				return false;
			return true;
			
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
	
	public static boolean modificastato(int stato, int id) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("UPDATE prescription SET state = ? WHERE ID = ?");
			ps.setInt(1, stato);
			ps.setInt(2, id);
			

			if (ps.executeUpdate() != 1)
				return false;
			return true;
			
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
	
	public static int ritornoID(int report, String doctor, String patient, int state) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		int ret = 0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM prescription WHERE MedicalReport = ? AND doctor = ? AND patient = ? AND state = ?");
			ps.setInt(1, report);
			ps.setString(2, doctor);
			ps.setString(3, patient);
			ps.setInt(4, state);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				ret = rs.getInt(1);
			
			}
		}finally {
			try {
				if(ps!= null) {
					ps.close();
				}
			} finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
		return ret;
		
	}
	
	
	public static boolean updatericetta(int id, Blob ricetta, String date) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("UPDATE prescription SET state = -1, prescription = ?,date = ? WHERE ID = ?");
			ps.setBlob(1, ricetta);
			ps.setString(2, date);
			ps.setInt(3, id);
			

			if (ps.executeUpdate() != 1)
				return false;
			return true;
			
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
