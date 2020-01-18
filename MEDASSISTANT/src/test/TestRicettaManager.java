package test;


import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bean.Prescription;
import junit.framework.*;
import model.RicettaManager;

public class TestRicettaManager extends TestCase {

	

	@Override
	protected void setUp() throws Exception {
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testricercaRicettabyID() throws SQLException{
		
		
		ArrayList<Prescription> risult= RicettaManager.ricercaRicettabyID(0);
		assertTrue(risult.isEmpty());

		
		risult= RicettaManager.ricercaRicettabyID(-9);
		assertTrue(risult.isEmpty());
		
	
		risult= RicettaManager.ricercaRicettabyID(1);
		assertNotNull(risult);
		assertTrue(!risult.isEmpty());
		for (Prescription ric : risult) {
			assertNotNull(ric.getID());
			assertNotNull(ric.getMedicalreport());
			assertNotNull(ric.getPrescription());
			assertNotNull(ric.getDate());
			assertNotNull(ric.getDoctor());
			assertNotNull(ric.getPatient());
			assertNotNull(ric.getState());
		
		}
		
	}
		
		 
	
		
		
	
	
	@Test
	void test() throws SQLException {
		testricercaRicettabyID();
	}

}
