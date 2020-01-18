package control.gestioneAppuntamento;

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
		Account acc = (Account) request.getSession().getAttribute("docLog");
		if (acc==null) {
			acc = (Account) request.getSession().getAttribute("pazLog");
		}
		ArrayList<Appointment> app = new ArrayList<Appointment>();
		System.out.println(acc.getDoctor());
		try {
			if(acc.getDoctor()!=null) {
				app = AppuntamentoManager.visualizzaAPPmedico(acc.getDoctor());
			}else {
				app = AppuntamentoManager.visualizzaAPPpaziente(acc.getPatient());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("allApp", app);
		request.getRequestDispatcher("presentation/appuntamento/visualizzaAgenda.jsp").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
