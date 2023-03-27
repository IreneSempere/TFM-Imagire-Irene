<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <title>Irene Okami</title>
        <link rel="icon" href="img/logoimagire.png" sizes="any"><!-- 32Ã32 -->
        <link rel="stylesheet" href="css/css.css">
        <script src="https://kit.fontawesome.com/716997629e.js"></script>
        <script src="js/slider_index.js" type="text/javascript"></script>
        <script src="js/formulario.js" type="text/javascript"></script>
    </head>

    <body class="body_contacto">
	
    <!-- ------------------------- AVISO COOKIES ------------------------------ -->

    <%@include file="aviso_cookies.html" %>

<!-- -------------------------  CABECERA Y NAV ------------------------------ -->

		<%@include file="menu.html" %>
          
<!------------------------ CONTENIDO CONTACTO ------------------------------ -->

         <div class="contenidoPag">

            <!------------------------ FORMULARIO ---------------------------------------------------------- -->

            <section class="section_contacto">
                <form class="formulario">
                    <h2 class="form_title">FORMULARIO DE CONTACTO</h2>
                    <div class="form_container">
                        <div class="form_group">
                            <ul>
                                <label for="motivo_consulta">¿Cual es el motivo de tu consulta?</label>
                                <select id="motivo_consulta">
                                    <option value="general">Consulta general</option>
                                    <option value="pedido">Pedir presupuesto o realizar un pedido</option>
                                    <option value="problema">Problema con un pedido</option>
                                </select>

                                <li>
                                    <label for="name">Nombre:</label>
                                    <input type="text" id="name" name="user_name" placeholder="" required>
                                </li>
                                <div class="selec_genero">Género:</div>
                                <label class="gender" for="gender_male">Hombre</label>
                                <input class="genero" type="radio" id="gender_male" name="gender" value="HTML" required>
                                <label class="gender" for="gender_female">Mujer</label>
                                <input class="genero" type="radio" id="gender_female" name="gender" value="HTML">
                                <label class="gender" for="gender_nb">nb</label>
                                <input class="genero" type="radio" id="gender_nb" name="gender" value="HTML">
								
                                <li>
                                    <label for="phone">Teléfono:</label>
                                    <input type="tel" id="phone" name="user_phone" placeholder="" pattern="[0-9]{9}" title="Debe contener 9 nÃºmeros" onkeypress="return valideKey(event);" required>
                                </li>
                                <li>
                                    <label for="address">Dirección:</label>
                                    <input type="text" id="address" name="user_address" placeholder="(opcional)">
                                 </li>
                                <li>
                                    <label for="mail">Email:</label>
                                    <input type="email" id="mail" name="user_mail" placeholder="" required>
                                 </li>
                                <div class="motivo_consulta">Escribe aquí el motivo de tu consulta:</div>
                                 <label class="textarea">
                                     <textarea name="textarea" placeholder="" required></textarea>
                                 </label>

                                <label class="checkbox"><input type="checkbox" id="cbx_form" value="checkbox_form" required> He leído y acepto los Términos y condiciones de uso</label>
                                
                                <input type="submit" class="form_submit" value="Enviar">
                            </ul>
                        </div>
                    </div>
                </form>
    <!------------------------ UBICACIÃN ------------------------------------------- -->
    
                <div class="ubicacion">
                    <h2>¿QUIERES HACER UNA VISITA?</h2>

                    <div class="mapa">
                        <iframe id="mapa_gra" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d25060.473376382794!2d-0.6896821499999999!3d38.2665289!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses!
                        2ses!4v1656509355323!5m2!1ses!2ses" width="450" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    <div class="info_ubicacion">
                        <p class="texto_ubicacion">
                            <b>Dónde puedes encontrarme:</b><br>
                            Calle Miguel Hernández nº (bajo), Elche (Alicante) ESPAÑA<br><br>
                            <b>Horario de visita:</b><br>
                            De Lunes a Viernes de 8:30 a 13:30<br>
                            Sábados de 9:00 a 15:00<br>
                            Domingo cerrado<br><br>
                            Puedes concertar una cita llamando al: +34650440000
                        </p>
                    </div>
                    <div class="mapa">
                        <iframe id="mapa_peq" src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d25060.473376382794!2d-0.6896821499999999!3d38.2665289!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1ses!
                        2ses!4v1656509355323!5m2!1ses!2ses" width="300" height="140" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>

            </section>
        </div>

    <!-- ------------------------- FOOTER ------------------------------ -->
    
		<%@include file="footer.html" %>
		
    <script src="js/cookies.js" type="text/javascript"></script> <!-- Enlace de desactivaciÃ³n del aviso de cookies -->

    </body>

</html>