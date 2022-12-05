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
public class CarrVO {


    int item;
    int ide_pers;
    String nom_pers;
    String urlDiseño_pers;
    double total_ped;
    int cantPren_det;
    double subTotal_ped;

   
    public CarrVO(int item, int ide_pers, String nom_pers, String urlDiseño_pers, double total_ped, int cantPren_det, double subTotal_ped) {
        this.item = item;
        this.ide_pers = ide_pers;
        this.nom_pers = nom_pers;
        this.urlDiseño_pers = urlDiseño_pers;
        this.total_ped = total_ped;
        this.cantPren_det = cantPren_det;
        this.subTotal_ped = subTotal_ped;
    }

    public CarrVO() {
       
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIde_pers() {
        return ide_pers;
    }

    public void setIde_pers(int ide_pers) {
        this.ide_pers = ide_pers;
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

    public double getTotal_ped() {
        return total_ped;
    }

    public void setTotal_ped(double total_ped) {
        this.total_ped = total_ped;
    }

    public int getCantPren_det() {
        return cantPren_det;
    }

    public void setCantPren_det(int cantPren_det) {
        this.cantPren_det = cantPren_det;
    }

    public double getSubTotal_ped() {
        return subTotal_ped;
    }

    public void setSubTotal_ped(double subTotal_ped) {
        this.subTotal_ped = subTotal_ped;
    }
    
    
    
}
