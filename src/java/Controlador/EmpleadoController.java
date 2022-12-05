/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EmpleadoDAO;
import Modelo.EmpleadoVO;
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
@WebServlet(name = "EmpleadoController", urlPatterns = {"/Empleado"})
public class EmpleadoController extends HttpServlet {

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

        //recibir datos de las vistas 
        String ide_em = request.getParameter("txtIde_emp");
        String ide_usu = request.getParameter("txtIde_usu");
        String doc_em = request.getParameter("txtDoc_emp");
        String prof_emp = request.getParameter("txtProf_emp");
        String nom_emp = request.getParameter("txtNom_emp");
        String ape_emp = request.getParameter("txtApe_emp");
        String perfil_emp = request.getParameter("txtPerfil_emp");
        String fecha_nac = request.getParameter("txtFecha_emp");
        String ciudad_emp = request.getParameter("txtCiu_emp");
        String dir_emp = request.getParameter("txtDir_emp");
        String corr_emp = request.getParameter("txtCorr_emp");
        String tel_emp = request.getParameter("txtTel_emp");
        String estado_emp = request.getParameter("txtEstado_emp");

        int opcion = Integer.parseInt(request.getParameter("opcion"));

        int ide_emp = 0;
        if(ide_em!= null) {
            ide_emp = Integer.parseInt(ide_em);
        }
        
        int doc_emp = 0;
        if(doc_em!= null) {
            doc_emp = Integer.parseInt(doc_em);
        }
        //Instanciar clase VO
        EmpleadoVO empvo = new EmpleadoVO();
        EmpleadoVO empVO = new EmpleadoVO(ide_emp, ide_usu, prof_emp, doc_emp, nom_emp, ape_emp, perfil_emp, fecha_nac, ciudad_emp, dir_emp, corr_emp, tel_emp, estado_emp);

        //Instanciar clase DAO
        EmpleadoDAO empdao = new EmpleadoDAO();
        EmpleadoDAO empDAO = new EmpleadoDAO(empVO);

        //Administrar operaciones
        switch (opcion) {

            case 1: //Consultar registro

                empVO = empDAO.consultarEmpleado(ide_emp);

                if (empVO != null) {

                    request.setAttribute("EmpleadoConsultado", empVO);
                    request.getRequestDispatcher("actualizarEmpleado.jsp").forward(request, response);

                } else {
                    request.setAttribute("mensajeError", "El Empleado NO existe!");
                    request.getRequestDispatcher("admGestion_Emp.jsp").forward(request, response);

                }
                break;

            case 2: //Actualizar Registro

                if (empDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("admGestion.jsp").forward(request, response);
                break;

            case 3: //ingresa Registros
                if (empDAO.agregarRegistro()) {

                    request.setAttribute("mensajeRegistro", "El Empleado se registro correctamente");
                } else {
                    request.setAttribute("mensajeERegistro", "El Empleado NO se registro correctamente");
                }

                request.getRequestDispatcher("admGestion_Emp.jsp").forward(request, response);
                break;

            case 4:
                String inactivar = request.getParameter("txtEstado_emp");
                if (inactivar.equals("Inactivo")) {
                    if (empDAO.ActivarRegistro()) {
                        request.setAttribute("mensajeDisponible", "El empleado se activo");
                    } else {
                        request.setAttribute("mensajeEDisponible", "error, El empleado esta inactivado");
                    }

                } else {
                    if (empDAO.inactivarRegistro()) {
                        request.setAttribute("mensajeAgotar", "El empleado esta inactivado");
                    } else {
                        request.setAttribute("mensajeEAgotar", "error, El empleado esta activado");
                    }
                }
                request.getRequestDispatcher("admGestion_Emp.jsp").forward(request, response);
                break;
                        
             case 5: //Actualizar Perfil

                if (empDAO.actualizarPerfil()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("admGestion.jsp").forward(request, response);
                break; 
             
             case 6: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarPerfil2()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("admGestion.jsp").forward(request, response);
                break;    
                
            case 7: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("gerPrendas.jsp").forward(request, response);
                break; 
                
            case 8: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarPerfil()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("gerPrendas.jsp").forward(request, response);
                break; 
                
                
             case 9: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("gerPrendas.jsp").forward(request, response);
                break;  
                
            case 10: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("gerPedidos.jsp").forward(request, response);
                break; 
                
            case 11: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarPerfil()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("gerPedidos.jsp").forward(request, response);
                break; 
                
            case 12: //Actualizar Direccion, ciudad y telefono de perfil

                if (empDAO.actualizarPerfil2()) {
                    request.setAttribute("mensajeActualizar", "El Empleado se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El Empleado NO se actualizo correctamente");
                }
                request.getRequestDispatcher("gerPedidos.jsp").forward(request, response);
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
        int ide_emp = Integer.parseInt(request.getParameter("txtIde_emp"));

        EmpleadoVO empVO = new EmpleadoVO(ide_emp);
        EmpleadoDAO empDAO = new EmpleadoDAO(empVO);

        String inactivar = request.getParameter("txtEstado_emp");
        if (!inactivar.equals("Inactivo")) {
            if (empDAO.ActivarRegistro()) {
                request.setAttribute("mensajeDisponible", "El empleado se activo");
            } else {
                request.setAttribute("mensajeEDisponible", "error, El empleado esta inactivado");
            }

        } else {
            if (empDAO.inactivarRegistro()) {
                request.setAttribute("mensajeAgotar", "El empleado esta inactivado");
            } else {
                request.setAttribute("mensajeEAgotar", "error, El empleado esta activado");
            }
        }
        request.getRequestDispatcher("admGestion_Emp.jsp").forward(request, response);
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
