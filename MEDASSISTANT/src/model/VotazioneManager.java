package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Voting;
import connectionPool.DriverManagerConnectionPool;

public class VotazioneManager {

	/*
	 * 
	 * @param v il voto da attribuire al medico
	 * @return true se la votazione è andata a buon fine, false altrimenti 
	 * @throws SQLException
	 * 
	 * */
	
	public static boolean votaMedico(Voting v) throws SQLException, ParseException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO voting (Date, Vote, Patient, Medico) VALUES(?,?,?,?);");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        Date parsed = format.parse(v.getDate());
	        java.sql.Date sql = new java.sql.Date(parsed.getTime());
			ps.setDate(1, sql);
			ps.setInt(2, v.getVote());
			ps.setString(3, v.getPatient());
			ps.setString(4, v.getDoctor());
			if (ps.executeUpdate() != 1) 
				return false;
			else
				return true;
			} finally {
				try {
					if(ps!= null) {
						ps.close();
						return false;
					}
				} finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
	
	public static boolean controlloVoto(String patient, String doctor) throws SQLException, ParseException {
		PreparedStatement ps = null;
		Connection con = null;
		System.out.println("sono qui");
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM voting WHERE Medico=? AND Patient=?");
			ps.setString(1, doctor);
			ps.setString(2, patient);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
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
