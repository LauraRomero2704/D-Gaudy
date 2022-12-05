/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionDB;
import Conexion.Crud;
import java.io.InputStream;
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
public class ReporteDAO extends ConexionDB implements Crud{
    
    //Declarar Variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    //Variables del modulo
    private int ide_rept;
    private String ide_emp, nom_rept, cat_rept, pdf_rept, estado_rept;
    
    
    //Constructor vacio
    public ReporteDAO() 
    {
    }
    
    //Recibir datos del VO
    public ReporteDAO(ReporteVO repVO) 
    {
        super();

        //Conectarse a la base de datos 
        try 
        {
            conexion = this.obtenerConexion();
            
            //traer al DAO los datos del VO para hacer la operación
            ide_rept = repVO.getIde_rept();
            ide_emp = repVO.getIde_emp();
            nom_rept = repVO.getNom_rept();
            cat_rept = repVO.getCat_rept();
            pdf_rept = repVO.getPdf_rept();
            estado_rept = repVO.getEstado_rept();
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // Metodo para Listar
    public ArrayList<ReporteVO> listarReportes() {
        // Crea Array
        ArrayList<ReporteVO> listaReportes = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT R.ide_rept, E.nom_emp, R.nom_rept, R.cat_rept, R.pdf_rept, "
                + "R.estado_rept FROM reporte R INNER JOIN empleado E ON R.ide_emp = E.ide_emp";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                ReporteVO repVO = new ReporteVO(mensajero.getInt(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
                listaReportes.add(repVO);
            }
        } catch (Exception e) {
            Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaReportes;
    }
    
    
    @Override
    public boolean agregarRegistro() {
        try {
            sql = "CALL InsertarReportes (?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_emp);
            puente.setString(2, nom_rept);
            puente.setString(3, cat_rept);
            puente.setString(4, pdf_rept);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase         
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            sql = "UPDATE reporte SET ide_emp = ?, nom_rept = ?, cat_rept = ?, estado_rept = ? WHERE ide_rept = ?";
            puente = conexion.prepareStatement(sql);
           puente.setString(1, ide_emp);
            puente.setString(2, nom_rept);
            puente.setString(3, cat_rept);
            puente.setString(4, estado_rept);
            puente.setInt(5, ide_rept);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase  
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    @Override
    public boolean inactivarRegistro() {
         try {

            sql = "CALL CambiarEstadoReporteArchivado(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_rept);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }
    
     // Metodos Propios (Todo metodo que NO sea generico y necesite la base de datos se necesita hacer la conexion)             
    public boolean ActivarRegistro() {
        try {
            sql = "CALL CambiarEstadoReporteNuevo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_rept);
            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Sentencia que ejecuta una accion sea lo que pase  
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(ReporteDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    
    // Metodo para Consultar
    public ReporteVO consultarRegistro(int ide_rept) {
        ReporteVO repVO= null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM reporte WHERE ide_rept = ?;";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_rept);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                repVO = new ReporteVO(mensajero.getInt(1), mensajero.getString(2),
                        mensajero.getString(3), mensajero.getString(4),
                        mensajero.getString(5), mensajero.getString(6));
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

        return repVO;
    }
}
