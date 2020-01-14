package control.gestioneEmail;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmailSender")
public class EmailSender extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private String host;
    private String port;
    private String user;
    private String pass;
	
	StringBuffer packed = new StringBuffer();
    
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
    
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(userName, password);
    		}
    	});
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
 
        // sends the e-mail
        Transport.send(msg);
 
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String email = request.getParameter("email");
    	String subject = request.getParameter("oggetto");
    	String content = request.getParameter("text");
    	
    	
        String resultMessage = "";

		 
		        try {
		            sendEmail(host, port, user, pass, email, subject,
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