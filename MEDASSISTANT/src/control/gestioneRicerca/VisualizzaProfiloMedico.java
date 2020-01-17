package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Doctor;
import model.RicercaManager;

@WebServlet("/VisualizzaProfiloMedico")
public class VisualizzaProfiloMedico extends HttpServlet {

    public VisualizzaProfiloMedico() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailDoc = request.getParameter("emaildoc");
		System.out.println("PORCO DIO " + emailDoc);
		Account account = new Account();
		Doctor doc = new Doctor();
		try {
			account = RicercaManager.cercaAccountMedico(emailDoc);
			doc = RicercaManager.cercaMedico(emailDoc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("infoDoc", doc);
		request.getSession().setAttribute("accDoc", account);
		request.getRequestDispatcher("/visualizzaProfiloMed.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	
	
	private static final long serialVersionUID = 1L;
}
