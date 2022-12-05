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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Janus
 */
public class ImagenDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    // Agregar prenda con imagen 
    public int agregar(PrendaVO p) {
        ConexionDB cn = new ConexionDB();
        String sql = "INSERT INTO prenda (ide_cat, nom_pren, descrip_pren, url_pren, color_pren, talla_pren, stock_pren, precio_pren) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getIde_cat());
            ps.setString(2, p.getNom_pren());
            ps.setString(3, p.getDescrip_pren());
            ps.setString(4, p.getUrl_pren());
            ps.setString(5, p.getColor_pren());
            ps.setInt(6, p.getTalla_pren());
            ps.setInt(7, p.getStock_pren());
            ps.setDouble(8, p.getPrecio_pren());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public int agregarPersonalizar(PersonalizaVO pervo) {
        ConexionDB cn = new ConexionDB();
        String sql = "INSERT INTO personalizar (ide_cli, ide_pren, ide_calc, nom_pers, urlDiseño_pers, precio_pers) VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println("Cualquier cosa");
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pervo.getIde_cli());
            ps.setInt(2, pervo.getIde_pren());
            ps.setInt(3, pervo.getIde_calc());
            ps.setString(4, pervo.getNom_pers());
            ps.setString(5, pervo.getUrlDiseño_pers());
            ps.setDouble(6, pervo.getPrecio_pers());
            ps.executeUpdate();
            System.out.println("Se registro");
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return r;
    }

    // Agregar reporte con pdf 
    public int listarPerso(int ide_cli) {
        ConexionDB cn = new ConexionDB();
        String sql = "select * from personalizar p inner join cliente c on p.ide_cli = c.ide_cli where c.ide_cli = " + ide_cli;
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return r;
    }

     // Agregar reporte con pdf 
     public int agregarReporte(ReporteVO repVO) {
        ConexionDB cn = new ConexionDB();
        String sql = "INSERT INTO reporte (ide_emp, nom_rept, cat_rept, pdf_rept) VALUES (?, ?, ?, ?)";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, repVO.getIde_emp());
            ps.setString(2, repVO.getNom_rept());
            ps.setString(3, repVO.getCat_rept());
            ps.setString(4, repVO.getPdf_rept());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
     
   public int agregarCalcomania(CalcomaniaVO calVO) {
        ConexionDB cn = new ConexionDB();
        String sql = "INSERT INTO calcomania (nom_calc, url_calc) VALUES (?, ?)";
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, calVO.getNom_calc());
            ps.setString(2, calVO.getUrl_calc());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }  
     
    // listar prenda despues de accion de agregar 
    public List<PrendaVO> listar() {
        ConexionDB cn = new ConexionDB();
        String sql = "select * from prenda";
        List<PrendaVO> lista = new ArrayList<>();
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PrendaVO p = new PrendaVO();
                p.setIde_pren(rs.getInt(1));
                p.setIde_cat(rs.getString(2));
                p.setNom_pren(rs.getString(3));
                p.setDescrip_pren(rs.getString(4));
                p.setUrl_pren(rs.getString(5));
                p.setColor_pren(rs.getString(6));
                p.setTalla_pren(rs.getInt(7));
                p.setStock_pren(rs.getInt(8));
                p.setPrecio_pren(rs.getDouble(9));
                p.setEstado_pren(rs.getString(10));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public List<CalcomaniaVO> listarCalcomania() {
        ConexionDB cn = new ConexionDB();
        String sql = "select * from calcomania";
        List<CalcomaniaVO> listaCalcomania = new ArrayList<>();
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CalcomaniaVO cal = new CalcomaniaVO();
                cal.setIde_calc(rs.getInt(1));
                cal.setNom_calc(rs.getString(2));
                cal.setUrl_calc(rs.getString(3));
                cal.setEstado_calc(rs.getString(4));
                listaCalcomania.add(cal);
            }
        } catch (Exception e) {
        }
        return listaCalcomania;
    }
    
    // listar reporte despues de accion de agregar 
    public List<ReporteVO> listarReporte() {
        ConexionDB cn = new ConexionDB();
        String sql = "select * from reporte";
        List<ReporteVO> listaReporte = new ArrayList<>();
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReporteVO rep = new ReporteVO();
                rep.setIde_rept(rs.getInt(1));
                rep.setIde_emp(rs.getString(2));
                rep.setNom_rept(rs.getString(3));
                rep.setCat_rept(rs.getString(4));
                rep.setPdf_rept(rs.getString(5));
                rep.setEstado_rept(rs.getString(6));
              
                listaReporte.add(rep);
            }
        } catch (Exception e) {
        }
        return listaReporte;
    }
}
