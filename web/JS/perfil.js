
/* ASIDE */
$(document).ready(function(){
		
		// AGREGANDO CLASE ACTIVE AL PRIMER ENLACE ====================
		// FILTRANDO PRODUCTOS  ============================================
		$('.item_menu').click(function(){
			$('.item_menu').removeClass('menu_active');

			// AGREGANDO CLASE ACTIVE AL ENLACE SELECCIONADO
			$(this).addClass('menu_active');
		});
	});


/* PERFIL */
$(document).ready(function(){

	function hideProduct(){
		$('.item_informacion').hide();
	} setTimeout(hideProduct,400);
	
	// AGREGANDO CLASE ACTIVE AL PRIMER ENLACE ====================
	$('.lista_categoria .item_categoria[categoria="info-pers"]').addClass('categoria_active');

	// MOSTRANDO PRODUCTOS =========================
	function showProduct(){
		$('.item_informacion[categoria="info-pers"]').show();
		$('.item_informacion[categoria="info-pers"]').css('scale(1)');
	} setTimeout(showProduct,400);

	// FILTRANDO PRODUCTOS  ============================================
	$('.item_categoria').click(function(){
		var catProduct = $(this).attr('categoria');
		console.log(catProduct);

		// AGREGANDO CLASE ACTIVE AL ENLACE SELECCIONADO
		$('.item_categoria').removeClass('categoria_active');
		$(this).addClass('categoria_active');

		// OCULTANDO PRODUCTOS =========================
		$('.item_informacion').css('transform', 'scale(0)');
		function hideProduct(){
			$('.item_informacion').hide();
		} setTimeout(hideProduct,400);

		// MOSTRANDO PRODUCTOS =========================
		function showProduct(){
			$('.item_informacion[categoria="'+catProduct+'"]').show();
			$('.item_informacion[categoria="'+catProduct+'"]').css('transform', 'scale(1)');
		} setTimeout(showProduct,400);
	});
});