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
import bean.Appointment;
import control.gestioneEmail.EmailSender;
import model.AppuntamentoManager;
import model.RicercaManager;

/**
 * Servlet implementation class RispostaAppuntamento
 */
@WebServlet("/RispostaAppuntamento")
public class RispostaAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RispostaAppuntamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Account doc = (Account) request.getSession().getAttribute("docLog");
		String emailPaz = request.getParameter("email");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		int appId = Integer.parseInt(request.getParameter("appId"));
		EmailSender email = new EmailSender();
		
		int resp = Integer.parseInt(request.getParameter("response"));
		if(resp==1) {
			String oggetto = "Appuntamento accettato";
			String text = "Attenzione, questo è un avviso per informarti che il tuo medico ha accettato l\'appuntamento\n\n Data:"+date+"  Ora:"+time;
			try {
				email.inviaMailAppuntamento(emailPaz, oggetto, text);
				AppuntamentoManager.updateAppuntamentoState(1, appId);
			}catch (SQLException | MessagingException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
			
		}else {
			Appointment app = new Appointment();
			Account pat = new Account();
			try {
				app = AppuntamentoManager.visualizzaAppuntamento(appId);
				pat = RicercaManager.cercaAccountPaziente(app.getPatient());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.getSession().removeAttribute("AppointmentPat");
			request.getSession().removeAttribute("Appointment");
			request.getSession().setAttribute("AppointmentPat", pat);
			request.getSession().setAttribute("Appointment", app);
			request.setAttribute("id", appId);
			request.getRequestDispatcher("presentation/appuntamento/modificaAppuntamento.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
