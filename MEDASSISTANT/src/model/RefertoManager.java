package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import bean.Account;
import bean.MedicalReport;
import connectionPool.DriverManagerConnectionPool;

public class RefertoManager {
	

	/*
	 * 
	 * @param r referto da caricare
	 * @return true se il caricamento è avvenuto correttamente, false altrimenti 
	 * @throws SQLException
	 * 
	 * */
	
	public static boolean caricaReferto(MedicalReport r) throws SQLException, ParseException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO medicalreport(Object, Description, Doctor, Patient, Date) VALUES(?, ?, ?, ?, ?);");
			ps.setString(1, r.getObject());
			ps.setString(2, r.getDescription());
			ps.setString(3, r.getDoctor());
			ps.setString(4, r.getPatient());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsed = format.parse(r.getDate());
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
			ps.setDate(5, sql);
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
	 * @param idReport id del medicalReport
	 * @return medRep se è stato trovato in base al suo id, null altrimenti
	 * @throws SQLException
	 * 
	 * */
	
	public static MedicalReport getRefertoById(int idReport) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		MedicalReport medRep = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM medicalreport WHERE idReport = ?;");
			ps.setInt(1, idReport);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				medRep = new MedicalReport();
				medRep.setIdReport(idReport);
				medRep.setObject(rs.getString(2));
				medRep.setDescription(rs.getString(3));
				medRep.setDoctor(rs.getString(4));
				medRep.setPatient(rs.getString(5));
				medRep.setDate(rs.getString(6));
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
		return medRep;
	}
	
	
	/*
	 * 
	 * @param email l'email del paziente
	 * @return medReps, collezione di medicalReport, se ne è stato trovato almeno uno in base alla email, null altrimenti
	 * @throws SQLException
	 * 
	 * */
	
	public static ArrayList<MedicalReport> getRefertoByPaziente(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<MedicalReport> medReps = null;
		try {
			medico = (Account) request.getSession().getAttribute("docLog");
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT object, date, idreport FROM medicalreport m WHERE m.patient = ? ORDER BY IDReport DESC;;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			medReps = new ArrayList<>();
			while(rs.next()) {
				MedicalReport m = new MedicalReport();
				m.setObject(rs.getString(1));
				m.setDate(rs.getString(2));
				int idReport = Integer.parseInt(rs.getString(3));
				m.setIdReport(idReport);
				medReps.add(m);
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
		return medReps;
	}
}
