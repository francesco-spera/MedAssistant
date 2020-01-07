package control.gestioneAppuntamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import model.AppuntamentoManager;


@WebServlet("/ModificareAppuntamento")

public class ModificaAppuntamento {



    public ModificaAppuntamento() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());


	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//mi trovo nella jsp i miei appuntamenti, in cui sono mostrati tutti gli appuntamenti a me collegati. seleziono un appuntamento da modificare 
	
		
		
		//controllare in jsp se lo stato è uguale a 2, in quel caso l'appuntamento è gia stato completato è non è possibile modificarlo
		
		int id = Integer.parseInt(request.getParameter("idApp"));
		Appointment app = null;
		try {
			app = AppuntamentoManager.cercaAppuntamento(id);
			if(AppuntamentoManager.cancellaAppuntamento(id)){
				String date = request.getParameter("date");
				String time = request.getParameter("time");
				app.setDate(date);
				app.setTime(time);
				app.setState(3);
				if(AppuntamentoManager.creaAppuntamento(app)) 
				{
					request.getRequestDispatcher("appuntamentoEffettuato.jsp").forward(request, response);
				}
				else {
					System.out.println("Errore Prenotazione");//momentaneo
				}
				
			}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/visualizzaprofilomed.jsp");
		requestDispatcher.forward(request, response);
	}
	
		



}