package control.gestioneAppuntamento;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AccettareAppuntamento")

public class AccettareAppuntamento {



    public AccettareAppuntamento() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("user");
		request.getSession().invalidate();
		request.getRequestDispatcher("appuntamento.jsp").forward(request, response);
		
	}

	
	private static final long serialVersionUID = 2L;
}
