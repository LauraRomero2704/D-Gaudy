package Controlador;

import Modelo.PedidoDAO;
import Modelo.PedidoVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Laura
 */
@WebServlet(name = "PedidoController", urlPatterns = {"/Pedido"})

public class PedidoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Recibe Datos de las Vistas
        String id_ped = request.getParameter("txtIde_ped");
        String id_cli = request.getParameter("txtIde_cli");
        String talla_prendas = request.getParameter("txtTallaPrenda_ped");
        String fecha_ped = request.getParameter("txtFecha_ped");
        String medioPago_ped = request.getParameter("txtMedioPago_ped");
        String dir_ped = request.getParameter("txtDir_ped");
        String subTotal = request.getParameter("txtSubTotal_ped");
        String descuento = request.getParameter("txtDescuento_ped");
        String tot_ped = request.getParameter("txtTotal_ped");
        String estado_ped = request.getParameter("txtEstado_ped");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        int ide_ped = 0;
        if(id_ped!= null) {
            ide_ped = Integer.parseInt(id_ped);
        }

        int ide_cli = 0;
        if(id_cli!= null) {
            ide_cli = Integer.parseInt(id_cli);
        }

        int tallaPrenda_ped = 0;
        if(talla_prendas!= null) {
            tallaPrenda_ped = Integer.parseInt(talla_prendas);
        }
        
        double total_ped = 0.0;
        if(tot_ped!= null){
        total_ped = Double.parseDouble(tot_ped); 
        }
        
        double subTotal_ped = 0.0;
        if(subTotal!= null){
        subTotal_ped = Double.parseDouble(subTotal); 
        }

        double descuento_ped = 0.0;
        if(descuento!= null){
        descuento_ped = Double.parseDouble(descuento); 
        } 
        
        // Se instancia la clase VO (El VO tiene los datos de forma segura)
        PedidoVO pedvo = new PedidoVO();
        PedidoVO pedVO = new PedidoVO(ide_ped, ide_cli, tallaPrenda_ped, fecha_ped, medioPago_ped, dir_ped, subTotal_ped, descuento_ped, total_ped, estado_ped);

        // Se instancia la clase DAO (El DAO tiene las operaciones)
        PedidoDAO peddao = new PedidoDAO();
        PedidoDAO pedDAO = new PedidoDAO(pedVO);

        // Administrar Operaciones
        switch (opcion) {

            case 1:
                String inactivar = request.getParameter("txtEstado_ped");
                if (inactivar.equals("Pendiente")) {
                    if (pedDAO.ActivarRegistro()) {
                        request.setAttribute("mensajeDisponible", "El pedido se entrego");
                    } else {
                        request.setAttribute("mensajeEDisponible", "Error, el estado de pedido no se actualizo");
                    }

                } else {
                    if (pedDAO.inactivarRegistro()) {
                        request.setAttribute("mensajeAgotar", "El pedido esta pendiente por entrega");
                    } else {
                        request.setAttribute("mensajeEAgotar", "Error, el estado de pedido no se actualizo");
                    }
                }
                request.getRequestDispatcher("gerPedidos_P.jsp").forward(request, response);
                break;

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ide_ped = Integer.parseInt(request.getParameter("txtIde_ped"));
        PedidoVO pedVO = new PedidoVO(ide_ped);
        PedidoDAO pedDAO = new PedidoDAO(pedVO);
        String inactivar = request.getParameter("txtEstado_ped");
        if (!inactivar.equals("Pendiente")) {
            if (pedDAO.ActivarRegistro()) {
                request.setAttribute("mensajeDisponible", "El pedido se entrego");
            } else {
                request.setAttribute("mensajeEDisponible", "Error, el estado de pedido no se actualizo");
            }

        } else {
            if (pedDAO.inactivarRegistro()) {
                request.setAttribute("mensajeAgotar", "El pedido esta pendiente por entrega");
            } else {
                request.setAttribute("mensajeEAgotar", "Error, el estado de pedido no se actualizo");
            }
        }
        request.getRequestDispatcher("gerPedidos_P.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
