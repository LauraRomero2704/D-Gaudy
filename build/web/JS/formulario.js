const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = 
{
	/* EMPLEADO */
	txtProf_emp: /^[a-zA-ZÀ-ÿ\s]{8,30}$/,
	txtDoc_emp: /^[0-9]{8,11}$/, 
	txtNom_emp: /^[a-zA-ZÀ-ÿ\s]{1,30}$/, 
	txtApe_emp: /^[a-zA-ZÀ-ÿ\s]{1,30}$/,
	txtCiu_emp: /^[a-zA-ZÀ-ÿ\s]{4,20}$/, 
	txtDir_emp: /^[a-zA-ZÀ-ÿ\s0-9_.+-º]{10,50}$/,
	txtCorr_emp: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	txtTel_emp: /^\d{7,14}$/,

	/* REPORTE */
	txtNom_rept: /^[a-zA-ZÀ-ÿ\s]{1,30}$/, 
	txtCat_rept: /^[a-zA-ZÀ-ÿ\s]{1,30}$/,

	/* USUARIO */
	txtnom_usu: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	txtcont_usu: /^.{8,32}$/,
        
        /* PRENDA */
        txtNom_pren: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        txtDescrip_pren: /^[a-zA-ZÀ-ÿ\s]{20,100}$/,
        txtUrl_pren: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
        txtColor_pren: /^[a-zA-ZÀ-ÿ\s]{4,15}$/,
        txtStock_pren: /^[a-zA-ZÀ-ÿ\s]{1,30}$/,
        txtPrecio_pren:/^.{8,32}$/
        
}

const campos = 
{
	/* EMPLEADO */
	txtProf_emp: false,
	txtDoc_emp: false,
	txtNom_emp: false,
	txtApe_emp: false,
	txtCiu_emp: false,
	txtDir_emp: false,
	txtCorr_emp: false,
	txtTel_emp: false,

	/* REPORTE*/
	txtNom_rept: false, 
	txtCat_rept: false,

	/* USUARIO */
	txtnom_usu: false,
	txtcont_usu: false,
        
        txtNom_pren: false,
        txtDescrip_pren: false,
        txtUrl_pren:false,
        txtColor_pren: false,
        txtStock_pren: false,
        txtPrecio_pren:false
        
}

const validarFormulario = (e) => 
{
	switch (e.target.name) 
	{
		/* EMPLEADO */
		case "txtProf_emp":
			validarCampo(expresiones.txtProf_emp, e.target, 'txtProf_emp');
		break;
		case "txtDoc_emp":
			validarCampo(expresiones.txtDoc_emp, e.target, 'txtDoc_emp');
		break;
		case "txtNom_emp":
			validarCampo(expresiones.txtNom_emp, e.target, 'txtNom_emp');
		break;
		case "txtApe_emp":
			validarCampo(expresiones.txtApe_emp, e.target, 'txtApe_emp');
		break;
		case "txtCiu_emp":
			validarCampo(expresiones.txtCiu_emp, e.target, 'txtCiu_emp');
		break;
		case "txtDir_emp":
			validarCampo(expresiones.txtDir_emp, e.target, 'txtDir_emp');
		break;
		case "txtCorr_emp":
			validarCampo(expresiones.txtCorr_emp, e.target, 'txtCorr_emp');
		break;
		case "txtTel_emp":
			validarCampo(expresiones.txtTel_emp, e.target, 'txtTel_emp');
		break;

		/* REPORTE */
		case "txtNom_rept":
			validarCampo(expresiones.txtNom_rept, e.target, 'txtNom_rept');
		break;
		case "txtCat_rept":
			validarCampo(expresiones.txtCat_rept, e.target, 'txtCat_rept');
		break;

		/* USUARIO */
		case "txtnom_usu":
			validarCampo(expresiones.txtnom_usu, e.target, 'txtnom_usu');
			validarCorreos();
		break;
		case "txtnom_usu2":
			validarCorreos();
		break;
		case "txtcont_usu":
			validarCampo(expresiones.txtcont_usu, e.target, 'txtcont_usu');
			validarContraseñas();
		break;
		case "txtcont_usu2":
			validarContraseñas();
		break;
                
                /* PRENDA */
                
                case "txtNom_pren":
			validarCampo(expresiones.txtNom_pren, e.target, 'txtNom_pren');
		break;
		case "txtDescrip_pren":
			validarCampo(expresiones.txtDescrip_pren, e.target, 'txtDescrip_pren');
		break;
		case "txtUrl_pren":
			validarCampo(expresiones.txtUrl_pren, e.target, 'txtUrl_pren');
		break;
                case "txtColor_pren":
			validarCampo(expresiones.txtColor_pren, e.target, 'txtColor_pren');
		break;
                case "txtStock_pren":
			validarCampo(expresiones.txtStock_pren, e.target, 'txtStock_pren');
		break;
                case "txtPrecio_pren":
			validarCampo(expresiones.txtPrecio_pren, e.target, 'txtPrecio_pren');
		break;
                
	}
}

