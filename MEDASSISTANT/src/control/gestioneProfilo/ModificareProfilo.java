package control.gestioneProfilo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import model.ProfiloManager;
import model.RicercaManager;

@WebServlet("/ModificareProfilo")
@MultipartConfig(maxFileSize = 32354432)//1.5mb 32.354.432 32354432
public class ModificareProfilo extends HttpServlet {

    public ModificareProfilo() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();	

		
		
		if(request.getSession().getAttribute("pazLog")!=null) {
			
			Account user = new Account();
			
			String name = request.getParameter("name");
			Pattern pattern = Pattern.compile(NAMEREGEX);
			Matcher m = pattern.matcher(name);
			if(!m.find()) {
				out.write("false");
				return;
			}
			user.setName(name);
			
			String surname = request.getParameter("surname");
			pattern = Pattern.compile(NAMEREGEX);
			m = pattern.matcher(surname);
			if(!m.find()) {
				out.write("false");
				return;
			}	
			user.setSurname(surname);
			
			String birth = request.getParameter("birth");
			if(birth==null) {
				out.write("false");
				return;
			}	
			user.setBirthDate(birth);
			
			String cf = request.getParameter("cf");
			if(cf.length()!=16) {
				out.write("false");
				return;
			}	
			user.setCf(cf);
			
			String email = request.getParameter("email");
			pattern = Pattern.compile(EMAILREGEX);
			m = pattern.matcher(email);
			if(!m.find()) {
				out.write("false");
				return;
			}	
			user.setPatient(email);
			
			Patient paziente = new Patient();
			paziente.setEmail(request.getParameter("email"));
			
			String password = request.getParameter("psw");
			if(password.length()<6) {
				out.write("false");
				return;
			}
			paziente.setPassword(request.getParameter("psw"));
			
			String domicile = request.getParameter("domicile");
			if(domicile==null) {
				out.write("false");
				return;
			}			
			paziente.setDomicile(domicile);
			
			
			String residence = request.getParameter("residence");
			if(residence==null) {
				out.write("false");
				return;
			}
			paziente.setResidence(residence);
			try {
				if(ProfiloManager.modificaProfilo(user, paziente)) {
					request.getSession().setAttribute("pazLog", RicercaManager.cercaAccountPaziente(user.getPatient()));
					request.getSession().setAttribute("dettPaz", ProfiloManager.visualizzaPaziente(paziente.getEmail()));
					out.write("true");
					request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(request.getSession().getAttribute("docLog")!=null) {
			Account user = new Account();
			
			String name = request.getParameter("nameM");
			Pattern pattern = Pattern.compile(NAMEREGEX);
			Matcher m = pattern.matcher(name);
			if(!m.find()) {
				out.write("false");
				return;
			}
			user.setName(name);
			
			String surname = request.getParameter("surnameM");
			pattern = Pattern.compile(NAMEREGEX);
			m = pattern.matcher(surname);
			if(!m.find()) {
				out.write("false");
				return;
			}	
			user.setSurname(surname);

			String birth = request.getParameter("birthM");
			if(birth==null) {
				out.write("false");
				return;
			}	
			user.setBirthDate(birth);

			String cf = request.getParameter("cfM");
			if(cf.length()!=16) {
				out.write("false");
				return;
			}	
			user.setCf(cf);
			
			String email = request.getParameter("emailM");
			pattern = Pattern.compile(EMAILREGEX);
			m = pattern.matcher(email);
			if(!m.find()) {
				out.write("false");
				return;
			}	
			user.setDoctor(email);
			
			
			Doctor medico = new Doctor();
			medico.setEmail(email);
			
			String password = request.getParameter("pswM");
			if(password.length()<6) {
				out.write("false");
				return;
			}
			medico.setPassword(password);
			
			String mobilep = request.getParameter("mobilep");
			if(mobilep.length()<10) {
				out.write("false");
				return;
			}			
			medico.setPhoneNumber(mobilep);
			
			String studioAddr = request.getParameter("studioaddr");
			if(studioAddr==null) {
				out.write("false");
				return;
			}			
			medico.setStudioAddress(studioAddr);
			
			
			medico.setType(request.getParameter("type"));
			
			String munAddr = request.getParameter("munaddr");
			pattern = Pattern.compile(NAMEREGEX);
			m = pattern.matcher(name);
			if(!m.find() && munAddr==null) {
				out.write("false");
				return;
			}
			medico.setMunicipalityAddress(munAddr);
			
			try {
				if(ProfiloManager.modificaProfilo(user, medico)) {
					request.getSession().setAttribute("docLog", RicercaManager.cercaAccountMedico(user.getDoctor()));
					request.getSession().setAttribute("dettDoc", ProfiloManager.visualizzaMedico(medico.getEmail()));
					out.write("true");
					request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static final long serialVersionUID = 1L;
	private static String EMAILREGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$";
	private static String NAMEREGEX = "^[A-Za-z]+$";
}
