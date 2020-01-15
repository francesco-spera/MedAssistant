package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.Patient;
import bean.Voting;
import connectionPool.DriverManagerConnectionPool;

public class VotazioneManager {

	//Inserire tupla in Review
	public static boolean doSave(Date date, float vote, String patient, String doctor ) throws SQLException {
	
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO voting (Date, Vote, Patient, Doctor) VALUES(?,?,?,?)");
			ps.setDate(1, date);
			ps.setFloat(2, vote);
			ps.setString(3, patient);
			ps.setString(4, doctor);
			if (ps.executeUpdate() != 1) 
				throw new RuntimeException("INSERT error.");
				else
				return true;
			}
			finally {
				try {
					if(ps!= null) {
						ps.close();
						return false;
					}
					}
				finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
		}

	//Stampare la lista di recensioni dato un paziente
	public ArrayList<Voting> VisualizzaVotazioniPaziente(Patient p){
		
		PreparedStatement ps = null;
		Connection con = null;
		
		try{
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM Patient P, Review R WHERE P.email = R.Patient");
			ArrayList<Voting> recensioni = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Voting v = new Voting();
				v.setDate(rs.getString(1));
				v.setVote(rs.getFloat(2));
				recensioni.add(v);
			}
			return recensioni;
		} catch(SQLException e) {
				throw new RuntimeException(e);
		}


	}

	//Stampare la lista di recensioni dato un medico
	public ArrayList<Voting> VisualizzaVotiMedico(Doctor m){
				
		PreparedStatement ps = null;
		Connection con = null;

		try{
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM Doctor D, Review R WHERE D.email = R.Doctor");
			ArrayList<Voting> recensioni = new ArrayList<>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			Voting v = new Voting();
			v.setDate(rs.getString(1));
			v.setVote(rs.getFloat(2));
			recensioni.add(v);
			}
		return recensioni;
		}catch(SQLException e) {
		 throw new RuntimeException(e);
		}
	}
	
	
public static boolean controllaVoto(String emailMed, String emailPaz) throws SQLException {
	PreparedStatement ps = null;
	Connection con = null;

	try{
		con = DriverManagerConnectionPool.getConnection();
		ps = con.prepareStatement("SELECT * FROM voting v WHERE v.Doctor=? and v.Patient=?");
		ps.setString(1, emailMed);
		ps.setString(2, emailPaz);
		ResultSet rs = ps.executeQuery();
		if(!rs.next()) {
			return false;
		}else {
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


}
