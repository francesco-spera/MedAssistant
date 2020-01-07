package control.gestioneAppuntamento;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Appointment;
import bean.Doctor;
import bean.Patient;
import model.AppuntamentoManager;


@WebServlet("/ModificareAppuntamento")

public class ModificareAppuntamento {



    public ModificareAppuntamento() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("IDappointment")!=null)
			request.getRequestDispatcher("appuntamento.jsp").forward(request, response);
		
		Appointment app = null;
		Patient p=null;
		Doctor d=null;
		
		try {
			app = new Appointment();
			p = new Patient();
			d = new Doctor();

			d = (Doctor) request.getSession().getAttribute("email");
			p = (Patient) request.getSession().getAttribute("email");
			
			app = (Appointment) request.getSession().getAttribute("date");
			app = (Appointment) request.getSession().getAttribute("time");
			app = (Appointment) request.getSession().getAttribute("doctor");

			if(p.getEmail()!=null&& app.getDoctor()!=null&&app.getDate()!=null&&app.getTime()!=null && d.getEmail()==null) 
			{
				AppuntamentoManager.ModificaAppuntamento(app, p, d, p.getEmail());
				System.out.println("Modifica appuntamento avvenuta con successo!!");//momentaneo
				request.getRequestDispatcher("appuntamento.jsp").forward(request, response);
			}
			else if( d.getEmail()!=null && p.getEmail()==null && app.getDate()!=null&&app.getTime()!=null ) {
				
				AppuntamentoManager.ModificaAppuntamento(app,p, d,d.getEmail());
				System.out.println("Modifica appuntamento avvenuta con successo!!");//momentaneo
				request.getRequestDispatcher("appuntamento.jsp").forward(request, response);
			
			}
			else {
				System.out.println("Errore modifica appuntamento!");//momentaneo
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	private static final long serialVersionUID = 2L;
}