package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;


import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpSession;

import control.gestioneAppuntamento.PrenotaAppuntamento;

public class TestPrenotaAppuntamento{

	@Test
	public void T2_1_1() throws IOException, SQLException{
		
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		prenotaServlet = new PrenotaAppuntamento();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);	
		
		Mockito.when(request.getParameter("doctor")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("patient")).thenReturn("paziente@gmail.com");
	
		Mockito.when(request.getParameter("date")).thenReturn("2020-02-01");
		Mockito.when(request.getParameter("time")).thenReturn("10:00");
		
		try{
			prenotaServlet.doPost(request, response);
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
	public void T2_1_2() throws IOException, SQLException{
		
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		prenotaServlet = new PrenotaAppuntamento();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);	
		
		Mockito.when(request.getParameter("doctor")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("patient")).thenReturn("paziente@gmail.com");
	
		Mockito.when(request.getParameter("date")).thenReturn("2020-01-01");
		Mockito.when(request.getParameter("time")).thenReturn("10:00");
		
		try{
			prenotaServlet.doPost(request, response);
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
	public void T2_1_3() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		prenotaServlet = new PrenotaAppuntamento();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);	
		
		Mockito.when(request.getParameter("doctor")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("patient")).thenReturn("paziente@gmail.com");
	
		Mockito.when(request.getParameter("date")).thenReturn("2020-02-01");
		Mockito.when(request.getParameter("time")).thenReturn("11:00");
		
		try{
			prenotaServlet.doPost(request, response);
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
	private PrenotaAppuntamento prenotaServlet;
	private MockHttpSession session;
	private PrintWriter print;
}
