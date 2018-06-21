<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<meta charset="utf-8">
</head>	
<body class="todo">
<form method="POST" action="">
<div class="login" >
    <form method="POST" action="actions/do-login.jsp">
	<h1>Login</h1>
         
	<p>Usuario</p>
	<input type="text" name="usuario" required="required">
	<p>Contraseña</p>
	<input type="password" name="contrasena" required="required"><br>
	<input type="submit" name="submit" value="Ingresar" class="botonAzul">
	<button class="botonAzul" onclick="window.location='registro.jsp'">Registrarse</button>
    </form>
</div>
</form>
</body>
</html>