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
            if(session.getAttribute("user") == null){
                response.sendRedirect("publicaciones.jsp?e=1");
                return;
            }
                
            RmiClient cliente = new RmiClient();
            Compra compra = new Compra();
            int id = Integer.parseInt(request.getParameter("id"));
            compra.setIdPublicacion(id);
            
            Usuario usr = (Usuario)request.getSession().getAttribute("user");
            Monedero monedero = client.monederos.getByUsuario(usr.getId());
            compra.setIdUsuario(usr.getId());
            String dinero = Hashing.AES.decrypt(Hashing.hash.sha1(usr.getUsername()+usr.getId()).substring(0, 16), "RandomInitVector", monedero.getDinero());
            int money = Integer.parseInt(dinero);
            
            Publicacion publicacion = cliente.publicaciones.getById(id);
            
            Usuario publicador = client.usuarios.getById(publicacion.getIdUsuario());
            Monedero monedero_pub = client.monederos.getByUsuario(publicador.getId());
            String dinero_pub = Hashing.AES.decrypt(Hashing.hash.sha1(publicador.getUsername()+publicador.getId()).substring(0, 16), "RandomInitVector", monedero_pub.getDinero());
            int money_pub = Integer.parseInt(dinero_pub);
            
            if(money>=publicacion.getPrecio()){
            if(cliente.compras.insert(compra)>0){
               cliente.publicaciones.updateEstado(id, true);
               money-=publicacion.getPrecio();
               dinero = Hashing.AES.encrypt(Hashing.hash.sha1(usr.getUsername()+usr.getId()).substring(0, 16), "RandomInitVector", money+"");
               money_pub+=publicacion.getPrecio();
               dinero_pub = Hashing.AES.encrypt(Hashing.hash.sha1(publicador.getUsername()+publicador.getId()).substring(0, 16), "RandomInitVector", money_pub+"");
               client.monederos.updateDinero(usr.getId(), dinero);
               client.monederos.updateDinero(publicador.getId(), dinero_pub);
            %>
            <h1>
                Producto comprado con éxito
            </h1>
            <%}else{%>
            <h1>
                El producto ya habías sido comprado previamente
            </h1>
            <%}}else{%>
            <h1>
                No cuenta con suficientes recursos en su monedero
            </h1>    
            <%}%>
            <a href="index.jsp">Regresar al inicio</a>
        </div>
    </body>
</html>
