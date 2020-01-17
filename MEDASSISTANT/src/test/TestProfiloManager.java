package test;


import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bean.Account;
import bean.Patient;
import junit.framework.TestCase;
import model.ProfiloManager;

public class TestProfiloManager extends TestCase {

	
	

	@Override
	protected void setUp() throws Exception {
	}
	
	public void TestAutenticazione() throws SQLException {
		
		
		Account account = ProfiloManager.autenticazione("medico@gmail.com","");
		assertNull(account);
		account = ProfiloManager.autenticazione("","medico");
		assertNull(account);
		account = ProfiloManager.autenticazione("","");
		assertNull(account);
		account = ProfiloManager.autenticazione("medico@gmail.com","medicp");
		assertNull(account);
		
		
		account = ProfiloManager.autenticazione("medico@gmail.com","medico");
		assertNotNull(account);
		
		assertNotNull(account.getIdAccount());
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getCf());
		assertNotNull(account.getPhoto());
		
		
		if(account.getDoctor()!=null) {
		assertNotNull(account.getDoctor());
		}else assertNotNull(account.getPatient());
		
		
		
		account = ProfiloManager.autenticazione("paziente@gmail.com","");
		assertNull(account);
		account = ProfiloManager.autenticazione("","paziente");
		assertNull(account);
		account = ProfiloManager.autenticazione("","");
		assertNull(account);
		account = ProfiloManager.autenticazione("paziente@gmail.com","paziento");
		assertNull(account);
		
		
		account = ProfiloManager.autenticazione("paziente@gmail.com","paziente");
		assertNotNull(account);
		
		assertNotNull(account.getIdAccount());
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getCf());
		assertNotNull(account.getPhoto());
		
		
		if(account.getPatient()!=null) {
		assertNotNull(account.getPatient());
		}else assertNotNull(account.getDoctor());
		
		
		
	}
	/* VERIFICARE COME FARE PER REGISTRAZIONE
	public void TestRegistrazione() throws SQLException {
		
		
		
		Account account = new Account();
		Patient patient = new Patient();		
		account.setName("Paolo");
		account.setSurname("Rossi");
		account.setCf("PCJDHFSLSHDUDI");
		account.setBirthDate("14-10-1990");
		//account.setPhoto(photo);
		account.setPatient("pazientepaolo@gmail.com");
		
	
		patient.setDomicile("via verdi");
		patient.setEmail("pazientepaolo@gmail.com");
		patient.setResidence("caserta");
		patient.setPassword("pazientepaolo");
		
		
		
		
		Account account = ProfiloManager.autenticazione("medico@gmail.com","");
		assertNull(account);
		account = ProfiloManager.autenticazione("","medico");
		assertNull(account);
		account = ProfiloManager.autenticazione("","");
		assertNull(account);
		account = ProfiloManager.autenticazione("medico@gmail.com","medicp");
		assertNull(account);
		
		
		account = ProfiloManager.autenticazione("medico@gmail.com","medico");
		assertNotNull(account);
		
		assertNotNull(account.getIdAccount());
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getCf());
		assertNotNull(account.getPhoto());
		
		
		if(account.getDoctor()!=null) {
		assertNotNull(account.getDoctor());
		}else assertNotNull(account.getPatient());
		
		
		
		account = ProfiloManager.autenticazione("paziente@gmail.com","");
		assertNull(account);
		account = ProfiloManager.autenticazione("","paziente");
		assertNull(account);
		account = ProfiloManager.autenticazione("","");
		assertNull(account);
		account = ProfiloManager.autenticazione("paziente@gmail.com","paziento");
		assertNull(account);
		
		
		account = ProfiloManager.autenticazione("paziente@gmail.com","paziente");
		assertNotNull(account);
		
		assertNotNull(account.getIdAccount());
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getCf());
		assertNotNull(account.getPhoto());
		
		
		if(account.getPatient()!=null) {
		assertNotNull(account.getPatient());
		}else assertNotNull(account.getDoctor());
		
		
		
	}
	
	*/
	
	public void testRegistrazioneMED() throws SQLException{
		
	}
	public void testvisualizzaPaziente() throws SQLException{
		
	}
	public void testvisualizzaMedico() throws SQLException{
	
	}
	public void testmodificaProfiloPaz() throws SQLException{
		
	}
	public void testmodificaProfiloMed() throws SQLException{
	
	}
	public void testcercaAccount() throws SQLException{
		
	}
	
	
	@Test
	public void test() throws SQLException {
		TestAutenticazione();
	}

}
