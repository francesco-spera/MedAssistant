package control.gestioneProfilo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProfiloManager;

@WebServlet("/controlloEmail")
public class ControlloEmail extends HttpServlet {

    public ControlloEmail() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		try {
			if(ProfiloManager.cercaAccount(email)) {
				System.out.println("sono dentro l false");
				out.write("false");
			} else {
				request.getSession().setAttribute("emailDaRegistrare", email);
				out.write("true");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}

	
	private static final long serialVersionUID = 1L;
}
