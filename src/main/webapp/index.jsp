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

        <section class=contenidoPag>


            <div class="fondo_info_general">
                <div class="info_general">
                    <i class="fa-sharp fa-solid fa-truck"></i>                        
                    <p>Envíos a toda España</p>
                </div>
                <div class="info_general">
                    <i class="fa-solid fa-pen-ruler"></i>                       
                    <p>Pedidos personalizados</p>
                </div>
                <div class="info_general">
                    <i class="fa-solid fa-clock"></i>                      
                    <p>Artesanía de stock limitado</p>
                </div>
                <div class="info_general">
                    <i class="fa-solid fa-percent"></i>
                    <p>Puntos y descuentos</p>
                </div>
        	</div>
                <div class="desripcionYfoto">
                    <h1>ILUSTRACIONES POR ENCARGO Y PRODUCTOS ARTESANALES</h1>
                    <aside><p class="descripcion_tienda">Todos nuestros productos son únicos y artesanales. Puedes realizar un encargo personalizado y hecho a medida</p></aside>
                </div>

	        <div class="productos_index">
	             <a href="ControladorProductos"><div class="circulo_enlace_productos">
	                 <h3 class="titulo_circulos">NUESTROS PRODUCTOS</h3>
	             </div></a>
	        </div>
                
                

        </section>

        <div class="foto_mesa"></div>

        <section class="contenidoPag">
            <div class="parrafo_descripcion">
                <div>
                    <h2>
                        Mucho más que una tienda de artesanía
                    </h2>
                    <p class="parrafo_index">
                        Me llamo Irene, y además de artista, soy una apasionada de la fantasía y naturaleza.<br>
    
                        En cada rincón de mi ser siempre ha habido un pedacito de naturaleza buscando la forma de salir. <br>Así nació esta pequeña tienda artesanal, una forma de que todos
                        puedan disfrutar de ese trocito de su ser <br>que siempre ha estado dentro de ellos pero que quieren sentir y sostener en sus propias manos.<br>
                        <div class="link_sobremi">
                            <a href="sobre_mi.html" class="link_pag"><h5>Más de mí </h5><i class="fa-solid fa-arrow-right"></i></a>
                        </div>
                    </p>
                </div>
            </div>
        </section>

        <!-- ------------------------- FOOTER ------------------------------ -->
        
		<%@include file="footer.html" %>
        
        <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>