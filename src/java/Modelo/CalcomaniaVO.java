/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author User
 */
public class CalcomaniaVO {
    
    // Declarar Variables
    private int ide_calc;
    private String nom_calc, url_calc;
    private String estado_calc;

    //Constructor

    public CalcomaniaVO(int ide_calc, String nom_calc, String url_calc, String estado_calc) {
        this.ide_calc = ide_calc;
        this.nom_calc = nom_calc;
        this.url_calc = url_calc;
        this.estado_calc = estado_calc;
    }
    
 
    public CalcomaniaVO() {
        
    }

    //SET AND GET
    public CalcomaniaVO(int ide_calc) {
          this.ide_calc = ide_calc;
    }

    public int getIde_calc() {
        return ide_calc;
    }

    public void setIde_calc(int ide_calc) {
        this.ide_calc = ide_calc;
    }

    public String getNom_calc() {
        return nom_calc;
    }

    public void setNom_calc(String nom_calc) {
        this.nom_calc = nom_calc;
    }

    public String getUrl_calc() {
        return url_calc;
    }

    public void setUrl_calc(String url_calc) {
        this.url_calc = url_calc;
    }

    public String getEstado_calc() {
        return estado_calc;
    }

    public void setEstado_calc(String estado_calc) {
        this.estado_calc = estado_calc;
    }

    
}
