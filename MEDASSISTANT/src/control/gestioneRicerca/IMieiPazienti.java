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
import model.RicercaManager;

@WebServlet("/IMieiPazienti")
public class IMieiPazienti extends HttpServlet {

    public IMieiPazienti() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account doctor = (Account) request.getSession().getAttribute("docLog");
		ArrayList<Account> patients = null;
		try {
			patients = RicercaManager.getPazienti(doctor.getDoctor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("allPaz", patients);
		request.getRequestDispatcher("presentation/ricerca/iMieiPazienti.jsp").forward(request, response);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
