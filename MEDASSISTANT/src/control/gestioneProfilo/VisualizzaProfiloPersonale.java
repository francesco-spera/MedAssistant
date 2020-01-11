package control.gestioneProfilo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import model.ProfiloManager;

@WebServlet("/VisualizzaProfiloPersonale")
public class VisualizzaProfiloPersonale extends HttpServlet {
	
    public VisualizzaProfiloPersonale() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("accPaz")!=null) {
			if(request.getSession().getAttribute("infoPaz")!=null)
				request.getRequestDispatcher("/visualizzaProfiloPersonale.jsp").forward(request, response);
			else {
				Account paziente = (Account) request.getSession().getAttribute("accPaz");
				try {
					request.getSession().setAttribute("infoPazz", ProfiloManager.visualizzaPaziente(paziente.getPatient()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("/visualizzaProfiloPersonale.jsp").forward(request, response);
			}
		} else {
			if(request.getSession().getAttribute("infoDoc")!=null)
				request.getRequestDispatcher("/visualizzaProfiloPersonale.jsp").forward(request, response);
			else {
				Account medico = (Account) request.getSession().getAttribute("accDoc");
				try {
					request.getSession().setAttribute("infoDoc", ProfiloManager.visualizzaMedico(medico.getDoctor()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("/visualizzaProfiloPersonale.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
