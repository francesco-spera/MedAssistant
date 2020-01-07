package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Doctor;
import bean.MedicalReport;
import bean.Prescription;
import connectionPool.DriverManagerConnectionPool;

public class RicettaManager {

	//Inserire tupla in Prescription
	public static boolean doSave(Prescription r) throws SQLException {

		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("INSERT INTO Prescription(Path, MedicalReport) VALUES(?,?)");
			ps.setString(1, r.getPath());
			ps.setInt(2, r.getMedicalReport());
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

		
	//Stampare la lista delle prescizioni dato un referto
	public ArrayList<Prescription> visualizzaRicetteDatoReferto(MedicalReport r){

		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Prescription> ricette = new ArrayList<>();
		try{
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM MedicalReport M, Prescription P WHERE M.IDReport = P.MedicalReport");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Prescription pr = new Prescription();
				pr.setPath(rs.getString(1));
				pr.setMedicalReport(2);
				ricette.add(pr);
			}
			return ricette;
		} catch(SQLException e) {
				throw new RuntimeException(e);
		}
	}

	//Stampare la lista delle prescrizioni dato un medico
	public ArrayList<Prescription> visualizzaRicetteDatoMedico(Doctor m){
		
		PreparedStatement ps = null;
		Connection con = null;
		ArrayList<Prescription> ricette = new ArrayList<>();
		try{
			con = DriverManagerConnectionPool.getConnection();
			ps = con.prepareStatement("SELECT * FROM Doctor D, MedicalReport M, Prescription P WHERE D.email = M.Doctor AND M.IDReport = P.MedicalReport");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Prescription pr = new Prescription();
				pr.setPath(rs.getString(1));
				pr.setMedicalReport(2);
				ricette.add(pr);
			}
			return ricette;
		} catch(SQLException e) {
				throw new RuntimeException(e);
		}

	}



}
