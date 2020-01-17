package control.gestioneRicetta;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import control.gestioneEmail.EmailSender;
import model.RicettaManager;

/**
 * Servlet implementation class RispostaRicetta
 */
@WebServlet("/RispostaRicetta")
public class RispostaRicetta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RispostaRicetta() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Account doc = (Account) request.getSession().getAttribute("docLog");
		String emailPaz = request.getParameter("email");
		String oggetto = "Ricetta caricata";
		String text = "Attenzione, questo è un avviso per informarti che il tuo medico sta provvedendo a caricare la ricetta richiesta";
		int reportid = Integer.parseInt(request.getParameter("reportid"));
		EmailSender email = new EmailSender();
		
		int resp = Integer.parseInt(request.getParameter("response"));
		if(resp==1) {
			
			
			
		}else {
			//rifiuta
			String oggettoRifiuto = "Caricamento rifiutato";
			String textRifiuto = "Attenzione, questo è un avviso di rifiuto per il caricamento della ricetta, ti consigliamo di prendere un appuntamento";
			try {
				RicettaManager.modificastato(2, reportid);
				email.inviaMailRicetta(emailPaz, oggettoRifiuto, textRifiuto);
			} catch (MessagingException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
