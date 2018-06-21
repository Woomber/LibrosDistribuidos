<%-- 
    Document   : devolver
    Created on : Jun 21, 2018, 12:18:18 PM
    Author     : Kevin Alan Martinez Virgen 14300260 8B1
--%>

<%@page import="models.Compra"%>
<%@page import="rmi.RmiClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Devolución</title>
	<link rel="stylesheet" type="text/css" href="css/publicaciones.css">
    </head>
    <body>
        <%@ include file = "actions/check-hash.jsp" %>
        <%@ include file = "barra.jsp" %>
        <div class="contenido">
            <%
            RmiClient cliente = new RmiClient();
            int id = Integer.parseInt(request.getParameter("id"));
            Compra compra = cliente.compras.getById(id);
            
            if(cliente.compras.delete(id)>0){
               cliente.publicaciones.updateEstado(compra.getIdPublicacion(), false);
            %>
            <h1>
                Producto devuelto con éxito
            </h1>
            <%}else{%>
            <h1>
                Error al devolver
            </h1>
            <%}%>
            <a href="index.jsp">Regresar al inicio</a>
        </div>
    </body>
</html>
