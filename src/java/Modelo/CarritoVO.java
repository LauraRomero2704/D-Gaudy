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
public class CarritoVO {
    int item;
    int ide_pren;
    String nom_pren;
    String url_pren;
    String descrip_pren;
    double total_ped;
    int cantPren_det;
    double subTotal_ped;

    public CarritoVO() {
    }

    public CarritoVO(int item, int ide_pren, String nom_pren, String url_pren, String descrip_pren, double total_ped, int cantPren_det, double subTotal_ped) {
        this.item = item;
        this.ide_pren = ide_pren;
        this.nom_pren = nom_pren;
        this.url_pren = url_pren;
        this.descrip_pren = descrip_pren;
        this.total_ped = total_ped;
        this.cantPren_det = cantPren_det;
        this.subTotal_ped = subTotal_ped;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIde_pren() {
        return ide_pren;
    }

    public void setIde_pren(int ide_pren) {
        this.ide_pren = ide_pren;
    }

    public String getNom_pren() {
        return nom_pren;
    }

    public void setNom_pren(String nom_pren) {
        this.nom_pren = nom_pren;
    }

    public String getUrl_pren() {
        return url_pren;
    }

    public void setUrl_pren(String url_pren) {
        this.url_pren = url_pren;
    }

    public String getDescrip_pren() {
        return descrip_pren;
    }

    public void setDescrip_pren(String descrip_pren) {
        this.descrip_pren = descrip_pren;
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





