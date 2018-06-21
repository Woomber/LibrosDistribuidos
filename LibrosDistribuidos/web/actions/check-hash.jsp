<%-- 
    Document   : check-hash
    Created on : Jun 21, 2018, 2:23:41 PM
    Author     : Kevin Alan Martinez Virgen 14300260 8B1
--%>

<%@page import="models.Usuario"%>
<%@page import="rmi.RmiClient"%>
<%
    RmiClient client = new RmiClient();
    Usuario original = (Usuario)request.getSession().getAttribute("user");
    if(original!=null){
        Usuario check = client.usuarios.getById(original.getId());
        if(!original.getHash().equals(check.getHash()))response.sendRedirect("./actions/do-logout.jsp");
    }
%>
