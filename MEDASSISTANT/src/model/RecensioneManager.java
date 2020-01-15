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

public class RecensioneManager {

	/*
	 * 
	 * @param date la data da aggiungere
	 * @param vote la votazione da aggiungere
	 * @param patient il paziente che effettua la votazione da aggiungere
	 * @param doctor il dottore che riceve la votazione da aggiungere
	 * @return false se la votazione non è stata aggiunta correttamente o true se la votazione è stata aggiunta correttamente
	 * @throws SQLException
	 * 
	 * */
	
	public static boolean doSave(Date date, int vote, String patient, String doctor ) throws SQLException {
		  
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
	
	/*
	 * 
	 * @param p il paziente che ha effettuato le votazioni
	 * @return null se il paziente non ha effettuato alcuna votazione o recensioni che stampa la lista di votazioni effettuate dal paziente
	 * @throws SQLException
	 * 
	 * 
	 * */

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
	
	/*
	 * 
	 * @param m il medico che ha ricevuto le votazioni
	 * @return null se il medico non ha ricevuto alcuna votazione o recensioni che stampa la lista di votazioni ricevute dal medico
	 * @throws SQLException
	 * 
	 * */

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
