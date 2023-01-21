<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Irene Okami</title>
        <link rel="icon" href="img/logoimagire.png" sizes="any"><!-- 32×32 -->
        <link rel="stylesheet" href="css/estilos.css">
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
		
    <!-- ------------------------- CONTENIDO SOBRE MI ------------------------------ -->

        <div class="contenidoPag">

           <section class="sobre_mi">
                <figure class="foto_sobre_mi">
                   <img src="img/sobremi/sobre_mi.jpg" alt="foto_artista">
               </figure>
                <div class="info_sobre_mi">
                    <h2>SOBRE MÍ</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed finibus aliquam est, a porta mauris ullamcorper nec. Morbi nec luctus tellus.
                    In id nisi ac elit dapibus faucibus vel ac purus. Mauris nec ipsum sed sapien eleifend suscipit. Nunc vel ornare nunc. Curabitur vel tempus tellus,
                         elit.<br><br>
                        <b>Mi trayectoria</b><br>Proin consequat orci vel consequat vestibulum. Curabitur vel semper orci, id euismod lacus. Pellentesque nec urna dui. Praesent odio ante,
                         ornare. Etiam ac tortor arcu. Aliquam sagittis, ex sit amet maximus congue,
                        urna augue auctor diam, nec lobortis orci eros at orci. Ut ultricies quis ligula.</p>
                    <figure><img src="img/sobremi/inspire.jpg"></figure>

                    <h3>Inspiración y experiencia</h3>

                    <div class="experiencia">
                        <p>Nunc tempor et ipsum et commodo. Etiam a gravida leo, ut ultrices sapien. Curabitur consequat mi et nulla consequat posuere nec ullamcorper dui. Proin auctor augue
                         sed mi aliquam ultricies. Aliquam erat volutpat. Donec sollicitudin feugiat erat facilisis.</p>
                    </div>
                </div>
           </section>
        </div>

    <!-- ------------------------- FOOTER ------------------------------ -->
    
		<%@include file="footer.html" %>
		
    <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivación del aviso de cookies -->

    </body>

</html>