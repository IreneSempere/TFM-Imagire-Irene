<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Irene Okami</title>
        <link rel="icon" href="img/logoimagire.png" sizes="any"><!-- 32×32 -->
        <link rel="stylesheet" href="css/css.css">
        <script src="https://kit.fontawesome.com/716997629e.js" crossorigin="anonymous"></script>
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
                Consulta nuestra <a href="politica_cookies.html" class="link_pag";">Política de cookies.</a> Si acepta o continúa navegando, consideramos que acepta su uso.
            </div>
            <button id="aceptarCookies">
                ACEPTAR
            </button>
        </div>

    <!-- -------------------------  CABECERA Y NAV --------------------------------- -->

		<%@include file="menu.html" %>
        
    <!------------------------ FORMULARIO ---------------------------------------------------------- -->

        <section class="section_sesion_admin">
            <form class="formulario_sesion_admin">
                <h2 class="form_title title_usuario">INICIAR SESIÓN</h2>
                <div class="form_container">
                    <div class="form_group">
                        <ul class="form_usuario">
                            <li>
                                <label for="name" class="texto_form_usuario">NOMBRE DE USUARIO</label>
                                <input type="text" id="usuario" name="username" placeholder="" required>
                            </li>
                            <li>
                                <label for="password" class="texto_form_usuario">CONTRASEÑA</label>
                                <input type="password" id="clave" name="password" placeholder="" required>
                            </li>
                            <input type="submit" class="form_submit input_sesion" value="Acceder">
                            <a href="#"><div class="enlace_sesion">¿Has olvidado tu contraseña?</div></a>
                            <a href="#"><div class="enlace_sesion">Regístrate</div></a>                                        
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