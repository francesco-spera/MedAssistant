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

import control.gestioneProfilo.Registrazione;

public class TestRegistrazioneMedico {

	@Test
	public void TC1_3_1() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_2() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio123");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_3() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_4() throws IOException, SQLException{	
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito123");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_5() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_6() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98.gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_7() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_8() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_9() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_10() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_11() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_12() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na123");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_13() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na123");
		Mockito.when(request.getParameter("birth")).thenReturn("");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
	public void TC1_3_14() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		registrazioneServlet = new Registrazione();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("name")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surname")).thenReturn("Esposito");
		Mockito.when(session.getAttribute("emailDaRegistrare")).thenReturn("medico98@gmail.com");
		Mockito.when(request.getParameter("psw")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cf")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birth")).thenReturn("2000-01-01");
		Mockito.when(request.getParameter("type")).thenReturn("medico di base");
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
