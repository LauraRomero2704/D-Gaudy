/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janus
 */
public class ClienteDAO extends Conexion.ConexionDB implements Crud {
    
    //1. Declarar variables y/o objetos 
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    // Declarar Variables del Modulo   
    private int ide_cli;
    private String ide_usu;
    private int doc_cli;
    private String nom_cli, ape_cli, ciudad_cli, dir_cli, corr_cli, tel_cli , estado_cli;

    // Metodo Constructor Vacio
    public ClienteDAO(){      
    }
    
    // Metodo Contructor que Recibe los Datos del VO    
    public ClienteDAO(ClienteVO cliVO) {
    super();
        
    //Conectarse a la base de datos 
        try {
            conexion = this.obtenerConexion();

            //Traer al DAO los datos del VO para hacer la operación
            ide_cli = cliVO.getIde_cli();
            ide_usu = cliVO.getIde_usu();
            doc_cli = cliVO.getDoc_cli();
            nom_cli = cliVO.getNom_cli();
            ape_cli = cliVO.getApe_cli();
            ciudad_cli = cliVO.getCiudad_cli();
            dir_cli = cliVO.getDir_cli();
            corr_cli = cliVO.getCorr_cli();
            tel_cli = cliVO.getTel_cli();
            estado_cli = cliVO.getEstado_cli();

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    
        public ArrayList<ClienteVO> listar() {

        //Crear Array, nombre del objeto + nombre del array 
        ArrayList<ClienteVO> listaCliente = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT C.ide_cli, U.nom_usu, C.doc_cli, C.nom_cli, C.ape_cli, "
                + "C.ciudad_cli, C.dir_cli, C.corr_cli, C.tel_cli, C.estado_cli "
                + "FROM cliente C INNER JOIN usuario U ON C.ide_usu = U.ide_usu";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                ClienteVO cliVO = new ClienteVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getInt(3), mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), mensajero.getString(9),mensajero.getString(10));

                listaCliente.add(cliVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaCliente;

    }
    
    @Override
    public boolean agregarRegistro() {
        try {

            sql = "CALL InsertarCliente(?,?,?,?,?,?,?,?,?)";            
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_usu);
            puente.setInt(2, doc_cli);
            puente.setString(3, nom_cli);
            puente.setString(4, ape_cli);
            puente.setString(5, ciudad_cli);
            puente.setString(6, dir_cli);
            puente.setString(7, corr_cli);
            puente.setString(9, tel_cli);
            puente.setString(9, estado_cli);
            
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;    
    }

    @Override
    public boolean actualizarRegistro() {
         try {
            sql = "CALL ActualizarCliente(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_usu);
            puente.setInt(2, doc_cli);
            puente.setString(3, nom_cli);
            puente.setString(4, ape_cli);
            puente.setString(5, ciudad_cli);
            puente.setString(6, dir_cli);
            puente.setString(7, corr_cli);
            puente.setString(8, tel_cli);
            puente.setString(9, estado_cli);
            puente.setInt(10, ide_cli);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }  
            return operacion;
    }

    @Override
    public boolean inactivarRegistro() {
    try {

            sql = "CALL CambiarEstadoClienteInactivo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cli);
           
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
    
        public boolean ActivarRegistro() {
        try {

            sql = "CALL CambiarEstadoClienteActivo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cli);
           
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
    
    
    
    public ClienteVO consultarCliente(int ide_cli) {
       ClienteVO cliVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM cliente WHERE ide_cli=?";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cli);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                cliVO = new ClienteVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getInt(3), 
                                      mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), 
                                      mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), 
                                      mensajero.getString(10));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return cliVO;
    }
    
     public ClienteVO consultarClienteCorreo(String correo) {
       ClienteVO cliVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM cliente C INNER JOIN usuario U ON u.ide_usu = c.ide_usu WHERE u.nom_usu = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, correo);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                cliVO = new ClienteVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getInt(3), 
                                      mensajero.getString(4), mensajero.getString(5), mensajero.getString(6), 
                                      mensajero.getString(7), mensajero.getString(8), mensajero.getString(9), 
                                      mensajero.getString(10));
            }

        } catch (SQLException e) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return cliVO;
    }
}

