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
		if(request.getSession().getAttribute("pazLog")!=null) {
			if(request.getSession().getAttribute("dettPaz")!=null)
				request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
			else {
				Account paziente = (Account) request.getSession().getAttribute("pazLog");
				try {
					request.getSession().setAttribute("dettPaz", ProfiloManager.visualizzaPaziente(paziente.getPatient()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
			}
		} else {
			if(request.getSession().getAttribute("dettDoc")!=null)
				request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
			else {
				Account medico = (Account) request.getSession().getAttribute("docLog");
				try {
					request.getSession().setAttribute("dettDoc", ProfiloManager.visualizzaMedico(medico.getDoctor()));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("presentation/profilo/visualizzaProfiloPersonale.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
