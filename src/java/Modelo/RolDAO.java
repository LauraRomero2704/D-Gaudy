/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KarenV
 */
public class RolDAO extends ConexionDB {

    //Declarar Variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    //Variables del modulo
    private String ide_rol = "", nom_rol = "";

    //Constructor vacio 
    public RolDAO() {
    }

    //Instanciar clase UsuarioVO
    Modelo.UsuarioVO usuVo = new Modelo.UsuarioVO();
    
    
    //Recibir datos del VO

    public RolDAO(RolVO rol) {
        super();
        try {
            conexion = this.obtenerConexion();

            ide_rol = rol.getIde_rol();
            nom_rol = rol.getNom_rol();

        } catch (Exception e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Metodo de lista de roles
    public ArrayList<RolVO> rolTipo(String nomUsu) {

        ArrayList<RolVO> listaRoles = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT U.ide_usu, R.nom_rol FROM rol R INNER JOIN usuario U ON R.ide_rol=U.ide_rol WHERE U.nom_usu=?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nomUsu);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                RolVO rolvo = new RolVO(mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(rolvo);
            }

        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaRoles;

    }
    
     //Metodo para LISTAR
    public ArrayList<RolVO> listarRol() {

        //Crear Array, nombre del objeto + nombre del array 
        ArrayList<RolVO> listaRoles = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM rol WHERE nom_rol IN ('Gerente de Pedidos', 'Gerente de Prendas')";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                RolVO rolVO = new RolVO(mensajero.getString(1), mensajero.getString(2));
                listaRoles.add(rolVO);
            }

        } catch (SQLException e) {
            Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(RolDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaRoles;

    }

}
