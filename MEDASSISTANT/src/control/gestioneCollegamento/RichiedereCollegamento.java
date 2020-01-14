package control.gestioneCollegamento;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.gestioneEmail.EmailSender;


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
		if(request.getSession().getAttribute("accPaz")==null)
			request.getRequestDispatcher("presentation/account/login.jsp").forward(request, response);
		
		
		
		//MOMENTANEO CONTROLLARE FUNZIONAMENTO
		
		String emailmed = request.getParameter("email");
		String oggetto = request.getParameter("oggetto");
		String text = request.getParameter("text");

		try {
			
			EmailSender email = new EmailSender();
			email.inviaMailCollegamento(emailmed, oggetto, text);
			
			
		
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

}
