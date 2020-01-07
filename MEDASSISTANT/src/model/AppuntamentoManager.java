package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Appointment;
import bean.Doctor;
import bean.Patient;
import connectionPool.DriverManagerConnectionPool;

public class AppuntamentoManager {

	//Inserire tupla in Appointment
	public static boolean creaAppuntamento(Appointment a) throws SQLException {
			PreparedStatement ps = null;
			Connection con = null;
			try {
				con = DriverManagerConnectionPool.getConnection();
				ps = con.prepareStatement("INSERT INTO Appointment(Date, Time, Doctor, State)"+ " VALUES(?, ?, ?, ?);");
				ps.setString(1, a.getDoctor());
				ps.setString(2, a.getTime());
				ps.setString(3, a.getDate());
				ps.setInt(4, a.getState());
				if (ps.executeUpdate() != 1) {
				ps.close();
				return false;
				}
				else return true;
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

	
	
	//Stampare la lista degli appuntamenti dato un paziente
	public ArrayList<Appointment> visualizzaAppDatoPaziente(Patient p) throws SQLException {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Appointment> app = new ArrayList<>();
		Appointment a= null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT idAppointment, doctor, time, date, state FROM Appointment A, Link L WHERE L.Patient = ? AND A.Doctor = L.Doctor;");
			ps.setString(1, p.getEmail());
			if(ps.executeUpdate() != 1)
			ps.close();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Appointment();
				a.setIdAppointment(rs.getInt(1));
				a.setDoctor(rs.getString(2));
				a.setTime(rs.getString(3));
			    a.setDate(rs.getString(4));
			    a.setState(rs.getInt(5));
				app.add(a);
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
		return app;
	}
	
	//Stampare la lista degli appuntamenti di un paziente dato un medico
	public ArrayList<Appointment> visualizzaAppPazienteDatoMedico(Patient p,String email) throws SQLException {
	
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Appointment> app = new ArrayList<>();
		Appointment a= null ;
		
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM Patient P, Doctor D, Link L, Appointment A WHERE P.email = L.Patient AND A.Doctor = L.Doctor AND D.email = \"Sassari\";");
			ps.setString(1, email);
			if(ps.executeUpdate() != 1 && !email.isEmpty())
			ps.close();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Appointment();
				a.setIdAppointment(rs.getInt(1));
				a.setDoctor(rs.getString(2));
				a.setTime(rs.getString(3));
			    a.setDate(rs.getString(4));
			    
			    app.add(a);
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
		return app;
	
	}
	
	//Stampare la lista degli appuntamenti dato un medico
	public ArrayList<Appointment> visualizzaAppMedico(String email) throws SQLException {

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Appointment> app = new ArrayList<>();
		Appointment a= new Appointment();
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM Doctor D, Appointment A WHERE D.email = A.Doctor;");
			ps.setString(1, email);
			if(ps.executeUpdate() != 1)
			ps.close();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Appointment();
				a.setIdAppointment(rs.getInt(1));
				a.setDoctor(rs.getString(2));
				a.setTime(rs.getString(3));
			    a.setDate(rs.getString(4));
				app.add(a);
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
		return app;
		
	}
	
	
	public static boolean ModificaAppuntamento(Appointment app,Patient p,Doctor d, String email) throws SQLException {
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			if(email.equals(p.getEmail())) {
				if(app.getDate() != null || app.getIdAppointment() != 0) {
					ps = con.prepareStatement("UPDATE appointment SET date = ?;");
					ps.setString(1, app.getDate());
					if (ps.executeUpdate() != 1)
					return false;				
				}
				ps.close();
				if(app.getTime() !=null ||  app.getIdAppointment() != 0) {
					ps = con.prepareStatement("UPDATE appointment SET time = ?;");
					ps.setString(1, app.getTime());
					if (ps.executeUpdate() != 1)
					return false;				
				}			
				ps.close();
				if(app.getDoctor()!=null ||  app.getIdAppointment() != 0) {
					ps = con.prepareStatement("UPDATE appointment SET doctor = ?;");
					ps.setString(1, app.getDoctor());
					if (ps.executeUpdate() != 1)
					return false;				
				}				
				ps.close();
				return true;
			}
			else if(email.equals(d.getEmail())) {
				if(app.getDate() != null || app.getIdAppointment() != 0) {
					ps = con.prepareStatement("UPDATE appointment SET date = ?;");
					ps.setString(1, app.getDate());
					if (ps.executeUpdate() != 1)
					return false;				
				}
				ps.close();
				if(app.getTime() !=null ||  app.getIdAppointment() != 0) {
					ps = con.prepareStatement("UPDATE appointment SET time = ?;");
					ps.setString(1, app.getTime());
					if (ps.executeUpdate() != 1)
					return false;				
				}			
				ps.close();
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
		return false;
	}
	
public static Appointment cercaAppuntamento(int id) throws SQLException {

		PreparedStatement ps = null;
		Connection con = null;
		Appointment a = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM Appointment A WHERE A.IDAppointment = ?;");
			ps.setInt(1, id);
			if(ps.executeUpdate() != 1)
			ps.close();
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				a = new Appointment();
				a.setIdAppointment(rs.getInt(1));
				a.setDate(rs.getString(2));
				a.setTime(rs.getString(3));
				a.setDoctor(rs.getString(4));
				a.setState(rs.getInt(4));
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
		return a;
		
	}
public static boolean cancellaAppuntamento(int id) throws SQLException {
	PreparedStatement ps = null;
	Connection con = null;
	try {
		con = DriverManagerConnectionPool.getConnection();
		ps = con.prepareStatement("DELETE FROM Appointment A WHERE A.IDAppointment = ?;");
		ps.setInt(1, id);
		if(ps.executeUpdate() != 1)
			ps.close();	
		ps.execute();
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
