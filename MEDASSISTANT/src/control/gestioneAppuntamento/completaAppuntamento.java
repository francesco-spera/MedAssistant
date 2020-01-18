package control.gestioneAppuntamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Appointment;
import model.AppuntamentoManager;
import model.RicercaManager;

/**
 * Servlet implementation class completaAppuntamento
 */
@WebServlet("/completaAppuntamento")
public class completaAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public completaAppuntamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("appId"));
		
		try {
			AppuntamentoManager.updateAppuntamentoState(2, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Appointment app = new Appointment();
		Account pat = new Account();
		try {
			app = AppuntamentoManager.visualizzaAppuntamento(id);
			pat = RicercaManager.cercaAccountPaziente(app.getPatient());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().removeAttribute("AppointmentPat");
		request.getSession().removeAttribute("Appointment");
		request.getSession().setAttribute("AppointmentPat", pat);
		request.getSession().setAttribute("Appointment", app);
		request.setAttribute("id", id);
		request.getRequestDispatcher("presentation/appuntamento/visualizzaAppuntamento.jsp").forward(request, response);
	}

}
