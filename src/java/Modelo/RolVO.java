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
public class RolVO {
    
    
    //Declarar Variables
    private String ide_rol, nom_rol;

    //Constructor 
    public RolVO() {
    }

    public RolVO(String ide_rol, String nom_rol) {
        this.ide_rol = ide_rol;
        this.nom_rol = nom_rol;
    }

    //SET AND GET
    public String getIde_rol() {
        return ide_rol;
    }

    public void setIde_rol(String ide_rol) {
        this.ide_rol = ide_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }

}