package model;

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
	
	
	

	
}
