package control.gestioneProfilo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;
import model.ProfiloManager;

@WebServlet("/autenticazione")
public class Autenticazione extends HttpServlet {

    public Autenticazione() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("pazLog")!=null)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		if(request.getSession().getAttribute("docLog")!=null)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		Account user = null;
		
		Pattern emailPattern = Pattern.compile(EMAILREGEX);
		Matcher m = emailPattern.matcher(email);
		if(!m.find() || psw.length()<6) {
			out.write("false");
			return;
		} else {
			try {
				user = ProfiloManager.autenticazione(email, psw);
				if(user!=null)
					out.write("true");
				else
					out.write("false");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30*60);
		if(user != null && user.getPatient()!=null)
			session.setAttribute("pazLog", user);
		else
			session.setAttribute("docLog", user);
		out.close();
	}

	
	private static final long serialVersionUID = 1L;
	private static String EMAILREGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$";
}
