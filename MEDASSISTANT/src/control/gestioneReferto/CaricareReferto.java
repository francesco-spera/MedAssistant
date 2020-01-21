package control.gestioneReferto;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MedicalReport;
import model.RefertoManager;

@WebServlet("/CaricareReferto")
public class CaricareReferto extends HttpServlet {

    public CaricareReferto() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MedicalReport medRep = new MedicalReport();
		medRep.setObject(request.getParameter("object"));
		medRep.setDescription(request.getParameter("description"));
		medRep.setDate(request.getParameter("date"));
		medRep.setDoctor(request.getParameter("doctor"));
		medRep.setPatient(request.getParameter("patient"));
		try {
			RefertoManager.caricaReferto(medRep);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(ParseException e1) {
			e1.printStackTrace();
		}
		
		request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	private static final long serialVersionUID = 1L;
}
