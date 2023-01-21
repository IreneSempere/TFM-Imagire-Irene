
let imagenes = [];
imagenes.push('img/slider/costa.jpg');
imagenes.push('img/slider/arte.jpg');
imagenes.push('img/slider/resina.jpg');

let cont = 0;
let fin = imagenes.length;

window.onload = () => {

    document.querySelector('.fa-arrow-right').addEventListener('click', () => {
        cont++;
        if(cont === fin){
            cont = 0;
        }
        document.querySelector(".slider").style.backgroundImage = ("url(" + imagenes[cont] + ")");
    })
    document.querySelector('.fa-arrow-left').addEventListener('click', () => {
        cont--;
        if(cont<0){
            cont=fin-1;
        }
        document.querySelector(".slider").style.backgroundImage = ("url(" + imagenes[cont] + ")");
    })

}
