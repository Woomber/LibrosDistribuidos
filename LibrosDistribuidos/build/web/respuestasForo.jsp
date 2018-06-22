<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.Mensaje"%>
<!DOCTYPE html>
<html>
<head>
	<title>RespuestasForo</title>
	<link rel="stylesheet" type="text/css" href="css/foro.css">
</head>
<body>
        <%@ include file = "actions/check-hash.jsp" %>
	<%@ include file = "barra.jsp" %>
        
        <%! List<Usuario> usuarios; %>
        
        <%! String searchUsername(int id){
            for(Usuario u : usuarios){
                if(u.getId() == id) return u.getNombre() + " " + u.getApellidos();
            }
            return null;
        } %>
        
        <%
            int id;
            try {
                id = Integer.parseInt(request.getParameter("id"));
            } catch (Exception ex){
                response.sendRedirect("foro.jsp?e=1");
                return;
            }
            RmiClient cliente = new RmiClient();
            List<Mensaje> mensajes = cliente.mensajes.get();
            List<Mensaje> convo = new ArrayList<>();
            usuarios = cliente.usuarios.get();
            
            for(Mensaje m : mensajes){
                if(m.getIdForo() == id) convo.add(m);
            }
            
            if(convo.size() == 0) {
                response.sendRedirect("foro.jsp?e=2");
                return;  
            }
            %>
<div class="contenido">
    <h1><%= convo.get(0).getMensaje() %> </h1>
        <% for(Mensaje m : convo){
            %>
            <div class="Respuestas">
		<div class="res">
			<p class="usuario"><%= searchUsername(m.getIdUsuario()) %></p>
			<p class="texto"><%= m.getMensaje() %></p>
		</div>
	</div>
            <%
        }

        if(session.getAttribute("user") != null){
        %>
	<div class="contestar">
		<form method="POST" action="actions/do-responder.jsp">
			<textarea name="contestar" required="required"></textarea><br>
                        <input type="hidden" name="foro" value="<%out.print(id);%>">
			<input type="submit" name="submit" value="Enviar" class="botonAzul">
		</form>
	</div>
        <% } %>
</div>
</body>
</html>