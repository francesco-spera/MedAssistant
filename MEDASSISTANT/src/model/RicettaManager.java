package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import bean.Prescription;
import connectionPool.DriverManagerConnectionPool;

public class RicettaManager {

	public static Prescription ricercaRicettabyID(int id) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		Prescription ricetta = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM prescription WHERE MedicalReport = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ricetta = new Prescription();
				ricetta.setID(rs.getInt(1));
				ricetta.setMedicalreport((rs.getInt(2)));
				ricetta.setPrescription(rs.getBlob(3));
				ricetta.setDoctor(rs.getString(4));
				ricetta.setPatient(rs.getString(5));
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
	
	



}
