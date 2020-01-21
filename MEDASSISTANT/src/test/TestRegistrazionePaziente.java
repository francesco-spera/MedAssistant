package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.mockito.Mockito;

import control.gestioneProfilo.Registrazione;

public class TestRegistrazionePaziente {

	@Test
	public void TC1_2_1() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_2() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero123");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_3() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_4() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno123");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_5() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_6() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_7() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_8() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_9() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_10() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_11() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("");
		try{
			registrazioneServlet.doPost(request, response);
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
	public void TC1_2_12() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			registrazioneServlet.doPost(request, response);
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
	private Registrazione registrazioneServlet;
	private HttpSession session;
	private PrintWriter print;
}
