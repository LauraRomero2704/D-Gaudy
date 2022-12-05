/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import JavaMail.ParametrosCorreo;
import Modelo.ClienteDAO;
import Modelo.ClienteVO;
import Modelo.EmpleadoDAO;
import Modelo.EmpleadoVO;
import Modelo.RolDAO;
import Modelo.RolVO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Yuliana
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/Usuario"})
public class UsuarioController extends HttpServlet {

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
        String ide_u = request.getParameter("txtide_usu");
        String ide_rol = request.getParameter("txtide_rol");
        String nom_usu = request.getParameter("txtnom_usu");
        String cont_usu = request.getParameter("txtcont_usu");
        String estado_usu = request.getParameter("txtestado_usu");

        int opcion = Integer.parseInt(request.getParameter("opcion"));
       
        int ide_usu = 0;
        if(ide_u!= null){
        ide_usu = Integer.parseInt(ide_u); 
        }
       
        ClienteVO cl = new ClienteVO();
        ClienteDAO cldao = new ClienteDAO();
        String logueo = "Iniciar Sesion";
        String correo = "Iniciar Sesion";
        
        // Instanciar Clase VO
        UsuarioVO usuvo = new UsuarioVO();
        UsuarioVO usuVO = new UsuarioVO(ide_usu, ide_rol, nom_usu, cont_usu, estado_usu);

        // Instanciar Clase DAO
        UsuarioDAO usudao = new UsuarioDAO();
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        String host;
        String puerto;
        String usuarioCorreo;
        String password;

        //Administrar operaciones
        switch (opcion) {
            case 1: // Agregar Registro de Cliente
                if (usuDAO.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se registro correctamente");

                    //Enviar correo de registro
                    ServletContext context = getServletContext();

                    host = context.getInitParameter("host");
                    puerto = context.getInitParameter("puerto");
                    usuarioCorreo = context.getInitParameter("usuarioCorreo");
                    password = context.getInitParameter("password");

                    String receptor = request.getParameter("txtnom_usu");
                    String asunto = "¡BIENVENIDO A D'GAUDY!";
                    String contenido = "\n¡NOS ALEGRA QUE ESTÉS AQUÍ! \n\nTe damos la bienvenida a D'GAUDY \nTienes a tus pies el mundo de los diseños con efecto sorpresa. Completamente gratis y sin compromiso. \n \n"
                                     + "Recuerda que estamos a tu disposición\n \n"
                                     + "Sus datos para ingresar en su cuenta son: \n"
                                     + "Usuario: " + request.getParameter("txtnom_usu") + "\n"
                                     + "Contraseña: " + request.getParameter("txtcont_usu") + "\n \n"
                                     + "Saludos cordialmente \nTu equipo D'GAUDY";
                    String resultadoMensaje = "";
                    try {
                        ParametrosCorreo.envioCorreo(host, puerto, usuarioCorreo, password, receptor, asunto, contenido);
                        resultadoMensaje = "El mensaje se envio de forma correcta";
                    } catch (Exception e) {

                        e.printStackTrace();
                        resultadoMensaje = "Error al enviar el mensaje " + e.getMessage();
                    } finally {

                        request.setAttribute("mensaje", resultadoMensaje);
                        getServletContext().getRequestDispatcher("/resultado.jsp");
                    }

                } else {
                    request.setAttribute("mensajeError", "El usuario no se registro");
                }
                request.getRequestDispatcher("principal.jsp").forward(request, response);
                break;

            case 2: //Actualizar Registro
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO se actualizo correctamente");
                }
                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                break;

            case 3://Inactivar Usuario
                String inactivar = request.getParameter("txtestado_usu");
                if (inactivar.equals("Inactivo")) {
                    if (usuDAO.activarRegistro()) {
                        request.setAttribute("mensajeDisponible", "el usuario se activo");
                    } else {
                        request.setAttribute("mensajeEDisponible", "error, el usuario esta inactivado");
                    }

                } else {
                    if (usuDAO.inactivarRegistro()) {
                        request.setAttribute("mensajeAgotar", "el usuario esta inactivado");
                    } else {
                        request.setAttribute("mensajeEAgotar", "error, el usuario esta activado");
                    }
                }
                request.getRequestDispatcher("admGestion_Usu.jsp").forward(request, response);
                break;
                
