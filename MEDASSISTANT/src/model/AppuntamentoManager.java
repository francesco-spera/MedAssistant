package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import bean.Appointment;
import connectionPool.DriverManagerConnectionPool;

public class AppuntamentoManager {

	
	public static ArrayList<Appointment> visualizzaAPPmedico(String email) throws SQLException{
		System.out.println("prova 3");
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Appointment> app = null;
		try {
			System.out.println("prova 4");
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
				a.setState(rs.getInt(5));
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
	
	
	

	
}
