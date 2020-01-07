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

@WebServlet("/autenticazione")
public class Autenticazione extends HttpServlet {

    public Autenticazione() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("paziente")!=null)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		Account user = null;
		if(email!=null && psw!=null)
			try {
				user = ProfiloManager.autenticazione(email, psw);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(user==null) {
			/*momentaneamente*/
			System.out.println("problemi con le credenziali");
			return;
		}
		
		if(user.getPatient()!=null)
			request.getSession().setAttribute("paziente", user);
		else
			request.getSession().setAttribute("medico", user);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
