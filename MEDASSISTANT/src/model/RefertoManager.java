package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.MedicalReport;
import connectionPool.DriverManagerConnectionPool;

public class RefertoManager {
	

	/*
	 * 
	 * @param r referto da salvare
	 * @param d il dottore che ha compilato il referto
	 * @return false se il salvataggio non è avvenuto con successo o true  se il salvataggio è avvenuto correttamente
	 * @throws SQLException
	 * 
	 * */
	
	public boolean doSave(MedicalReport r, Doctor d) throws SQLException {
	

		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO medicalreport(Object, Description, Doctor)"
					+ "VALUES(?, ?, ?);");
			ps.setString(1, r.getObject());
			ps.setString(2, r.getDescription());
			ps.setString(3, d.getEmail());
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
	 * @param email l'email del paziente
	 * @return null se non è stato trovato alcun paziente o medrep che mostra la lista dei referti del paziente
	 * @throws SQLException
	 * 
	 * */
	
	public ArrayList<MedicalReport> doRetrieveByPaziente(String email) throws SQLException{
		
		PreparedStatement ps = null;
		Connection con = null;
		MedicalReport m = null;
		ArrayList<MedicalReport> medrep = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM patient p, link l, medicalreport m WHERE p.email = l.patient AND l.doctor = m.doctor AND l.email = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			medrep = new ArrayList<>();
			if(rs.next()) {
				m = new MedicalReport();
				m.setObject(rs.getString(1));
				m.setDescription(rs.getString(2));
				m.setDoctor(rs.getString(3));
				medrep.add(m);
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
		return medrep;



	}

	/*
	 * 
	 * @param email l'email del medico
	 * @return null se non è stato trovato alcun medico o medrep che mostra la lista dei referti dato un medico
	 * @throws SQLException
	 * 
	 * */
	
	public ArrayList<MedicalReport> doRetrieveByMedico(String email) throws SQLException{
		
		PreparedStatement ps = null;
		Connection con = null;
		MedicalReport m = null;
		ArrayList<MedicalReport> medrep = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM doctor d, medicalreport m WHERE d.email = m.doctor AND m.doctor = ?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			medrep = new ArrayList<>();
			if(rs.next()) {
				m = new MedicalReport();
				m.setObject(rs.getString(1));
				m.setDescription(rs.getString(2));
				m.setDoctor(rs.getString(3));
				medrep.add(m);
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
		return medrep;

	}
}
