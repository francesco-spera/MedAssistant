package control.gestioneProfilo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class Logout extends HttpServlet {

    public Logout() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("paziente")!=null)
			request.getSession().removeAttribute("paziente");
		else if(request.getSession().getAttribute("medico")!=null)
			request.getSession().removeAttribute("medico");
		request.getSession().invalidate();
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	private static final long serialVersionUID = 2L;
}
