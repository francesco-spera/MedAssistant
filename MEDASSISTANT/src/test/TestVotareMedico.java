package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;

import control.gestioneVotazione.VotaMedico;

public class TestVotareMedico {

	@Test
	public void TC_4_1_1() throws IOException {
		
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		votamedico = new VotaMedico();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);	
		
		Mockito.when(request.getParameter("emailDoc")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("emailPatient")).thenReturn("paziente@gmail.com");
	
		Mockito.when(request.getParameter("dateVote")).thenReturn("2020-01-18");
		Mockito.when(request.getParameter("selected_rating")).thenReturn("");
		
		
		try{
			votamedico.doPost(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		print.flush();
		print.close();
		Scanner scr = new Scanner(new File("tmp.txt"));
		String result = "";
		if(scr.hasNext()) {
			result = scr.nextLine();
		}
		scr.close();
		assertEquals("false", result);
		
	}
	
	@Test
	public void TC_4_1_2() throws IOException {
		
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		votamedico = new VotaMedico();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);	
		
		Mockito.when(request.getParameter("emailDoc")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("emailPatient")).thenReturn("paziente@gmail.com");
	
		Mockito.when(request.getParameter("dateVote")).thenReturn("2020-01-18");
		Mockito.when(request.getParameter("selected_rating")).thenReturn("1");
		
		
		try{
			votamedico.doPost(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		print.flush();
		print.close();
		Scanner scr = new Scanner(new File("tmp.txt"));
		String result = "";
		if(scr.hasNext()) {
			result = scr.nextLine();
		}
		scr.close(); 
		assertEquals("true", result);
		
	}
	
	
	
	

	private HttpServletRequest request;
	private HttpServletResponse response;
	private VotaMedico votamedico;
	private MockHttpSession session;
	private PrintWriter print;
}
