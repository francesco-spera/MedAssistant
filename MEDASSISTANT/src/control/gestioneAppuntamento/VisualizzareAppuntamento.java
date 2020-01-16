package control.gestioneAppuntamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import model.AppuntamentoManager;

/**
 * Servlet implementation class VisualizzareAppuntamento
 */
@WebServlet("/VisualizzareAppuntamento")
public class VisualizzareAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzareAppuntamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int AppointmentID = Integer.parseInt(request.getParameter("id"));
		Appointment app = new Appointment();
		try {
			app = AppuntamentoManager.visualizzaAppuntamento(AppointmentID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("Appointment", app);
		request.getRequestDispatcher("/visualizzaAppuntamento.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
