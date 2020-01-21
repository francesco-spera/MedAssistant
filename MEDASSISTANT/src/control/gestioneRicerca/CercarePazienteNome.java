package control.gestioneRicerca;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;


import bean.Account;
import bean.Patient;
import model.RicercaManager;


@WebServlet("/CercarePazienteNome")
public class CercarePazienteNome extends HttpServlet {
	
    public CercarePazienteNome() {
        super();
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		
		Account doctor = (Account) request.getSession().getAttribute("docLog");
		if(doctor==null) {
			out.write("false");
			return;
		}
		
		System.out.println("1");
		
		String emaildoc = doctor.getDoctor();
		Pattern pattern = Pattern.compile(EMAILREGEX);
		Matcher m = pattern.matcher(emaildoc);
		if(!m.find()) {
			out.write("false");
			return;
		}
		
		System.out.println("2");
		
		String name = request.getParameter("name");
		pattern = Pattern.compile(NAMEREGEX);
		m = pattern.matcher(name);
		if(!m.find()) {
			out.write("false");
			return;
		}
		
		System.out.println("3");
		
		String surname = request.getParameter("surname");
		pattern = Pattern.compile(NAMEREGEX);
		m = pattern.matcher(surname);
		if(!m.find()) {
			out.write("false");
			return;
		}
		
		System.out.println(name+" "+surname+" "+emaildoc);
		
		System.out.println("4");
		
		try {
			System.out.println("5");
			ArrayList<Patient> patient = RicercaManager.cercaPazienteNome(name, surname, emaildoc);
			request.setAttribute("infoPaz", patient);
			ArrayList<Account> account = new ArrayList<Account>();
			System.out.println("size: "+ patient.size());
			for(Patient pat: patient) {
				System.out.println("6");
				 account.add(RicercaManager.cercaAccountPaziente(pat.getEmail()));
			}
			if(account.size()>0) {
				out.write("true");
				System.out.println("true");
			}else {
				out.write("false");
				return;
			}
			request.setAttribute("accPaz", account);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("presentation/ricerca/risultatiCercaPaziente.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
	private static String EMAILREGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$";
	private static String NAMEREGEX = "^[A-Za-z]+$";
}
