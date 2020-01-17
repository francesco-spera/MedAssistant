<%@page import="connectionPool.DriverManagerConnectionPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
	PreparedStatement ps = null;
    String chiave = request.getParameter("patient");
	if(chiave==null)
		chiave = request.getParameter("doctor");
    try {
        Connection con = DriverManagerConnectionPool.getConnection();
        	ps = con.prepareStatement("select photo from account where patient=? OR doctor=?");
        ps.setString(1, chiave);
        ps.setString(2, chiave);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Blob blob = rs.getBlob("photo");
            byte byteArray[] = blob.getBytes(1, (int) blob.length());
            response.setContentType("image/gif");
            OutputStream os = response.getOutputStream();
            os.write(byteArray);
            os.flush();
            os.close();
        } else {
            System.out.println("Immagine non trovata.");
        }
    } catch (Exception e) {
        out.println(e);
    }
%>
