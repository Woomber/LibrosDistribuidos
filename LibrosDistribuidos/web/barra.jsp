<link rel="stylesheet" type="text/css" href="css/barra.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<div class="barra">
	<div class="inicio" onclick="window.location='publicaciones.jsp'">Inicio</div>
        <% if(session.getAttribute("user") == null){
            %>
                <div class="login" onclick="window.location='login.jsp'">Iniciar sesión</div>
            <%
        } else {
            %>
            <div class="login" onclick = "window.location='actions/do-logout.jsp'">Cerrar sesión</div>
            <% } %>
	<div class="buscar">
            <form><input type="text" name="buscar" placeholder="buscar">
                <img src=""></form>
	</div>
	<div class="publicar" onclick="window.location='publicar.jsp'">Publicar</div>
	<div class="foro" onclick="window.location='foro.jsp'">Foro</div>
</div>