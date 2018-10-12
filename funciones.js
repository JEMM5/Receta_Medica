function validarFormu(form){
    var nombre = form.nombre;
    if(nombre.value == ""){
        alert("Por favor ingresa el nombre del paciente");
        nombre.focus();
        nombre.select();
        return false;
    }
}
