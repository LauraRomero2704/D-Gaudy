/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CalcomaniaVO;
import Modelo.ClienteVO;
import Modelo.ImagenDAO;
import Modelo.PersonalizaVO;
import Modelo.PrendaDAO;
import Modelo.PrendaVO;
import Modelo.ReporteVO;
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
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Janus
 */
@WebServlet(name = "ImagenController", urlPatterns = {"/Imagen"})
public class ImagenController extends HttpServlet {

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
        String accion = request.getParameter("accion");
        PrendaVO p = new PrendaVO();
        PersonalizaVO pevo = new PersonalizaVO();
        ReporteVO rep = new ReporteVO();
        
        ImagenDAO idao = new ImagenDAO();
        CalcomaniaVO cal = new CalcomaniaVO();
        
        switch (accion) {
            case "Guardar": //Hace el registro de prenda y guarda las imagenes dentro de una carpeta vacia
                ArrayList<String> lista = new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File f = new File("C:\\xampp\\htdocs\\imagenes\\" + fileItem.getName());
                            fileItem.write(f);
                            p.setUrl_pren("http://localhost/imagenes/"+fileItem.getName());
                            request.setAttribute("mensajeRegistro", "La prenda se registro correctamente");
                        } else {
                            lista.add(fileItem.getString());
                            request.setAttribute("mensajeERegistro", "La prenda no se registro");
                        }
                    }
                    p.setIde_cat(lista.get(0));
                    p.setNom_pren(lista.get(1));
                    p.setDescrip_pren(lista.get(2));
                    p.setColor_pren(lista.get(3));
                    p.setTalla_pren(Integer.parseInt(lista.get(4)));
                    p.setStock_pren(Integer.parseInt(lista.get(5)));
                    p.setPrecio_pren(Double.parseDouble(lista.get(6)));
                    p.setEstado_pren(lista.get(7));
                    idao.agregar(p);
                } catch (Exception e) {
                }
                request.getRequestDispatcher("gerPrendas_P.jsp").forward(request, response);
                break;
                
             case "GuardarCalcomania": //Hace el registro de prenda y guarda las imagenes dentro de una carpeta vacia
                ArrayList<String> listaCalcomania = new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File f = new File("C:\\xampp\\htdocs\\imagenes\\calcomanias\\" + fileItem.getName());
                            fileItem.write(f);
                            cal.setUrl_calc("http://localhost/imagenes/calcomanias/"+fileItem.getName());
                            request.setAttribute("mensajeRegistro", "La calcomania se registro correctamente");
                        } else {
                            listaCalcomania.add(fileItem.getString());
                            request.setAttribute("mensajeERegistro", "La calcomania no se registro");
                        }
                    }
                    
                    cal.setNom_calc(listaCalcomania.get(0));
                    cal.setEstado_calc(listaCalcomania.get(1));
                    idao.agregarCalcomania(cal);
                } catch (Exception e) {
                }
                request.getRequestDispatcher("gerPrendas_C.jsp").forward(request, response);
                break;  
                
            case "GuardarPersonalizar": 
                ArrayList<String> listaPersonaliza = new ArrayList<>();
                PersonalizaVO pervo = new PersonalizaVO();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File f = new File("C:\\xampp\\htdocs\\imagenes\\personaliza\\" + fileItem.getName());
                            fileItem.write(f);
                            pervo.setUrlDiseño_pers("http://localhost/personalizar/"+fileItem.getName());
                            request.setAttribute("mensajeRegistro", "La prenda se registro correctamente");
                        } else {
                            listaPersonaliza.add(fileItem.getString());
                            request.setAttribute("mensajeERegistro", "La prenda no se registro");
                        }
                    }
                    HttpSession miSesion = request.getSession();
                    ClienteVO clivo = (ClienteVO) miSesion.getAttribute("datosCliente");
                    
                    
                    System.out.println("Se acabo");
                    pervo.setIde_pren(Integer.parseInt("1"));
                    pervo.setIde_cli (clivo.getIde_cli());
                    pervo.setIde_calc(Integer.parseInt("1"));
                    pervo.setNom_pers(listaPersonaliza.get(0));
                    pervo.setPrecio_pers(Double.parseDouble("90000"));
                    idao.agregarPersonalizar(pervo);
                } catch (Exception e) {
                    System.out.println("e  error en el controlador = " + e  );
                }
                request.getRequestDispatcher("misPersonalizaciones.jsp").forward(request, response);
                break;    
         
            case "GuardarReporte": //Hace el registro de reportes y guarda los pdf dentro de una carpeta vacia
                ArrayList<String> listaReporte = new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if (!fileItem.isFormField()) {
                            File f = new File("C:\\xampp\\htdocs\\imagenes\\pdf\\" + fileItem.getName());
                            fileItem.write(f);
                            rep.setPdf_rept("http://localhost/imagenes/pdf/"+fileItem.getName());
                            request.setAttribute("mensajeRegistro", "El reporte se registro correctamente");
                        } else {
                            listaReporte.add(fileItem.getString());
                            request.setAttribute("mensajeERegistro", "El reporte no se registro");
                        }
                    }
                    rep.setIde_emp(listaReporte.get(0));
                    rep.setNom_rept(listaReporte.get(1));
                    rep.setCat_rept(listaReporte.get(2));
                    rep.setEstado_rept(listaReporte.get(3));                
                    idao.agregarReporte(rep);
                } catch (Exception e) {
                }
                request.getRequestDispatcher("admGestion_R.jsp").forward(request, response);
                break;
             
                default:
                throw new AssertionError();    
            
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
        processRequest(request, response);
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
