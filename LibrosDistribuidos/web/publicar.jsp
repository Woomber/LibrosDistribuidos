<!DOCTYPE html>
<html>
<head>
	<title>Publicar</title>
	<link rel="stylesheet" type="text/css" href="css/publicar.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <%
    if(session.getAttribute("user") == null){
        response.sendRedirect("publicaciones.jsp");
        return;
    } %>
    
        <%@ include file = "actions/check-hash.jsp" %>
	<%@ include file = "barra.jsp" %>
	<form method="POST" action="actions/do-publicar.jsp">
	<div class="contenido">
		<h1>Publicar</h1>
		<h3>Descripcion</h3>
		<textarea name="descripcion" required="required"></textarea>
		<h3>Precio</h3>
		<input type="number" name="precio" required="required"><br>
		<input class="botonAzul" type="submit" name="submit" value="Publicar">
	</div>
	</form>
</body>
</html>