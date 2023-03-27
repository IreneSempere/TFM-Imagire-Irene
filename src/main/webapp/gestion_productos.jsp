<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Irene Okami</title>
        <link rel="icon" href="img/logoimagire.png" sizes="any">
        <link rel="stylesheet" href="css/css.css">
        <script src="https://kit.fontawesome.com/716997629e.js" crossorigin="anonymous"></script>
        <script src="js/slider_index.js" type="text/javascript"></script>
    </head>

    <body>

    <!-- ------------------------- AVISO COOKIES ------------------------------ -->

    <%@include file="aviso_cookies.html" %>

<!-- -------------------------  CABECERA Y NAV ------------------------------ -->

		<%@include file="menu.html" %>
 
    <!-- ------------------------- CONTENIDO PRODUCTOS ------------------------------ -->
		<section class="fondoGestion">
		
			<section class="contenidoPag">
            
                       
	            <div>
	                <h1>
	                    GESTIÓN DE PRODUCTOS
	                </h1> 
	            </div>
	          
	            <section class="filtro_e_inserción"> 
					<section>
						<div class="textoFiltrarProductos">Filtrar productos:</div>
					
						<div class="filtroGestionProductos">
							<a href="ControladorGestionProductos" class="link_pag">
				            	<div class="TodosFiltroGestion">
					                <h4>Todos los productos</h4>
				                </div>
			                </a>
							<a href="ControladorGestionProductos?tipo_producto=Diorama" class="link_pag">
				            	<div class="DioramasFiltroGestion">
					                <h4>Dioramas</h4>
				                </div>
			                </a>
							<a href="ControladorGestionProductos?tipo_producto=Joyeria" class="link_pag">
				            	<div class="JoyeriaFiltroGestion">
					                <h4>Joyería</h4>
				                </div>
			                </a>
							<a href="ControladorGestionProductos?tipo_producto=Cuadro" class="link_pag">
				            	<div class="CuadrosFiltroGestion">
					                <h4>Cuadros</h4>
				                </div>
			                </a>
							<a href="ControladorGestionProductos?tipo_producto=Mesa" class="link_pag">
				            	<div class="MesasFiltroGestion">
					                <h4>Mesas</h4>
				                </div>
			                </a>
							<a href="ControladorGestionProductos?tipo_producto=Ilustracion" class="link_pag">
				            	<div class="IlustracionFiltroGestion">
					                <h4>Ilustración</h4>
				                </div>
			                </a>
						</div>
						
					</section>
					
					<section class="section_BotonInsertarProducto">
						<div class="BotonInsertarProducto">
							<input type="button" value="Añadir producto" onclick="window.location.href='insertar_producto.jsp'"/>
						</div>
					</section>		
						
				</section> 
				
	            
				<section class="tablaProductos">
	            
	            	<table>
	            		<tr class="superiorTabla">
	            			<th>ID</th>
	            			<th>Nombre</th>
	            			<th>Descripción</th>
	            			<th>Precio</th>
	            			<th>Precio oferta</th>
	            			<th>Stock</th>
	            			<th>Tipo producto</th>
	            			<th>Fecha</th>
	            			<th>Ruta imagen</th>
	            			<th></th>
	            			<th></th>
	            		</tr>
	            		
						<c:forEach var="producto" items="${LISTA_PRODUCTOS}">
						
							<!-- Link para cada producto con su campo clave -->
							<c:url var="link_modificarProducto" value="ControladorGestionProductos">
								<c:param name="instruccion" value="cargarPorID"></c:param>
								<c:param name="IDproducto" value="${producto.id}"></c:param>
							</c:url>
							
							<!-- Link para eliminar cada registro con su campo clave--> 
							<c:url var="link_eliminarProducto" value="ControladorGestionProductos">
								<c:param name="instruccion" value="eliminarPorID"></c:param>
								<c:param name="IDproducto" value="${producto.id}"></c:param>
							</c:url>
							
		                	<tr class="inferiorTabla">
		                		<td>${producto.id}</td>
		                		<td>${producto.nombre}</td>
		                		<td>${producto.descripcion}</td>
		                		<td>${producto.precio}</td>
		                		<td>${producto.precioOferta}</td>
		                		<td>${producto.stock}</td>
		                		<td>${producto.tipoProducto}</td>
		                		<td>${producto.fecha}</td>
		                		<td>${producto.pathImg}</td>
		                		<td class="modificar_producto"><a href="${link_modificarProducto}">Modificar</a></td>
		                		<td><a href="${link_eliminarProducto}"><i class="fa-solid fa-trash"></i></a></td>
		                	</tr>
						</c:forEach>
						
	            	</table>
	            
	            </section>
				
	        </section>
	        
			    <!-- ------------------------- FOOTER ------------------------------ -->
	    
		<%@include file="footer.html" %>
		
		</section>
        


    <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>