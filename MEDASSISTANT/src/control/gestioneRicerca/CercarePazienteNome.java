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
import bean.Patient;
import model.RicercaManager;


@WebServlet("/CercarePazienteNome")
public class CercarePazienteNome extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CercarePazienteNome() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Account doctor = (Account) request.getSession().getAttribute("docLog");
 
		try {
			ArrayList<Patient> patient = RicercaManager.cercaPazienteNome(request.getParameter("name"), request.getParameter("surname"),doctor.getDoctor());
			request.setAttribute("infoPaz", patient);
			ArrayList<Account> account = new ArrayList<Account>();
			for(Patient pat: patient) {
				 account.add(RicercaManager.cercaAccountPaziente(pat.getEmail()));
			}
			request.setAttribute("accPaz", account);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/risultatiCercaPaziente.jsp");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
