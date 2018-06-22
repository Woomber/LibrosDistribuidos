<%-- 
    Document   : do-nueva-pregunta
    Created on : 22/06/2018, 01:42:39 AM
    Author     : Yael Arturo Chavoya Andalón 14300094
--%>

<%@page import="rmi.RmiClient"%>
<%@page import="models.*"%>
<%
if(session.getAttribute("user") == null){
    response.sendRedirect("../publicaciones.jsp?e=1");
    return;
}
Usuario u = (Usuario) session.getAttribute("user");
Mensaje m = new Mensaje();

RmiClient client = new RmiClient();

m.setMensaje(request.getParameter("contestar"));
m.setIdUsuario(u.getId());

try {
    m.setIdForo(Integer.parseInt(request.getParameter("foro")));    
} catch(Exception ex){
    response.sendRedirect("../foro.jsp?e=1");
    return;
}


if(checkEmpty(m.getMensaje())){
    response.sendRedirect("../respuestasForo.jsp?id="+m.getIdForo()+"&e=2");
    return;
}

if(client.mensajes.insert(m) != 0){
    response.sendRedirect("../respuestasForo.jsp?id=" + m.getIdForo());
} else {
    response.sendRedirect("../respuestasForo.jsp?id="+m.getIdForo()+"&e=3");
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