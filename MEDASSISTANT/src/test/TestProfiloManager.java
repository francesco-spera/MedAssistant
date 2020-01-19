package test;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import connectionPool.DriverManagerConnectionPool;
import junit.framework.TestCase;
import model.ProfiloManager;

public class TestProfiloManager extends TestCase {
	@Override
	protected void setUp() throws Exception {
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	
	public void testAutenticazione() throws SQLException {
		Account account = null;
		
		//caso di non successo per medico non inserendo la password
		account = ProfiloManager.autenticazione("medico@gmail.com","");
		assertNull(account);
		//caso di non successo per medico non inserendo l'email
		account = ProfiloManager.autenticazione("","medico");
		assertNull(account);
		//caso di non successo per medico non inserendo sia email che password
		account = ProfiloManager.autenticazione("","");
		assertNull(account);
		//caso di non successo per medico sbagliando la password
		account = ProfiloManager.autenticazione("medico@gmail.com","medicp");
		assertNull(account);
		//casi di non successo per medico sbagliando l'email
		account = ProfiloManager.autenticazione("medio@gmail.com","medico");
		assertNull(account);
		//caso di successo per medico inserendo email e password corretti
		account = ProfiloManager.autenticazione("medico@gmail.com","medico");
		assertNotNull(account);
		assertNotNull(account.getIdAccount());
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getCf());
		assertNotNull(account.getPhoto());
		assertNotNull(account.getDoctor());	
		
		//caso di non successo per paziente non inserendo la password
		account = ProfiloManager.autenticazione("paziente@gmail.com","");
		assertNull(account);
		//casi di non successo per paziente non inserendo l'email
		account = ProfiloManager.autenticazione("","paziente");
		assertNull(account);
		//casi di non successo per paziente non inserendo sia email che password
		account = ProfiloManager.autenticazione("","");
		assertNull(account);
		//casi di non successo per paziente sbagliando la password
		account = ProfiloManager.autenticazione("paziente@gmail.com","paziento");
		assertNull(account);
		//casi di non successo per paziente sbagliando l'email
		account = ProfiloManager.autenticazione("paziene@gmail.com","paziente");
		assertNull(account);
		//casu di successo per paziente inserendo email e password corretti
		account = ProfiloManager.autenticazione("paziente@gmail.com","paziente");
		assertNotNull(account);
		assertNotNull(account.getIdAccount());
		assertNotNull(account.getName());
		assertNotNull(account.getSurname());
		assertNotNull(account.getBirthDate());
		assertNotNull(account.getCf());
		assertNotNull(account.getPhoto());
		assertNotNull(account.getPatient());	
	}
	
	/*public void testRegistrazionePaziente() throws SQLException {
		Patient patient = new Patient();
		Account account = new Account();
		
		//caso di successo per paziente inserendo le credenziali in modo corretto
		account.setName("Paolo");
		account.setSurname("Rossi");
		account.setCf("PCJDHFSLSHDUDIDW");
		account.setBirthDate("1990-01-14");
		byte[] byteData = null;
		try {
			byteData = "C:\\Users\\spera\\Desktop\\appelli.png".getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Blob blobData = DriverManagerConnectionPool.getConnection().createBlob();
		blobData.setBytes(1, byteData);
		account.setPhoto(blobData);
		account.setPatient("pazientepaolo@gmail.com");
		patient.setEmail("pazientepaolo@gmail.com");
		patient.setPassword("pazientepaolo");
		patient.setDomicile("via verdi");
		patient.setResidence("caserta");
		assertTrue(ProfiloManager.registrazione(account, patient));
	}
	
	public void testRegistrazioneMedico() throws SQLException{
		Account account = new Account();
		Doctor doctor = new Doctor();
		
		//caso di successo per medico inserendo le credenziali in modo corretto
		account.setName("Maria");
		account.setSurname("verdi");
		account.setCf("PCJDHFSLSHDUDF4I");
		account.setBirthDate("1990-02-01");
		byteData = null;
		try {
			byteData = "C:\\Users\\spera\\Desktop\\appelli.png".getBytes("UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		blobData = DriverManagerConnectionPool.getConnection().createBlob();
		blobData.setBytes(1, byteData);
		account.setPhoto(blobData);
		account.setDoctor("medicomaria@gmail.com");
		doctor.setEmail("medicomaria@gmail.com");
		doctor.setPassword("medicomaria");
		doctor.setPhoneNumber("0101011010");
		doctor.setStudioAddress("via Argine");
		doctor.setType("medico di base");
		doctor.setMunicipalityAddress("via Argine");
		assertTrue(ProfiloManager.registrazione(account, doctor));
	}*/
	
	public void testVisualizzaPaziente() throws SQLException{
		Patient patient = null;
		
		//caso di successo inserendo l'email corretta
		patient = ProfiloManager.visualizzaPaziente("paziente@gmail.com");
		assertNotNull(patient);
		assertNotNull(patient.getEmail());
		assertNotNull(patient.getResidence());
		assertNotNull(patient.getDomicile());
		//caso di non successo inserendo l'email sbagliata
		patient = ProfiloManager.visualizzaPaziente("pazien@gmail.com");
		assertNull(patient);
		//caso di non successo non inserendo l'email
		patient = ProfiloManager.visualizzaPaziente("");
		assertNull(patient);
	}
	
