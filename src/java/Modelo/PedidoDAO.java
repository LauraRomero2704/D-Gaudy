package Modelo;

import Conexion.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Laura
 */
public class PedidoDAO extends Conexion.ConexionDB // Hereda                   // Implementa           
{

    // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    // Declarar Variables del Modulo 
    private int ide_ped, ide_cli, tallaPrenda_ped;
    private String fecha_ped, medioPago_ped, dir_ped;
    private double subTotal_ped, descuento_ped, total_ped;
    private String estado_ped;

    // Metodo Constructor Vacio
    public PedidoDAO() {
    }

    // Metodo Contructor que Recibe los Datos del VO
    public PedidoDAO(PedidoVO pedVO) {
        super();

        // Conectarse
        try {
            conexion = this.obtenerConexion();

            // Trae los Datos de VO para hacer la operacion
            ide_ped = pedVO.getIde_ped();
            ide_cli = pedVO.getIde_cli();
            tallaPrenda_ped = pedVO.getTallaPrenda_ped();;
            fecha_ped = pedVO.getFecha_ped();
            medioPago_ped = pedVO.getMedioPago_ped();
            dir_ped = pedVO.getDir_ped();
            subTotal_ped = pedVO.getSubTotal_ped();
            descuento_ped = pedVO.getDescuento_ped();
            total_ped = pedVO.getTotal_ped();
            estado_ped = pedVO.getEstado_ped();

        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public boolean inactivarRegistro() {
        try {

            sql = "CALL CambiarEstadoPedidoPendiente(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_ped);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    public boolean ActivarRegistro() {

        try {

            sql = "CALL CambiarEstadoPedidoEntregado(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_ped);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    // Metodo para Listar
    public ArrayList<PedidoVO> listarPedidos() {
        // Crea Array
        ArrayList<PedidoVO> listaPedidos = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();

            sql = "SELECT * FROM pedido";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                PedidoVO pedVO = new PedidoVO(mensajero.getInt(1), mensajero.getInt(2),
                        mensajero.getInt(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6), mensajero.getDouble(7),
                        mensajero.getDouble(8), mensajero.getDouble(9),
                        mensajero.getString(10));
                listaPedidos.add(pedVO);
            }
        } catch (Exception e) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaPedidos;
    }

    public int IdPedido() {
        int idc = 0;
        String sql = "select max(ide_ped) from pedido;";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                idc = mensajero.getInt(1);
            }
        } catch (Exception e) {
        }
        return idc;
    }

    public int guardarDetalle(DetalleVO detvo) {
        String sql = "insert into detalle(ide_ped, ide_pren, cantPren_det, precio_ped)values(?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, detvo.getIde_ped());
            puente.setInt(2, detvo.getIde_pren());
            puente.setInt(3, detvo.getCantPren_det());
            puente.setDouble(4, detvo.getPrecio_ped());
            puente.executeUpdate();
           
        } catch (Exception e) {
            System.out.println("Error :,((" + e);
        } finally{
           
        }
        return 1;
    }

