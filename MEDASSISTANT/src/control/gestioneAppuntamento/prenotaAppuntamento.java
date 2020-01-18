package control.gestioneAppuntamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import control.gestioneEmail.EmailSender;
import model.AppuntamentoManager;

/**
 * Servlet implementation class prenotaAppuntamento
 */
@WebServlet("/prenotaAppuntamento")
public class prenotaAppuntamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prenotaAppuntamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String emailmed = request.getParameter("doctor");
		String emailpat= request.getParameter("patient");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		
		String oggetto = "Richiesta di appuntamento";
		String text = "Salve Dott.,\n\nIl paziente email:"+emailpat+"\n\nha richiesto un appuntamento: \n\nlocalhost:65535/MEDASSISTANT/presentation/appuntamento/visualizzaRicAppuntamento.jsp?date="+date+"&time="+time+"&patient="+emailpat;
		
		Appointment app = new Appointment();
		app.setDate(date);
		app.setTime(time);
		app.setDoctor(emailmed);
		app.setPatient(emailpat);
		app.setState(0);
		
		System.out.println(date+" "+time);
		
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
			request.getRequestDispatcher("presentation/appuntamento/prenotaAppuntamento.jsp").forward(request, response);
		}else {
			System.out.println("non presente");
			
			try {
				AppuntamentoManager.inserisciApp(app);
				int id = AppuntamentoManager.ritornoID(emailmed, emailpat, date, 0);
				text=text.concat("&appId="+id);
				EmailSender email = new EmailSender();
				email.inviaMailAppuntamento(emailmed, oggetto, text);
				request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
				
			} catch (MessagingException | SQLException e) {
				e.printStackTrace();
			}
			

		}
		
	}

}
