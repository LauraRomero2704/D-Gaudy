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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janus
 */
public class DetalleDAO extends Conexion.ConexionDB 
                    // Hereda                   // Implementa           
{
    // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    // Declarar Variables del Modulo 
    private int ide_det, ide_ped, ide_pren, cantPren_det;
    private double precio_ped;

    
    // Metodo Constructor Vacio
    public DetalleDAO() 
    {
    }
    
    // Metodo Contructor que Recibe los Datos del VO
    public DetalleDAO (DetalleVO comVO)
    {
        super();
        
        //Conectarse a la base de datos 
        try 
        {
            conexion = this.obtenerConexion();
            
            // Trae los Datos de VO para hacer la operacion
            ide_det = comVO.getIde_det();
            ide_ped = comVO.getIde_ped();
            ide_pren = comVO.getIde_pren();
            cantPren_det = comVO.getCantPren_det();
            precio_ped = comVO.getPrecio_ped();
 
          
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
 
    
    // Metodo para Listar
    public ArrayList<DetalleVO> listarDetalles()
    {
        // Crea Array
        ArrayList<DetalleVO> listaDetalles = new ArrayList<>();
        
        try 
        {

            conexion = this.obtenerConexion();
            sql = "SELECT * FROM detalle";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                DetalleVO detVO = new DetalleVO(mensajero.getInt(1), mensajero.getInt(2), mensajero.getInt(3)
                                                ,mensajero.getInt(4), mensajero.getDouble(5));

                listaDetalles.add(detVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaDetalles;

    }
    
    public boolean inactivarRegistro() {
    try {

            sql = "CALL CambiarEstadoCom_FacturaPendiente(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_det);
           
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }  
    
       public boolean ActivarRegistro(){
        
        try {

            sql = "CALL CambiarEstadoCom_FacturaEntregado(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_det);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(DetalleDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
          
}
