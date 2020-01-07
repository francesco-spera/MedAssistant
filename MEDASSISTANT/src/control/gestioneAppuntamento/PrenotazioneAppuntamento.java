package control.gestioneAppuntamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import model.AppuntamentoManager;


@WebServlet("/PrenotazioneAppuntamento")

public class PrenotazioneAppuntamento {


    public PrenotazioneAppuntamento() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//controllare funzionamento sessione
		if(request.getSession().getAttribute("paziente")==null)
			request.getRequestDispatcher("presentation/account/login.jsp").forward(request, response);
		
		Appointment app = null;
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String doctor = request.getParameter("doctor"); // modificare. me lo devo prendere dal profilo del medico in cui mi trovavo

		try {
			app = new Appointment();
			app.setDate(date);
			app.setTime(time);
			app.setState(0);
			app.setDoctor(doctor);

			if(AppuntamentoManager.creaAppuntamento(app)) 
			{
				request.getRequestDispatcher("appuntamentoEffettuato.jsp").forward(request, response);
			}
			else {
				System.out.println("Errore Prenotazione");//momentaneo
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	


	
}
