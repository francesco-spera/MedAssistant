package control.gestioneProfilo;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import model.ProfiloManager;

@WebServlet("/registrazione")
public class Registrazione extends HttpServlet {

    public Registrazione() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user")!=null)
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		String email = request.getParameter("email");
				
		try {
			if(ProfiloManager.cercaAccount(email)) {
				/*momentaneo*/
				System.out.println("account already esistente");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Account user = new Account();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setBirthDate(request.getParameter("birth"));
		user.setCf(request.getParameter("cf"));
		byte[] buff = request.getParameter("photo").getBytes();
		Blob blob = null;
		try {
			blob = new SerialBlob(buff);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		user.setPhoto(blob);
		String type = request.getParameter("type");
		if(type!=null) {
			user.setDoctor(email);
			Doctor medico = new Doctor();
			medico.setEmail(email);
			medico.setPassword(request.getParameter("psw"));
			medico.setPhoneNumber(request.getParameter("mobilep"));
			medico.setStudioAddress(request.getParameter("studioaddr"));
			medico.setType(type);
			medico.setMunicipalityAddress(request.getParameter("munddr"));
			try {
				if(ProfiloManager.registrazione(user, medico)) {
					request.getSession().setAttribute("medico", user);
					request.getSession().setAttribute("medicoInfo", medico);
					request.getRequestDispatcher("presentation/account/index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			user.setPatient(email);
			Patient paziente = new Patient();
			paziente.setEmail(email);
			paziente.setPassword(request.getParameter("psw"));
			paziente.setDomicile(request.getParameter("domicile"));
			paziente.setResidence(request.getParameter("residence"));
			try {
				if(ProfiloManager.registrazione(user, paziente)) {
					request.getSession().setAttribute("paziente", user);
					request.getSession().setAttribute("pazienteInfo", paziente);
					request.getRequestDispatcher("presentation/account/index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static final long serialVersionUID = 4L;
}
