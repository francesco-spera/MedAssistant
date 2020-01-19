package test;


import java.sql.SQLException;
import java.text.ParseException;

import org.junit.jupiter.api.Test;

import bean.Voting;
import junit.framework.*;
import model.VotazioneManager;

public class TestVotazioneManager extends TestCase {
	
	
	/*
	public TestVotazioneManager(String name) {
		super(name);
	}*/


	@Override
	protected void setUp() throws Exception {
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	 
	public void testvotaMedico() throws SQLException, ParseException{
		//I CAMPI SONO PREIMPOSTATI QUINDI NON E' POSSIBILE UN CASO DI FAULT
		Voting v = new Voting();
		
		//caso di successo inserendo il campo con valore 1
		v.setVote(1);
		v.setDoctor("medico.medassistant@gmail.com");
		v.setPatient("paziente@gmail.com");
		v.setDate("2020-15-01");
		assertTrue(VotazioneManager.votaMedico(v));
		//caso di successo inserendo il campo con valore 2
		v.setVote(2);
		v.setDoctor("medico.medassistant@gmail.com");
		v.setPatient("paziente@gmail.com");
		v.setDate("2020-15-01");
		assertTrue(VotazioneManager.votaMedico(v));
		//caso di successo inserendo il campo con valore 3
		v.setVote(3);
		v.setDoctor("medico.medassistant@gmail.com");
		v.setPatient("paziente@gmail.com");
		v.setDate("2020-15-01");
		assertTrue(VotazioneManager.votaMedico(v));
		//caso di successo inserendo il campo con valore 4
		v.setVote(4);
		v.setDoctor("medico.medassistant@gmail.com");
		v.setPatient("paziente@gmail.com");
		v.setDate("2020-15-01");
		assertTrue(VotazioneManager.votaMedico(v));
		//caso di successo inserendo il campo con valore 5
		v.setVote(5);
		v.setDoctor("medico.medassistant@gmail.com");
		v.setPatient("paziente@gmail.com");
		v.setDate("2020-15-01");
		assertTrue(VotazioneManager.votaMedico(v));
	}
	
	
	@Test
	void test() throws SQLException, ParseException {
		testvotaMedico();
	}

}
