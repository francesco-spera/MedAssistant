package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.Patient;
import bean.Voting;
import connectionPool.DriverManagerConnectionPool;

public class RecensioneManager {

	//Inserire tupla in Review
	public static boolean doSave(Voting v) throws SQLException {
	
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO Review (Date, Ratings, Patient, Doctor) VALUES(?,?,?,?)");
			ps.setString(1, v.getDate());
			ps.setFloat(2, v.getVote());
			ps.setString(3, v.getPatient());
			ps.setString(4, v.getDoctor());
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

}
