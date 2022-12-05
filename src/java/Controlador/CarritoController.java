/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Conexion.Fecha;
import Modelo.CarrVO;
import Modelo.CarritoVO;
import Modelo.ClienteDAO;
import Modelo.ClienteVO;
import Modelo.DetalleVO;
import Modelo.EmpleadoDAO;
import Modelo.EmpleadoVO;
import Modelo.PagoVO;
import Modelo.PedidoDAO;
import Modelo.PedidoVO;
import Modelo.PersonalizaDAO;
import Modelo.PersonalizaVO;
import Modelo.PrendaDAO;
import Modelo.PrendaVO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
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
@WebServlet(name = "CarritoController", urlPatterns = {"/CarritoController"})
public class CarritoController extends HttpServlet {

    PagoVO pago = new PagoVO();
    ClienteVO cl = new ClienteVO();
    ClienteDAO cldao = new ClienteDAO();
    UsuarioVO usuvo = new UsuarioVO();
    UsuarioDAO usudao = new UsuarioDAO();
    PedidoDAO peddao = new PedidoDAO();
    PedidoVO pedvo = new PedidoVO();
    PrendaDAO pdao = new PrendaDAO();
    PrendaVO preVO = new PrendaVO();
    EmpleadoVO emp = new EmpleadoVO();
    EmpleadoDAO empdao = new EmpleadoDAO();
    PersonalizaDAO perdao = new PersonalizaDAO();
    PersonalizaVO perVO = new PersonalizaVO();
    int item = 0;
    int cantPren_det = 1;
    double subTotal_ped = 0.0;
    double total_ped = 0.0;

    List<CarritoVO> listaPrendas = new ArrayList<>();
    List prendas = new ArrayList();
    
    List<CarrVO> listaPersonaliza = new ArrayList<>();
    List personaliza = new ArrayList();
    
    List<CarritoVO> listaShorts = new ArrayList<>();
    List shorts = new ArrayList();
    List faldas = new ArrayList();
    List perAdm = new ArrayList();

    int idpedido;
    int idpago;
    double montopagar;
    int id_prenda = 0;
    int id_perso = 0;

    CarritoVO car = new CarritoVO();
    CarrVO carr = new CarrVO();

    Fecha fechaSistem = new Fecha();
    double descuento = 0.0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        prendas = pdao.Listar();
        shorts = pdao.ListarShorts();
        faldas = pdao.ListarFaldas();
       
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "carrito":
                descuento = 0.0;
                total_ped = 0.0;
                item = 0;  
                request.setAttribute("Carrito", listaPrendas);
                for (int i = 0; i < listaPrendas.size(); i++) {
                    total_ped = total_ped + listaPrendas.get(i).getSubTotal_ped();
                    listaPrendas.get(i).setItem(item + i + 1);
                }
                if(listaPrendas.get(item).getCantPren_det() >=6){
                   descuento = total_ped*0.10;
                   total_ped = total_ped - descuento;                  
                }
                subTotal_ped = cantPren_det * total_ped + descuento;               
                request.setAttribute("SubTotal", subTotal_ped);
                request.setAttribute("Descuento", descuento);
                request.setAttribute("totalPedido", total_ped);
                request.getRequestDispatcher("carrito.jsp").forward(request, response);
                break;
                
            case "carritoPers":
                descuento = 0.0;
                total_ped = 0.0;
                item = 0;
                request.setAttribute("CarritoPers", listaPersonaliza);
                for (int i = 0; i < listaPersonaliza.size(); i++) {
                    total_ped = total_ped + listaPersonaliza.get(i).getSubTotal_ped();
                    listaPersonaliza.get(i).setItem(item + i + 1);
                }
                if (listaPersonaliza.get(item).getCantPren_det() >= 6) {
                    descuento = total_ped * 0.10;
                    total_ped = total_ped - descuento;
                }
                subTotal_ped = cantPren_det * total_ped + descuento;
                request.setAttribute("SubTotal", subTotal_ped);
                request.setAttribute("Descuento", descuento);
                request.setAttribute("totalPedido", total_ped);
                request.getRequestDispatcher("carritoPers.jsp").forward(request, response);
                break;     
                
