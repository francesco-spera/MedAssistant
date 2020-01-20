package control.gestioneReferto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Doctor;
import bean.MedicalReport;
import model.ProfiloManager;
import model.RefertoManager;
import model.RicercaManager;

@WebServlet("/VisualizzaReferto")
public class VisualizzaReferto extends HttpServlet {

    public VisualizzaReferto() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idReport = Integer.parseInt(request.getParameter("idReport"));
		MedicalReport medRep = null;
		Doctor d = null;
		Account medico = null;
		try {
			medRep = RefertoManager.getRefertoById(idReport);
			medico = (Account) request.getSession().getAttribute("docLog");
			if(request.getSession().getAttribute("dettDoc")==null && medico!=null) {
				d = ProfiloManager.visualizzaMedico(medico.getDoctor());
				request.getSession().setAttribute("tipoDoc", d.getType());
			}
			medico = RicercaManager.cercaAccountMedico(medRep.getDoctor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute("medRep", medRep);
		request.getSession().setAttribute("nameDoc", medico);
		request.getRequestDispatcher("presentation/referto/visualizzaReferto.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
