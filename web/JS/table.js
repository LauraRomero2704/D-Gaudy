// Codigo para datables 
$(document).ready(function () { 
    // Inicializar datables de la manera mas simple 
    $('#table').DataTable( { 
        responsive: true, 
        // Cambiar el lenguaje a español 
        "language": { 
            "lengthMenu": "Mostrar _MENU_ registros", 
            "ZeroRecords": "No se encontraron resultados", 
            "info": "Mostrando registros del _START_ al _END_ de un _TOTAL_ registros", 
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros", 
            "infoFiltered": "(Filtrando un total de _MAX_ registros)", 
            "sSearch": "Buscar", 
            "oPaginate": { "sFirst": "Primero", "sLast": "Ultimo", "sNext": "Siguiente", "sPrevious": "Anterior" }, 
            "sProcessing": "Procesando...", }
        }
        ).columns.adjust() 
        .responsive.recalc(); 
    });