package control.gestioneAgenda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Appointment;
import bean.Doctor;
import model.AppuntamentoManager;

/**
 * Servlet implementation class visualizzaAgenda
 */
@WebServlet("/VisualizzaAgenda")
public class VisualizzaAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisualizzaAgenda() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account doctor = (Account) request.getSession().getAttribute("docLog");
		ArrayList<Appointment> app = new ArrayList<Appointment>();
		System.out.println(doctor.getDoctor());
		try {
			app = AppuntamentoManager.visualizzaAPPmedico(doctor.getDoctor());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("allApp", app);
		request.getRequestDispatcher("/visualizzaAgendaMed.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
