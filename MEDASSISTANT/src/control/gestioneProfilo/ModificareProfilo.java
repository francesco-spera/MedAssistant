package control.gestioneProfilo;

import java.io.IOException;
import java.sql.SQLException;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("pazLog")!=null) {
			Account user = new Account();
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setBirthDate(request.getParameter("birth"));
			user.setCf(request.getParameter("cf"));
			user.setPatient(request.getParameter("email"));
			Patient paziente = new Patient();
			paziente.setEmail(request.getParameter("email"));
			paziente.setPassword(request.getParameter("psw"));
			paziente.setDomicile(request.getParameter("domicile"));
			paziente.setResidence(request.getParameter("residence"));
			try {
				if(ProfiloManager.modificaProfilo(user, paziente)) {
					request.getSession().setAttribute("pazLog", RicercaManager.cercaAccountPaziente(user.getPatient()));
					request.getSession().setAttribute("dettPaz", ProfiloManager.visualizzaPaziente(paziente.getEmail()));
					request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(request.getSession().getAttribute("docLog")!=null) {
			Account user = new Account();
			user.setName(request.getParameter("nameM"));
			user.setSurname(request.getParameter("surnameM"));
			user.setBirthDate(request.getParameter("birthM"));
			user.setCf(request.getParameter("cfM"));
			user.setDoctor(request.getParameter("emailM"));
			Doctor medico = new Doctor();
			medico.setEmail(request.getParameter("emailM"));
			medico.setPassword(request.getParameter("pswM"));
			medico.setPhoneNumber(request.getParameter("mobilep"));
			medico.setStudioAddress(request.getParameter("studioaddr"));
			medico.setType(request.getParameter("type"));
			medico.setMunicipalityAddress(request.getParameter("munaddr"));
			try {
				if(ProfiloManager.modificaProfilo(user, medico)) {
					request.getSession().setAttribute("docLog", RicercaManager.cercaAccountMedico(user.getDoctor()));
					request.getSession().setAttribute("dettDoc", ProfiloManager.visualizzaMedico(medico.getEmail()));
					request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static final long serialVersionUID = 1L;
}
