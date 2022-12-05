package Modelo;

import Conexion.ConexionDB;
import Conexion.Crud;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Laura
 */
public class PrendaDAO extends Conexion.ConexionDB implements Crud // Hereda                   // Implementa   
{

    // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    // Declarar Variables del Modulo 
    private int ide_pren;
    private String ide_cat, nom_pren, descrip_pren, url_pren, color_pren;
    private int talla_pren, stock_pren;
    private double precio_pren; 
    private String estado_pren;
   
    // Metodo Constructor Vacio
    public PrendaDAO() {
    }

    // Metodo Contructor que Recibe los Datos del VO
    public PrendaDAO(PrendaVO prenVO) {
        super();

        //Conectarse a la base de datos 
        try {
            conexion = this.obtenerConexion();

            // Trae los Datos de VO para hacer la operacion
            ide_pren = prenVO.getIde_pren();
            ide_cat = prenVO.getIde_cat();
            nom_pren = prenVO.getNom_pren();
            descrip_pren = prenVO.getDescrip_pren();
            url_pren = prenVO.getUrl_pren();
            color_pren = prenVO.getColor_pren();
            talla_pren = prenVO.getTalla_pren();
            stock_pren = prenVO.getStock_pren();
            precio_pren = prenVO.getPrecio_pren();
            estado_pren = prenVO.getEstado_pren();
        } catch (Exception e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

     // Metodo para Listar
     // Metodo para Listar
    public ArrayList<PrendaVO> listarPrendas() {
        // Crea Array
        ArrayList<PrendaVO> listaPrendas = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT P.ide_pren, C.nom_cat, P.nom_pren, P.descrip_pren, P.url_pren, "
                + "P.color_pren, P.talla_pren, P.stock_pren, P.precio_pren, P.estado_pren "
                + "FROM prenda P INNER JOIN categoria C ON P.ide_cat = C.ide_cat";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                PrendaVO prenVO = new PrendaVO(mensajero.getInt(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getInt(7), mensajero.getInt(8),
                        mensajero.getDouble(9), mensajero.getString(10));
                listaPrendas.add(prenVO);
            }
        } catch (Exception e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaPrendas;
    }
    
    public void listarImg(int ide_pren, HttpServletResponse response) {
        String sql = "select * from prenda where ide_pren=" + ide_pren;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {
                inputStream = mensajero.getBinaryStream("Foto");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
        } catch (Exception e) {
        }
    }
    
    // Metodos Genericos
    @Override
    public boolean agregarRegistro() {

        try {
            sql = "CALL InsertarPrenda(?, ?, ?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_cat);
            puente.setString(2, nom_pren);
            puente.setString(3, descrip_pren);
            puente.setString(4, url_pren);
            puente.setString(5, color_pren);
            puente.setInt(6, talla_pren);
            puente.setInt(7, stock_pren);
            puente.setDouble(8, precio_pren);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase         
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE prenda SET ide_cat = ?, nom_pren = ?, descrip_pren = ?,url_pren = ?, color_pren = ?, talla_pren = ?, stock_pren = ?, precio_pren = ?, estado_pren = ? WHERE ide_pren = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_cat);
            puente.setString(2, nom_pren);
            puente.setString(3, descrip_pren);
            puente.setString(4, url_pren);
            puente.setString(5, color_pren);
            puente.setInt(6, talla_pren);
            puente.setInt(7, stock_pren);
            puente.setDouble(8, precio_pren);
            puente.setString(9, estado_pren);
            puente.setInt(10, ide_pren);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase  
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean inactivarRegistro() {
        try {

            sql = "CALL CambiarEstadoPrendaAgotado(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_pren);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    // Metodos Propios (Todo metodo que NO sea generico y necesite la base de datos se necesita hacer la conexion)             
    public boolean ActivarRegistro() {
        try {
            sql = "CALL CambiarEstadoPrendaDisponible(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_pren);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase  
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

       // Metodo para Consultar
    public PrendaVO consultarRegistro(int ide_pren) {
        PrendaVO prenVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM prenda WHERE ide_pren = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_pren);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                prenVO = new PrendaVO(mensajero.getInt(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6),
                        mensajero.getInt(7), mensajero.getInt(8),
                        mensajero.getDouble(9), mensajero.getString(10));
            }
        } catch (Exception e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return prenVO;
    }
           
    public PrendaVO getPrendas(int ide_pren){
        String sql="select * from prenda where ide_pren=" +ide_pren;
        PrendaVO prenVO = new PrendaVO();
        
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                prenVO.setIde_pren(mensajero.getInt(1));
                prenVO.setIde_cat(mensajero.getString(2));
                prenVO.setNom_pren(mensajero.getString(3));
                prenVO.setDescrip_pren(mensajero.getString(4));
                prenVO.setUrl_pren(mensajero.getString(5));
                prenVO.setColor_pren(mensajero.getString(6));
                prenVO.setTalla_pren(mensajero.getInt(7));
                prenVO.setStock_pren(mensajero.getInt(8));
                prenVO.setPrecio_pren(mensajero.getDouble(9));
                prenVO.setEstado_pren(mensajero.getString(10));
                       
            }
        } catch (Exception e) {
        
        } 
        
        return prenVO;
    }
    
     public boolean AgregarNuevaPrenda(PrendaVO prendao) {
        try {
            sql = "insert into prenda(ide_cat, nom_pren, descrip_pren, url_pren, color_pren, talla_pren, stock_pren, precio_pren, estado_pren)values(?,?,?,?,?,?,?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, prendao.getIde_cat());
            puente.setString(2, prendao.getNom_pren());
            puente.setString(3, prendao.getDescrip_pren());
            puente.setString(4, prendao.getUrl_pren());
            puente.setString(5, prendao.getColor_pren());
            puente.setInt(6, prendao.getTalla_pren());
            puente.setInt(7, prendao.getStock_pren());
            puente.setDouble(8, prendao.getPrecio_pren());
            puente.setString(9, prendao.getEstado_pren());
            puente.executeUpdate();
            operacion = true;
            
        } catch (SQLException e) {
            Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase  
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PrendaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
     
     public List Listar() {
        ArrayList<PrendaVO> productos = new ArrayList<>();
        sql = "select * from prenda where ide_cat = 1";
        try {

            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO proVO = new PrendaVO();
                proVO.setIde_pren(mensajero.getInt(1));
                proVO.setIde_cat(mensajero.getString(2));
                proVO.setNom_pren(mensajero.getString(3));
                proVO.setDescrip_pren(mensajero.getString(4));
                proVO.setUrl_pren(mensajero.getString(5));
                proVO.setColor_pren(mensajero.getString(6));
                proVO.setTalla_pren(mensajero.getInt(7));
//              proVO.setFoto(mensajero.getString(5));
                proVO.setStock_pren(mensajero.getInt(8));
                proVO.setPrecio_pren(mensajero.getDouble(9));
                proVO.setEstado_pren(mensajero.getString(10));
                productos.add(proVO);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
     
      public List ListarShorts() {
        ArrayList<PrendaVO> shorts = new ArrayList<>();
        sql = "select * from prenda where ide_cat = 2";
        try {

            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO proVO = new PrendaVO();
                proVO.setIde_pren(mensajero.getInt(1));
                proVO.setIde_cat(mensajero.getString(2));
                proVO.setNom_pren(mensajero.getString(3));
                proVO.setDescrip_pren(mensajero.getString(4));
                proVO.setUrl_pren(mensajero.getString(5));
                proVO.setColor_pren(mensajero.getString(6));
                proVO.setTalla_pren(mensajero.getInt(7));
//              proVO.setFoto(mensajero.getString(5));
                proVO.setStock_pren(mensajero.getInt(8));
                proVO.setPrecio_pren(mensajero.getDouble(9));
                proVO.setEstado_pren(mensajero.getString(10));
                shorts.add(proVO);
            }
        } catch (SQLException e) {
        }
        return shorts;
    }
       
     public List ObservarShort(String ide_pren) {
        List lista = new ArrayList();
        String sql = "select * from prenda where ide_cat= 2";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO prenVO = new PrendaVO();
                prenVO.setIde_pren(mensajero.getInt(1));
                prenVO.setIde_cat(mensajero.getString(2));
                prenVO.setNom_pren(mensajero.getString(3));
                prenVO.setDescrip_pren(mensajero.getString(4));
                prenVO.setUrl_pren(mensajero.getString(5));
                prenVO.setColor_pren(mensajero.getString(6));
                prenVO.setTalla_pren(mensajero.getInt(7));
                prenVO.setStock_pren(mensajero.getInt(8));
                prenVO.setPrecio_pren(mensajero.getDouble(9));
                prenVO.setEstado_pren(mensajero.getString(10));
                lista.add(prenVO);
            }
        } catch (Exception e) {
        }
        return lista;
    }  
     
     public List ListarFaldas() {
        ArrayList<PrendaVO> shorts = new ArrayList<>();
        sql = "select * from prenda where ide_cat = 3";
        try {

            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO proVO = new PrendaVO();
                proVO.setIde_pren(mensajero.getInt(1));
                proVO.setIde_cat(mensajero.getString(2));
                proVO.setNom_pren(mensajero.getString(3));
                proVO.setDescrip_pren(mensajero.getString(4));
                proVO.setUrl_pren(mensajero.getString(5));
                proVO.setColor_pren(mensajero.getString(6));
                proVO.setTalla_pren(mensajero.getInt(7));
//              proVO.setFoto(mensajero.getString(5));
                proVO.setStock_pren(mensajero.getInt(8));
                proVO.setPrecio_pren(mensajero.getDouble(9));
                proVO.setEstado_pren(mensajero.getString(10));
                shorts.add(proVO);
            }
        } catch (SQLException e) {
        }
        return shorts;
    }
       
     public List ObservarFaldas(String ide_pren) {
        List lista = new ArrayList();
        String sql = "select * from prenda where ide_cat= 3";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                PrendaVO prenVO = new PrendaVO();
                prenVO.setIde_pren(mensajero.getInt(1));
                prenVO.setIde_cat(mensajero.getString(2));
                prenVO.setNom_pren(mensajero.getString(3));
                prenVO.setDescrip_pren(mensajero.getString(4));
                prenVO.setUrl_pren(mensajero.getString(5));
                prenVO.setColor_pren(mensajero.getString(6));
                prenVO.setTalla_pren(mensajero.getInt(7));
                prenVO.setStock_pren(mensajero.getInt(8));
                prenVO.setPrecio_pren(mensajero.getDouble(9));
                prenVO.setEstado_pren(mensajero.getString(10));
                lista.add(prenVO);
            }
        } catch (Exception e) {
        }
        return lista;
    }   
}
