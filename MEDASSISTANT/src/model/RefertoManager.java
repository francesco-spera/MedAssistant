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
	

	//Inserire tupla in MedicalReport
	public boolean doSave(MedicalReport r, Doctor d) throws SQLException {
		//INSERT INTO MedicalReport(Object, Description, Doctor)
		//VALUES(?, ?, ?)

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

	//Stampare la lista dei referti dato un paziente
	public ArrayList<MedicalReport> doRetrieveByPaziente(String email) throws SQLException{
		//SELECT *
		//FROM Patient P, Link L, MedicalReport M
		//WHERE P.IDPatient = L.Patient AND L.Doctor = M.Doctor;

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

	//Stampare la lista dei referti dato un medico
	public ArrayList<MedicalReport> doRetrieveByMedico(String email) throws SQLException{
		//SELECT *
		//FROM Doctor D, MedicalReport M
		//WHERE D.IDDoctor = M.Doctor;
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
