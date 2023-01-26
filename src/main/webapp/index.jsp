<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Irene Okami</title>
        <link rel="icon" href="img/logoimagire.png" sizes="any"><!-- 32×32 -->
        <link rel="stylesheet" href="css/css.css">
        <script src="https://kit.fontawesome.com/716997629e.js"></script>
        <script src="js/slider_index.js" type="text/javascript"></script>
        <meta name="keywords" content="arte, artes, manual, manualidades, artesania, artesano, unico, personalizado, encargo, transparente, agua, marina, mar, playa, diorama, centro, mesa, tabla, cuadro, paisaje, natural, naturaleza, 
        arena, cala, rio, montaña, ambar, encapsulado,  artesania, tienda, decoracion, resina, figura, accesorios, madera, noble, epoxy, collar, collares, llaveros, colgantes, pendientes, lampara, miniatura, realista, ambiente, lamparas, luz, marino, oceano, azul"/>
    </head>

    <body>

    <!-- ------------------------- AVISO COOKIES ------------------------------ -->

        <div class="avisoCookies">
            <div id="tituloAvisoCookies">
                <b>AVISO DE COOKIES</b>
            </div>
            <div id="infoCookies">
                Utilizamos cookies propias y de terceros para obtener datos estadísticos de la navegación de nuestros usuarios y mejorar nuestros servicios. 
                Consulta nuestra <a href="politica_cookies.html" class="link_pag">Política de cookies.</a> Si acepta o continúa navegando, consideramos que acepta su uso.
            </div>
            <button id="aceptarCookies">
                ACEPTAR
            </button>
        </div>

    <!-- -------------------------  CABECERA Y NAV --------------------------------- -->

		<%@include file="menu.html" %>
        
    <!-- -------------------------------- SLIDER --------------------------------- -->

        <div class="slider">
            <i class="fa-solid fa-arrow-left"></i>
            <i class="fa-solid fa-arrow-right"></i>
        </div>

    <!-- ------------------------- CONTENIDO INDEX ------------------------------- -->

		<section class="contenedor_info_general">
			<section class="fondo_info_general">
                <div class="info_general">
                    <i class="fa-sharp fa-solid fa-truck"></i>                        
                    <p class="texto_info_general">Envíos a toda España</p>
                </div>
                <div class="info_general">
                    <i class="fa-solid fa-pen-ruler"></i>                       
                    <p class="texto_info_general">Pedidos personalizados</p>
                </div>
                <div class="info_general">
                    <i class="fa-solid fa-clock"></i>                      
                    <p class="texto_info_general">Artesanía de stock limitado</p>
                </div>
                <div class="info_general">
                    <i class="fa-solid fa-percent"></i>
                    <p class="texto_info_general">Ofertas y descuentos</p>
                </div>
        	</section> 
		</section>
            
        	
    	
       	<section class="info_tienda">
       		<h1>TIENDA DE PRODUCTOS ARTESANALES</h1>
       		<p class="parrafo_info_tienda">¡Bienvenido/a a nuestra pequeña tienda de artesanía!</p>
       		<section class="contenido_info_tienda">
       			<div>
       				<a href="productos.jsp"><img src="img/diorama.jpg" alt="imagen de un producto artesanal" class="circulos_index"></a>
       				<p class="texto_productos_index">Aquí podrás encontrar diferentes productos<br> en stock de decoración y joyería artesanal</p>
       			</div>
       			<div>
       				<a href="contacto.jsp"><img src="img/handmade.jpg" alt="imagen de una persona trabajando manualmente" class="circulos_index"></a>
       				<p class="texto_productos_index">Si prefieres hacernos un pedido personalizado<br> y/o hecho a medida, contacta con nosotros</p>
       			</div>   
       			<div>
       				<a href="ofertas.jsp"><img src="img/offer.jpg" alt="imagen de un cartel de ofertas" class="circulos_index"></a>
       				<p class="texto_productos_index">No olvides que tenemos ofertas por tiempo<br> limitado o hasta fin de stock</p>
       			</div>    			
       		</section>
       		
       	</section>

        <div class="foto_mesa"></div>

        <section class="contenidoPag">
            <h2 class="titulo_sobre_mi">
               Mucho más que una tienda de artesanía
            </h2>
            <section class="parrafo_descripcion">
				<img src="img/sobre_mi.jpg" alt="imagen de una chica trabajando" class="img_sobre_mi">
				<section>
					<h3 class="h4_sobre_mi">Un poco sobre mí y el origen de la tienda</h3>
					<p class="parrafo_index">
	                    Me llamo Irene, y además de artista, soy una apasionada de la fantasía y naturaleza.<br>
	
	                    En un rincón dentro de mí siempre ha habido algo de naturaleza buscando la forma de salir. Así nació esta pequeña tienda artesanal.<br>
	                </p>
	                <h3 class="h4_sobre_mi2">Mi inspiración</h3>
	                <p class="parrafo_index">
	                   Desde niña he disfrutado de los paisajes, los animales y la fantasía detras de todos aquellos libros y películas que tanto amaba. Quiero que la gente como yo pueda
	                   sentir que tiene una pequeña parte de esos mundos en su hogar.
	                </p>
	                <img src="img/sobremi/inspire.jpg" alt="imagen de un pájaro volando" class="foto_inspiracion">
				</section>
                
            </section>
        </section>
        
        <h2 class="titulo_sobre_mi">
               Conoce algunos de nuestros productos artesanales
        </h2>
        
        <div class="slide">
            <div class="slide-inner">
                <input class="slide-open" type="radio" id="slide-1" 
                      name="slide" aria-hidden="true" hidden="" checked="checked">
                <div class="slide-item">
                    <img src="img/productos/cuadro.jpg">
                </div>
                <input class="slide-open" type="radio" id="slide-2" 
                      name="slide" aria-hidden="true" hidden="">
                <div class="slide-item">
                    <img src="img/productos/collares.jpg">
                </div>
                <input class="slide-open" type="radio" id="slide-3" 
                      name="slide" aria-hidden="true" hidden="">
                <div class="slide-item">
                    <img src="img/productos/mesa.jpg">
                </div>
                <label for="slide-3" class="slide-control prev control-1">‹</label>
                <label for="slide-2" class="slide-control next control-1">›</label>
                <label for="slide-1" class="slide-control prev control-2">‹</label>
                <label for="slide-3" class="slide-control next control-2">›</label>
                <label for="slide-2" class="slide-control prev control-3">‹</label>
                <label for="slide-1" class="slide-control next control-3">›</label>
                <ol class="slide-indicador">
                    <li>
                        <label for="slide-1" class="slide-circulo">•</label>
                    </li>
                    <li>
                        <label for="slide-2" class="slide-circulo">•</label>
                    </li>
                    <li>
                        <label for="slide-3" class="slide-circulo">•</label>
                    </li>
                </ol>
            </div>
        </div>

        <!-- ------------------------- FOOTER ------------------------------ -->
        
		<%@include file="footer.html" %>
        
        <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>