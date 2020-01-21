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
import bean.Doctor;
import model.RicercaManager;

@WebServlet("/CercareMedicoNome")
public class CercareMedicoNome extends HttpServlet {
	
    public CercareMedicoNome() {
        super();
    }

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		Account patient = (Account) request.getSession().getAttribute("pazLog");
		if(patient==null) {
			out.write("false");
			return;
		}
		
		String emailpaz = patient.getPatient();
		Pattern pattern = Pattern.compile(EMAILREGEX);
		Matcher m = pattern.matcher(emailpaz);
		if(!m.find()) {
			out.write("false");
			return;
		}
		
		String name = request.getParameter("name");
		pattern = Pattern.compile(NAMEREGEX);
		m = pattern.matcher(name);
		if(!m.find()) {
			out.write("false");
			return;
		}
		
		
		String surname = request.getParameter("surname");
		pattern = Pattern.compile(NAMEREGEX);
		m = pattern.matcher(surname);
		if(!m.find()) {
			out.write("false");
			return;
		}
		
		
		try {
			ArrayList<Doctor> doctor = RicercaManager.cercaMedicoNome(name, surname,emailpaz);
			request.setAttribute("infoDoc", doctor);
			ArrayList<Account> account = new ArrayList<Account>();
			for(Doctor doc: doctor) {
				 account.add(RicercaManager.cercaAccountMedico(doc.getEmail()));
			}
			if(account.size()>0) {
				out.write("true");
			}else {
				out.write("false");
			}
			request.setAttribute("accDoc", account);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("presentation/ricerca/risultatiCercaMedico.jsp");
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
