<%@page import="models.Monedero"%>
<%@page import="rmi.RmiClient"%>
<%@page import="models.Usuario"%>
<link rel="stylesheet" type="text/css" href="css/barra.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<div class="barra">
	<div class="inicio" onclick="window.location='publicaciones.jsp'">Inicio</div>
        <% if(session.getAttribute("user") == null){
            %>
                <div class="login" onclick="window.location='login.jsp'">Iniciar sesión</div>
            <%
        } else {
            Usuario usr = (Usuario)session.getAttribute("user");
            Monedero monedero = client.monederos.getByUsuario(usr.getId());
            String dinero = Hashing.AES.decrypt(Hashing.hash.sha1(usr.getUsername()+usr.getId()).substring(0, 16), "RandomInitVector", monedero.getDinero());
            
            out.print("Monedero: "+dinero);
            %>
            <div class="login" onclick = "window.location='actions/do-logout.jsp'">Cerrar sesión</div>
            <% } %>
	<div class="buscar">
            <form method="POST" action="publicaciones.jsp"><input type="text" name="buscar" placeholder="Buscar">
                <input type="submit" value="Buscar"><img src=""></form>
	</div>
	<div class="publicar" onclick="window.location='publicar.jsp'">Publicar</div>
	<div class="foro" onclick="window.location='foro.jsp'">Foro</div>
</div>