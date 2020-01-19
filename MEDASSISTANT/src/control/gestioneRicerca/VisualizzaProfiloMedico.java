package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.Doctor;
import model.CollegamentoManager;
import model.RicercaManager;
import model.VotazioneManager;

@WebServlet("/VisualizzaProfiloMedico")
public class VisualizzaProfiloMedico extends HttpServlet {

    public VisualizzaProfiloMedico() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailDoc = request.getParameter("emaildoc");
		Account pazLog = (Account) request.getSession().getAttribute("pazLog");
		Account account = new Account();
		Doctor doc = new Doctor();
		boolean votestate = false;
		boolean linkstate = false;
		
		try {
			account = RicercaManager.cercaAccountMedico(emailDoc);
			doc = RicercaManager.cercaMedico(emailDoc);
			votestate = VotazioneManager.controlloVoto(pazLog.getPatient(), emailDoc);
			linkstate = CollegamentoManager.controlloCollegamento(pazLog.getPatient(), emailDoc);
			
		} catch (ParseException | SQLException e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("linkstate", linkstate);
		request.setAttribute("votestate", votestate);
		request.getSession().setAttribute("infoDoc", doc);
		request.getSession().setAttribute("accDoc", account);
		request.getRequestDispatcher("presentation/ricerca/visualizzaProfiloMed.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private static final long serialVersionUID = 1L;
}
