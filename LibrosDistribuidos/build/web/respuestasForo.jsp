<!DOCTYPE html>
<html>
<head>
	<title>RespuestasForo</title>
	<link rel="stylesheet" type="text/css" href="css/foro.css">
</head>
<body>
	<%@ include file = "barra.jsp" %>
<div class="contenido">
		<h1>PREGUNTA</h1>
	<div class="Respuestas">
		<div class="res">
			<p class="usuario">Usuario</p>
			<p class="texto">ls odjoseo odjf sojf osjsdl ei ei ei</p>
		</div>
	</div>
	
	<div class="contestar">
		<form method="POST" action="">
			<textarea name="contestar" required="required"></textarea><br>
			<input type="submit" name="submit" value="Enviar" class="botonAzul">
		</form>
	</div>
</div>
</body>
</html>