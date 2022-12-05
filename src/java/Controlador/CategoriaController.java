/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.CategoriaDAO;
import Modelo.CategoriaVO;
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
@WebServlet(name = "CategoriaController", urlPatterns = {"/Categoria"})
public class CategoriaController extends HttpServlet {

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
        String ide_cat = request.getParameter("txtIde_cat");
        String nom_cat = request.getParameter("txtNom_cat");
        String estado_cat = request.getParameter("txtEstado_cat");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
    
        int idecat = 0;
        if(ide_cat!= null){
        idecat = Integer.parseInt(ide_cat); 
        }
        
        // Se instancia la clase VO (El VO tiene los datos de forma segura)
        CategoriaVO catVO = new CategoriaVO();
        catVO = new CategoriaVO(idecat, nom_cat, estado_cat);
        
        // Se instancia la clase DAO (El DAO tiene las operaciones)
        CategoriaDAO catDAO = new CategoriaDAO();
        catDAO = new CategoriaDAO(catVO);
    
        // Administrar Operaciones
        switch (opcion)
        {
            case 1: // Agregar Registro de Categoria
                
                if (catDAO.agregarRegistro()) 
                {
                    request.setAttribute("mensajeRegistro", "La categoria se registro correctamente");
                }
                
                else 
                {
                    request.setAttribute("mensajeERegistro", "La categoria no se registro");
                }
                
                
                request.getRequestDispatcher("gerPrendas_Cat.jsp").forward(request, response);
            
            break; 
            
            case 2: // Actualizar Registro de Prenda
                
                if (catDAO.actualizarRegistro()) 
                {
                    request.setAttribute("mensajeActualizar", "La prenda se actualizo correctamente");
                }
                
                else
                {
                    request.setAttribute("mensajeEActualizar", "La categoria no se actualizo correspondiente");
                }
                
                request.getRequestDispatcher("gerPrendas_Cat.jsp").forward(request, response);
            
            break;
                
             case 3:
               String inactivar = request.getParameter("txtEstado_cat");
           
                if (inactivar.equals("Agotada")) {
                    if (catDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La categoria esta disponible");
                    }else{
                        request.setAttribute("mensajeError", "Error, el estado de pedido no se actualizo");
                    }
                    
                }else{
                    if (catDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La categoria esta agotada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de pedido no se actualizo");
                    }
                }
             request.getRequestDispatcher("gerPrendas_Cat.jsp").forward(request, response); 
             break;

        
            case 4: // Consultar Registro de Prenda
                
                catVO = catDAO.consultarCategoria(idecat);
                
                if (catVO != null) {
                    
                    System.out.println("Consulto la categoria");
                    request.setAttribute("categoriaConsultada", catVO);
                    request.getRequestDispatcher("gerPrendas_Cat.jsp").forward(request, response);
                    System.out.println("Se redirecciono");
                   

                } else {
                    System.out.println("Ocurrio un error al consultar la categoria");
                    request.setAttribute("mensajeError", "La categoria NO existe!");
                    request.getRequestDispatcher("gerPrendas_Cat.jsp").forward(request, response);
              
            
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
        int idecat = Integer.parseInt(request.getParameter("txtIde_cat"));
        CategoriaVO catVO = new CategoriaVO(idecat);
        CategoriaDAO catDAO = new CategoriaDAO(catVO);
        String inactivar = request.getParameter("txtEstado_cat");
                if (!inactivar.equals("Agotada")) {
                    if (catDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La categoria esta disponible");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el estado de pedido no se actualizo");
                    }
                    
                }else{
                    if (catDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La categoria esta agotado");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de pedido no se actualizo");
                    }
                }
             request.getRequestDispatcher("gerPrendas_Cat.jsp").forward(request, response);   
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
