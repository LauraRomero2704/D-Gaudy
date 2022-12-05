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
public class PersonalizaVO {
    
    // Declarar Variables
    private int ide_pers, ide_cli, ide_pren, ide_calc;
    private String nom_pers, urlDiseño_pers;
    private double precio_pers;

    //Constructor

    public PersonalizaVO(int ide_pers, int ide_cli, int ide_pren, int ide_calc, String nom_pers, String urlDiseño_pers, double precio_pers) {
        this.ide_pers = ide_pers;
        this.ide_cli = ide_cli;
        this.ide_pren = ide_pren;
        this.ide_calc = ide_calc;
        this.nom_pers = nom_pers;
        this.urlDiseño_pers = urlDiseño_pers;
        this.precio_pers = precio_pers;
    }
 
    public PersonalizaVO() {
    }

    //SET AND GET
    public PersonalizaVO(int ide_pers) {
         this.ide_pers = ide_pers;
    }

    public int getIde_pers() {
        return ide_pers;
    }

    public void setIde_pers(int ide_pers) {
        this.ide_pers = ide_pers;
    }

    public int getIde_cli() {
        return ide_cli;
    }

    public void setIde_cli(int ide_cli) {
        this.ide_cli = ide_cli;
    }

    public int getIde_pren() {
        return ide_pren;
    }

    public void setIde_pren(int ide_pren) {
        this.ide_pren = ide_pren;
    }

    public int getIde_calc() {
        return ide_calc;
    }

    public void setIde_calc(int ide_calc) {
        this.ide_calc = ide_calc;
    }

    public String getNom_pers() {
        return nom_pers;
    }

    public void setNom_pers(String nom_pers) {
        this.nom_pers = nom_pers;
    }

    public String getUrlDiseño_pers() {
        return urlDiseño_pers;
    }

    public void setUrlDiseño_pers(String urlDiseño_pers) {
        this.urlDiseño_pers = urlDiseño_pers;
    }

    public double getPrecio_pers() {
        return precio_pers;
    }

    public void setPrecio_pers(double precio_pers) {
        this.precio_pers = precio_pers;
    }
 
}
