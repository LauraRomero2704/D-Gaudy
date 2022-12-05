/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ClienteDAO;
import Modelo.ClienteVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ClienteController", urlPatterns = {"/Cliente"})
public class ClienteController extends HttpServlet {

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
        
        //Recibir datos de las vistas 
        String ide_c = request.getParameter("txtid");
        String ide_usu = request.getParameter("txtusu");
        String doc_cl = request.getParameter("txtdoc");
        String nom_cli = request.getParameter("txtnom");
        String ape_cli = request.getParameter("txtape");
        String ciu_cli = request.getParameter("txtcui");
        String dir_cli = request.getParameter("txtdir");
        String corr_cli = request.getParameter("txtcorr");
        String tel_cli = request.getParameter("txttel");
        String estado_cli = request.getParameter("txtestado");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        int ide_cli = 0;
        if(ide_c!= null){
        ide_cli = Integer.parseInt(ide_c); 
        }
        
        int doc_cli = 0;
        if(doc_cl!= null){
        doc_cli = Integer.parseInt(doc_cl); 
        }
        
        //Instanciar clase VO
        ClienteVO clivo = new ClienteVO();
        ClienteVO cliVO = new ClienteVO(ide_cli, ide_usu, doc_cli, nom_cli, ape_cli, ciu_cli, dir_cli, corr_cli, tel_cli, estado_cli);
        
        //Instanciar clase DAO
        ClienteDAO clidao = new ClienteDAO();
        ClienteDAO cliDAO = new ClienteDAO(cliVO);
        
        
        //Administrar operaciones
        switch (opcion) {

            
            case 1: //Consultar registro

                cliVO = cliDAO.consultarCliente(ide_cli);

                if (cliVO != null) {

                    request.setAttribute("ClienteConsultado", cliVO);
                    request.getRequestDispatcher("actualizarCliente.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "La Cliente NO existe!");
                    request.getRequestDispatcher("admGestion_Cli.jsp").forward(request, response);

                }
                break;

            case 2: //Actualizar Registro

                if (cliDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeExito", "La Cliente se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "La Cliente NO se actualizo correctamente");
                }

                request.getRequestDispatcher("admGestion_Cli.jsp").forward(request, response);
                break;

            case 3: //Ingresa Registros
                if (cliDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "La Cliente se registro correctamente");
                } else {
                    request.setAttribute("mensajeError", "La Cliente NO se registro correctamente");
                }

                request.getRequestDispatcher("admGestion_Cli.jsp").forward(request, response);
                break;

        
         case 4: //Inactivar o activar registro
               String inactivar = request.getParameter("txtestado");
                if (inactivar.equals("Inactivo")) {
                    if (cliDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "el cliente se activo");
                    }else{
                        request.setAttribute("mensajeEDisponible", "error, el cliente esta inactivado");
                    }
                    
                }else{
                    if (cliDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "el cliente esta inactivado");
                    }else{
                        request.setAttribute("mensajeEAgotar", "error, el cliente esta activado");
                    }
                }
             request.getRequestDispatcher("admGestion_Cli.jsp").forward(request, response);   
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
        int ide_cli = Integer.parseInt(request.getParameter("txtid"));
        ClienteVO cliVO = new ClienteVO(ide_cli);
        ClienteDAO cliDAO = new ClienteDAO(cliVO);
        String inactivar = request.getParameter("txtestado");
        if (!inactivar.equals("Inactivo")) {
            if (cliDAO.ActivarRegistro()) {
                request.setAttribute("mensajeDisponible", "El cliente se activo");
            } else {
                request.setAttribute("mensajeEDisponible", "Error, el estado de cliente no se actualizo");
            }

        } else {
            if (cliDAO.inactivarRegistro()) {
                request.setAttribute("mensajeAgotar", "El cliente esta inactivado");
            } else {
                request.setAttribute("mensajeEAgotar", "Error, el estado de cliente no se actualizo");
            }
        }
        request.getRequestDispatcher("admGestion_Cli.jsp").forward(request, response);
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
