package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import Modelo.EmpleadoDAO;
import Modelo.EmpleadoVO;
import Modelo.RolVO;
import Modelo.UsuarioVO;

public final class admGestion_005fPerfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/sesiones.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Dashboard</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    ");

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-control", "no-cache, no-store,must-revalidate");
        response.setDateHeader("Expires", 0);
    
      out.write("\r\n");
      out.write("    ");

        HttpSession miSesion = (HttpSession)request.getSession();
        String usuario="";
            
        if(miSesion.getAttribute("datosUsuario") == null){
        request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
        }else{
            UsuarioVO usuVO = (UsuarioVO)miSesion.getAttribute("datosUsuario");
            RolVO rolVO = new RolVO();
            usuario = usuVO.getNom_usu();              
        }
    
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("       \r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Perfil </title>\n");
      out.write("        \n");
      out.write("        <!-- ICONO -->\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"IMAGES/icono.png\">\n");
      out.write("\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"CSS/style-dashboard.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/style-datables.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/style_perfil.css\">\n");
      out.write("\n");
      out.write("        <!-- ICONOS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"ICON/style.css\">\n");
      out.write("        <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("\n");
      out.write("        <!-- ANIMACIONES -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css\"/>\n");
      out.write("\n");
      out.write("        <!-- JS -->\n");
      out.write("        <script src=\"JS/jquery-3.2.1.js\"></script>\n");
      out.write("        <script src=\"JS/perfil.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <!-- ASIDE -->\n");
      out.write("        <aside class=\"aside\">\n");
      out.write("          <div class=\"logo\">\n");
      out.write("              <div class=\"nombre_logo\"> <span class=\"D\"> D'</span>GAUDY </div>\n");
      out.write("              <i class='bx bx-menu-alt-right' id=\"btn\" ></i>\n");
      out.write("          </div>\n");
      out.write("          <ul class=\"lista admin\">\n");
      out.write("            <li>\n");
      out.write("              <a href=\"admGestion.jsp\" style=\"margin-left: 15px;\">\n");
      out.write("                <i class=\"icon-suitcase\"></i>\n");
      out.write("                <span class=\"enlaces\">Administrador</span>\n");
      out.write("              </a>\n");
      out.write("              <span class=\"tooltip\">Administrador</span>\n");
      out.write("            </li>\n");
      out.write("          </ul>\n");
      out.write("\n");
      out.write("          <ul class=\"lista tareas\">\n");
      out.write("            <h3 class=\"titulo\"> Tareas </h3>\n");
      out.write("            <li>\n");
      out.write("              <a href=\"admGestion_Cli.jsp\">\n");
      out.write("                <i class=\"icon-basket\" ></i>\n");
      out.write("                <span class=\"enlaces\">Clientes</span>\n");
      out.write("              </a>\n");
      out.write("              <span class=\"tooltip\">Clientes</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("              <a href=\"admGestion_Emp.jsp\">\n");
      out.write("                <i class='bx bx-id-card'></i>\n");
      out.write("                <span class=\"enlaces\">Empleados</span>\n");
      out.write("              </a>\n");
      out.write("              <span class=\"tooltip\">Empleados</span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("              <a href=\"admGestion_R.jsp\">\n");
      out.write("                <i class=\"bx bxs-file-pdf\" ></i>\n");
      out.write("                <span class=\"enlaces otros\">Reportes</span>\n");
      out.write("              </a>\n");
      out.write("              <span class=\"tooltip\">Reportes</span>\n");
      out.write("            </li>\n");
      out.write("           <li>\n");
      out.write("             <a href=\"admGestion_Usu.jsp\">\n");
      out.write("               <i class=\"bx bxs-user\" ></i>\n");
      out.write("               <span class=\"enlaces otros\">Usuarios</span>\n");
      out.write("             </a>\n");
      out.write("             <span class=\"tooltip\">Usuarios</span>\n");
      out.write("           </li>\n");
      out.write("          </ul>\n");
      out.write("            ");
  
                HttpSession miSesion2 = request.getSession();
                UsuarioVO usuvo = (UsuarioVO) miSesion2.getAttribute("datosUsuario");
                EmpleadoVO empvo = (EmpleadoVO) miSesion2.getAttribute("datosEmpleado");
                String rolEs = "Administradora";
            
      out.write("    \n");
      out.write("            \n");
      out.write("          <ul class=\"lista\">\n");
      out.write("              <li class=\"menu\">\n");
      out.write("                    <a href=\"CarritoController?accion=verPerfil&ide_emp=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${datosEmpleado.getIde_emp()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"marcado\">\n");
      out.write("                    <i style=\"margin-left: 30px\" class='bx bxs-magic-wand'></i>\n");
      out.write("                    <span class=\"enlaces\">Perfil</span>\n");
      out.write("               </a>             \n");
      out.write("               <span class=\"tooltip\">Perfil</span>\n");
      out.write("             </li>\n");
      out.write("           <li class=\"perfil\">\n");
      out.write("              <div class=\"detalles_perfil\">\n");
      out.write("                 <img src=\"IMAGES/modelo.png\" alt=\"perfilImg\">\n");
      out.write("                 <div class=\"nombre_rol\">\n");
      out.write("                  <div class=\"nombre\">");
      out.print(empvo.getNom_emp());
      out.write(' ');
      out.print(empvo.getApe_emp());
      out.write("</div>\n");
      out.write("                  <div class=\"rol\">");
      out.print(rolEs);
      out.write("</div>\n");
      out.write("                 </div>\n");
      out.write("               </div>\n");
      out.write("               <form method=\"post\" action=\"sesiones\">\n");
      out.write("                     <button type=\"submit\" value=\"Cerrar Sesión\" > <i class='bx bx-log-out' id=\"log_out\"></i></button>\n");
      out.write("               </form>\n");
      out.write("           </li>\n");
      out.write("          </ul>\n");
      out.write("        </aside>\n");
      out.write("        \n");
      out.write("        ");
 
        EmpleadoVO emvo = (EmpleadoVO)request.getAttribute("myPerfilAdmin");
        
      out.write("  \n");
      out.write("        \n");
      out.write("        <!-- PERFIL -->\n");
      out.write(" \n");
      out.write("        <div class=\"perfil\">\n");
      out.write("            <div class=\"publicidad animate__animated animate__slideInDown\">\n");
      out.write("                <div class=\"imagen\">\n");
      out.write("                    <img src=\"IMAGES/modelo.png\" class=\"foto\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"texto\">\n");
      out.write("                    <h2 class=\"nombre_perfil\"> ");
      out.print(emvo.getNom_emp());
      out.write(' ');
      out.print(emvo.getApe_emp());
      out.write("</h2>\n");
      out.write("                    <h3 class=\"rol_perfil\"> ");
      out.print(emvo.getProf_emp());
      out.write("</h3>\n");
      out.write("                    <p> ");
      out.print(emvo.getPerfil_emp());
      out.write("\n");
      out.write("                    </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"informacion\">\n");
      out.write("                <div class=\"lista_categoria\">\n");
      out.write("                    <a href=\"#\" class=\"item_categoria\" categoria=\"info-pers\"> INFORMACIÓN PERSONAL </a>\n");
      out.write("                    <a href=\"#\" class=\"item_categoria\" categoria=\"perfil\"> EDITAR PERFIL </a>\n");
      out.write("                </div>\n");
      out.write("                <section class=\"lista_informacion\">\n");
      out.write("                    <div class=\"item_informacion info animate__animated animate__jackInTheBox\" categoria=\"info-pers\">\n");
      out.write("                        <div>\n");
      out.write("                          <h3 class=\"titulo_categoria\"> <i class='icono bx bxs-user-detail'></i> Datos Personales </h3>\n");
      out.write("                          <ul class=\"datos\">\n");
      out.write("                            <li> <span class=\"dato\"> Documento:</span> ");
      out.print(emvo.getDoc_emp());
      out.write(" </li>\n");
      out.write("                            <li> <span class=\"dato\"> Fecha de Nacimiento:</span> ");
      out.print(emvo.getFecha_nac());
      out.write(" </li>\n");
      out.write("                            <li> <span class=\"dato\"> Correo:</span> ");
      out.print(emvo.getCorr_emp());
      out.write(" </li>\n");
      out.write("                          </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                          <h3 class=\"titulo_categoria\"> <i class='icono bx bx bxs-phone-call'></i> Contacto </h3>\n");
      out.write("                          <ul class=\"datos\">\n");
      out.write("                            <li> <span class=\"dato\"> Ciudad:</span> ");
      out.print(emvo.getCiudad_emp());
      out.write("</li>\n");
      out.write("                            <li> <span class=\"dato\"> Dirección:</span> ");
      out.print(emvo.getDir_emp());
      out.write(" </li>\n");
      out.write("                            <li> <span class=\"dato\"> Teléfono:</span> ");
      out.print(emvo.getTel_emp());
      out.write(" </li>\n");
      out.write("                          </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </c:forEach> \n");
      out.write("                    <div class=\"item_informacion animate__animated animate__jackInTheBox\" categoria=\"perfil\">\n");
      out.write("                        <div class=\"formularios\">\n");
      out.write("\n");
      out.write("                          <!-- Perfil -->\n");
      out.write("                          <form method=\"post\" action=\"Empleado\" class=\"formulario\">\n");
      out.write("                            <h3 class=\"titulo_formularios\"> <i class='bx bx-bookmark-heart'></i> Perfil </h3>\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"perfil\" class=\"formulario_label\"> Perfil </label>\n");
      out.write("                              <textarea id=\"perfil\" class=\"input_form\" name=\"txtPerfil_emp\" value=\"");
      out.print(emvo.getPerfil_emp());
      out.write("\" placeholder=\" \"></textarea>\n");
      out.write("                              <span class=\"linea_form_\"></span>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"boton_form\">Actualizar</button>\n");
      out.write("                            <input type=\"hidden\" value=\"5\" name=\"opcion\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print(emvo.getIde_emp());
      out.write("\" name=\"txtIde_emp\">\n");
      out.write("                          </form> \n");
      out.write("\n");
      out.write("                          <!-- Datos Personales -->\n");
      out.write("                          <form method=\"post\" action=\"Empleado\" class=\"formulario\">\n");
      out.write("                            <h3 class=\"titulo_formularios\"> <i class='icono bx bxs-user-detail'></i> Datos Personales </h3>\n");
      out.write("\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"documento\" class=\"formulario_label\"> Documento </label>\n");
      out.write("                              <input type=\"number\" id=\"documento\" class=\"input_form\" name=\"txtDoc_emp\" value=\"");
      out.print(emvo.getDoc_emp());
      out.write("\" placeholder=\" \">\n");
      out.write("                              <span class=\"linea_form\"></span>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"fechaN\" class=\"formulario_label\"> Fecha de Nacimiento </label>\n");
      out.write("                              <input type=\"date\" id=\"fechaN\" class=\"input_form\" name=\"txtFecha_emp\" value=\"");
      out.print(emvo.getFecha_nac());
      out.write("\" placeholder=\" \">\n");
      out.write("                              <span class=\"linea_form\"></span>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"correo\" class=\"formulario_label\"> Correo electrónico </label>\n");
      out.write("                              <input type=\"email\" id=\"correo\" class=\"input_form\" name=\"txtCorr_emp\" value=\"");
      out.print(emvo.getCorr_emp());
      out.write("\" placeholder=\" \">\n");
      out.write("                              <span class=\"linea_form\"></span>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"boton_form\">Actualizar</button>\n");
      out.write("                            <input type=\"hidden\" value=\"2\" name=\"opcion\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print(emvo.getIde_emp());
      out.write("\" name=\"txtIde_emp\">\n");
      out.write("                          </form>\n");
      out.write("\n");
      out.write("                          <!-- Contacto --> \n");
      out.write("                          <form  method=\"post\" action=\"Empleado\" class=\"formulario\">\n");
      out.write("                            <h3 class=\"titulo_formularios\"> <i class='icono bx bx bxs-phone-call'></i> Contacto </h3>\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"ciudad\" class=\"formulario_label\"> Ciudad </label>\n");
      out.write("                              <input type=\"text\" id=\"ciudad\" class=\"input_form\" name=\"txtCiu_emp\" value=\"");
      out.print(emvo.getCiudad_emp());
      out.write("\" placeholder=\" \">\n");
      out.write("                              <span class=\"linea_form\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"dir\" class=\"formulario_label\"> Dirección </label>\n");
      out.write("                              <input type=\"text\" id=\"dir\" class=\"input_form\" name=\"txtDir_emp\" value=\"");
      out.print(emvo.getDir_emp());
      out.write("\" placeholder=\" \">\n");
      out.write("                              <span class=\"linea_form\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"grupo_form\">\n");
      out.write("                              <label for=\"tel\" class=\"formulario_label\"> Teléfono </label>\n");
      out.write("                              <input type=\"number\" id=\"tel\" class=\"input_form\" name=\"txtTel_emp\" value=\"");
      out.print(emvo.getTel_emp());
      out.write("\" placeholder=\" \">\n");
      out.write("                              <span class=\"linea_form\"></span>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <button type=\"submit\" class=\"boton_form\">Actualizar</button>\n");
      out.write("                            <input type=\"hidden\" value=\"6\" name=\"opcion\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print(emvo.getIde_emp());
      out.write("\" name=\"txtIde_emp\">\n");
      out.write("                          </form> \n");
      out.write("                        </div>                             \n");
      out.write("                    </div>\n");
      out.write("                </section>\n");
      out.write("            </div>\n");
      out.write("        </div>\t\n");
      out.write("        \n");
      out.write("        <!-- JS -->\n");
      out.write("        <script src=\"JS/aside.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
