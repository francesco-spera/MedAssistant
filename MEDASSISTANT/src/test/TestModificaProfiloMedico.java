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

public class TestModificaProfiloMedico {


	@Test
	public void TC1_5_1() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("ce");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_2() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio123");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_3() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_4() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito123");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_5() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_6() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_7() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_8() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_9() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
	public void TC1_5_10() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("");
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
	public void TC1_5_11() throws IOException, SQLException{
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		modificareProfiloServlet = new ModificareProfilo();
		print = new PrintWriter("tmp.txt");
		session = Mockito.mock(HttpSession.class);
		Mockito.when(response.getWriter()).thenReturn(print);
		Mockito.when(request.getSession()).thenReturn(session);
		
		Mockito.when(request.getParameter("emailM")).thenReturn("medico.medassistant@gmail.com");
		Mockito.when(request.getParameter("nameM")).thenReturn("Antonio");
		Mockito.when(request.getParameter("surnameM")).thenReturn("Esposito");
		Mockito.when(request.getParameter("pswM")).thenReturn("prova1234");
		Mockito.when(request.getParameter("cfM")).thenReturn("SPSNTN80A01F839R");
		Mockito.when(request.getParameter("mobilep")).thenReturn("3312436699");
		Mockito.when(request.getParameter("studioaddr")).thenReturn("via dei girasoli");
		Mockito.when(request.getParameter("munaddr")).thenReturn("na");
		Mockito.when(request.getParameter("birthM")).thenReturn("1990-01-01");
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
