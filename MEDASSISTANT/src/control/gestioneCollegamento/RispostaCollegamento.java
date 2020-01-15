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


@WebServlet("/RispostaCollegamento")
public class RispostaCollegamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RispostaCollegamento() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Account doc = (Account) request.getSession().getAttribute("docLog");
		String emailPaz = request.getParameter("email");
		String oggetto = "Collegamento accettato dal medico";
		String text = "Attenzione, questo è un avviso di accettazione di collegamento da parte di un medico.";
		EmailSender email = new EmailSender();
		
		System.out.println(emailPaz);
		System.out.println(doc.getDoctor());

		int resp = Integer.parseInt(request.getParameter("response"));
		if(resp==1) {
			//accettato
			try {
				CollegamentoManager.modificaStatoCollegamento(request.getParameter("email"), doc.getDoctor(), 1);
				
				email.inviaMailCollegamento(emailPaz, oggetto, text);

			} catch (SQLException | MessagingException e) {
				e.printStackTrace();
			}
		
		}else {

			String oggettoRifiuto = "Collegamento rifiutato dal medico";
			String textRifiuto = "Attenzione, questo è un avviso di rifiuto di collegamento da parte di un medico.";
			try {
				CollegamentoManager.modificaStatoCollegamento(request.getParameter("email"), doc.getDoctor(), 2);
				email.inviaMailCollegamento(emailPaz, oggettoRifiuto, textRifiuto);
			} catch (MessagingException | SQLException e) {
				e.printStackTrace();
			}
			
		}

	
	
	
	
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
		
}
