package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Doctor;
import model.RicercaManager;
 

@WebServlet("/CercareMedicoZonaTipo")
public class CercareMedicoZonaTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CercareMedicoZonaTipo() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			ArrayList<Doctor> doctors = RicercaManager.cercaMedicoZonaTipo(request.getParameter("zona"), request.getParameter("tipo"));
			request.setAttribute("infoDoc", doctors);
			ArrayList<Account> accounts = new ArrayList<>();
			for (Doctor doctor : doctors) {
				accounts.add(RicercaManager.cercaAccountMedico(doctor.getEmail()));
			}
			request.setAttribute("accDoc", accounts);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/risultatiCercaMedico.jsp");
			requestDispatcher.forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
