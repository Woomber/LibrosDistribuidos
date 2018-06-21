<%-- 
    Document   : do-login
    Created on : Jun 21, 2018, 10:22:27 AM
    Author     : Yo merengues bien hermoso (Osea el Erick)
--%>

<%@page import="models.Usuario"%>
<%@page import="rmi.RmiClient"%>
<%

String usuario = request.getParameter("usuario");
String password = request.getParameter("contrasena");


if(checkEmpty(usuario,password)){
    response.sendRedirect("../registro.jsp?e=2");
    return;
}

RmiClient client = new RmiClient();
Usuario u = client.usuarios.login(usuario, password);
if(u != null){
    session.setAttribute("user", u);
    response.sendRedirect("../index.jsp");
} else {
    response.sendRedirect("../login.jsp?e=2");
}

%>

<%! 
boolean checkEmpty(String... args){
    for(String str : args){
        if(str.trim().isEmpty()) return true;
    }
    return false;
}
%>