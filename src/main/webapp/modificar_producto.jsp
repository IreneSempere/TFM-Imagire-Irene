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
 
    <!-- ------------------------- CONTENIDO PRODUCTOS ------------------------------ -->

        <section class="contenidoPag">

            <div class="tituloProductos">
                <h1>
                    MODIFICAR PRODUCTO
                </h1> 
            </div>
			
			<form class="formularioModificarProducto" id="formularioModificarProducto" method="get" action="ControladorGestionProductos">
				<input type="hidden" name="instruccion" value="actualizarBDyListar"> <!-- El parámetro instrucción/IDarticulo se utiliza para utilizar diferentes "paginas" o secciones dentro de una misma url -->
				<input type="hidden" name="IDproducto" value="${productoModificar.id}">
				
                <div class="form_container">
                    <div class="form_group">
                        <ul>
                        	<li>
	                            <label for="tipo" >Tipo de producto</label>
	                            <select id="labelTipoProducto" name="tipo_producto" form="formularioModificarProducto">
	                            	<option value="${productoModificar.tipoProducto}">${productoModificar.tipoProducto}</option>
	                                <option value="Diorama">Diorama</option>
	                                <option value="Cuadro">Cuadro</option>
	                                <option value="Joyería">Joyería</option>
	                                <option value="Mesa">Mesa</option>
	                                <option value="Ilustracion">Ilustración</option>
	                            </select>
							</li>
                            <li>
                                <label for="nombre">Nombre del producto:</label>
                                <input type="text" id="nombre" name="nombre_producto" value="${productoModificar.nombre}">
                            </li>
                            <li>                           
                                <label for="descripcion">Descripción:</label>
                                <input type="text" id="descripcion" name="descripcion_producto" value="${productoModificar.descripcion}">
                            </li>
                            <li>                            
                                <label for="precio">Precio:</label>
                                <input type="text" id="precio" name="precio_producto" value="${productoModificar.precio}">
                            </li> 
                            <li>                          
                                <label for="oferta">Oferta:</label>
                                <input type="text" id="oferta" name="oferta_producto" value="${productoModificar.precioOferta}">
                            </li>  
                            <li>                         
                                <label for="stock">Stock:</label>
                                <input type="text" id="stock" name="stock_producto" value="${productoModificar.stock}">
                            </li>
							<li>
								<input type="submit" class="form_submit" value="Actualizar">
							</li>
                        </ul>
                    </div>
                </div>
            </form>
        </section>

    <!-- ------------------------- FOOTER ------------------------------ -->
	    
		<%@include file="footer.html" %>

    <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>