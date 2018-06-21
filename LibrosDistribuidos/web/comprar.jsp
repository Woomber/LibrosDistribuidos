<%-- 
    Document   : comprar
    Created on : Jun 21, 2018, 11:51:35 AM
    Author     : Kevin Alan Martinez Virgen 14300260 8B1
--%>

<%@page import="models.Publicacion"%>
<%@page import="models.Usuario"%>
<%@page import="models.Compra"%>
<%@page import="rmi.RmiClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compra</title>
	<link rel="stylesheet" type="text/css" href="css/publicaciones.css">
    </head>
    <body>
        <%@ include file = "actions/check-hash.jsp" %>
        <%@ include file = "barra.jsp" %>
        
        <div class="contenido">
            <%
            RmiClient cliente = new RmiClient();
            Compra compra = new Compra();
            int id = Integer.parseInt(request.getParameter("id"));
            compra.setIdPublicacion(id);
            Usuario usuario = (Usuario)request.getSession().getAttribute("user");
            compra.setIdUsuario(usuario.getId());
            if(cliente.compras.insert(compra)>0){
               cliente.publicaciones.updateEstado(id, true);
            %>
            <h1>
                Producto comprado con éxito
            </h1>
            <%}else{%>
            <h1>
                Error al comprar
            </h1>
            <%}%>
            <a href="index.jsp">Regresar al inicio</a>
        </div>
    </body>
</html>