            case 4: //Admi ingresa Registros
                if (usuDAO.agregarRegistroEmpl()) {

                    request.setAttribute("mensajeRegistro", "El empleado se registro correctamente");

                    //Enviar correo de registro
                    ServletContext context = getServletContext();

                    host = context.getInitParameter("host");
                    puerto = context.getInitParameter("puerto");
                    usuarioCorreo = context.getInitParameter("usuarioCorreo");
                    password = context.getInitParameter("password");

                    String receptor = request.getParameter("txtcorr_usu");
                    String asunto = "Correo de Registro";
                    String contenido = "¡BIENVENIDO A D'GAUDY! Ahora eres un colaborador de nuestra pagina \n \n"
                            + "Su usuario y contraseña son: \n"
                            + "Usuario: " + request.getParameter("txtnom_usu") + "\n"
                            + "Contraseña: " + request.getParameter("txtcont_usu") + "\n \n";
                    String resultadoMensaje = "";
                    try {
                        ParametrosCorreo.envioCorreo(host, puerto, usuarioCorreo, password, receptor, asunto, contenido);
                        resultadoMensaje = "El mensaje se envio de forma correcta";
                    } catch (Exception e) {

                        e.printStackTrace();
                        resultadoMensaje = "Error al enviar el mensaje " + e.getMessage();
                    } finally {

                        request.setAttribute("mensaje", resultadoMensaje);
                        getServletContext().getRequestDispatcher("/resultado.jsp");
                    }
                } else {
                    request.setAttribute("mensajeERegistro", "El empleado NO se registro correctamente");
                }

                request.getRequestDispatcher("admGestion_Usu.jsp").forward(request, response);
                break;

            case 5: //Iniciar sesion 

                if (usuDAO.iniciarSesion(nom_usu, cont_usu)) {

                    HttpSession miSesion = request.getSession(true);
                    usuVO = new UsuarioVO(ide_usu, ide_rol, nom_usu, cont_usu, estado_usu);
                    UsuarioDAO usdao = new UsuarioDAO();
                    UsuarioVO usuo = usdao.consultarUsuarioC(nom_usu);
                    miSesion.setAttribute("datosUsuario", usuo);
                    ClienteDAO clidao = new ClienteDAO();
                    ClienteVO clivo = clidao.consultarClienteCorreo(nom_usu);
                    miSesion.setAttribute("datosCliente", clivo);
                    EmpleadoDAO empdao = new EmpleadoDAO();
                    EmpleadoVO empvo = empdao.consultarEmpleadoC(nom_usu);
                    miSesion.setAttribute("datosEmpleado", empvo);

                    usuVO = new UsuarioVO(ide_usu, ide_rol, nom_usu, cont_usu, estado_usu);

                    //Instanciar metodo rol
                    RolDAO rolDAO = new RolDAO();
                    RolVO rolVO = new RolVO();

                    ArrayList<RolVO> listaRoles = rolDAO.rolTipo(nom_usu);

                    for (int i = 0; i < listaRoles.size(); i++) {
                        rolVO = listaRoles.get(i);
                    }

                    String roltipo = rolVO.getNom_rol();

                    if (roltipo.equals("Administrador")) {
                        request.getRequestDispatcher("admGestion.jsp").forward(request, response);
                    } else if (roltipo.equals("Gerente de Prendas")) {
                        request.getRequestDispatcher("gerPrendas.jsp").forward(request, response);
                    } else if (roltipo.equals("Gerente de Pedidos")) {
                        request.getRequestDispatcher("gerPedidos.jsp").forward(request, response);
                   
                    } else {
                        request.getRequestDispatcher("principal.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mensajeError", "Los datos de ingreso son incorrectos, vuelve a intentarlo");
                    request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
                }

                break;
                
                case 6: //Actualizar contraseña

                if (usuDAO.actualizarContra()) {
                    request.setAttribute("mensajeActualizar", "El usuario se actualizo correctamente");
                } else {
                    request.setAttribute("mensajeEActualizar", "El usuario NO se actualizo correctamente");
                }
                request.getRequestDispatcher("admGestion.jsp").forward(request, response);
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

        int ide_usu = Integer.parseInt(request.getParameter("txtide_usu"));

        UsuarioVO usuVO = new UsuarioVO(ide_usu);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);

        String inactivar = request.getParameter("txtestado_usu");
        if (!inactivar.equals("Inactivo")) {
            if (usuDAO.activarRegistro()) {
                request.setAttribute("mensajeDisponible", "el usuario se activo");
            } else {
                request.setAttribute("mensajeEDisponible", "error, el usuario esta inactivado");
            }

        } else {
            if (usuDAO.inactivarRegistro()) {
                request.setAttribute("mensajeAgotar", "el usuario esta inactivado");
            } else {
                request.setAttribute("mensajeEAgotar", "error, el usuario esta activado");
            }
        }
        request.getRequestDispatcher("admGestion_Usu.jsp").forward(request, response);

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
