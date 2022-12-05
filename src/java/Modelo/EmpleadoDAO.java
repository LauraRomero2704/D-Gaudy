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
public class EmpleadoDAO extends Conexion.ConexionDB implements Crud {

    // Declarar Variables y/o Objetos
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private boolean operacion = false;
    private String sql;

    // Declarar Variables del Modulo 
    private int ide_emp;
    private String ide_usu, prof_emp;
    private int doc_emp;
    private String nom_emp, ape_emp, perfil_emp, fecha_nac, ciudad_emp, dir_emp, corr_emp, tel_emp, estado_emp;
  
    // Metodo Constructor Vacio
    public EmpleadoDAO() {

    }

    // Metodo Contructor que Recibe los Datos del VO
    public EmpleadoDAO(EmpleadoVO empVO) {
        super();

        //Conectarse a la base de datos 
        try {
            conexion = this.obtenerConexion();

            // Trae los Datos de VO para hacer la operacion
            ide_emp = empVO.getIde_emp();
            ide_usu = empVO.getIde_usu();
            prof_emp = empVO.getProf_emp();
            doc_emp = empVO.getDoc_emp();
            nom_emp = empVO.getNom_emp();
            ape_emp = empVO.getApe_emp();
            perfil_emp = empVO.getPerfil_emp();
            fecha_nac = empVO.getFecha_nac();
            ciudad_emp = empVO.getCiudad_emp();
            dir_emp = empVO.getDir_emp();
            corr_emp = empVO.getCorr_emp();
            tel_emp = empVO.getTel_emp();
            estado_emp = empVO.getEstado_emp();

        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<EmpleadoVO> listar() {

        //Crear Array, nombre del objeto + nombre del array 
        ArrayList<EmpleadoVO> listaEmpleado = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT E.ide_emp, U.nom_usu, E.prof_emp, E.doc_emp, E.nom_emp, "
                + "E.ape_emp, E.perfil_emp, E.fecha_nac, E.ciudad_emp, E.dir_emp, "
                + "E.corr_emp, E.tel_emp, E.estado_emp FROM empleado E INNER JOIN usuario U ON E.ide_usu = U.ide_usu";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                EmpleadoVO empVO = new EmpleadoVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), mensajero.getInt(4), 
                                                  mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), 
                                                  mensajero.getString(9), mensajero.getString(10), mensajero.getString(11), mensajero.getString(12)
                                                  ,mensajero.getString(13));

                listaEmpleado.add(empVO);

            }

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return listaEmpleado;

    }
    
    @Override
    public boolean agregarRegistro() {
        try {

            sql = "INSERT INTO empleado(ide_usu, prof_emp, doc_emp, nom_emp, ape_emp, "
                + "perfil_emp, fecha_nac, ciudad_emp, dir_emp, corr_emp, tel_emp) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ide_usu);
            puente.setString(2, prof_emp);
            puente.setInt(3, doc_emp);
            puente.setString(4, nom_emp);
            puente.setString(5, ape_emp);
            puente.setString(6, perfil_emp);
            puente.setString(7, fecha_nac);
            puente.setString(8, ciudad_emp);
            puente.setString(9, dir_emp);
            puente.setString(10, corr_emp);
            puente.setString(11, tel_emp);

            puente.executeUpdate();
            operacion = true;

        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            try {
                this.cerrarConexion();

            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        try {
            System.out.println("ide_emp="+ ide_emp);
            sql = "UPDATE empleado SET doc_emp=?, fecha_nac=?, corr_emp=? WHERE ide_emp=?;";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, doc_emp);
            puente.setString(2, fecha_nac);          
            puente.setString(3, corr_emp);
            puente.setInt(4, ide_emp);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    public boolean actualizarPerfil() {
        try {
            System.out.println("ide_emp="+ ide_emp);
            sql = "UPDATE empleado SET perfil_emp=? WHERE ide_emp=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, perfil_emp);
            puente.setInt(2, ide_emp);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
    
     public boolean actualizarPerfil2() {
        try {
            System.out.println("ide_emp="+ ide_emp);
            sql = "UPDATE empleado SET ciudad_emp=?, dir_emp=?, tel_emp=? WHERE ide_emp=?;";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, ciudad_emp);
            puente.setString(2, dir_emp);
            puente.setString(3, tel_emp);
            puente.setInt(4, ide_emp);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }
    
    @Override
    public boolean inactivarRegistro() {
        try {

            sql = "CALL CambiarEstadoEmpleadoInactivo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_emp);

            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;

    }

    public boolean ActivarRegistro() {

        try {

            sql = "CALL CambiarEstadoEmpleadoActivo(?)";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_emp);
            puente.executeUpdate();
            operacion = true;

        } catch (SQLException e) {

            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);

        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (Exception e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return operacion;
    }

    public EmpleadoVO consultarEmpleado(int ide_emp) {
        EmpleadoVO empVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM empleado WHERE ide_emp=?";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ide_emp);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {

                empVO = new EmpleadoVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), mensajero.getInt(4), 
                                                  mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), 
                                                  mensajero.getString(9), mensajero.getString(10), mensajero.getString(11), mensajero.getString(12)
                                                 ,mensajero.getString(13));
            }

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            //Sentencia para que independientemnte de lo que pase haga eso
            try {

                this.cerrarConexion();
            } catch (SQLException e) {

                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return empVO;
    }

     public EmpleadoVO consultarEmpleadoC(String correo) {
       EmpleadoVO empVO = null;

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM empleado E INNER JOIN usuario U ON U.ide_usu = E.ide_usu WHERE U.nom_usu = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, correo);
            mensajero = puente.executeQuery();

            if (mensajero.next()) {

                 empVO = new EmpleadoVO(mensajero.getInt(1), mensajero.getString(2), mensajero.getString(3), mensajero.getInt(4), 
                                        mensajero.getString(5), mensajero.getString(6), mensajero.getString(7), mensajero.getString(8), 
                                        mensajero.getString(9), mensajero.getString(10), mensajero.getString(11), mensajero.getString(12)
                                        ,mensajero.getString(13));
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
        return empVO;
    }
     
    
         
      public EmpleadoVO getPerfil(int ide_emp){
        String sql="select * from empleado where ide_emp=" +ide_emp;
        EmpleadoVO empvo = new EmpleadoVO();
        
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                empvo.setIde_emp(mensajero.getInt(1));
                empvo.setIde_usu(mensajero.getString(2));
                empvo.setProf_emp(mensajero.getString(3));
                empvo.setDoc_emp(mensajero.getInt(4));
                empvo.setNom_emp(mensajero.getString(5));
                empvo.setApe_emp(mensajero.getString(6));
                empvo.setPerfil_emp(mensajero.getString(7));
                empvo.setFecha_nac(mensajero.getString(8));
                empvo.setCiudad_emp(mensajero.getString(9));
                empvo.setDir_emp(mensajero.getString(10));
                empvo.setCorr_emp(mensajero.getString(11));
                empvo.setTel_emp(mensajero.getString(12));
                empvo.setEstado_emp(mensajero.getString(13));
                       
            }
        } catch (Exception e) {
        
        } 
        
        return empvo;
    }
}
