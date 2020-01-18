package test;


import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bean.MedicalReport;
import model.RefertoManager;
import junit.framework.*;

public class TestRefertoManager extends TestCase {

	public TestRefertoManager(String name) {
		super(name);
	}


	@Override
	protected void setUp() throws Exception {
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	
	
	public void testcaricaReferto() throws SQLException{
		
	}
	
	
	
	public void testgetRefertoById() throws SQLException{
		
		MedicalReport rep = RefertoManager.getRefertoById(0);
		assertNull(rep);
		
		rep = RefertoManager.getRefertoById(1);
		assertNotNull(rep.getIdReport());
		assertNotNull(rep.getDate());
		assertNotNull(rep.getDescription());
		assertNotNull(rep.getObject());
		assertNotNull(rep.getDoctor());
		assertNotNull(rep.getPatient());

		
	}
	
	public void testgetRefertoByPaziente() throws SQLException{
		
		ArrayList<MedicalReport> risult= RefertoManager.getRefertoByPaziente("medico@gmail.com");
		assertTrue(risult.isEmpty());

		
		risult= RefertoManager.getRefertoByPaziente("");
		assertTrue(risult.isEmpty());
		
	
		risult= RefertoManager.getRefertoByPaziente("paziente98@gmail.com");
		assertTrue(risult.isEmpty());
		
		risult = RefertoManager.getRefertoByPaziente("paziente@gmail.com");
		assertNotNull(risult);
		assertTrue(!risult.isEmpty());
		for (MedicalReport medicalReport : risult) {
			assertNotNull(medicalReport.getDate());
			assertNotNull(medicalReport.getIdReport());
			assertNotNull(medicalReport.getObject());
		
		}
		
	}
	
	
	
	
	
	
	@Test
	void test() throws SQLException {
		testgetRefertoById();
		testgetRefertoByPaziente();
	}

}
