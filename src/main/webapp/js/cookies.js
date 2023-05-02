const queryString = window.location.search; //obtiene url de la pagina
const urlParams = new URLSearchParams(queryString); //crea un objeto para obtener parametros facilmente
var muestra_cookies=urlParams.get('muestra_cookies') === 'false' ? false : true; //obtenemos el parametro muestra cookies que usaremos para posteriormente desactivar las cookies una vez aceptadas

//si el parametro muestra cookies es false se desactiva el aviso de cookies
if (muestra_cookies===false){ 
    desactivarAviso();
}

// función que desactiva el aviso de cookies
function desactivarAviso(){
    let links = document.getElementsByClassName("link_pag"); /* esta variable es un array */
    
    for (i=0;i<links.length;i++){
 		if(links[i].href.includes("?")){
        	links[i].href += "&&muestra_cookies=false";
		} else {
       		links[i].href += "?muestra_cookies=false";
		}
    }

	if(document.querySelector(".avisoCookies") != null){
	    document.querySelector(".avisoCookies").style.display = 'none';
	}
}


//cuando se acepten las cookies se modifica el parametro muestra cookies a false
document.querySelector('#aceptarCookies').addEventListener('click', () =>  { 
    muestra_cookies=false;
    desactivarAviso();
})