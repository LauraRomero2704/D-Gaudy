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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class CalcomaniaDAO extends Conexion.ConexionDB implements Crud{
    
     // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    // Declarar Variables del Modulo 
    private int ide_calc;
    private String nom_calc, url_calc;
    private String estado_calc;
    
    // Metodo Constructor Vacio
    public CalcomaniaDAO() {
    }
    
    // Metodo Contructor que Recibe los Datos del VO
    public CalcomaniaDAO(CalcomaniaVO calVO) {
        super();

        //Conectarse a la base de datos 
        try {
            conexion = this.obtenerConexion();

            //Traer al DAO los datos del VO para hacer la operación
            ide_calc = calVO.getIde_calc();
            nom_calc = calVO.getNom_calc();
            url_calc = calVO.getUrl_calc();
            estado_calc = calVO.getEstado_calc();
           

        } catch (Exception e) {
            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

        }
    }
    
     public ArrayList<CalcomaniaVO> listar() {

        //Crear Array, nombre del objeto + nombre del array 
        ArrayList<CalcomaniaVO> listaCalcomanias = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM calcomania";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

               CalcomaniaVO calVO = new CalcomaniaVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), 
                                                     mensajero.getString(4));

               listaCalcomanias.add(calVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaCalcomanias;

    }

    @Override
    public boolean agregarRegistro() {
         try {

            sql = "CALL InsertarCalcomania (?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_calc);
            puente.setString(2, url_calc);
           
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
         try {
            sql = "CALL ActualizarCalcomania (?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_calc);
            puente.setString(2, nom_calc);
            puente.setString(3, url_calc);
            puente.setString(4, estado_calc);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    @Override
    public boolean inactivarRegistro() {
        try {

            sql = "CALL CambiarEstadoCalcomaniaAgotada(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_calc);
           
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }
    
    public boolean ActivarRegistro(){
        
        try {

            sql = "CALL CambiarEstadoCalcomaniaDisponible(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_calc);
            
            puente.executeUpdate();
            operacion = true;

         } catch (SQLException e) {

            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
    

    public CalcomaniaVO consultarCalcomanias(int ide_calc) {
       CalcomaniaVO calVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM calcomania WHERE ide_calc=?";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_calc);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                calVO = new CalcomaniaVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), 
                                         mensajero.getString(4));
            }

        } catch (SQLException e) {
            Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(CalcomaniaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return calVO;
    }

}

