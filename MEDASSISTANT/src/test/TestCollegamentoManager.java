package test;


import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bean.Patient;
import junit.framework.TestCase;
import model.CollegamentoManager;

class TestCollegamentoManager extends TestCase {

	
	public void testdoRetrieveByPazienteCollegato() throws SQLException{
		
		
		
		//non usato 
		
		Patient p = CollegamentoManager.doRetrieveByPazienteCollegato("pippobaudo@gmail.com");
		assertNull(p);
		p = CollegamentoManager.doRetrieveByPazienteCollegato("");
		assertNull(p);
		p = CollegamentoManager.doRetrieveByPazienteCollegato("paziente.it");
		assertNull(p);
		
		
		p = CollegamentoManager.doRetrieveByPazienteCollegato("paziente@gmail.com");
		assertNotNull(p);
		assertNotNull(p.getEmail());
		assertNotNull(p.getDomicile());
		assertNotNull(p.getResidence());
		assertNotNull(p.getPassword());
		
		
	}
	
	
	public void testdoRetrieveAll() throws SQLException{
		//non usato
	}
	
	public void testcreaCollegamento() throws SQLException{
		
		
		//errore le inserisce nel db, controllare//
		assertFalse(CollegamentoManager.creaCollegamento("", "", 90));
		assertFalse(CollegamentoManager.creaCollegamento("paziente@gmail.com", "", 0));
		assertFalse(CollegamentoManager.creaCollegamento("medico@gmail.com", "paziente@gmail.com", 0));
		
		
		assertTrue(CollegamentoManager.creaCollegamento("paziente@gmail.com", "medico@gmail.com", 0));
		

	}

	public void testmodificaStatoCollegamento() throws SQLException{
	
		assertFalse(CollegamentoManager.modificaStatoCollegamento("", "", 0));
		assertFalse(CollegamentoManager.modificaStatoCollegamento("paziente.it", "", 0));
		assertFalse(CollegamentoManager.modificaStatoCollegamento("medico@gmail.com", "paziente@gmail.com", 0));
		assertFalse(CollegamentoManager.modificaStatoCollegamento("medico@gmail.com", "paziente.it", 0));
		
		
		assertTrue(CollegamentoManager.modificaStatoCollegamento("paziente@gmail.com", "medico@gmail.com", 1));

		
		
	}

	
	
		
	
	@Test
	void test() throws SQLException {

		//testcreaCollegamento();
		testmodificaStatoCollegamento();
	}

}