            case "Comprar":
                agregarCarrito(request);
                request.getRequestDispatcher("CarritoController?accion=carrito").forward(request, response);
                break;
               
                
            case "AgregarCarrito":
                agregarCarrito(request);
                request.setAttribute("cont", listaPrendas.size());
                request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                break;
             
            case "AgregarPersonalizacion":
                agregarPersonaliza(request);
                request.setAttribute("cont", listaPersonaliza.size());
                request.getRequestDispatcher("misPersonalizaciones.jsp").forward(request, response);
                break;     
            
              
            case "CategoriaShort":
                String categoriaS = request.getParameter("ide_cat");
                List<PrendaVO> categoriaShorts = pdao.ObservarShort(categoriaS);
                request.setAttribute("myShorts", categoriaShorts);
                request.getRequestDispatcher("categoriaShorts.jsp").forward(request, response);
                break;
                               
                             
             case "AgregarShort":
                agregarCarrito(request);
                request.setAttribute("cont", listaPrendas.size());
                String categoriaSh = request.getParameter("ide_pren");
                List<PrendaVO> categoriaShort = pdao.ObservarShort(categoriaSh);
                request.setAttribute("myShorts", categoriaShort);
                request.getRequestDispatcher("categoriaShorts.jsp").forward(request, response);
                break;   
                
             case "CategoriaFalda":
                String categoriaF = request.getParameter("ide_cat");
                List<PrendaVO> categoriaFaldas = pdao.ObservarFaldas(categoriaF);
                request.setAttribute("myFaldas", categoriaFaldas);
                request.getRequestDispatcher("categoriaFaldas.jsp").forward(request, response);
                break;
               
                
             case "AgregarFalda":
                agregarCarrito(request);
                request.setAttribute("cont", listaPrendas.size());
                String categoriaFa = request.getParameter("ide_pren");
                List<PrendaVO> categoriaFalda = pdao.ObservarFaldas(categoriaFa);
                request.setAttribute("myFaldas", categoriaFalda);
                request.getRequestDispatcher("categoriaFaldas.jsp").forward(request, response);
                break;     
                
            case "deleteProducto":
                id_prenda = Integer.parseInt(request.getParameter("ide_pren"));
                if (listaPrendas != null) {
                    for (int j = 0; j < listaPrendas.size(); j++) {
                        if (listaPrendas.get(j).getIde_pren() == id_prenda) {
                            listaPrendas.remove(j);
                        }
                    }
                }
                break;
                
            case "deletePerso":
                id_perso = Integer.parseInt(request.getParameter("ide_pers"));
                if (listaPersonaliza != null) {
                    for (int j = 0; j < listaPersonaliza.size(); j++) {
                        if (listaPersonaliza.get(j).getIde_pers() == id_perso) {
                            listaPersonaliza.remove(j);
                        }
                    }
                }
                break;
                
            case "updateCantidad":
                id_prenda = Integer.parseInt(request.getParameter("ide_pren"));
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                for (int j = 0; j < listaPrendas.size(); j++) {
                    if (listaPrendas.get(j).getIde_pren() == id_prenda) {
                        listaPrendas.get(j).setCantPren_det(cant);
                        listaPrendas.get(j).setSubTotal_ped(listaPrendas.get(j).getTotal_ped() * cant);
                    }
                }
                break;
             
             case "updateCantidadPers":
                id_perso = Integer.parseInt(request.getParameter("ide_pers"));
                int cantP = Integer.parseInt(request.getParameter("cantidad"));
                for (int j = 0; j < listaPersonaliza.size(); j++) {
                    if (listaPersonaliza.get(j).getIde_pers() == id_perso) {
                        listaPersonaliza.get(j).setCantPren_det(cantP);
                        listaPersonaliza.get(j).setSubTotal_ped(listaPersonaliza.get(j).getTotal_ped() * cantP);
                    }
                }
                break;    

