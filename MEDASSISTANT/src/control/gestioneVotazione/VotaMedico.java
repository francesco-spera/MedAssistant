package control.gestioneVotazione;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import model.RecensioneManager;

@WebServlet("/VotaMedico")
public class VotaMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public VotaMedico() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		float voto = Float.parseFloat(request.getParameter("selected_rating"));
		String emaildoc = request.getParameter("emaildoc");
		Account patient = (Account)request.getSession().getAttribute("pazLog");
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());

			try {

					
					RecensioneManager.doSave(sqlDate, voto, patient.getPatient(),emaildoc);
					
			
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getRequestDispatcher("visualizzaProfiloMed.jsp").forward(request, response);		
		
		

}
}
