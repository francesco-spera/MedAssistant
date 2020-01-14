package control.gestioneProfilo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import model.ProfiloManager;

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
		Account user = new Account();
		String email = request.getParameter("email");
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setBirthDate(request.getParameter("birth"));
		user.setCf(request.getParameter("cf"));
		Part part = request.getPart("photo");
		InputStream is = part.getInputStream();
		Blob blob = (Blob) is;
		user.setPhoto(blob);;
		if(request.getSession().getAttribute("pazLog")!=null) {
			user.setPatient(email);
			Patient paziente = new Patient();
			paziente.setEmail(email);
			paziente.setPassword(request.getParameter("psw"));
			paziente.setDomicile(request.getParameter("domicile"));
			paziente.setResidence(request.getParameter("residence"));
			try {
				if(ProfiloManager.modificaProfilo(user, paziente))
					request.getRequestDispatcher("visualizzaProfiloPersonale.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			user.setDoctor(email);
			Doctor medico = new Doctor();
			medico.setEmail(email);
			medico.setPassword(request.getParameter("psw"));
			medico.setPhoneNumber(request.getParameter("mobilep"));
			medico.setStudioAddress(request.getParameter("studioaddr"));
			medico.setType(request.getParameter("type"));
			medico.setMunicipalityAddress(request.getParameter("munaddr"));
			try {
				if(ProfiloManager.modificaProfilo(user, medico))
					request.getRequestDispatcher("visualizzaProfiloPersonale.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static final long serialVersionUID = 1L;
}