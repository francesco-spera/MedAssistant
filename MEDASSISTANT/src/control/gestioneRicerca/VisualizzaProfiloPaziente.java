package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Patient;
import model.RicercaManager;

@WebServlet("/VisualizzaProfiloPaziente")
public class VisualizzaProfiloPaziente extends HttpServlet {

    public VisualizzaProfiloPaziente() { 	
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailPaz = request.getParameter("emailpaz");
		Account account = new Account();
		Patient pat = new Patient();
		try {
			account = RicercaManager.cercaAccountPaziente(emailPaz);
			pat = RicercaManager.cercaPaziente(emailPaz);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		request.getSession().setAttribute("infoPaz", pat);
		request.getSession().setAttribute("accPaz", account);
		request.getRequestDispatcher("presentation/ricerca/visualizzaProfiloPaz.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
