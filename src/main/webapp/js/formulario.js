
const nombre = document.getElementsByClassName("name")
const telefono = document.getElementsByClassName("phone")
const direccion = document.getElementsByClassName("address")
const email = document.getElementsByClassName("mail")

//función para validar el teléfono solo con caracteres numéricos
function valideKey(evt){
    
    // code is the decimal ASCII representation of the pressed key.
    var code = (evt.which) ? evt.which : evt.keyCode;
    
    if(code==8) { // borrar caracter
      return true;
    } else if(code>=48 && code<=57) { // codigo ASCII para números entre 0 y 9
      return true;
    } else{ // cualquier otro caracter
      return false;
    }
}

formulario.addEventListener("submit", e=>{

})


