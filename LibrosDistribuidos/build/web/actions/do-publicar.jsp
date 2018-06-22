<%-- 
    Document   : do-registro
    Created on : 20/06/2018, 05:02:12 PM
    Author     : Yael Arturo Chavoya Andalón 14300094
--%>

<%@page import="models.Usuario"%>
<%@page import="models.Publicacion"%>
<%@page import="rmi.RmiClient"%>
<%
if(session.getAttribute("user") == null){
    response.sendRedirect("../publicaciones.jsp?e=1");
    return;
}
    
Publicacion p = new Publicacion();
Usuario current = (Usuario) session.getAttribute("user");

p.setEstado(false);
p.setIdUsuario(current.getId());
p.setTexto(request.getParameter("descripcion"));

try {
    p.setPrecio(Double.parseDouble(request.getParameter("precio")));
} catch(Exception ex){
    response.sendRedirect("../publicar.jsp?e=2");
    return;
}

if(checkEmpty(p.getTexto())){
    response.sendRedirect("../publicar.jsp?e=2");
    return;
}

RmiClient client = new RmiClient();

if(client.publicaciones.insert(p) != 0){
    response.sendRedirect("../publicaciones.jsp");
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