package control.gestioneRicetta;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import bean.MedicalReport;
import bean.Prescription;
import control.gestioneEmail.EmailSender;
import model.CollegamentoManager;
import model.RicettaManager;

/**
 * Servlet implementation class richiedereRicetta
 */
@WebServlet("/RichiedereRicetta")
public class RichiedereRicetta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RichiedereRicetta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String emailmed = request.getParameter("email");
		String oggetto = request.getParameter("oggetto");
		String text = request.getParameter("text");
		Account patient = (Account) request.getSession().getAttribute("pazLog");
		System.out.println(patient.getPatient());
		text=text.concat(patient.getPatient());
		
		MedicalReport report = (MedicalReport) request.getSession().getAttribute("medRep");
		text=text.concat("&repobj="+report.getObject()+"&desc="+URLEncoder.encode(report.getDescription(), StandardCharsets.UTF_8.toString())+"&idReport="+report.getIdReport());
		
try {
			
			EmailSender email = new EmailSender();
			email.inviaMailRicetta(emailmed, oggetto, text);
			Prescription ricetta = new Prescription();
			ricetta.setState(0);
			ricetta.setMedicalreport(report.getIdReport());
			ricetta.setDoctor(emailmed);
			ricetta.setPatient(patient.getPatient());
			RicettaManager.caricareRicetta(ricetta);
			
		
		} catch (MessagingException | SQLException e) {
			e.printStackTrace();
		}
	}

}
