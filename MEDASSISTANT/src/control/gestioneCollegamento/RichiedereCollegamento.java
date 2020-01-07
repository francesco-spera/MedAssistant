package control.gestioneCollegamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Patient;
import model.CollegamentoManager;


@WebServlet("/RichiedereCollegamento")
public class RichiedereCollegamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RichiedereCollegamento() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("paziente")==null)
			request.getRequestDispatcher("presentation/account/login.jsp").forward(request, response);
		
		
		
		//MOMENTANEO CONTROLLARE FUNZIONAMENTO
		
		String emailmed = request.getParameter("emaildoc");
		Patient user = null;
		try {
			user = new Patient();
			user = (Patient) request.getSession().getAttribute("paziente");
			if(CollegamentoManager.creaCollegamento(user.getEmail(), emailmed, 0)) 
			{
				request.getRequestDispatcher("presentation/account/collegamentoRichiesto.jsp").forward(request, response);
			}
			else {
				System.out.println("Errore collegamento");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
