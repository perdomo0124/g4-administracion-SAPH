let tablaResidente;
document.addEventListener('DOMContentLoaded', function () {
    $.fn.dataTable.ext.errMode = 'throw'; //ocultar error del datatable
    tablaResidente = $('#tablaResidente').dataTable({
        "Processing": true,
        "ServerSide": true,
        "ajax": {
            "url": "http://localhost:8080/residente",//ruta de la api
            "dataSrc": ""
        },
        "columns": [
            { "data": "idpk" },
            { "data": "nombre" },
            { "data": "doc" },
            { "data": "telefono" },
            { "data": "accion" }
        ], columnDefs: [
            { targets: 4, visible: true },
            {
                targets: -1,
                orderable: false,
                data: null,
                render: function (data, type, row, meta) {
                    let botones = `
                    <div class="btn-group">
                    <button onClick="EditarRes(`+ row.idpk + `,'` + row.nombre + `','` +
                     row.doc + `','` + row.telefono + `');" class="btn btn-primary">Editar</button>
                    <button onClick="eliminarRes(`+ row.idpk + `);" class="btn btn-danger">Eliminar</button>
                    </div>`;
                    return botones; } }
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
        if (document.querySelector("#formResidente")) { 
        var id = getParameterByName('id');
        var nom = getParameterByName('nom');
        var nit = getParameterByName('doc');
        var tel = getParameterByName('tel');
        if (id != '' || nom != '' || doc != '' || tel != '') {
            document.querySelector('#idproveedor').value = id;
            document.querySelector('#textnombre').value = nom;
            document.querySelector('#textDoc').value = doc;
            document.querySelector('#telefono').value = tel;
        }
    }
  
    }, 500);
    GuardarResidente();
}, false);

function GuardarResidente() {
    if (document.querySelector("#formResidente")) { //validamos que exista el formulario
        let formApto = document.querySelector("#formResidente"); //seleccionamos el formulario
        formApto.onsubmit = function (e) {
            e.preventDefault(); //evitamos que recargue la pagina al precionar el boton
            let id = document.querySelector('#idresidente').value;
            let nombre = document.querySelector('#textnombre').value;
            let doc = document.querySelector('#textDoc').value;
            let tel = document.querySelector('#telefono').value;
            if (nombre == '' || doc == '') {
                let error = document.getElementById('alertError');
                error.innerHTML = 'Todos los campos son obligatorios.'
                error.style.display = 'flex';
                return false; }
            let request = (window.XMLHttpRequest) ?
                new XMLHttpRequest() :
                new ActiveXObject('Microsoft.XMLHTTP');
            let ajaxUrl = 'http://localhost:8080/residente'; //rutas api metodo post
            let json = JSON.stringify({ idpk: id, nombre: nombre, doc: doc,telefono:tel }) //creamos un json
            request.open("POST", ajaxUrl, true);
            request.setRequestHeader("Content-Type", "application/json");
            request.send(json);
            request.onreadystatechange = function () {
                if (request.status == 200) {
                    let exito = document.getElementById('alertSuccess');  //mensajes de exito
                    exito.innerHTML = 'Muy Bien, Se Guardo un Residente Correctamente.'
                    exito.style.display = 'flex';
                    window.location.href = "/Vista/Residente.html";
                } else {
                    let error = document.getElementById('alertError');  //mensajes de error
                    error.innerHTML = 'Error !! No se puedo Guardar el Residente'
                    error.style.display = 'flex';
                    return false;
                }
                return false;
            }
        }
    }
}

function EditarRes(id,nom,doc,tel){
    window.location.href = "/Vista/nuevoResidente.html?id=" + id + "&nom=" + nom + "&doc=" + 
                            doc+ "&tel=" + tel;
}
function eliminarRes(idpk){
        window.confirm("Esta seguro de Eliminar este Residente?");
        let request = (window.XMLHttpRequest) ?
            new XMLHttpRequest() :
            new ActiveXObject('Microsoft.XMLHTTP');
        let ajaxUrl = 'http://localhost:8080/residente/' + idpk; //rutas api metodo post
        request.open("DELETE", ajaxUrl);
        request.setRequestHeader("Accept", "*/*");
        request.setRequestHeader("Content-Type", "application/json");
        request.send();
        request.onreadystatechange = function () {
            if (request.status === 200) {
                let error = document.getElementById('alertSuccessmenu');  //mensajes de error
                error.innerHTML = 'Muy Bien , Residente Eliminado'
                error.style.display = 'flex';
                Window.confirm('Residente Eliminado');
                window.location.reload();
            }else{
                let error = document.getElementById('alertErrormenu');  //mensajes de error
                error.innerHTML = 'Error !! No se puedo Eliminar el Residente'
                error.style.display = 'flex';    
            }
            return false;  
       }
    
}

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}