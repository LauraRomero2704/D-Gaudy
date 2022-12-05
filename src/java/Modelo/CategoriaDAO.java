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
import javax.swing.JOptionPane;

/**
 *
 * @author Janus
 */
public class CategoriaDAO extends Conexion.ConexionDB implements Crud
                       // Hereda                   // Implementa   
{
    // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    // Declarar Variables del Modulo                                
    private int ide_cat;
    private String nom_cat, estado_cat;
    
    // Metodo Constructor Vacio
    public CategoriaDAO() 
    {
    }
    
    // Metodo Contructor que Recibe los Datos del VO
    public CategoriaDAO (CategoriaVO catVO) 
    {        
        super();
        
        //Conectarse a la base de datos 
        try 
        {
            conexion = this.obtenerConexion(); 
            
            //Traer al DAO los datos del VO para hacer la operación
            ide_cat = catVO.getIde_cat();
            nom_cat = catVO.getNom_cat();
            estado_cat = catVO.getEstado_cat();
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }


    // Metodo para Listar
    public ArrayList<CategoriaVO> listar()
    {
        // Crea Array
        ArrayList<CategoriaVO> listarCategorias = new ArrayList<>();
        
        try 
        {

            conexion = this.obtenerConexion();
            sql = "SELECT * FROM categoria";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                CategoriaVO catVO = new CategoriaVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3));

                listarCategorias.add(catVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listarCategorias;

    }
    
    // Metodos Genericos
    @Override
    public boolean agregarRegistro()
    {
        try 
        {
            sql = "CALL InsertarCategoria (?);"; 
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_cat);
            puente.executeUpdate();
            operacion = true;
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        finally 
        {
            // Sentencia que ejecuta una accion sea lo que pase   
            try 
            {
                this.cerrarConexion();
            } 
            
            catch (Exception e) 
            {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() 
    {
        try 
        {
            sql = "CALL ActualizarCategoria (?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cat);
            puente.setString(2, nom_cat);
            puente.setString(3, estado_cat);
            puente.executeUpdate();
            operacion = true;
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        finally
        {
            // Sentencia que ejecuta una accion sea lo que pase   
            try 
            {
                this.cerrarConexion();
            } 
            
            catch (Exception e) 
            {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return operacion;
    }
    
    @Override
    public boolean inactivarRegistro() 
    {
        try 
        {
            sql = "CALL CambiarEstadoCategoriaAgotada(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cat);
            puente.executeUpdate();
            operacion = true;
        } 
        
        catch (SQLException e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        finally 
        {
            // Sentencia que ejecuta una accion sea lo que pase   
            try 
            {
                this.cerrarConexion();
            } 
            
            catch (Exception e) 
            {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return operacion;
    }
    
    // Metodos Propios (Todo metodo que NO sea generico y necesite la base de datos se necesita hacer la conexion)             

    
    public boolean ActivarRegistro() 
    {
        try 
        {
            sql = "CALL CambiarEstadoCategoriaDisponible(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cat);
            puente.executeUpdate();
            operacion = true;
        } 
        
        catch (SQLException e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        finally 
        {
            // Sentencia que ejecuta una accion sea lo que pase   
            try 
            {
                this.cerrarConexion();
            } 
            
            catch (Exception e) 
            {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return operacion;
    }
   
    

    public CategoriaVO consultarCategoria(int ide_cat) {
       CategoriaVO catVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM categoria WHERE ide_cat=?";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_cat);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                catVO = new CategoriaVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3));
            }

        } catch (SQLException e) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return catVO;
    }
    
    
    public int existeDato (String ide_cat)
    {
        try 
        {
            sql = "SELECT count(ide_cat) FROM categoria WHERE ide_cat=?;"; 
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_cat);
            mensajero = puente.executeQuery();
            operacion = true;
            
            if(mensajero.next())
            {
                return mensajero.getInt(1);
            }
            return 1;
            }
        
        catch (Exception e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        finally 
        {
            // Sentencia que ejecuta una accion sea lo que pase   
            try 
            {
                this.cerrarConexion();
            } 
            
            catch (Exception e) 
            {
                Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return 1;
    }

  
}

    
    
    


