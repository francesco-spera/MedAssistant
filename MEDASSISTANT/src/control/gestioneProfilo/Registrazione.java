package control.gestioneProfilo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import bean.Account;
import bean.Doctor;
import bean.Patient;
import model.ProfiloManager;

@WebServlet("/registrazione")
@MultipartConfig(maxFileSize = 32354432)//1.5mb 32.354.432 32354432
public class Registrazione extends HttpServlet {

    public Registrazione() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("pazLog")!=null)
			request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
		if(request.getSession().getAttribute("docLog")!=null)
			request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(20*60);
		
		PrintWriter out = response.getWriter();
	
		String email = (String) request.getSession().getAttribute("emailDaRegistrare");
		Pattern pattern = Pattern.compile(EMAILREGEX);
		Matcher m = pattern.matcher(email);
		if(!m.find()) {
			out.write("false");
			return;
		}
		String password = request.getParameter("psw");
		if(password.length()<6) {
			out.write("false");
			return;
		}
		String name = request.getParameter("name");
		pattern = Pattern.compile(NAMEREGEX);
		m = pattern.matcher(name);
		if(!m.find()) {
			out.write("false");
			return;
		}
		System.out.println("post name");
		String surname = request.getParameter("surname");
		pattern = Pattern.compile(NAMEREGEX);
		m = pattern.matcher(surname);
		if(!m.find()) {
			out.write("false");
			return;
		}
		System.out.println("post surname");
		String birth = request.getParameter("birth");
		if(birth.length()<1) {
			out.write("false");
			return;
		}
		System.out.println("post birth");
		String cf = request.getParameter("cf");
		if(cf.length()!=16) {
			out.write("false");
			return;
		}
		System.out.println("post cf");
		Account user = new Account();
		user.setName(name);
		user.setSurname(surname);
		user.setBirthDate(birth);
		user.setCf(cf);
		Part part = request.getPart("photo");
		if(part!=null) {
			InputStream is = part.getInputStream();
			byte[] content = IOUtils.toByteArray(is);
			Blob blob = null;
			try {
				blob = new SerialBlob(content);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			user.setPhoto(blob);
		}
		String type = request.getParameter("type");
		if(type!=null) {
			user.setDoctor(email);
			Doctor medico = new Doctor();
			medico.setEmail(email);
			medico.setPassword(password);
			String mobilep = request.getParameter("mobilep");
			if(mobilep.length()<10) {
				out.write("false");
				return;
			}
			medico.setPhoneNumber(mobilep);
			String studioAddr = request.getParameter("studioaddr");
			if(studioAddr.length()<1) {
				out.write("false");
				return;
			}
			medico.setStudioAddress(studioAddr);
			medico.setType(type);
			String munAddr = request.getParameter("munaddr");
			pattern = Pattern.compile(NAMEREGEX);
			m = pattern.matcher(munAddr);
			if(!m.find()) {
				out.write("false");
				return;
			}
			medico.setMunicipalityAddress(munAddr);
			try {System.out.println("pre reg");
				if(ProfiloManager.registrazione(user, medico)) {
					System.out.println("post reg");
					session.setAttribute("docLog", user);
					session.setAttribute("dettDoc", medico);
					out.write("true");
					request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			user.setPatient(email);
			Patient paziente = new Patient();
			paziente.setEmail(email);
			paziente.setPassword(password);
			String domicile = request.getParameter("domicile");
			if(domicile==null) {
				out.write("false");
				return;
			}
			paziente.setDomicile(domicile);
			String residence = request.getParameter("residence");
			if(residence==null) {
				out.write("false");
				return;
			}
			paziente.setResidence(residence);
			try {
				if(ProfiloManager.registrazione(user, paziente)) {
					session.setAttribute("pazLog", user);
					session.setAttribute("dettPaz", paziente);
					out.write("true");
					request.getRequestDispatcher("presentation/generali/index.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	private static final long serialVersionUID = 4L;
	private static String EMAILREGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w+)+$";
	private static String NAMEREGEX = "^[A-Za-z]+$";
}