const validarCampo = (expresion, input, campo) => 
{
	if(expresion.test(input.value))
	{
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos[campo] = true;
	} 
	
	else 
	{
		document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos[campo] = false;
	}
}


const validarCorreos = () => {
	const inputtxtnom_usu1 = document.getElementById('txtnom_usu');
	const inputtxtnom_usu2 = document.getElementById('txtnom_usu2');

	if(inputtxtnom_usu1.value !== inputtxtnom_usu2.value){
		document.getElementById(`grupo__txtnom_usu2`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__txtnom_usu2`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__txtnom_usu2 i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__txtnom_usu2 i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__txtnom_usu2 .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos['txtnom_usu'] = false;
	} else {
		document.getElementById(`grupo__txtnom_usu2`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__txtnom_usu2`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__txtnom_usu2 i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__txtnom_usu2 i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__txtnom_usu2 .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos['txtnom_usu'] = true;
	}
}

const validarContraseñas = () => {
	const inputtxtcont_usu1 = document.getElementById('txtcont_usu');
	const inputtxtcont_usu2 = document.getElementById('txtcont_usu2');

	if(inputtxtcont_usu1.value !== inputtxtcont_usu2.value){
		document.getElementById(`grupo__txtcont_usu2`).classList.add('formulario__grupo-incorrecto');
		document.getElementById(`grupo__txtcont_usu2`).classList.remove('formulario__grupo-correcto');
		document.querySelector(`#grupo__txtcont_usu2 i`).classList.add('fa-times-circle');
		document.querySelector(`#grupo__txtcont_usu2 i`).classList.remove('fa-check-circle');
		document.querySelector(`#grupo__txtcont_usu2 .formulario__input-error`).classList.add('formulario__input-error-activo');
		campos['txtcont_usu'] = false;
	} else {
		document.getElementById(`grupo__txtcont_usu2`).classList.remove('formulario__grupo-incorrecto');
		document.getElementById(`grupo__txtcont_usu2`).classList.add('formulario__grupo-correcto');
		document.querySelector(`#grupo__txtcont_usu2 i`).classList.remove('fa-times-circle');
		document.querySelector(`#grupo__txtcont_usu2 i`).classList.add('fa-check-circle');
		document.querySelector(`#grupo__txtcont_usu2 .formulario__input-error`).classList.remove('formulario__input-error-activo');
		campos['txtcont_usu'] = true;
	}
}


inputs.forEach((input) => 
{
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => 
{

	if
	(	/* EMPLEADO */ 
		campos.txtProf_emp && campos.txtDoc_emp && campos.txtNom_emp && campos.txtApe_emp && campos.txtCiu_emp && campos.txtDir_emp && campos.txtCorr_emp && campos.txtTel_emp && 

		/* REPORTE */ 
		campos.txtNom_rept && campos.txtCat_rept &&

		/* USUARIO */ 
		campos.txtnom_usu && campos.txtcont_usu &&
                        
                /* PRENDA */         
                campos.txtNom_pren && campos.txtDescrip_pren && campos.txtUrl_pren && campos.txtColor_pren && campos.txtStock_pren && campos.txtPrecio_pren 
	)
	{
	} 
	
});