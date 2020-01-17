package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import model.RicercaManager;

class TestRicercaManager {

	
	public void testcercaMedicoZonaTipo() throws SQLException{
		
	}
	
	public void testcercaMedicoNome() throws SQLException{
		
		ArrayList<Doctor> risult= RicercaManager.cercaMedicoNome("pietro", "neri", "paziente@gmail.com");
		assertTrue(risult.isEmpty());
		
		risult = RicercaManager.cercaMedicoNome("", "", "paziente@gmail.com");
		assertTrue(!risult.isEmpty());
		assertNotNull(risult);
		
		risult = RicercaManager.cercaMedicoNome("maria", "", "paziente@gmail.com");
		assertTrue(!risult.isEmpty());
		assertNotNull(risult);
		
		risult = RicercaManager.cercaMedicoNome("", "verde", "paziente@gmail.com");
		assertTrue(!risult.isEmpty());
		assertNotNull(risult);
		
		risult = RicercaManager.cercaMedicoNome("maria", "verde", "paziente@gmail.com");
		assertTrue(!risult.isEmpty());
		assertNotNull(risult);
		
		
	}
	
	public void testcercaPazienteNome() throws SQLException{
		
	}
	
	public void testgetMedici() throws SQLException{
		
		ArrayList<Account> risult= RicercaManager.getMedici("medico@gmail.com");
		assertTrue(risult.isEmpty());

		risult= RicercaManager.getMedici("");
		assertTrue(risult.isEmpty());
		
		risult = RicercaManager.getMedici("paziente@gmail.com");
		assertNotNull(risult);
		assertTrue(!risult.isEmpty());
		
	}
	
	public void testgetPazienti() throws SQLException{
		ArrayList<Account> risult= RicercaManager.getPazienti("paziente@gmail.com");
		assertTrue(risult.isEmpty());

		risult= RicercaManager.getPazienti("");
		assertTrue(risult.isEmpty());
		
		risult = RicercaManager.getPazienti("medico@gmail.com");
		assertNotNull(risult);
		assertTrue(!risult.isEmpty());
	}
	
	public void testcercaAccountMedico() throws SQLException{
		
		Account account = RicercaManager.cercaAccountMedico("");
		assertNull(account);

		
		account = RicercaManager.cercaAccountMedico("medico@gmail.com");
		assertNotNull(account);
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getDoctor());


		
	}
	
	public void testcercaMedico() throws SQLException{
		
		Doctor account = RicercaManager.cercaMedico("");
		assertNull(account);

		
		account = RicercaManager.cercaMedico("medico@gmail.com");
		assertNotNull(account);
		assertNotNull(account.getEmail());
		assertNotNull(account.getPhoneNumber());
		assertNotNull(account.getStudioAddress());
		assertNotNull(account.getAvgReviews());
		assertNotNull(account.getMunicipalityAddress());
		assertNotNull(account.getType());
		
		
	}
	
	public void testcercaAccountPaziente() throws SQLException{
		
		Account account = RicercaManager.cercaAccountPaziente("");
		assertNull(account);

		
		account = RicercaManager.cercaAccountPaziente("paziente@gmail.com");
		assertNotNull(account);
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getPatient());

	}
	
	public void testcercaPaziente() throws SQLException{
		

		Patient account = RicercaManager.cercaPaziente("");
		assertNull(account);

		
		account = RicercaManager.cercaPaziente("paziente@gmail.com");
		assertNotNull(account);
		assertNotNull(account.getEmail());
		assertNotNull(account.getDomicile());
		assertNotNull(account.getResidence());

	}
	
	
	
	
	@Test
	void test() throws SQLException {
		testcercaMedicoNome();
		testgetMedici();
		testgetPazienti();
		testcercaAccountMedico();
		testcercaMedico();
		testcercaAccountPaziente();
		testcercaPaziente();
		
	}

}