            case "GenerarPedido":
                usuvo = (UsuarioVO)session.getAttribute("datosUsuario");
                ClienteVO clivo =(ClienteVO)session.getAttribute("datosCliente");
                System.out.println(usuvo.getNom_usu());
                descuento = 0.0;
                if (usuvo.getNom_usu() != null && listaPrendas.size() != 0 ) {
                    if (total_ped > 0.0) {
                        PedidoVO ped = new PedidoVO();
                        ped.setIde_cli(clivo.getIde_cli());
                        ped.setTallaPrenda_ped(Integer.parseInt(request.getParameter("txtTallaPrenda_ped")));
                        ped.setFecha_ped(fechaSistem.FechaBD());
                        ped.setMedioPago_ped(request.getParameter("txtMedioPago_ped"));
                        ped.setDir_ped(request.getParameter("txtDir_ped"));
                        ped.setSubTotal_ped(Double.parseDouble(request.getParameter("txtSubTotal_ped")));
                        ped.setDescuento_ped(Double.parseDouble(request.getParameter("txtDescuento"))); 
                        ped.setTotal_ped(total_ped);
                        ped.setEstado_ped("Pendiente");
                        peddao.guardarPedido(ped);
                        montopagar = 0;

                        idpedido = peddao.IdPedido();
                        System.out.println("listaPrendas:"+listaPrendas);
                        for (int i = 0; i < listaPrendas.size(); i++) {
                            DetalleVO det = new DetalleVO();
                            det.setIde_ped(idpedido);
                            det.setIde_pren(listaPrendas.get(i).getIde_pren());
                            det.setCantPren_det(listaPrendas.get(i).getCantPren_det());
                            det.setPrecio_ped(listaPrendas.get(i).getTotal_ped());
                            peddao.guardarDetalle(det);
                        }
                        listaPrendas = new ArrayList<>();
                        List pedido = peddao.misPedidos(usuvo.getIde_usu());
                        request.setAttribute("myPedidos", pedido);
                        request.getRequestDispatcher("compras.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("CarritoController?accion=carrito").forward(request, response);
                }
                break;
                
             case "GenerarPedidoPers":
                usuvo = (UsuarioVO) session.getAttribute("datosUsuario");
                ClienteVO civo = (ClienteVO) session.getAttribute("datosCliente");
                System.out.println(usuvo.getNom_usu());
                descuento = 0.0;
                if (usuvo.getNom_usu() != null && listaPersonaliza.size() != 0) {
                    if (total_ped > 0.0) {
                        PedidoVO ped = new PedidoVO();
                        ped.setIde_cli(civo.getIde_cli());
                        ped.setTallaPrenda_ped(Integer.parseInt(request.getParameter("txtTallaPrenda_ped")));
                        ped.setFecha_ped(fechaSistem.FechaBD());
                        ped.setMedioPago_ped(request.getParameter("txtMedioPago_ped"));
                        ped.setDir_ped(request.getParameter("txtDir_ped"));
                        ped.setSubTotal_ped(Double.parseDouble(request.getParameter("txtSubTotal_ped")));
                        ped.setDescuento_ped(Double.parseDouble(request.getParameter("txtDescuento")));
                        ped.setTotal_ped(total_ped);
                        ped.setEstado_ped("Pendiente");
                        peddao.guardarPedido(ped);
                        montopagar = 0;

                        
                        listaPersonaliza = new ArrayList<>();
                        List pedido = peddao.misPedidos(usuvo.getIde_usu());
                        request.setAttribute("myPedidos", pedido);
                        request.getRequestDispatcher("comprasPers.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                    }
                } else {
                    request.getRequestDispatcher("CarritoController?accion=carrito").forward(request, response);
                }
                break;    

            case "RegistrarPersonalizar":
                usuvo = (UsuarioVO) session.getAttribute("datosUsuario");
                ClienteVO cli = (ClienteVO) session.getAttribute("datosCliente");
                System.out.println(usuvo.getNom_usu());
                if (usuvo.getNom_usu() != null) {
                    PersonalizaVO per = new PersonalizaVO();
                    per.setIde_cli(cli.getIde_cli());
                    per.setIde_pren(per.getIde_pren());
                    per.setIde_calc(per.getIde_calc());
                    per.setNom_pers(request.getParameter("txtNom_pers"));
                    per.setUrlDiseño_pers(request.getParameter("txtUrlDiseño_pers"));
                    per.setPrecio_pers(70000);
                    peddao.guardarPersonalizar(per);

                    request.getRequestDispatcher("falda.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("jean1.jsp").forward(request, response);
                }

                break;    
              
            case "MisPedidos":
                usuvo = (UsuarioVO)session.getAttribute("datosUsuario");
                ClienteVO clientevo = (ClienteVO)session.getAttribute("datosCliente");
                System.out.println(clientevo.getIde_cli());
                if (usuvo.getNom_usu() != null) {
                    List pedido = peddao.misPedidos(clientevo.getIde_cli());
                    request.setAttribute("myPedidos", pedido);
                    request.getRequestDispatcher("compras.jsp").forward(request, response);
                } else if (listaPrendas.size() > 0) {
                    request.getRequestDispatcher("CarritoController?accion=carrito").forward(request, response);
                } else {
                    request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                }
                break;
                
            case "MisPerson":
                usuvo = (UsuarioVO) session.getAttribute("datosUsuario");
                ClienteVO clientvo = (ClienteVO) session.getAttribute("datosCliente");
                System.out.println(clientvo.getIde_cli());
                if (usuvo.getNom_usu() != null) {
                    List personal = peddao.misPerso(clientvo.getIde_cli());
                    request.setAttribute("myPer", personal);
                    request.getRequestDispatcher("misPersonalizaciones.jsp").forward(request, response);
                } else if (listaPrendas.size() > 0) {
                    request.getRequestDispatcher("CarritoController?accion=carrito").forward(request, response);
                } else {
                    request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                }
                break;    
                               
            case "GuardarProducto":
                ArrayList<String> pro=new ArrayList<>();
                try {
                    FileItemFactory factory = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(factory);
                    List items = fileUpload.parseRequest(request);
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileItem = (FileItem) items.get(i);
                        if(!fileItem.isFormField()){
                            File file=new File("C:\\xampp\\htdocs\\carrito\\"+fileItem.getName());
                            fileItem.write(file);
                            preVO.setUrl_pren("http://localhost/carrito/"+fileItem.getName());
                        }else{
                            pro.add(fileItem.getString());                            
                        }
                    }
                    preVO.setNom_pren(pro.get(0));
                    preVO.setDescrip_pren(pro.get(1));
                    preVO.setPrecio_pren(Double.parseDouble(pro.get(2)));
                    preVO.setTalla_pren(Integer.parseInt(pro.get(3)));
                    pdao.AgregarNuevaPrenda(preVO);

                } catch (Exception e) {
                    System.err.println(""+e);
                }
                request.getRequestDispatcher("Controlador?accion=NuevoProducto").forward(request, response);
                break;
              
            case "verDetalle":
                total_ped = 0.0;
                int idpedidos = Integer.parseInt(request.getParameter("ide_ped"));
                List<DetalleVO> detalle = peddao.Detalle(idpedidos);
                request.setAttribute("myDetalle", detalle);
                for (int i = 0; i < detalle.size(); i++) {
                    total_ped = total_ped + (detalle.get(i).getPrecio_ped() * detalle.get(i).getCantPren_det());
                }
                request.setAttribute("PrecioTotal", total_ped);
                request.getRequestDispatcher("DetalleCompra.jsp").forward(request, response);
                break;
                    
            case "verDetallePrenda":
                 int idprendas = Integer.parseInt(request.getParameter("ide_pren"));
                 PrendaDAO prendao = new PrendaDAO();
                 PrendaVO prenvo = prendao.getPrendas(idprendas);
                 if(prenvo != null){
                     request.setAttribute("DetallePrenda", prenvo);
                     request.getRequestDispatcher("detallePrenda.jsp").forward(request, response);
                 }else{
                    request.getRequestDispatcher("index.jsp").forward(request, response); 
                 }
                 break;
             
             case "verPerfil":
                 int perfilAdmin = Integer.parseInt(request.getParameter("ide_emp"));
                 EmpleadoDAO empdao = new EmpleadoDAO();
                 EmpleadoVO empvo = empdao.getPerfil(perfilAdmin);
                 if(empvo != null){
                     request.setAttribute("myPerfilAdmin", empvo);
                     request.getRequestDispatcher("admGestion_Perfil.jsp").forward(request, response);
                 }else{
                    request.getRequestDispatcher("admGestion_Perfil.jsp").forward(request, response); 
                 }
                 break; 
           
             case "verCont":
                 int perfilCont = Integer.parseInt(request.getParameter("ide_usu"));
                 UsuarioDAO usudao = new UsuarioDAO();
                 UsuarioVO usuvo = usudao.getCont(perfilCont);
                 if(usuvo != null){
                     request.setAttribute("myPerfilCont", usuvo);
                     request.getRequestDispatcher("admGestion_Perfil.jsp").forward(request, response);
                 }else{
                    request.getRequestDispatcher("admGestion_Perfil.jsp").forward(request, response); 
                 }
                 break; 
                 
             case "verPerfilPedido":
                 int perfilPedido = Integer.parseInt(request.getParameter("ide_emp"));
                 EmpleadoDAO empda = new EmpleadoDAO();
                 EmpleadoVO empv = empda.getPerfil(perfilPedido);
                 if(empv != null){
                     request.setAttribute("myPerfilPedido", empv);
                     request.getRequestDispatcher("gerPedidos_Perfil.jsp").forward(request, response);
                 }else{
                    request.getRequestDispatcher("gerPedidos_Perfil.jsp").forward(request, response); 
                 }
                 break;      
                 
             case "verPerfilPrenda":
                 int perfilPrenda = Integer.parseInt(request.getParameter("ide_emp"));
                 EmpleadoDAO empd = new EmpleadoDAO();
                 EmpleadoVO emp = empd.getPerfil(perfilPrenda);
                 if(emp != null){
                     request.setAttribute("myPerfilPrenda", emp);
                     request.getRequestDispatcher("gerPrendas_Perfil.jsp").forward(request, response);
                 }else{
                    request.getRequestDispatcher("gerPrendas_Perfil.jsp").forward(request, response); 
                 }
                 break;
                 
             case "CatPerson":
                usuvo = (UsuarioVO) session.getAttribute("datosUsuario");
                ClienteVO clienvo = (ClienteVO) session.getAttribute("datosCliente");
                System.out.println(clienvo.getIde_cli());
                if (usuvo.getNom_usu() != null) {
                    List catPer = peddao.CatPers(clienvo.getIde_cli());
                    request.setAttribute("CatPer", catPer);
                    request.getRequestDispatcher("catalogoPers.jsp").forward(request, response);
                } else if (listaPrendas.size() > 0) {
                    request.getRequestDispatcher("CarritoController?accion=carrito").forward(request, response);
                } else {
                    request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                }
                break;
                 
            case "Nuevo":
                listaPrendas = new ArrayList();
                request.getRequestDispatcher("CarritoController?accion=home").forward(request, response);
                break;
                   
    
            case "Salir":
                listaPrendas = new ArrayList();
                request.getRequestDispatcher("CarritoController?accion=Salirr").forward(request, response);
                break;
            default:
                request.setAttribute("cont", listaPrendas.size());
                request.setAttribute("prendas", prendas);
                request.setAttribute("shorts", shorts);
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void agregarCarrito(HttpServletRequest request) {
        cantPren_det = 1;
        int pos = 0;
        int idpp = Integer.parseInt(request.getParameter("ide_pren"));
        if (listaPrendas.size() > 0) {
            for (int i = 0; i < listaPrendas.size(); i++) {
                if (listaPrendas.get(i).getIde_pren() == idpp) {
                    pos = i;
                }
            }
            if (idpp == listaPrendas.get(pos).getIde_pren()) {
                cantPren_det = listaPrendas.get(pos).getCantPren_det() + cantPren_det;
                subTotal_ped = listaPrendas.get(pos).getTotal_ped() * cantPren_det;
                listaPrendas.get(pos).setCantPren_det(cantPren_det);
                listaPrendas.get(pos).setSubTotal_ped(subTotal_ped);
            } else {
                car = new CarritoVO();
                preVO = pdao.getPrendas(idpp);
                car.setIde_pren(preVO.getIde_pren());
                car.setNom_pren(preVO.getNom_pren());
                car.setUrl_pren(preVO.getUrl_pren());
                car.setDescrip_pren(preVO.getDescrip_pren());
                car.setTotal_ped(preVO.getPrecio_pren());
                car.setCantPren_det(cantPren_det);
                subTotal_ped = cantPren_det * preVO.getPrecio_pren();
                car.setSubTotal_ped(subTotal_ped);
                listaPrendas.add(car);
            }
        } else {
            car = new CarritoVO();
            preVO = pdao.getPrendas(idpp);
            car.setIde_pren(preVO.getIde_pren());
            car.setNom_pren(preVO.getNom_pren());
            car.setUrl_pren(preVO.getUrl_pren());
            car.setDescrip_pren(preVO.getDescrip_pren());
            car.setTotal_ped(preVO.getPrecio_pren());
            car.setCantPren_det(cantPren_det);
            subTotal_ped = cantPren_det * preVO.getPrecio_pren();
            car.setSubTotal_ped(subTotal_ped);
            listaPrendas.add(car);
        }
    }
    
    public void agregarPersonaliza(HttpServletRequest request) {
        cantPren_det = 1;
        int pos = 0;
        int idpp = Integer.parseInt(request.getParameter("ide_pers"));
        if (listaPersonaliza.size() > 0) {
            for (int i = 0; i < listaPersonaliza.size(); i++) {
                if (listaPersonaliza.get(i).getIde_pers() == idpp) {
                    pos = i;
                }
            }
            if (idpp == listaPersonaliza.get(pos).getIde_pers()) {
                cantPren_det = listaPersonaliza.get(pos).getCantPren_det() + cantPren_det;
                subTotal_ped = listaPersonaliza.get(pos).getTotal_ped() * cantPren_det;
                listaPersonaliza.get(pos).setCantPren_det(cantPren_det);
                listaPersonaliza.get(pos).setSubTotal_ped(subTotal_ped);
            } else {
                carr = new CarrVO();
                perVO = perdao.getPerso(idpp);
                carr.setIde_pers(perVO.getIde_pers());
                carr.setNom_pers(perVO.getNom_pers());
                carr.setUrlDiseño_pers(perVO.getUrlDiseño_pers());
                carr.setTotal_ped(perVO.getPrecio_pers());
                carr.setCantPren_det(cantPren_det);
                subTotal_ped = cantPren_det * perVO.getPrecio_pers();
                carr.setSubTotal_ped(subTotal_ped);
                listaPersonaliza.add(carr);
            }
        } else {
            carr = new CarrVO();
            perVO = perdao.getPerso(idpp);
            carr.setIde_pers(perVO.getIde_pers());
            carr.setNom_pers(perVO.getNom_pers());
            carr.setUrlDiseño_pers(perVO.getUrlDiseño_pers());
            carr.setTotal_ped(perVO.getPrecio_pers());
            carr.setCantPren_det(cantPren_det);
            subTotal_ped = cantPren_det * perVO.getPrecio_pers();
            carr.setSubTotal_ped(subTotal_ped);
            listaPersonaliza.add(carr);
        }
    }
}
