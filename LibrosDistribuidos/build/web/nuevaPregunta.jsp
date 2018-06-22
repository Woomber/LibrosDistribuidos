<!DOCTYPE html>
<html>
<head>
	<title>NuevaPregunta</title>
	<link rel="stylesheet" type="text/css" href="css/foro.css">
</head>
<body>
        <%@ include file = "actions/check-hash.jsp" %>
	<%@ include file = "barra.jsp" %>
        <%
            if(session.getAttribute("user") == null){
                response.sendRedirect("publicaciones.jsp?e=1");
                return;
            }
        %>
	<form method="POST" action="actions/do-nueva-pregunta.jsp">
		<h1>Nueva pregunta</h1>
		<input type="text" name="pregunta" class="nuevaPre"><br>
		<input class="botonAzul" type="submit" name="submit" value="Crear">
	</form>
</body>
</html>