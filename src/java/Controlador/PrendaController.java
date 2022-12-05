package Controlador;

import Modelo.PrendaDAO;
import Modelo.PrendaVO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author Laura
 */

@WebServlet(name = "PrendaController", urlPatterns = {"/Prenda"})

public class PrendaController extends HttpServlet
{
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
              throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        // Recibe Datos de las Vistas
        String ide_p = request.getParameter("txtIde_pren");
        String ide_cat = request.getParameter("txtIde_cat");
        String nom_pren = request.getParameter("txtNom_pren");
        String descrip_pren = request.getParameter("txtDescrip_pren");
        String img_pren = request.getParameter("txtUrl_pren");
        String color_pren = request.getParameter("txtColor_pren");
        String talla = request.getParameter("txtTalla_pren");
        String stock = request.getParameter("txtStock_pren");
        String precio = request.getParameter("txtPrecio_pren");
        String estado_pren = request.getParameter("txtEstado_pren");
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        
        double precio_pren = 0.0;
        if(precio!= null){
        precio_pren = Double.parseDouble(precio); 
        } 
        
        int ide_pren = 0;
        if(ide_p!= null){
        ide_pren = Integer.parseInt(ide_p); 
        } 
        
        int talla_pren = 0;
        if(talla!= null){
        talla_pren = Integer.parseInt(talla); 
        }
        
        int stock_pren = 0;
        if(stock!= null){
        stock_pren = Integer.parseInt(stock); 
        }
        
        // Se instancia la clase VO (El VO tiene los datos de forma segura)
        PrendaVO prenvo = new PrendaVO();
        PrendaVO  prenVO= new PrendaVO(ide_pren, ide_cat, nom_pren, descrip_pren, img_pren, color_pren, talla_pren, stock_pren, precio_pren, estado_pren);
        
        // Se instancia la clase DAO (El DAO tiene las operaciones)
        PrendaDAO prendao = new PrendaDAO();
        PrendaDAO prenDAO = new PrendaDAO(prenVO);

        
        // Administrar Operaciones
        switch (opcion)
        {
            case 1: // Agregar Registro de Prenda
                
                if (prenDAO.agregarRegistro()) 
                {
                    request.setAttribute("mensajeRegistro", "La prenda se registro correctamente");
                }
                
                else 
                {
                    request.setAttribute("mensajeERegistro", "La prenda no se registro");
                }
                
                 request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);
                
            
            break;
            
            case 2: // Actualizar Registro de Prenda
                
                if (prenDAO.actualizarRegistro())
                {
                    request.setAttribute("mensajeActualizar", "La prenda se actualizo correctamente");
                }
                
                else 
                {
                    request.setAttribute("mensajeEActualizar", "La prenda no se actualizo");
                }
                
                request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);
            
            break; 
            
            case 3: // Inactivar Registro de Prenda
               String inactivar = request.getParameter("txtEstado_pren");
                if (inactivar.equals("Agotada")) {
                    if (prenDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La prenda esta disponible");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el estado de prenda no se actualizo");
                    }
                    
                }else{
                    if (prenDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La prenda esta agotada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de prenda no se actualizo");
                    }
                }
             request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);   
             break;

            
            case 4: // Consultar Registro de Prenda
                
                prenVO = prenDAO.consultarRegistro(ide_pren);
                
                if (prenVO != null) {
                    
                    System.out.println("Consulto la prenda");
                    request.setAttribute("prendaConsultada", prenVO);
                    request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);
                    System.out.println("Se redirecciono");
                    

                } else {
                    System.out.println("Ocurrio un error al consultar la prenda");
                    request.setAttribute("mensajeEAgotar", "La prenda NO existe!");
                    request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);
                          
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
        int ide_pren = Integer.parseInt(request.getParameter("txtIde_pren"));
        PrendaVO prenVO = new PrendaVO(ide_pren);
        PrendaDAO prenDAO = new PrendaDAO(prenVO);
        String inactivar = request.getParameter("txtEstado_pren");
                if (!inactivar.equals("Agotada")) {
                    if (prenDAO.ActivarRegistro()){
                     request.setAttribute("mensajeDisponible", "La prenda esta disponible");
                    }else{
                        request.setAttribute("mensajeEDisponible", "Error, el estado de prenda no se actualizo");
                    }
                    
                }else{
                    if (prenDAO.inactivarRegistro()) {
                    request.setAttribute("mensajeAgotar", "La prenda esta agotada");
                    }else{
                        request.setAttribute("mensajeEAgotar", "Error, el estado de prenda no se actualizo");
                    }
                }
             request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);   
        }
    
    
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
