/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CalcomaniaDAO;
import Modelo.CalcomaniaVO;
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
@WebServlet(name = "CalcomaniaController", urlPatterns = {"/Calcomania"})
public class CalcomaniaController extends HttpServlet {

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
        String ide_c = request.getParameter("txtIde_calc");
        String nom_calc = request.getParameter("txtNom_calc");
        String url_calc = request.getParameter("txtUrl_calc");
        String estado_calc = request.getParameter("txtEstado_calc");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        int ide_calc = 0;
        if (ide_c != null) {
            ide_calc = Integer.parseInt(ide_c);
        }
        
        //Instanciar clase VO
        CalcomaniaVO calvo = new CalcomaniaVO();
        CalcomaniaVO calVO = new CalcomaniaVO(ide_calc, nom_calc, url_calc, estado_calc);

        //Instanciar clase DAO
        CalcomaniaDAO caldao = new CalcomaniaDAO();
        CalcomaniaDAO calDAO = new CalcomaniaDAO(calVO);

        //Administrar operaciones
        switch (opcion) {

            case 1: //Registrar calcomania

                if (calDAO.agregarRegistro()) {

                    request.setAttribute("mensajeRegistro", "La calcomania se registro correctamente");
                } else {
                    request.setAttribute("mensajeERegistro", "La calcomania NO se registro correctamente");
                }

                request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro

                if (calDAO.actualizarRegistro()) {

                    request.setAttribute("mensajeActualizar", "La calcomania se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "La calcomania NO se actualizo correctamente");
                }

                request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);
                break;

            case 3: //Inactivar - Activar
                String inactivar = request.getParameter("txtEstado_calc");
                if (inactivar.equals("Agotada")) {
                    if (calDAO.ActivarRegistro()) {
                        request.setAttribute("mensajeDisponible", "La calcomania se activo");
                    } else {
                        request.setAttribute("mensajeEDisponible", "error, La calcomania esta inactivado");
                    }

                } else {
                    if (calDAO.inactivarRegistro()) {
                        request.setAttribute("mensajeAgotar", "La calcomania esta inactivado");
                    } else {
                        request.setAttribute("mensajeEAgotar", "error, La calcomania esta activado");
                    }
                }
                request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);
                break;

            case 4: //Consultra registro
                calVO = calDAO.consultarCalcomanias(ide_calc);

                if (calVO != null) {

                    System.out.println("Consulto la calcomanias");
                    request.setAttribute("CalcomaniaConsultada", calVO);
                    request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);
                    System.out.println("Se redirecciono");

                } else {
                    request.setAttribute("mensajeError", "La calcomania NO existe!");
                    request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);

                }
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

        int ide_calc = Integer.parseInt(request.getParameter("txtIde_calc"));

        CalcomaniaVO calVO = new CalcomaniaVO(ide_calc);
        CalcomaniaDAO calDAO = new CalcomaniaDAO(calVO);

        String inactivar = request.getParameter("txtEstado_calc");
        if (!inactivar.equals("Agotada")) {
            if (calDAO.ActivarRegistro()) {
                request.setAttribute("mensajeDisponible", "La calcomania se activo");
            } else {
                request.setAttribute("mensajeEDisponible", "error, La calcomania esta inactivado");
            }

        } else {
            if (calDAO.inactivarRegistro()) {
                request.setAttribute("mensajeAgotar", "La calcomania esta inactivado");
            } else {
                request.setAttribute("mensajeEAgotar", "error, La calcomania esta activado");
            }
        }
        request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);
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
