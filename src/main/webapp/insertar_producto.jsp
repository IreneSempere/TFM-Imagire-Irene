<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Imagire</title>
        <link rel="icon" href="img/logoimagire.png" sizes="any">
        <link rel="stylesheet" href="css/css.css">
        <script src="https://kit.fontawesome.com/716997629e.js"></script>
        <script src="js/slider_index.js" type="text/javascript"></script>
    </head>

    <body>

    <!-- ------------------------- AVISO COOKIES ------------------------------ -->

<%--     	<%@include file="aviso_cookies.html" %> --%>

	<!-- -------------------------  CABECERA Y NAV ------------------------------ -->

		<%@include file="menu.html" %>
 
    <!-- ------------------------- CONTENIDO PRODUCTOS ------------------------------ -->

        <section class="contenidoPag">

            <div class="tituloProductos">
                <h1>
                    AÑADIR PRODUCTO
                </h1> 
            </div>
			
			<section class="contenedor_formulario_gestion">
				<form class="formularioInsertarProducto" id="formularioInsertarProducto" method="post" action="ControladorGestionProductos" enctype="multipart/form-data">
					<input type="hidden" name="instruccion" value="insertarEnBD"> <!-- El parámetro instrucción se utiliza para utilizar diferentes "paginas" o secciones dentro de una misma url -->
					
	                <div class="form_container">
	                    <div class="form_group">
	                        <ul>
	                        	<li>
		                            <label for="tipo" >Tipo de producto</label>
		                            <select id="labelTipoProducto" name="tipo_producto" form="formularioInsertarProducto">
		                                <option value="Diorama">Diorama</option>
		                                <option value="Cuadro">Cuadro</option>
		                                <option value="Joyería">Joyería</option>
		                                <option value="Mesa">Mesa</option>
		                                <option value="Ilustracion">Ilustración</option>
		                            </select>
								</li>
	                            <li>
	                                <label for="nombre">Nombre del producto:</label>
	                                <input type="text" id="nombre" name="nombre_producto" placeholder="" required>
	                            </li>
	                            <li>                           
	                                <label for="descripcion">Descripción:</label>
	                                <input type="text" id="descripcion" name="descripcion_producto" placeholder="" required>
	                            </li>
	                            <li>                            
	                                <label for="precio">Precio:</label>
	                                <input type="text" id="precio" name="precio_producto" placeholder="" required>
	                            </li> 
	                            <li>                          
	                                <label for="oferta">Oferta:</label>
	                                <input type="text" id="oferta" name="oferta_producto" placeholder="">
	                            </li>  
	                            <li>                         
	                                <label for="stock">Stock:</label>
	                                <input type="text" id="stock" name="stock_producto" placeholder="" required>
	                            </li>
	                            <li>
	                            	<label for="img">Sube una foto del producto:</label>
            						<input type="file" id="img" name="foto_producto" />
            					</li>
								<li>
									<input type="submit" class="form_submit" value="Añadir">
								</li>
	                        </ul>
	                    </div>
	                </div>
	            </form>
			</section>
			
        </section>

    <!-- ------------------------- FOOTER ------------------------------ -->
	    
		<%@include file="footer.html" %>

    <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>