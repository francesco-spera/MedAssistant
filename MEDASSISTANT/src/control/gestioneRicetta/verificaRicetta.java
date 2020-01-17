package control.gestioneRicetta;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.MedicalReport;
import bean.Prescription;
import model.RicettaManager;

/**
 * Servlet implementation class verificaRicetta
 */
@WebServlet("/verificaRicetta")
public class verificaRicetta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verificaRicetta() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idReport = Integer.parseInt(request.getParameter("idReport"));
		Prescription ricetta = new Prescription();
		System.out.println(idReport);
		try {
			ricetta = RicettaManager.ricercaRicettabyID(idReport);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("read", "true");
		request.setAttribute("Pres", ricetta);
		request.getRequestDispatcher("/visualizzaReferto.jsp?idReport"+idReport).forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
