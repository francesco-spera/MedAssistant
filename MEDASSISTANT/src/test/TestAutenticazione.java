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

import control.gestioneProfilo.Autenticazione;

public class TestAutenticazione {	
	
	@Test
	public void TC1_1_1() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		autenticazioneServlet = new Autenticazione();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("");
		Mockito.when(request.getParameter("psw")).thenReturn("medico");
		try{
			autenticazioneServlet.doPost(request, response);
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
	public void TC1_1_2() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		autenticazioneServlet = new Autenticazione();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("medico.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("medico");
		try{
			autenticazioneServlet.doPost(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		print.flush();
		print.close();
		Scanner sc = new Scanner(new File("tmp.txt"));
		String res = "";
		if(sc.hasNext()) {
			res = sc.nextLine();
		}
		sc.close();
		assertEquals("false", res);
	}
	
	@Test
	public void TC1_1_3() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		autenticazioneServlet = new Autenticazione();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("med");
		try{
			autenticazioneServlet.doPost(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		print.flush();
		print.close();
		Scanner sc = new Scanner(new File("tmp.txt"));
		String res = "";
		if(sc.hasNext()) {
			res = sc.nextLine();
		}
		sc.close();
		assertEquals("false", res);
	}
	
	@Test
	public void TC1_1_4() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		autenticazioneServlet = new Autenticazione();
		print = new PrintWriter("tmp.txt");
		session = new MockHttpSession();
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("medico@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("medico");
		try{
			autenticazioneServlet.doPost(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
		print.flush();
		print.close();
		Scanner sc = new Scanner(new File("tmp.txt"));
		String res = "";
		if(sc.hasNext()) {
			res = sc.nextLine();
		}
		sc.close();
		assertEquals("true", res);
	}
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Autenticazione autenticazioneServlet;
	private MockHttpSession session;
	private PrintWriter print;
}
