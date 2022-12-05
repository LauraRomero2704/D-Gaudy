/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Janus
 */
public class UsuarioVO {
    
    // Declarar Variables
    private int ide_usu;
    private String ide_rol, nom_usu, cont_usu, estado_usu;
   
   
    //Constructor 
    public UsuarioVO(int ide_usu, String ide_rol, String nom_usu, String cont_usu, String estado_usu) {
            this.ide_usu = ide_usu;
            this.ide_rol = ide_rol;
            this.nom_usu = nom_usu;
            this.cont_usu = cont_usu;
            this.estado_usu = estado_usu;
        }

    
    public UsuarioVO(int ide_usu) {
        this.ide_usu = ide_usu;
    }

    public UsuarioVO() {
    }

    
    //SET AND GET

    public int getIde_usu() {
        return ide_usu;
    }

    public void setIde_usu(int ide_usu) {
        this.ide_usu = ide_usu;
    }

    public String getIde_rol() {
        return ide_rol;
    }

    public void setIde_rol(String ide_rol) {
        this.ide_rol = ide_rol;
    }

    public String getNom_usu() {
        return nom_usu;
    }

    public void setNom_usu(String nom_usu) {
        this.nom_usu = nom_usu;
    }

    public String getCont_usu() {
        return cont_usu;
    }

    public void setCont_usu(String cont_usu) {
        this.cont_usu = cont_usu;
    }

    public String getEstado_usu() {
        return estado_usu;
    }

    public void setEstado_usu(String estado_usu) {
        this.estado_usu = estado_usu;
    }
    
}

