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

@WebServlet("/CercareMedicoNome")
public class CercareMedicoNome extends HttpServlet {
	
    public CercareMedicoNome() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account patient = (Account) request.getSession().getAttribute("pazLog");
		try {
			ArrayList<Doctor> doctor = RicercaManager.cercaMedicoNome(request.getParameter("name"), request.getParameter("surname"),patient.getPatient());
			request.setAttribute("infoDoc", doctor);
			ArrayList<Account> account = new ArrayList<Account>();
			for(Doctor doc: doctor) {
				 account.add(RicercaManager.cercaAccountMedico(doc.getEmail()));
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
}