	public void testVisualizzaMedico() throws SQLException{
		Doctor doctor = null;
		
		//caso di successo inserendo l'email corretta
		doctor = ProfiloManager.visualizzaMedico("medico@gmail.com");
		assertNotNull(doctor);
		assertNotNull(doctor.getEmail());
		assertNotNull(doctor.getPhoneNumber());
		assertNotNull(doctor.getStudioAddress());
		assertNotNull(doctor.getMunicipalityAddress());
		assertNotNull(doctor.getType());
		//caso di non successo inserendo l'email sbagliata
		doctor = ProfiloManager.visualizzaMedico("medic@gmail.com");
		assertNull(doctor);
		//caso di non successo non inserendo l'email
		doctor = ProfiloManager.visualizzaMedico("");
		assertNull(doctor);
	}
	
	public void testModificaProfiloPaziente() throws SQLException{
		Account account = new Account();
		Patient patient = new Patient();
		
		//caso di successo modificando tutti i campi
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setPatient("prova@gmail.com");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi tranne il nome
		account.setName("");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setPatient("prova@gmail.com");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi tranne il nome e cognome
		account.setName("");
		account.setSurname("");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setPatient("prova@gmail.com");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi tranne il nome, cognome e data di nascita
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("abcabcabcabcabca");
		account.setPatient("prova@gmail.com");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita e cf
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setPatient("prova@gmail.com");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita, cf e psw
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setPatient("prova@gmail.com");
		patient.setPassword("");
		patient.setEmail("prova@gmail.com");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita, cf, psw e domicilio
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setPatient("prova@gmail.com");
		patient.setPassword("");
		patient.setDomicile("");
		patient.setEmail("prova@gmail.com");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo non modificando campi lasciando i campi email e patient
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setPatient("prova@gmail.com");
		patient.setPassword("");
		patient.setDomicile("");
		patient.setEmail("prova@gmail.com");
		patient.setResidence("");;
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di non successo modificando tutti i campi e non inserendo il campo email in patient
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setPatient("prova@gmail.com");
		patient.setEmail("");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertFalse(ProfiloManager.modificaProfilo(account, patient));
		//caso di non successo modificando tutti i campi e non inserendo il campo patient in account
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setPatient("");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertFalse(ProfiloManager.modificaProfilo(account, patient));
		//caso di non successo modificando tutti i campi e non inserendo nè il campo patient in account nè
		//il campo email in patient
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");;
		account.setPatient("");
		patient.setEmail("");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertFalse(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi escludendo quelli di patient
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");;
		account.setPatient("prova@gmail.com");
		patient.setEmail("");
		patient.setPassword("");
		patient.setDomicile("");
		patient.setResidence("");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
		//caso di successo modificando tutti i campi escludendo quelli di account
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setPatient("");
		patient.setEmail("prova@gmail.com");
		patient.setPassword("ciao1234");
		patient.setDomicile("via rodari");
		patient.setResidence("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, patient));
	}
	
	public void testModificaProfiloMedico() throws SQLException{
		Account account = new Account();
		Doctor doctor = new Doctor();
		
		//caso di successo modificando tutti i campi
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome
		account.setName("");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome e cognome
		account.setName("");
		account.setSurname("");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome, cognome e data di nascita
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita e cf
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita, cf e psw
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita, cf, psw e numero di telefono
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("");
		doctor.setPhoneNumber("");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi tranne il nome, cognome, data di nascita, cf, psw
		//numero di telefono, indirizzo studio
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("");
		doctor.setPhoneNumber("");
		doctor.setStudioAddress("");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo non modificando campi lasciando i campi email e doctor
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("");
		doctor.setPhoneNumber("");
		doctor.setStudioAddress("");
		doctor.setMunicipalityAddress("");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di non successo modificando tutti i campi e non inserendo il campo email in doctor
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertFalse(ProfiloManager.modificaProfilo(account, doctor));
		//caso di non successo modificando tutti i campi e non inserendo il campo doctor in account
		account.setName("Mario");
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertFalse(ProfiloManager.modificaProfilo(account, doctor));
		//caso di non successo modificando tutti i campi e non inserendo nè il campo doctor in account nè
		//il campo email in doctor
		account.setName("Mario");
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("");
		doctor.setEmail("");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertFalse(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi escludendo quelli di doctor
		account.setName("Mario");
		account.setName("Mario");
		account.setSurname("Rossi");
		account.setBirthDate("1990-01-01");
		account.setCf("abcabcabcabcabca");
		account.setDoctor("medico.medassistant@gmail.com");
		doctor.setEmail("");
		doctor.setPassword("");
		doctor.setPhoneNumber("");
		doctor.setStudioAddress("");
		doctor.setMunicipalityAddress("");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
		//caso di successo modificando tutti i campi escludendo quelli di account
		account.setName("");
		account.setName("");
		account.setSurname("");
		account.setBirthDate("");
		account.setCf("");
		account.setDoctor("");
		doctor.setEmail("medico.medassistant@gmail.com");
		doctor.setPassword("ciao1234");
		doctor.setPhoneNumber("0818411213");
		doctor.setStudioAddress("via rodari");
		doctor.setMunicipalityAddress("via rodari");
		assertTrue(ProfiloManager.modificaProfilo(account, doctor));
	}
	
	public void testCercaAccount() throws SQLException{
		//caso di successo inserendo l'email corretta
		assertTrue(ProfiloManager.cercaAccount("medico@gmail.com"));
		//caso di non successo inserendo l'email sbagliata
		assertFalse(ProfiloManager.cercaAccount("medio@gmail.com"));
		//caso di non successo non inserendo l'email
		assertFalse(ProfiloManager.cercaAccount(""));
	}
	
	
	@Test
	public void test() throws SQLException {
		testAutenticazione();
		//testRegistrazionePaziente();
		//testRegistrazioneMedico();
		testVisualizzaPaziente();
		testVisualizzaMedico();
		testModificaProfiloPaziente();
		testModificaProfiloMedico();
		testCercaAccount();
	}

}
