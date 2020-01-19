package test;

import java.sql.SQLException;
import java.text.ParseException;
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
	
	
	
	public void testCaricaReferto() throws SQLException{
		//I CAMPI DATA, DOCTOR E PATIENT SARANNO AUTOMATICAMENTE CORRETTI POICHE' GESTITI IN MODO AUTOMATICO
		//ASSUMIAMO CHE IL REFERTO CON OBJECT E DESCRIPTION VUOTI VOGLIANO DIRE CHE IL PAZIENTE NON HA AVUTO
		//BISOGNO DI CURE
		
		MedicalReport r = new MedicalReport();
		
		//caso di successo inserendo tutti i campi in modo corretto
		r.setDate("2010-01-01");
		r.setObject("malattia veneria");
		r.setDescription("prendersi il caspocazzalin per 8 gg mattina e sera");
		r.setDoctor("medico@gmail.com");
		r.setPatient("paziente@gmail.com");
		try {
			assertTrue(RefertoManager.caricaReferto(r));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//caso di successo inserendo tutti i campi tranne l'oggetto
		r.setDate("2010-01-01");
		r.setObject("");
		r.setDescription("prendersi il caspocazzalin per 8 gg mattina e sera");
		r.setDoctor("medico@gmail.com");
		r.setPatient("paziente@gmail.com");
		try {
			assertTrue(RefertoManager.caricaReferto(r));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//caso di successo inserendo tutti i campi tranne l'oggetto e la descrizione
		r.setDate("2010-01-01");
		r.setObject("");
		r.setDescription("");
		r.setDoctor("medico@gmail.com");
		r.setPatient("paziente@gmail.com");
		try {
			assertTrue(RefertoManager.caricaReferto(r));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//caso di successo inserendo tutti i campi tranne la descrizione
		r.setDate("2010-01-01");
		r.setObject("malattia veneria");
		r.setDescription("");
		r.setDoctor("medico@gmail.com");
		r.setPatient("paziente@gmail.com");
		try {
			assertTrue(RefertoManager.caricaReferto(r));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void testGetRefertoById() throws SQLException{
		//L'ID PASSATO AL METODO E' PASSATO IN MODO AUTOMATICO QUINDI ASSUMIAMO CHE SARA'
		//SEMPRE VERIFICATA LA QUERY
		MedicalReport rep = RefertoManager.getRefertoById(1);
		assertNotNull(rep);
		assertNotNull(rep.getIdReport());
		assertNotNull(rep.getDate());
		assertNotNull(rep.getDescription());
		assertNotNull(rep.getObject());
		assertNotNull(rep.getDoctor());
		assertNotNull(rep.getPatient());
	}
	
	public void testGetRefertoByPaziente() throws SQLException{
		//IL CAMPO PASSATO AL METODO E' PASSATO IN MODO AUTOMATICA QUINDI ASSUMIAMO CHE
		//NON SARA' MAI VUOTO
		
		ArrayList<MedicalReport> risult= null;
		
		//caso di non successo inserendo un paziente che non ha ancora referti associati
		risult= RefertoManager.getRefertoByPaziente("paziente98@gmail.com");
		assertTrue(risult.isEmpty());
		
		//caso di successo inserendo un paziente che ha referti associati
		risult = RefertoManager.getRefertoByPaziente("paziente@gmail.com");
		assertNotNull(risult);
		assertTrue(!risult.isEmpty());
	}

	
	@Test
	void test() throws SQLException {
		testCaricaReferto();
		testGetRefertoById();
		testGetRefertoByPaziente();
	}

}
