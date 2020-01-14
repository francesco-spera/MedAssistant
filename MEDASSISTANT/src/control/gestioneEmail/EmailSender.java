package control.gestioneEmail;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebServlet("/EmailSender")
public class EmailSender extends HttpServlet {
	
    /**
	 *  setting dei dati per l'invio dell'email
	 */
	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;
 
    /**
     * setting dati per controllo esistenza utente
     */
	
	StringBuffer packed = new StringBuffer();
    
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String email = request.getParameter("email");
    	String subject = request.getParameter("oggetto");
    	String content = request.getParameter("text");
    	
    	
        String resultMessage = "";

		 
		        try {
		            EmailUtility.sendEmail(host, port, user, pass, email, subject,
		                    content);
		            System.out.println("email inviata");
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            resultMessage = "0";
		        } finally {
					
		        	resultMessage = "1";
		        }
				

    	packed.setLength(0);
    	packed.append("<result>");
		packed.append(resultMessage);
		packed.append("</result>");
    	try {
			Thread.sleep(3000);
		} catch(InterruptedException e) {}
    	System.out.println(packed.toString());
		response.getWriter().write(packed.toString());
        
    }
}