let tableListapto;
document.addEventListener('DOMContentLoaded', function () {
    $.fn.dataTable.ext.errMode = 'throw'; //ocultar error del datatable
    tableListapto = $('#tablaListapto').dataTable({
        "Processing": true,
        "ServerSide": true,
        "ajax": {
            "url": "http://localhost:8080/listapto",//ruta de la api
            "dataSrc": ""
        },
        "columns": [
            { "data": "idpk" },
            { "data": "apto.descripcion" },
            { "data": "residente.nombre" },
            { "data": "ubicacion" },//stock
            { "data": "administracion" },//sucursal
            { "data": "accion" }
        ], columnDefs: [
            { targets: 5, visible: true },
            { targets: -1,
                orderable: false,
                data: null,
                render: function (data, type, row, meta) {
                    let botones = `
                    <div class="btn-group">
                        <button onClick="ActualizarUbicacion(`+ row.idpk + `,`+
                        row.ubicacion + `);" class="btn btn-danger">ubicacion</button>
                    </div>`;
                    return botones;}}
        ],
        'dom': 'lBfrtip',
        "resonsieve": "true",
        "bDestroy": true,
        "iDisplayLength": 10,
        "order": [[0, "asc"]]
    });
}, false);

window.addEventListener('load', function () {
    setTimeout(() => {
        if (document.querySelector("#formubicacion")) { 
        var invenId = getParameterByName('id');
        var ubicacion = getParameterByName('ubicacion');
        if (invenId != null ) {
            document.querySelector('#idinvent').value = invenId;
            document.querySelector('#numUbicacion').value = ubicacion;
        }
        Actualizar();
    }
    }, 500);
    GuardarListapto();
}, false);

function GuardarListapto() {
    if (document.querySelector("#formListapto")) { //validamos que exista el formulario
        let formAptos = document.querySelector("#formListapto"); //seleccionamos el formulario
        formAptos.onsubmit = function (e) {
            e.preventDefault(); //evitamos que recargue la pagina al precionar el boton
            let idapto = document.querySelector('#intapto').value;
            let idresidente = document.querySelector('#intresidente').value;
            let idadministracion = document.querySelector('#numAdministracion').value;
            let ubicacion = document.querySelector('#numUbicacion').value;
            if (idapto == '' || idresidente == '' || idadministracion == '' || ubicacion == '') {
                let error = document.getElementById('alertError');
                error.innerHTML = 'Todos los campos son obligatorios.'
                error.style.display = 'flex';
                return false;
            } let request = (window.XMLHttpRequest) ?
                new XMLHttpRequest() :
                new ActiveXObject('Microsoft.XMLHTTP');
            let ajaxUrl = 'http://localhost:8080/listapto'; //rutas api metodo post
            let json = JSON.stringify({apto:{idpk: parseInt(idapto)}, 
                residente:{idpk:parseInt(idresidente)}, 
                administracion:parseInt(idadministracion), ubicacion: parseInt(ubicacion) }) //creamos un json
            request.open("POST", ajaxUrl, true);
            request.setRequestHeader("Accept", "*/*");
            request.setRequestHeader("Content-Type", "application/json");
            request.send(json);
            request.onreadystatechange = function () {
                if (request.status == 200) {
                    let exito = document.getElementById('alertSuccess');  //mensajes de exito
                    exito.innerHTML = 'Muy Bien, Se Guardo el Listapto Correctamente.'
                    exito.style.display = 'flex';
                    window.location.href = "/Vista/Listapto.html";
                } else {
                    let error = document.getElementById('alertError');  //mensajes de error
                    error.innerHTML = 'Error !! No se puedo Guardar el Listapto'
                    error.style.display = 'flex';
                    return false;
                }
                return false;
            }
        }
    }
}


function ActualizarUbicacion(idpk,ubicacion) {
    window.location.href = "/Vista/actualizarUbicacion.html?id="+idpk+"&ubicacion="+ubicacion;
               
}
function Actualizar() {
    if (document.querySelector("#formubicacion")) { //validamos que exista el formulario
       let formApto = document.querySelector("#formubicacion"); //seleccionamos el formulario
       formApto.onsubmit = function (e) {
           e.preventDefault(); //evitamos que recargue la pagina al precionar el boton
           let idinvent= document.querySelector('#idinvent').value;
           let ubicacion = document.querySelector('#numUbicacion').value;
           if (idinvent == '' ||  ubicacion == '') {
               let error = document.getElementById('alertError');
               error.innerHTML = 'Todos los campos son obligatorios.'
               error.style.display = 'flex';
               return false;
           }
           let request = (window.XMLHttpRequest) ?
               new XMLHttpRequest() :
               new ActiveXObject('Microsoft.XMLHTTP');
           let ajaxUrl = 'http://localhost:8080/listapto'; //rutas api metodo post
           let json = JSON.stringify({idpk:idinvent, ubicacion:ubicacion }) //creamos un json
           request.open("PUT", ajaxUrl, true);
           request.setRequestHeader("Content-Type", "application/json");
           request.send(json);
           request.onreadystatechange = function () {
               if (request.status == 200) {
                   let exito = document.getElementById('alertSuccess');  //mensajes de exito
                   exito.innerHTML = 'Muy Bien, Se Actualizo el Listapto Correctamente.'
                   exito.style.display = 'flex';
                   window.location.href = "/Vista/Listapto.html";
               } else {
                   let error = document.getElementById('alertError');  //mensajes de error
                   error.innerHTML = 'Error !! No se puedo Actualizar el Listapto'
                   error.style.display = 'flex';
                   return false;
               }
               return false;
           }
       }
   }
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}