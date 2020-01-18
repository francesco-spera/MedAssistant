package control.gestioneCollegamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import control.gestioneEmail.EmailSender;
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

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("pazLog")==null)
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		
		
		//MOMENTANEO CONTROLLARE FUNZIONAMENTO
		
		String emailmed = request.getParameter("email");
		String oggetto = request.getParameter("oggetto");
		String text = request.getParameter("text");
		Account patient = (Account) request.getSession().getAttribute("pazLog");
		System.out.println(patient.getPatient());
		text=text.concat(patient.getPatient());
		
		//fare query per ricavare email paziente che richiede collegamento e aggiungerlo a text

		try {
			
			EmailSender email = new EmailSender();
			email.inviaMailCollegamento(emailmed, oggetto, text);
			CollegamentoManager.creaCollegamento(patient.getPatient(), emailmed, 0);
			
			
		
		} catch (MessagingException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
