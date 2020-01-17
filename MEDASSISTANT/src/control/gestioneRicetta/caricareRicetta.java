package control.gestioneRicetta;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import bean.Prescription;
import model.RicettaManager;

/**
 * Servlet implementation class caricareRicetta
 */
@WebServlet("/caricareRicetta")
@MultipartConfig(maxFileSize = 32354432)//1.5mb 32.354.432 32354432 //ESSENZIALE
public class caricareRicetta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public caricareRicetta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int resp = Integer.parseInt(request.getParameter("res"));
		Prescription ricetta = new Prescription();
		ricetta.setMedicalreport(Integer.parseInt(request.getParameter("id")));
		ricetta.setDate(request.getParameter("date"));
		ricetta.setDoctor(request.getParameter("doctor"));
		ricetta.setPatient(request.getParameter("patient"));
		ricetta.setState(-1);
		Part part = request.getPart("image");
		InputStream is = part.getInputStream();
		byte[] content = IOUtils.toByteArray(is);
		Blob blob = null;
		try {
			blob = new SerialBlob(content);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		ricetta.setPrescription(blob);
		
		try {
			if (resp==0) {
				RicettaManager.caricareRicetta(ricetta);	
			}else {
				System.out.println("qui ci va update");
				RicettaManager.updatericetta(RicettaManager.ritornoID(ricetta.getMedicalreport(), ricetta.getDoctor(), ricetta.getPatient(), 0), ricetta.getPrescription(), ricetta.getDate());
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/visualizzaReferto?idReport="+request.getParameter("id")).forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
