package control.gestioneCollegamento;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Doctor;
import model.CollegamentoManager;
import model.RicercaManager;

@WebServlet("/VisualizzareImieiMedici")
public class VisualizzareImieiMedici extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VisualizzareImieiMedici() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Doctor> med = null;

		Account user = (Account)request.getSession().getAttribute("paziente");
		if(user==null) {
			request.getRequestDispatcher("/presentation/account/login.jsp").forward(request, response); //momentaneo 
			
		}
		
			try {
				if(user!=null) {
				med=CollegamentoManager.doRetrieveAll(user.getPatient());
				request.setAttribute("doctors", med);
				ArrayList<Account> accounts = new ArrayList<>();
				for (Doctor doctor : med) {
					accounts.add(RicercaManager.cercaAccountMedico(doctor.getEmail()));
				}
				request.setAttribute("accounts", accounts);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("presentation/ricerca/imieimedici.jsp");
				requestDispatcher.forward(request, response);
				}
				else {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("presentation/generali/index.jsp"); //momentaneo 
					requestDispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
		
		
		
		
	}

}
