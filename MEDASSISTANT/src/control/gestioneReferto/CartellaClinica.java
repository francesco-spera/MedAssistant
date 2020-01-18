package control.gestioneReferto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.MedicalReport;
import model.RefertoManager;

@WebServlet("/cartellaClinica")
public class CartellaClinica extends HttpServlet {

    public CartellaClinica() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account paziente = (Account) request.getSession().getAttribute("accPaz");
		if (paziente==null) {
			paziente = (Account) request.getSession().getAttribute("pazLog");
		}
		ArrayList<MedicalReport> medReps = null;
		try {
			medReps = RefertoManager.getRefertoByPaziente(paziente.getPatient());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("medReps", medReps);
		request.getRequestDispatcher("presentation/referto/cartellaClinica.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
