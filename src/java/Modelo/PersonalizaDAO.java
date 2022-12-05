/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
public class PersonalizaDAO extends Conexion.ConexionDB{
    
    // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;
    
    // Declarar Variables del Modulo  
    private int ide_pers, ide_cli, ide_pren, ide_calc;
    private String nom_pers, urlDiseño_pers;
    private double precio_pers;

    public PersonalizaDAO() {
    }
    
    // Metodo Contructor que Recibe los Datos del VO
    public PersonalizaDAO (PersonalizaVO perVO) 
    {        
        super();
        
        //Conectarse a la base de datos 
        try 
        {
            conexion = this.obtenerConexion(); 
            
            //Traer al DAO los datos del VO para hacer la operación
            ide_pers = perVO.getIde_pers();
            ide_cli = perVO.getIde_cli();
            ide_pren = perVO.getIde_pren();
            ide_calc = perVO.getIde_calc();
            urlDiseño_pers = perVO.getUrlDiseño_pers();
            precio_pers = perVO.getPrecio_pers();           
            
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
     // Metodo para Listar
    public ArrayList<PersonalizaVO> listar()
    {
        // Crea Array
        ArrayList<PersonalizaVO> listarPersonaliza = new ArrayList<>();
        
        try 
        {

            conexion = this.obtenerConexion();
            sql = "SELECT * FROM personalizar";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                PersonalizaVO perVO = new PersonalizaVO(mensajero.getInt(1), mensajero.getInt(2), mensajero.getInt(3),mensajero.getInt(4),
                                                        mensajero.getString(5), mensajero.getString(6), mensajero.getDouble(7));

                listarPersonaliza.add(perVO);

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

        return listarPersonaliza;

    }
    
     public boolean inactivarRegistro() 
    {
        try 
        {
            sql = "CALL CambiarEstadoPersoPublica(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_pers);
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
    
    
    public boolean ActivarRegistro() 
    {
        try 
        {
            sql = "CALL CambiarEstadoPersoPrivada(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_pers);
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
    
    public PersonalizaVO getPerso(int ide_pers){
        String sql="select * from personalizar where ide_pers=" +ide_pers;
        PersonalizaVO perVO = new PersonalizaVO();
        
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                perVO.setIde_pers(mensajero.getInt(1));
                perVO.setIde_cli(mensajero.getInt(2));
                perVO.setIde_pren(mensajero.getInt(3));
                perVO.setIde_calc(mensajero.getInt(4));
                perVO.setNom_pers(mensajero.getString(5));
                perVO.setUrlDiseño_pers(mensajero.getString(6));
                perVO.setPrecio_pers(mensajero.getDouble(7));
                       
            }
        } catch (Exception e) {
        
        } 
        
        return perVO;
    }
}
