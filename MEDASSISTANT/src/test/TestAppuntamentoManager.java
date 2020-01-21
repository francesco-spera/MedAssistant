package test;



import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bean.Appointment;
import junit.framework.*;
import model.AppuntamentoManager;

public class TestAppuntamentoManager extends TestCase {

	public TestAppuntamentoManager(String name) {
		super(name);
	}


	@Override
	protected void setUp() throws Exception {
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPrenotaAppuntamento() throws SQLException {
		
		Appointment app = new Appointment();
		//tc_2.1 codice 2.1.1
		app.setDate("2020-01-30");
		app.setTime("08:00");
		app.setDoctor("medico@gmail.com");
		app.setPatient("paziente@gmail.com");
		assertFalse(AppuntamentoManager.inserisciApp(app));
		
		//tc 2.1 codice 2.1.2
		/*app.setDate("2020-01-30");
		app.setTime("17:00");
		app.setDoctor("medico@gmail.com");
		app.setPatient("paziente@gmail.com");
		assertTrue(AppuntamentoManager.inserisciApp(app));
		
		*/
		
	}
	
	
	
	@Test
	public void test() throws SQLException {
		testPrenotaAppuntamento();
	}

}
