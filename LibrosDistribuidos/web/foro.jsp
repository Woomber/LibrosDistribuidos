    <%@page import="models.Mensaje"%>
<%@page import="java.util.List"%>
<%@page import="models.Foro"%>
<!DOCTYPE html>
<html>
<head>
	<title>Foro</title>
	<link rel="stylesheet" type="text/css" href="css/foro.css">
</head>
<body>
        <%@ include file = "actions/check-hash.jsp" %>
	<%@ include file = "barra.jsp" %>
        
        <%! List<Mensaje> mensajes;
            String searchMensaje(int idForo){
            for(Mensaje m : mensajes){
                if(m.getIdForo() == idForo) return m.getMensaje();
            }
            return null;
        } %>
        
        <%
            RmiClient cliente = new RmiClient();
            
            List<Foro> foros = cliente.foros.get();
            mensajes = cliente.mensajes.get();
            %>
            
	<div class="foroP">
	<h1>Foro <% if(session.getAttribute("user") != null){
                %><button class="botonAzul" onclick="window.location='nuevaPregunta.jsp'">Nueva pregunta</button><%
            }%></h1><br>

                <% for(Foro f : foros){
                    %>
                    <div class="pregunta" onclick="window.location='respuestasForo.jsp?id=<%out.println(f.getId() + "'");%>">
			<h2><%= searchMensaje(f.getId()) %></h2>
                    </div>
                    <%
                } %>
	</div>
</body>
</html>
