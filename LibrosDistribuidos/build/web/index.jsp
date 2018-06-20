<%-- 
    Document   : index
    Created on : 15/06/2018, 02:27:08 PM
    Author     : Yael Arturo Chavoya Andalón 14300094
--%>

<%@page import="rmi.RmiClient"%>
<%@page import="models.Foro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros Distribuidos</title>
    </head>
    <body>
        <h1>Ya tenemos 100 :D</h1>
        <%
            RmiClient client = new RmiClient();
            
            ArrayList<Foro> foros = client.foro.get();
            out.println(foros.size());

         %>
    </body>
</html>
