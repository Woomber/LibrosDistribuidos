<%@page import="org.joda.time.DateTime"%>
<%@page import="org.joda.time.Minutes"%>
<%@page import="org.joda.time.Days"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.Usuario"%>
<%@page import="models.Compra"%>
<%@page import="rmi.RmiClient"%>
<%@page import="java.util.List"%>
<%@page import="models.Publicacion"%>
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %-->
<!DOCTYPE html>
<html>
<head>
	<title>Pubicaciones</title>
	<link rel="stylesheet" type="text/css" href="css/publicaciones.css">
        <script>
            function comprar(id){
                var answer = confirm("¿Está seguro de comprar el producto?")
                if(answer){
                    window.location.replace("comprar.jsp?id="+id)
                }
            }
            function devolver(id){
                var answer = confirm("¿Está seguro de devolver el producto?")
                if(answer){
                    window.location.replace("devolver.jsp?id="+id)
                }
            }
        </script>
</head>
<body>
	<%@ include file = "actions/check-hash.jsp" %>
	<%@ include file = "barra.jsp" %>
        <%  RmiClient cliente = new RmiClient();
            List<Publicacion> publicaciones;
            if(request.getParameter("buscar") == null)
                publicaciones = cliente.publicaciones.get();
            else
                publicaciones = cliente.publicaciones.search(request.getParameter("buscar").toString());
            %>
	<div class="contenido">
            <!--<button class="picar" onclick="">Solicitar</button>
			<div class="estado">Vendido</div>
			<div class="estado">Comprado</div>-->
            <% for(Publicacion publicacion:publicaciones){ %>
                <div class="publicacion">
                    <p class="texto">
                        <% out.print(publicacion.getTexto()); %>
                    </p>
                    <p class="precio">
                        <% out.print(publicacion.getPrecio()); %>
                    </p>
                    <% if(publicacion.isEstado()){ 
                        
                        List<Compra> compras = cliente.compras.get();
                        Compra compra = null;
                        Usuario usuario = (Usuario)request.getSession().getAttribute("user");
                        if(usuario!=null){
                            for(Compra x:compras){
                                int days = Days.daysBetween(new DateTime(x.getFecha().getTime()), new DateTime()).getDays();
                                if(days<=3 && x.getIdUsuario()==usuario.getId()){
                                    
                                    compra = x;
                                    break;
                                }
                            }
                        }
                        if(compra==null){
                    %>
                        
                        <div class="estado">Comprado</div>
                    <%}else{%>
                    <button class="picar" onclick="devolver(<%out.print(compra.getId());%>)">Devolver</button>
                    <%}
                     }else if(request.getSession().getAttribute("user")!=null){%>
                     <button class="picar" onclick="comprar(<%out.print(publicacion.getId());%>)">Comprar</button>
                    <%}%>
                </div>
            <%}%>
	</div>
</body>
</html>


