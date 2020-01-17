<%@page import="connectionPool.DriverManagerConnectionPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    String id = request.getParameter("id");
    try {
        Connection con = DriverManagerConnectionPool.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from prescription where ID=?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Blob blob = rs.getBlob("prescription");
            byte byteArray[] = blob.getBytes(1, (int) blob.length());
            response.setContentType("application/pdf");
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
