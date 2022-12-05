$(document).ready(function () {
    $("tr #deleteItem").click(function (e) {
        e.preventDefault();
        var idp = $(this).parent().find('#item2').val();        
        swal({
            title: "Esta Seguro de eliminar esta prenda?",
            text: "Una vez eliminada, debera agregarla de nuevo!",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((willDelete) => {
            if (willDelete) {
                eliminar(idp);
                swal("¡Eliminaste la prenda del carrito! ", {
                    icon: "success",
                }).then((willDelete) => {
                    if (willDelete) {
                        parent.location.href = "CarritoController?accion=carrito";
                    }
                });
            }
        });
    });
    function eliminar(idp) {
        var url = "CarritoController?accion=deleteProducto&ide_pren=" + idp;
        console.log("hol");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
            }
        });
    }
    
    $("tr #deletePer").click(function (e) {
        e.preventDefault();
        var idp = $(this).parent().find('#b4').val();        
        swal({
            title: "Esta Seguro de eliminar esta Prenda Personalizada?",
            text: "Una vez eliminada, debera agregarla de nuevo!",
            icon: "warning",
            buttons: true,
            dangerMode: true
        }).then((willDelete) => {
            if (willDelete) {
                eliminarPers(idp);
                swal("¡Eliminaste la prenda del carrito! ", {
                    icon: "success",
                }).then((willDelete) => {
                    if (willDelete) {
                        parent.location.href = "CarritoController?accion=carritoPers";
                    }
                });
            }
        });
    });
    function eliminarPers(idp) {
        var url = "CarritoController?accion=deletePerso&ide_pers=" + idp;
        console.log("hol");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            success: function (r) {
            }
        });
    }


    $("tr #Cant").click(function (e) {
        var idp = $(this).parent().find('#item1').val();
        var cantidad = $(this).parent().find('#Cant').val();
        var url = "CarritoController?accion=updateCantidad";
        console.log(idp, cantidad);
        $.ajax({
            type: 'POST',
            url: url,
            data: "ide_pren=" + idp + "&cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
            location.href = "CarritoController?accion=carrito";
            }
        });
    });   
    
    $("tr #CantPer").click(function (e) {
        var idp = $(this).parent().find('#item2').val();
        var cantidad = $(this).parent().find('#CantPer').val();
        var url = "CarritoController?accion=updateCantidadPers";
        console.log(idp, cantidad);
        $.ajax({
            type: 'POST',
            url: url,
            data: "ide_pers=" + idp + "&cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
            location.href = "CarritoController?accion=carritoPers";
            }
        });
    }); 
   
});





