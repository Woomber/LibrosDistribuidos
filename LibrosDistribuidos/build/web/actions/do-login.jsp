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
    response.sendRedirect("../login.jsp?e=1");
    return;
}
password = Hashing.hash.sha1(password);
RmiClient client = new RmiClient();
Usuario u = client.usuarios.login(usuario, password);
Double hash = Math.random()*Math.random();
String key = Hashing.hash.sha1(hash.toString());
if(u != null){
    u.setHash(key);
    client.usuarios.setHash(u.getId(), key);
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