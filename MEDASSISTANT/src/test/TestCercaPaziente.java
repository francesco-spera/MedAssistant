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

import bean.Account;
import control.gestioneRicerca.CercarePazienteNome;

public class TestCercaPaziente {

	@Test
	public void TC3_1_1() throws IOException, SQLException{
	request = Mockito.mock(HttpServletRequest.class);
	response = Mockito.mock(HttpServletResponse.class);
	ricercaPazienteServlet = new CercarePazienteNome();
	print = new PrintWriter("tmp.txt");
	session = Mockito.mock(HttpSession.class);
	Mockito.when(response.getWriter()).thenReturn(print);
	Mockito.when(request.getSession()).thenReturn(session);
	
	
	Account medico = new Account();
	medico.setDoctor("medico@gmail.com");
	
	Mockito.when(session.getAttribute("docLog")).thenReturn(medico);
	Mockito.when(request.getParameter("name")).thenReturn("giuseppe");
	Mockito.when(request.getParameter("surname")).thenReturn("rossi");
	
	try{
		ricercaPazienteServlet.doGet(request, response);
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
	public void TC3_1_2() throws IOException, SQLException{
	request = Mockito.mock(HttpServletRequest.class);
	response = Mockito.mock(HttpServletResponse.class);
	ricercaPazienteServlet = new CercarePazienteNome();
	print = new PrintWriter("tmp.txt");
	session = Mockito.mock(HttpSession.class);
	Mockito.when(response.getWriter()).thenReturn(print);
	Mockito.when(request.getSession()).thenReturn(session);
	
	
	Account medico = new Account();
	medico.setDoctor("medico@gmail.com");
	
	Mockito.when(session.getAttribute("docLog")).thenReturn(medico);
	Mockito.when(request.getParameter("name")).thenReturn("joseph1");
	Mockito.when(request.getParameter("surname")).thenReturn("rossi");
	
	try{
		ricercaPazienteServlet.doGet(request, response);
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
	public void TC3_1_3() throws IOException, SQLException{
	request = Mockito.mock(HttpServletRequest.class);
	response = Mockito.mock(HttpServletResponse.class);
	ricercaPazienteServlet = new CercarePazienteNome();
	print = new PrintWriter("tmp.txt");
	session = Mockito.mock(HttpSession.class);
	Mockito.when(response.getWriter()).thenReturn(print);
	Mockito.when(request.getSession()).thenReturn(session);
	
	
	Account medico = new Account();
	medico.setDoctor("medico@gmail.com");
	
	Mockito.when(session.getAttribute("docLog")).thenReturn(medico);
	Mockito.when(request.getParameter("name")).thenReturn("joseph");
	Mockito.when(request.getParameter("surname")).thenReturn("rosso");
	
	try{
		ricercaPazienteServlet.doGet(request, response);
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
	public void TC3_1_4() throws IOException, SQLException{
	request = Mockito.mock(HttpServletRequest.class);
	response = Mockito.mock(HttpServletResponse.class);
	ricercaPazienteServlet = new CercarePazienteNome();
	print = new PrintWriter("tmp.txt");
	session = Mockito.mock(HttpSession.class);
	Mockito.when(response.getWriter()).thenReturn(print);
	Mockito.when(request.getSession()).thenReturn(session);
	
	
	Account medico = new Account();
	medico.setDoctor("medico@gmail.com");
	
	Mockito.when(session.getAttribute("docLog")).thenReturn(medico);
	Mockito.when(request.getParameter("name")).thenReturn("joseph");
	Mockito.when(request.getParameter("surname")).thenReturn("rossi1");
	
	try{
		ricercaPazienteServlet.doGet(request, response);
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
	public void TC3_1_5() throws IOException, SQLException{
	request = Mockito.mock(HttpServletRequest.class);
	response = Mockito.mock(HttpServletResponse.class);
	ricercaPazienteServlet = new CercarePazienteNome();
	print = new PrintWriter("tmp.txt");
	session = Mockito.mock(HttpSession.class);
	Mockito.when(response.getWriter()).thenReturn(print);
	Mockito.when(request.getSession()).thenReturn(session);
	
	
	Account medico = new Account();
	medico.setDoctor("medico@gmail.com");
	
	Mockito.when(session.getAttribute("docLog")).thenReturn(medico);
	Mockito.when(request.getParameter("name")).thenReturn("Joseph");
	Mockito.when(request.getParameter("surname")).thenReturn("Rossi");
	
	try{
		ricercaPazienteServlet.doGet(request, response);
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
	private CercarePazienteNome ricercaPazienteServlet;
	private HttpSession session;
	private PrintWriter print;
}
