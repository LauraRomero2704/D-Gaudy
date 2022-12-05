<%-- 
    Document   : alerta
    Created on : 9/10/2022, 03:24:59 PM
    Author     : Juan Romero, Laura Romero y Yuliana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src= " https://unpkg.com/sweetalert/dist/sweetalert.min.js " ></script> 
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

        <title>Alerta</title>
    </head>
    <body>


        <script>

            function confirmar(ide_tipo) {

                Swal.fire({
                    title: '¿Estas seguro de agotar esta tipografia: ' + ide_tipo + '?',

                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'

                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Tipografia?txtIde_tipo=" + ide_tipo + "&txtEstado_tipo=Agotado";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se inactivo', '', 'info');
                    }
                });

            }
            ;

        </script>



        <script>

            function confirmarCategoria(idecat) {

                Swal.fire({
                    title: '¿Estas seguro de agotar esta categoria: ' + idecat + '?',
                    icon: 'warning',
                    iconColor: '#F66060',         
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Categoria?txtIde_cat=" + idecat + "&txtEstado_cat=Agotada";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se inactivo', '', 'info');
                    }
                });

            }
            ;

        </script>


        <script>

            function confirmarPrenda(idepren) {

                Swal.fire({
                    title: '¿Estas seguro de agotar esta prenda: ' + idepren + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Prenda?txtIde_pren=" + idepren + "&txtEstado_pren=Agotada";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se inactivo', '', 'info');
                    }
                });

            }
            ;

        </script>

        <script>

            function confirmarPedido(ideped) {

                Swal.fire({
                    title: '¿Estas seguro de dejar pendiente este pedido: ' + ideped + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Pedido?txtIde_ped=" + ideped + "&txtEstado_ped=Pendiente";

                        Swal.fire('El pedido esta pendiente por entrega', '', 'success');

                    } else if (result.isDenied) {
                        Swal.fire('El estado de pedido no se actualizo', '', 'info');
                    }
                });

            }
            ;

        </script>

        <script>

            function confirmarComprobante(ide_comp) {

                Swal.fire({
                    title: '¿Estas seguro de entregar este comprobante de pedido?: ' + ide_comp + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Comprobante?txtIde_comp=" + ide_comp + "&txtEstado_comp=Pendiente";

                        Swal.fire('El pedido esta pendiente por entrega', '', 'success');

                    } else if (result.isDenied) {
                        Swal.fire('El estado de pedido no se actualizo', '', 'info');
                    }
                });

            }
            ;

        </script>


        <script>

            function confirmarUsuario(ide_usu) {

                Swal.fire({
                    title: '¿Estas seguro de inactivar este registro: ' + ide_usu + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Usuario?txtide_usu=" + ide_usu + "&txtestado_usu=Inactivo";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se inactivo', '', 'info');
                    }
                });

            }
            ;

        </script>
        
        <script>

            function confirmarCliente(ide_cli) {

                Swal.fire({
                    title: '¿Estas seguro de inactivar este registro: ' + ide_cli + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Cliente?txtid=" + ide_cli + "&txtestado=Inactivo";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se inactivo', '', 'info');
                    }
                });

            }
            ;

        </script>

        <script>

            function confirmarEmpleado(ide_emp) {

                Swal.fire({
                    title: '¿Estas seguro de inactivar el registro: ' + ide_emp + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Empleado?txtIde_emp=" + ide_emp + "&txtEstado_emp=Inactivo";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se inactivo', '', 'info');
                    }
                });

            }
            ;

        </script>


        <script>

            function confirmarCalcomania(ide_calc) {

                Swal.fire({
                    title: '¿Estas seguro de agotar esta calcomania: ' + ide_calc + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Calcomania?txtIde_calc=" + ide_calc + "&txtEstado_calc=Agotada";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se a Agotada', '', 'info');
                    }
                });

            }
            ;

        </script>
        
         <script>

            function confirmarReporte(ide_rept) {

                Swal.fire({
                    title: '¿Estas seguro de archivar este reporte: ' + ide_rept + '?',
                    icon: 'warning',
                    iconColor: '#F66060',
                    showCancelButton: true,
                    confirmButtonColor: '#0DCECE',
                    cancelButtonColor: '#ff013cc2',
                    confirmButtonText: 'Confirmar'
                }).then((result) => {
                    if (result.isConfirmed) {

                        parent.location.href = "Reporte?txtIde_rept=" + ide_rept + "&txtEstado_rept=Archivado";

                    } else if (result.isDenied) {
                        Swal.fire('El registro no se archivo', '', 'info');
                    }
                });

            }
            ;

        </script>


    </body>
</html>


