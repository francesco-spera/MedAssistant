package test;

import static org.junit.jupiter.api.Assertions.*;

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

import control.gestioneProfilo.ModificareProfilo;

public class TestModificaProfiloPaziente {

	@Test
	public void TC1_4_1() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_2() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Gianni123");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_3() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_4() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_5() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_6() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_7() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_8() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_9() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	public void TC1_4_10() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("email")).thenReturn("paziente@gmail.com");
		Mockito.when(request.getParameter("name")).thenReturn("Piero");
		Mockito.when(request.getParameter("surname")).thenReturn("Armeno");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("paziente69@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("RMNPRI80A01F839J");
		Mockito.when(request.getParameter("domicile")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("residence")).thenReturn("via delle puglie");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		try{
			modificareProfiloServlet.doPost(request, response);
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
	private ModificareProfilo modificareProfiloServlet;
	private HttpSession session;
	private PrintWriter print;
	

}
