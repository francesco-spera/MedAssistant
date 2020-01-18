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
		
		Voting v = null;
		assertFalse(VotazioneManager.votaMedico(v));
		
		v = new Voting();
		v.setVote(10000);
		v.setDoctor("");
		v.setPatient("");
		v.setDate(null);
		assertFalse(VotazioneManager.votaMedico(v));
		
		v = new Voting();
		v.setVote(0);
		v.setDoctor("");
		v.setPatient("");
		v.setDate(null);
		assertFalse(VotazioneManager.votaMedico(v));
		
		
		v = new Voting();
		v.setVote(5);
		v.setDoctor("medico.medassistant@gmail.com");
		v.setPatient("paziente@gmail.com");
		v.setDate("2020-15-01");
		assertTrue(VotazioneManager.votaMedico(v));
		
		
		
		//controllare
	}

	
	
	
	
	@Test
	void test() throws SQLException, ParseException {
		testvotaMedico();
	}

}
