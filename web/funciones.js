function validarFormu(form){
    var nombre = form.nombre;
    if(nombre.value == ""){
        alert("Por favor ingresa el nombre del paciente");
        nombre.focus();
        nombre.select();
        return false;
    }
    var id = form.id;
    if(id.value == ""){
        alert("Por favor ingresa la Cédula/Tarjeta de Identidad");
        id.focus();
        id.select();
        return false;
    }
    var generos = form.genero;
    var radSeleccionado = false;
    for(i=0; i<generos.length;i++){
        if(generos[i].checked){
            radSeleccionado = true;
        }
    }
    if(!radSeleccionado){
        alert("Por favor selecciona un genero");
        return false;
    }
    //var edad1 = form.edad1;
    var edad2 = form.edad2;

    if(edad2.value == "a"){
        alert("Por favor ingresa una edad valida");
        return false;
    }
    var peso = form.peso;
    if(peso.value == ""){
        alert("Por favor ingresa el peso");
        peso.focus();
        peso.select();
        return false;
    }
    var estatura = form.estatura;
    if(estatura.value == ""){
        alert("Por favor ingresa la estatura");
        estatura.focus();
        estatura.select();
        return false;
    }
    var alergia = form.alergia;
    var checkSeleccionado = false;
    for(i=0; i<alergia.length; i++){
        if(alergia[i].checked){
            checkSeleccionado = true;
        }
    }
    if(!checkSeleccionado){
        alert("Por favor verifica en la casilla de alergias");
        return false;
    }
    
    var diagnostico = form.diagnostico;
    if(diagnostico.value == ""){
        alert("Por favor ingresa el diagnostico medico");
        diagnostico.focus();
        diagnostico.select();
        return false;
    }
    
    var medicamentos = form.medicamentos;
    if(medicamentos.value == ""){
        alert("Por favor ingresa los medicamentos a recetar");
        medicamentos.focus();
        medicamentos.select();
        return false;
    }
    
    var dosis = form.dosis;
    if(dosis.value == ""){
        alert("Por favor ingresa la dosis del paciente");
        dosis.focus();
        dosis.select();
        return false;
    }
}
