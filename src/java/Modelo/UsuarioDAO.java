/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Conexion.ConexionDB;
import Conexion.Crud;
import Encriptar.esconder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author User
 */
public class UsuarioDAO extends ConexionDB implements Crud {

    //Declarar Variables
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    //Variables del modulo
    private int ide_usu;
    private String ide_rol, nom_usu, cont_usu, estado_usu;

    //Constructor vacio 
    public UsuarioDAO() {
    }

    //Recibir datos del VO
    public UsuarioDAO(UsuarioVO usuVO) {
        super();

        //Conectarse a la base de datos 
        try {
            conexion = this.obtenerConexion();

            //traer al DAO los datos del VO para hacer la operación
            ide_usu = usuVO.getIde_usu();
            ide_rol = usuVO.getIde_rol();
            nom_usu = usuVO.getNom_usu();
            cont_usu = usuVO.getCont_usu();
            estado_usu = usuVO.getEstado_usu();
        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //Metodo lista usuarios
    public ArrayList<UsuarioVO> listar() {

        //Crear Array, nombre del objeto + nombre del array 
        ArrayList<UsuarioVO> listaUsuarios = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT U.ide_usu, R.nom_rol, U.nom_usu, U.cont_usu, U.estado_usu "
                    + "FROM usuario U INNER JOIN rol R ON U.ide_rol=R.ide_rol";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                UsuarioVO usuVO = new UsuarioVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

                listaUsuarios.add(usuVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaUsuarios;

    }

    /* LISTAR EMPLEADOS */
    public ArrayList<UsuarioVO> listarEmp() {

        //Crear Array, nombre del objeto + nombre del array 
        ArrayList<UsuarioVO> listaEmpleados = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM usuario WHERE ide_rol < 4";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                UsuarioVO usuVO = new UsuarioVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), mensajero.getString(5));

                listaEmpleados.add(usuVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaEmpleados;

    }

    //Metodos genericos
    @Override
    public boolean agregarRegistro() {//Cliente se registra
        //Instanciar la clase esconder
        esconder esc = new esconder();

        //Crear nueva variable con el objeto de la instancia y el nombre de la variable de contraseña
        String nuevaPass = esc.ecnode(cont_usu);
        try {
            sql = "CALL InsertarUsuario (?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, nom_usu);
            puente.setString(2, nuevaPass);

            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    @Override
    public boolean actualizarRegistro() {

        try {
            sql = "CALL ActualizarUsuario (?, ?, ?, ?, ?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, cont_usu);
            puente.setInt(2, ide_usu);

            puente.executeUpdate();
            operacion = true;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;

    }

    @Override
    public boolean inactivarRegistro() {

        try {

            sql = "CALL CambiarEstadoUsuarioInactivo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_usu);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    public boolean activarRegistro() {
        try {

            sql = "CALL CambiarEstadoUsuarioActivo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_usu);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    public boolean agregarRegistroEmpl() {//agregar empleado

         //Instanciar la clase esconder
        esconder esc = new esconder();
        
        //Crear nueva variable con el objeto de la instancia y el nombre de la variable de contraseña
        String nuevaPass = esc.ecnode(cont_usu);
        
        try {

            sql = "INSERT INTO usuario (ide_rol,nom_usu, cont_usu) values (?,?,?)";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_rol);
            puente.setString(2, nom_usu);
            puente.setString(3, nuevaPass);
            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    //Metodo Inicio Sesion
    public boolean iniciarSesion(String usuario, String clave) {

        //Instanciar la clase esconder
        esconder esc = new esconder();

        //Crear nueva variable con el objeto de la instancia y el nombre de la variable de contraseña
        String nuevaPass = esc.ecnode(clave);
        
        //Todo metodo que no sea generico y necesite la bses de datos se necesita hacer la conexion
        try {

            conexion = this.obtenerConexion();
            sql = "SELECT * FROM usuario WHERE nom_usu=? AND cont_usu=?"; //Sentencia sql
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, nuevaPass);
            mensajero = puente.executeQuery();
            if (mensajero.next()) {

                operacion = true;
            }

        } catch (Exception e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;

    }

    public UsuarioVO Validar(String email, String pass) {
        String sql = "select * from usuario where nom_usu=? and cont_usu=?";
        UsuarioVO usu = new UsuarioVO();
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, email);
            puente.setString(2, pass);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                usu.setIde_usu(mensajero.getInt(1));
                usu.setIde_rol(mensajero.getString(2));
                usu.setNom_usu(mensajero.getString(3));
                usu.setCont_usu(mensajero.getString(4));
                usu.setEstado_usu(mensajero.getString(5));
            }
        } catch (Exception e) {
        }
        return usu;
    }
    
    public boolean actualizarContra() {
        try {
            System.out.println("ide_usu="+ ide_usu);
            sql = "UPDATE usuario SET cont_usu=? WHERE ide_usu=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, cont_usu);
            puente.setInt(2, ide_usu);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
     
     public UsuarioVO getCont(int ide_usu){
        String sql="select * from usuario where ide_usu=" +ide_usu;
        UsuarioVO usuvo = new UsuarioVO();
         System.out.println("datos"+ide_usu);
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                usuvo.setIde_usu(mensajero.getInt(1));
                usuvo.setIde_rol(mensajero.getString(2));
                usuvo.setNom_usu(mensajero.getString(3));
                usuvo.setCont_usu(mensajero.getString(4));
                usuvo.setEstado_usu(mensajero.getString(5));
                System.out.println("datos"+ide_usu);       
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        
        } 
        
        return usuvo;
    }
     
     public UsuarioVO consultarUsuarioC(String correo) {
       UsuarioVO usuVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM usuario WHERE nom_usu = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, correo);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                 usuVO = new UsuarioVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), mensajero.getString(4), 
                                        mensajero.getString(5));
            }

        } catch (SQLException e) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return usuVO;
    }
}
