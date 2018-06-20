<!DOCTYPE html>
<html>
<head>
	<title>Registro</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<meta charset="utf-8">
</head>
<body class="todo">
<form method="POST" action="registro.php">
	<div class="registro">
	<h1>Registro</h1>
	<p>Usuario</p>
	<input type="text" name="Usuario" required="required">
	<p>Nombre</p>
	<input type="text" name="nombre" required="required">
	<p>Apellidos</p>
	<input type="text" name="apellidos" required="required">
	<p>Contraseña</p>
	<input type="password" name="contrasena" required="required">
	<p>Confirmar contraseña</p>
	<input type="password" name="confContra" required="required"><br>
	<input class="botonAzul" type="submit" name="submit" value="Registrarse">
	</div>
</form>
</body>
</html>