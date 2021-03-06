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

@WebServlet("/IMieiMedici")
public class IMieiMedici extends HttpServlet {
	
    public IMieiMedici() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account patient = (Account) request.getSession().getAttribute("pazLog");
		ArrayList<Account> doctors = null;
		try {
			doctors = RicercaManager.getMedici(patient.getPatient());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("allDoc", doctors);
		request.getRequestDispatcher("presentation/ricerca/iMieiMedici.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
