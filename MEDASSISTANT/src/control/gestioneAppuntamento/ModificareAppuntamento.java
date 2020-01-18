package control.gestioneAppuntamento;

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
import model.AppuntamentoManager;

/**
 * Servlet implementation class ModificareAppuntamento
 */
@WebServlet("/ModificareAppuntamento")
public class ModificareAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificareAppuntamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emailmed = request.getParameter("doctor");
		String emailpat= request.getParameter("patient");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int appId = Integer.parseInt(request.getParameter("appId"));
		EmailSender email = new EmailSender();
		
		
		int state =0;

		boolean risp = false;
		try {
			risp = AppuntamentoManager.controlloAppDisponibile(emailmed, date, time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(risp) {

			System.out.println("presente");
			request.setAttribute("error", "Orario non disponibile");
			request.getRequestDispatcher("presentation/appuntamento/modificaAppuntamento.jsp").forward(request, response);
		}else {
			System.out.println("non presente");
			Account acc = (Account) request.getSession().getAttribute("docLog");
			if (acc==null) {
				acc = (Account) request.getSession().getAttribute("pazLog");
			}
			try {
				
				if(acc.getDoctor()!=null) {
					System.out.println("dottore loggato");
					String oggetto = "Appuntamento accettato con nuova data";
					String text = "Attenzione, questo è un avviso per informarti che il tuo medico modificando la data dell'appuntamento\n\n\nData:"+date+"  Ora:"+time;
					email.inviaMailAppuntamento(emailpat, oggetto, text);
					AppuntamentoManager.modificaAppuntamento(3, appId, date, time);
				}else {
					System.out.println("paziente loggato");
					String oggetto = "Richiesta di appuntamento";
					String text = "Salve Dott.,\n\nIl paziente email:"+emailpat+"\n\nha richiesto la modifica di appuntamento: \n\nlocalhost:65535/MEDASSISTANT/presentation/appuntamento/visualizzaRicAppuntamento.jsp?date="+date+"&time="+time+"&patient="+emailpat+"&appId="+appId;
					email.inviaMailAppuntamento("r.caccia@outlook.com", oggetto, text);
					AppuntamentoManager.modificaAppuntamento(0, appId, date, time);
				}
				
				
				
				
			} catch (MessagingException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
		}
		
	}

}
