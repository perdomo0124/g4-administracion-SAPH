/* $(document).ready( function () {
    $('#tablaProducto').DataTable();
} ); */

let tableApto;
document.addEventListener('DOMContentLoaded', function () {
    $.fn.dataTable.ext.errMode = 'throw'; //ocultar error del datatable
    tableApto = $('#tablaApto').dataTable({
        "Processing": true,
        "ServerSide": true,
        "ajax": {
            "url": "http://localhost:8080/apto",//ruta de la api
            "dataSrc": ""
        },
        "columns": [
            { "data": "idpk" },
            { "data": "descripcion" },
            { "data": "cuota" },
            { "data": "accion" }
        ],
        columnDefs: [
            { targets: 3, visible: true },
            {
                targets: -1,
                orderable: false,
                data: null,
                render: function (data, type, row, meta) {
                    let botones = `
                    <div class="btn-group">
                    <button onClick="EditarApto(`+ row.idpk + `,'` + row.descripcion + `',` + row.cuota + `);" class="btn btn-primary">Editar</button>
                    <button onClick="eliminarApto(`+ row.idpk + `);" class="btn btn-danger">Eliminar</button>
                    </div>`;
                    return botones;
                }
            }
        ],
        'dom': 'lBfrtip',
        "resonsieve": "true",
        "bDestroy": true,
        "iDisplayLength": 10,
        "order": [[0, "asc"]]
    });


}, false);

/* function EditarProdu() {
    alert("Editar Producto");
}

function eliminarProd() {
    alert("Eliminar Producto");
}
$("#tablaProducto").Database(); */



window.addEventListener('load', function () {
    setTimeout(() => {
        if (document.querySelector("#formApto")) { 
        var aptoId = getParameterByName('id');
        var descripcion = getParameterByName('descripcion');
        var cuota = getParameterByName('cuota');
        if (aptoId != null || aptoId != '' || descripcion != '') {
            document.querySelector('#idapto').value = aptoId;
            document.querySelector('#textDescripcion').value = descripcion;
            document.querySelector('#numCuota').value = cuota;
        }
    }
        GuardarApto();
    }, 500);
}, false);
function GuardarApto() {
    if (document.querySelector("#formApto")) { //validamos que exista el formulario
        let formApto = document.querySelector("#formApto"); //seleccionamos el formulario
        formApto.onsubmit = function (e) {
            e.preventDefault(); //evitamos que recargue la pagina al precionar el boton
            let id = document.querySelector('#idapto').value;
            let strDescrip = document.querySelector('#textDescripcion').value;
            let intCost = document.querySelector('#numCuota').value;

            if (strDescrip == '' || intCost == '') {
                let error = document.getElementById('alertError');
                error.innerHTML = 'Todos los campos son obligatorios.'
                error.style.display = 'flex';
                return false;
            }
            let request = (window.XMLHttpRequest) ?
                new XMLHttpRequest() :
                new ActiveXObject('Microsoft.XMLHTTP');
            let ajaxUrl = 'http://localhost:8080/apto'; //rutas api metodo post
            let json = JSON.stringify({ idpk: id, descripcion: strDescrip, cuota: intCost }) //creamos un json
            request.open("POST", ajaxUrl, true);
            request.setRequestHeader("Content-Type", "application/json");
            request.send(json);
            request.onreadystatechange = function () {
                if (request.status == 200) {
                    let exito = document.getElementById('alertSuccess');  //mensajes de exito
                    exito.innerHTML = 'Muy Bien, Se Guardo un Apartamento Correctamente.'
                    exito.style.display = 'flex';
                    window.location.href = "/Vista/Apto.html";
                } else {
                    let error = document.getElementById('alertError');  //mensajes de error
                    error.innerHTML = 'Error !! No se puedo Guardar el Apartamento'
                    error.style.display = 'flex';
                    return false;
                }
                return false;
            }
        }
    }
}
function EditarApto(id, descripcion, cuota) {
    window.location.href = "/Vista/nuevoApto.html?id=" + id + "&descripcion=" + descripcion + "&cuota=" + cuota;
}
function eliminarApto(id) {
    window.confirm("Esta seguro de Eliminar este Apto");
    let request = (window.XMLHttpRequest) ?
        new XMLHttpRequest() :
        new ActiveXObject('Microsoft.XMLHTTP');
    let ajaxUrl = 'http://localhost:8080/apto/' + id; //rutas api metodo post
    request.open("DELETE", ajaxUrl);
    request.setRequestHeader("Accept", "*/*");
    request.setRequestHeader("Content-Type", "application/json");
    request.send();
    request.onreadystatechange = function () {
        if (request.status === 4) {
            let error = document.getElementById('alertSuccessmenu');  //mensajes de error
            error.innerHTML = 'Muy Bien , Apartamento Eliminado'
            error.style.display = 'flex';
            window.location.reload();
        }else{
            let error = document.getElementById('alertErrormenu');  //mensajes de error
            error.innerHTML = 'Error !! No se puedo Eliminar el Apartamento'
            error.style.display = 'flex';
            window.location.reload();
        }
        return false;  
   }
}

$("#tablaApto").DataTable();
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}