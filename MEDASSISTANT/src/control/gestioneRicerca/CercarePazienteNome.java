package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try {
			ArrayList<Patient> patient = RicercaManager.cercaPazienteNome(request.getParameter("name"), request.getParameter("surname"));
			ArrayList<Account> account = new ArrayList<Account>();
			for(Patient pat: patient) {
				 account.add(RicercaManager.cercaAccountPaziente(pat.getEmail()));
			}
			if(patient==null) {
				//momentaneo
				System.out.println("paziente non trovato");
			}
			request.getSession().setAttribute("accPaz", account);
			request.getRequestDispatcher("/risultatiCercaPaziente.jsp").forward(request, response);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
