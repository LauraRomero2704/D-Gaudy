/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PersonalizaDAO;
import Modelo.PersonalizaVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Janus
 */
@WebServlet(name = "PersonalizaController", urlPatterns = {"/Personaliza"})
public class PersonalizaController extends HttpServlet {

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
        String ide_per = request.getParameter("txtIde_pers");
        String ide_cl = request.getParameter("txtIde_cli");
        String ide_pre = request.getParameter("txtIde_pren");
        String ide_cal = request.getParameter("txtIde_calc");      
        String nom_pers = request.getParameter("txtNom_pers");
        String urlDiseño_pers = request.getParameter("txtUrlDiseño_pers");
        String precio_p = request.getParameter("txtPrecio_pers");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));

        int ide_pers = 0;
        if(ide_per!= null){
        ide_pers = Integer.parseInt(ide_per); 
        }
        
        int ide_pren = 0;
        if(ide_pre!= null){
        ide_pren = Integer.parseInt(ide_pre); 
        }
        
        int ide_calc = 0;
        if(ide_cal!= null){
        ide_calc = Integer.parseInt(ide_cal); 
        }
        
        int ide_cli = 0;
        if(ide_cl!= null){
        ide_cli = Integer.parseInt(ide_cl); 
        }
        
        double precio_pers = 0.0;
        if(precio_p!= null){
        precio_pers = Double.parseDouble(precio_p); 
        } 
        
         // Se instancia la clase VO (El VO tiene los datos de forma segura)
        PersonalizaVO perVO = new PersonalizaVO();
        perVO = new PersonalizaVO(ide_pers, ide_cli, ide_pren, ide_calc, nom_pers, urlDiseño_pers, precio_pers);

        // Se instancia la clase DAO (El DAO tiene las operaciones)
        PersonalizaDAO perDAO = new PersonalizaDAO();
        perDAO = new PersonalizaDAO(perVO);
           // Administrar Operaciones
        switch (opcion) {
           
             case 1:
               String inactivar = request.getParameter("txtEstado_pers");
                if (inactivar.equals("Publica")) {
                    if (perDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La personalizacion se puso publica");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error");
                    }
                    
                }else{
                    if (perDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La personalizacion se puso privada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error");
                    }
                }
             request.getRequestDispatcher("gerPrendas_Per.jsp").forward(request, response);   
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
        int ide_pers = Integer.parseInt(request.getParameter("txtIde_pers"));
        PersonalizaVO perVO = new PersonalizaVO(ide_pers);
        PersonalizaDAO perDAO = new  PersonalizaDAO(perVO);
        String inactivar = request.getParameter("txtEstado_pers");
                if (!inactivar.equals("Publica")) {
                    if (perDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La personalizacion se puso publica");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error");
                    }
                    
                }else{
                    if (perDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La personalizacion se puso privada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error");
                    }
                }
             request.getRequestDispatcher("gerPrendas_Per.jsp").forward(request, response);  
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
