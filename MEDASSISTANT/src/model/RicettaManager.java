package model;

import java.io.InputStream;
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
			ps = con.prepareStatement("SELECT * FROM prescription WHERE MedicalReport = ?");
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
			ps = con.prepareStatement("INSERT INTO prescription (MedicalReport, prescription,date,Doctor,Patient) VALUES (?,?,?,?,?)");
			ps.setInt(1,ricetta.getMedicalreport());
			ps.setBlob(2, ricetta.getPrescription());
			ps.setString(3, ricetta.getDate());
			ps.setString(4, ricetta.getDoctor());
			ps.setString(5, ricetta.getPatient());
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
