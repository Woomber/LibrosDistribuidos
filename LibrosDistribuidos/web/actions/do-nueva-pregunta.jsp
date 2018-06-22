<%-- 
    Document   : do-nueva-pregunta
    Created on : 22/06/2018, 01:42:39 AM
    Author     : Yael Arturo Chavoya Andalón 14300094
--%>

<%@page import="rmi.RmiClient"%>
<%@page import="models.*"%>
<%
if(session.getAttribute("user") == null){
    response.sendRedirect("../publicaciones.jsp");
    return;
}
Usuario u = (Usuario) session.getAttribute("user");
Foro f = new Foro();
Mensaje m = new Mensaje();

RmiClient client = new RmiClient();

int id = client.foros.insert();
if(id == 0){
    response.sendRedirect("../nuevaPregunta.jsp?e=1");
    return;
}

m.setMensaje(request.getParameter("pregunta"));
m.setIdUsuario(u.getId());
m.setIdForo(id);

if(checkEmpty(m.getMensaje())){
    response.sendRedirect("../nuevaPregunta.jsp?e=2");
    return;
}

if(client.mensajes.insert(m) != 0){
    response.sendRedirect("../respuestasForo.jsp?id=" + id);
} else {
    response.sendRedirect("../nuevaPregunta.jsp?e=3");
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