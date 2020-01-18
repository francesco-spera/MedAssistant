package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Appointment;
import connectionPool.DriverManagerConnectionPool;

public class AppuntamentoManager {

	
	public static ArrayList<Appointment> visualizzaAPPmedico(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Appointment> app = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM appointment WHERE Doctor = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			app = new ArrayList<Appointment>();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setIdAppointment(rs.getInt(1));
			    a.setDate(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDoctor(rs.getString(4));
				a.setPatient(rs.getString(5));
				a.setState(rs.getInt(6));
				app.add(a);
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
		return app;
		
	}
	
	public static ArrayList<Appointment> visualizzaAPPpaziente(String email) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Appointment> app = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM appointment WHERE Patient = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			app = new ArrayList<Appointment>();
			while(rs.next()) {
				Appointment a = new Appointment();
				a.setIdAppointment(rs.getInt(1));
			    a.setDate(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDoctor(rs.getString(4));
				a.setPatient(rs.getString(5));
				a.setState(rs.getInt(6));
				app.add(a);
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
		return app;
		
	}
	
	public static Appointment visualizzaAppuntamento(int id) throws SQLException {
		
		PreparedStatement ps = null;
		Connection con = null;
		Appointment app = new Appointment();
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM appointment WHERE IDAppointment = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				app.setIdAppointment(rs.getInt(1));
			    app.setDate(rs.getString(2));
				app.setTime(rs.getString(3));
				app.setDoctor(rs.getString(4));
				app.setPatient(rs.getString(5));
				app.setState(rs.getInt(6));

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
		return app;
		

	}
	
	
	public static boolean controlloAppDisponibile(String doctor, String date, String time) throws SQLException {
		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM appointment WHERE Doctor=? AND Date=? AND Time=?");
			ps.setString(1, doctor);
			ps.setString(2, date);
			ps.setString(3, time);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt("IDAppointment")); 
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
	
	
	public static boolean inserisciApp(Appointment appuntamento) throws SQLException {
			
			PreparedStatement ps = null;
			Connection con = null;
			try {
				con = DriverManagerConnectionPool.getConnection();
				ps = con.prepareStatement("INSERT INTO appointment (Date,Time,Doctor,Patient,State) VALUES (?,?,?,?,?)");
				ps.setString(1, appuntamento.getDate());
				ps.setString(2, appuntamento.getTime());
				ps.setString(3, appuntamento.getDoctor());
				ps.setString(4, appuntamento.getPatient());
				ps.setInt(5, appuntamento.getState());
	
				
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

	public static int ritornoID(String doctor, String patient, String date, int state) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		int ret = 0;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM appointment WHERE Date = ? AND Doctor = ? AND Patient = ? AND state = ?");
			ps.setString(1, date);
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
	
	public static boolean updateAppuntamentoState(int state,int id) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("UPDATE appointment SET state = ? WHERE IDAppointment =?");

			ps.setInt(1, state);
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
	
	public static boolean modificaAppuntamento(int state,int id, String date, String time) throws SQLException{
		PreparedStatement ps = null;
		Connection con = null;
		System.out.println("new state:"+state);
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("UPDATE appointment SET Date =?, Time=?,State = ? WHERE IDAppointment =?");
			ps.setString(1, date);
			ps.setString(2, time);
			ps.setInt(3, state);
			ps.setInt(4, id);

			

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
