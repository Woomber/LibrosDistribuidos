    <!DOCTYPE html>
<html>
<head>
	<title>Foro</title>
	<link rel="stylesheet" type="text/css" href="css/foro.css">
</head>
<body>
	<%@ include file = "barra.jsp" %>

	<div class="foroP">

	<h1>Foro <button class="botonAzul" onclick="window.location='nuevaPregunta.jsp'">Nueva pregunta</button></h1><br>

		<div class="pregunta" onclick="window.location='respuestasForo.jsp'">
			<h2>Pregunta</h2>
			<p>Primera respuesta</p>
		</div>
		<div class="pregunta" onclick="window.location='respuestasForo.jsp'">
			<h2>Pregunta</h2>
			<p>Primera respuesta</p>
		</div>
		<div class="pregunta" onclick="window.location='respuestasForo.jsp'">
			<h2>Pregunta</h2>
			<p>Primera respuesta</p>
		</div>
	</div>
</body>
</html>