    public List misPedidos(int ide_cli) {
        List lista = new ArrayList();
        String sql = "select * from pedido where ide_cli=" + ide_cli ;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PedidoVO pedvo = new PedidoVO();
                pedvo.setIde_ped(mensajero.getInt(1));
                pedvo.setIde_cli(mensajero.getInt(2));
                pedvo.setTallaPrenda_ped(mensajero.getInt(3));
                pedvo.setFecha_ped(mensajero.getString(4));
                pedvo.setMedioPago_ped(mensajero.getString(5));
                pedvo.setDir_ped(mensajero.getString(6));
                pedvo.setSubTotal_ped(mensajero.getDouble(7));
                pedvo.setDescuento_ped(mensajero.getDouble(8));
                pedvo.setTotal_ped(mensajero.getDouble(9));
                pedvo.setEstado_ped(mensajero.getString(10));
                lista.add(pedvo);
            }
        } catch (Exception e) {
        System.out.println("Error :,((" + e);
        } finally{
           
        }
        return lista;
    }
    
    public List misPerso(int ide_cli) {
        List lista = new ArrayList();
        String sql = "select * from personalizar where ide_cli=" + ide_cli ;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PersonalizaVO pervo = new PersonalizaVO();
                pervo.setIde_pers(mensajero.getInt(1));
                pervo.setIde_cli(mensajero.getInt(2));
                pervo.setIde_pren(mensajero.getInt(3));
                pervo.setIde_calc(mensajero.getInt(4));
                pervo.setNom_pers(mensajero.getString(5));
                pervo.setUrlDiseño_pers(mensajero.getString(6));
                pervo.setPrecio_pers(mensajero.getDouble(7));
                lista.add(pervo);
            }
        } catch (Exception e) {
        System.out.println("Error :,((" + e);
        } finally{
           
        }
        return lista;
    }
    
     public List misPrendas(int ide_usu) {
        List lista = new ArrayList();
        String sql = "select * from prenda ";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO prenvo = new PrendaVO();
                prenvo.setIde_pren(mensajero.getInt(1));
                prenvo.setIde_cat(mensajero.getString(2));
                prenvo.setNom_pren(mensajero.getString(3));
                prenvo.setDescrip_pren(mensajero.getString(4));
                prenvo.setUrl_pren(mensajero.getString(5));
                prenvo.setColor_pren(mensajero.getString(6));
                prenvo.setTalla_pren(mensajero.getInt(7));
                prenvo.setStock_pren(mensajero.getInt(8));
                prenvo.setPrecio_pren(mensajero.getDouble(9));
                prenvo.setEstado_pren(mensajero.getString(10));
                lista.add(prenvo);
            }
        } catch (Exception e) {
        System.out.println("Error :,((" + e);
        } finally{
           
        }
        return lista;
    }

    public List Detalle(int ide_det) {
        List lista = new ArrayList();
        String sql = "select D.ide_det, P.url_pren, P.nom_pren, D.ide_ped, D.cantPren_det, D.precio_ped FROM detalle D inner join prenda P on P.ide_pren = D.ide_pren where ide_ped=" + ide_det;
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                DetalleVO det = new DetalleVO();
                PrendaVO Prendavo = new PrendaVO();
                det.setIde_det(mensajero.getInt(1));
                det.setPrendavo(new PrendaVO());
                det.getPrendavo().setUrl_pren(mensajero.getString(2));
                det.getPrendavo().setNom_pren(mensajero.getString(3));
                det.setIde_ped(mensajero.getInt(4));
                det.setCantPren_det(mensajero.getInt(5));
                det.setPrecio_ped(mensajero.getDouble(6));
                lista.add(det);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
   
    
    public int guardarPedido(PedidoVO ped) {
        String sql = "insert into pedido(ide_cli, tallaPrenda_ped, fecha_ped, medioPago_ped, dir_ped, subTotal_ped, descuento_ped, total_ped )values(?,?,?,?,?,?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ped.getIde_cli());
            puente.setInt(2, ped.getTallaPrenda_ped());
            puente.setString(3, ped.getFecha_ped());
            puente.setString(4, ped.getMedioPago_ped());
            puente.setString(5, ped.getDir_ped());
            puente.setDouble(6, ped.getSubTotal_ped());
            puente.setDouble(7, ped.getDescuento_ped()); 
            puente.setDouble(8, ped.getTotal_ped());
            puente.executeUpdate();
        } catch (Exception e) {
            System.out.println("errooor"+ e);
        }
        return 1;
    }
    
    public int guardarPersonalizar(PersonalizaVO per) {
        String sql = "INSERT INTO personalizar(ide_cli, ide_pren, ide_calc, nom_pers, urlDiseño_pers, precio_pers) VALUES(?, ?, ?, ?, ?, ?);";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, per.getIde_cli());
            puente.setInt(2, per.getIde_pren());
            puente.setInt(3, per.getIde_calc());
            puente.setString(4, per.getNom_pers());
            puente.setString(5, per.getUrlDiseño_pers());
            puente.setDouble(6, per.getPrecio_pers());
            puente.executeUpdate();
        } catch (Exception e) {
            System.out.println("errooor"+ e);
        }
        return 1;
    }
    
    public List CatPers(int ide_pren) {
        List lista = new ArrayList();
        String sql = "Select * from prenda WHERE ide_pren = 2 OR ide_pren= 4 OR ide_pren= 9 OR ide_pren= 10 OR ide_pren= 17 OR ide_pren= 18";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO prenvo = new PrendaVO();
                prenvo.setIde_pren(mensajero.getInt(1));
                prenvo.setIde_cat(mensajero.getString(2));
                prenvo.setNom_pren(mensajero.getString(3));
                prenvo.setDescrip_pren(mensajero.getString(4));
                prenvo.setUrl_pren(mensajero.getString(5));
                prenvo.setColor_pren(mensajero.getString(6));
                prenvo.setTalla_pren(mensajero.getInt(7));
                prenvo.setStock_pren(mensajero.getInt(8));
                prenvo.setPrecio_pren(mensajero.getDouble(9));
                prenvo.setEstado_pren(mensajero.getString(10));
                lista.add(prenvo);
            }
        } catch (Exception e) {
            System.out.println("Error :,((" + e);
        } finally {

        }
        return lista;
    }

}


