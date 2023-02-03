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

    <div class="avisoCookies">
        <div id="tituloAvisoCookies">
            <b>AVISO DE COOKIES</b>
        </div>
        <div id="infoCookies">
            Utilizamos cookies propias y de terceros para obtener datos estadísticos de la navegación de nuestros usuarios y mejorar nuestros servicios. 
            Consulta nuestra <a href="politica_cookies.html" class="link_pag" style="color: #0096c8;">Política de cookies.</a> Si acepta o continúa navegando, consideramos que acepta su uso.
        </div>
        <button id="aceptarCookies">
            ACEPTAR
        </button>
    </div>

<!-- -------------------------  CABECERA Y NAV ------------------------------ -->

		<%@include file="menu.html" %>
   
    <!-- -------------------------------- SLIDER --------------------------------- -->

        <div class="slider">
            <i class="fa-solid fa-arrow-left"></i>
            <i class="fa-solid fa-arrow-right"></i>
        </div>
         
    <!-- ------------------------- CONTENIDO PRODUCTOS ------------------------------ -->
    
		<section class="contenedor_filtro">		
                <aside><p id="textoProductos">
                    Aquí encontrarás diferentes productos en stock con envío 24/48h. Recuerda que puedes realizar un pedido personalizado.<br>
                    El tiempo de envío de los pedidos personalizados varía según el tiempo de fabricación de los mismos.
                </p></aside>			
		</section>
		
  
        <section class="contenidoPag">
			
			<div class="filtroProductos">
            	<a href="ControladorProductosCliente" class="link_pag">
	            	<div>
		            	<div class="circuloFiltroProductos">
		            	</div>
		                <h4>Todos los productos</h4>
	                </div>
                </a>
            	<a href="ControladorProductosCliente?tipo_producto=Diorama" class="link_pag">
	            	<div>
		            	<div class="circuloFiltroProductos circuloFiltroProductosDioramas">
		            	</div>
		                <h4>Dioramas</h4>
	                </div>
	             </a>
            	<a href="ControladorProductosCliente?tipo_producto=Cuadro" class="link_pag">
	            	<div>
		            	<div class="circuloFiltroProductos circuloFiltroProductosCuadros">
		            	</div>
		                <h4>Cuadros</h4>
	                </div>
                </a>
            	<a href="ControladorProductosCliente?tipo_producto=Joyeria" class="link_pag">
	            	<div>
		            	<div class="circuloFiltroProductos circuloFiltroProductosJoyeria">
		            	</div>
		                <h4>Joyería</h4>
	                </div>
                </a>
            	<a href="ControladorProductosCliente?tipo_producto=Mesa" class="link_pag">
	            	<div>
		            	<div class="circuloFiltroProductos circuloFiltroProductosMesas">
		            	</div>
		                <h4>Mesas</h4>
	                </div>
                </a>
            	<a href="ControladorProductosCliente?tipo_producto=Ilustracion" class="link_pag">
	            	<div>
		            	<div class="circuloFiltroProductos circuloFiltroProductosIlus">
		            	</div>
		                <h4>Ilustración</h4>
	                </div>
                </a>
            </div>
       
            <div class="tituloProductos">
                <h1>
                    TODOS LOS PRODUCTOS
                </h1>
            </div>
            
            <section class="listaProductos">
            
			<c:forEach var="producto" items="${LISTA_PRODUCTOS}">

                <a href="#" class="link_pag">
                    <div class="cajaProducto">
                        <img alt="imagen de un producto en oferta" src="${producto.pathImg}">
                        <div class="nombreProducto">
							<c:set var="precioDosDecimales"><fmt:formatNumber type="number" minFractionDigits="2" maxFractionDigits="2" value="${producto.precio}" /></c:set>
                            <div class="precioProducto"> ${precioDosDecimales}€</div>
                            <p>
                                 ${producto.nombre} 
                            </p>
                        </div>
                        <p class="descripcionProducto">
                       		 ${producto.descripcion}
                        </p>
                    </div>
                </a>
			</c:forEach>	
            
            </section>
			
        </section>

    <!-- ------------------------- FOOTER ------------------------------ -->
	    
		<%@include file="footer.html" %>

    <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>