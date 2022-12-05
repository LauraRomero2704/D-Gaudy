/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
var stage = new Konva.Stage({
    container: 'container',
    width: 500,
    height: 500,
});
var layer = new Konva.Layer();
stage.add(layer);

// what is url of dragging element?
var itemURL = '';
document
        .getElementById('drag-items')
        .addEventListener('dragstart', function (e) {
            itemURL = e.target.src;
        });

var con = stage.container();
con.addEventListener('dragover', function (e) {
    e.preventDefault(); // !important
});

con.addEventListener('drop', function (e) {
    e.preventDefault();
    // now we need to find pointer position
    // we can't use stage.getPointerPosition() here, because that event
    // is not registered by Konva.Stage
    // we can register it manually:
    stage.setPointersPositions(e);

    Konva.Image.fromURL(itemURL, function (image) {
        layer.add(image);

        image.position(stage.getPointerPosition());
        image.draggable(true);
    });
});

//captura de pantalla
const $boton = document.querySelector("#btnCapturar"), // El botón que desencadena
        $objetivo = document.querySelector("#container"), // A qué le tomamos la foto
        $contenedorCanvas = document.querySelector("#contenedorCanvas"); // En dónde ponemos el elemento canvas

// Agregar el listener al botón
$boton.addEventListener("click", () => {
    html2canvas($objetivo) // Llamar a html2canvas y pasarle el elemento
            .then(canvas => {
                // Cuando se resuelva la promesa traerá el canvas
                $contenedorCanvas.appendChild(canvas); // Lo agregamos como hijo del div
            });
});

//boton de limpiar

document.getElementById('clean').addEventListener("click", function () {
    location.reload();
});

