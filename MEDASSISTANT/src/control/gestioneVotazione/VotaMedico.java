package control.gestioneVotazione;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Voting;
import model.CollegamentoManager;
import model.ProfiloManager;
import model.VotazioneManager;

@WebServlet("/VotaMedico")
public class VotaMedico extends HttpServlet {
	
    public VotaMedico() {
        super();   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		Voting vote = new Voting();
		vote.setDate(request.getParameter("dateVote"));
		vote.setDoctor(request.getParameter("emailDoc"));
		vote.setPatient(request.getParameter("emailPatient"));
		if(request.getParameter("selected_rating").isEmpty()) {
			out.write("false");
			return;
		}else out.write("true");
		
		int ratings = Integer.parseInt(request.getParameter("selected_rating"));
		vote.setVote(ratings);
		
		boolean votestate = false;
		boolean linkstate = false;
		
		try {
			VotazioneManager.votaMedico(vote);
			request.getSession().setAttribute("infoDoc", ProfiloManager.visualizzaMedico(request.getParameter("emailDoc")));
			votestate = VotazioneManager.controlloVoto(request.getParameter("emailPatient"), request.getParameter("emailDoc"));
			linkstate = CollegamentoManager.controlloCollegamento(request.getParameter("emailPatient"), request.getParameter("emailDoc"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("linkstate", linkstate);
		request.setAttribute("votestate", votestate);
		request.getRequestDispatcher("presentation/ricerca/visualizzaProfiloMed.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private static final long serialVersionUID = 1L;
}
