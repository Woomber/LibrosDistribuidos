<%-- 
    Document   : do-registro
    Created on : 20/06/2018, 05:02:12 PM
    Author     : Yael Arturo Chavoya Andalón 14300094
--%>

<%@page import="models.Usuario"%>
<%@page import="rmi.RmiClient"%>
<%

Usuario u = new Usuario();
    
u.setUsername(request.getParameter("usuario"));  
u.setNombre(request.getParameter("nombre"));  
u.setApellidos(request.getParameter("apellidos"));  
u.setPassword(request.getParameter("contrasena"));
String confirmar = request.getParameter("confContra"); 

/*
Idealmente estas verificaciones se podrían hacer en un ajax o algo,
pero pues lo dejo así como ejemplo.

(y sí, sé que se ve medio feo)
*/

if(!u.getPassword().equals(confirmar)){
    response.sendRedirect("../registro.jsp?e=1");
    return;
}

if(checkEmpty(u.getUsername(), u.getNombre(), u.getApellidos(), u.getPassword())){
    response.sendRedirect("../registro.jsp?e=2");
    return;
}

RmiClient client = new RmiClient();
u.setPassword(Hashing.hash.sha1(u.getPassword()));
if(client.usuarios.insert(u) != 0){
    response.sendRedirect("../login.jsp");
} else {
    response.sendRedirect("../registro.jsp?e=3");
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