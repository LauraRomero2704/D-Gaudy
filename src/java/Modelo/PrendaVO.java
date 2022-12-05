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
public class PrendaVO 
{
    
    // Declarar Variables
    private int ide_pren;
    private String ide_cat, nom_pren, descrip_pren, url_pren, color_pren;
    private int talla_pren, stock_pren;
    private double precio_pren; 
    private String estado_pren;
   
   
    public PrendaVO() 
    {
    }

    // Constructor

    public PrendaVO(int ide_pren, String ide_cat, String nom_pren, String descrip_pren, String url_pren, String color_pren, int talla_pren, int stock_pren, double precio_pren, String estado_pren) {
        this.ide_pren = ide_pren;
        this.ide_cat = ide_cat;
        this.nom_pren = nom_pren;
        this.descrip_pren = descrip_pren;
        this.url_pren = url_pren;
        this.color_pren = color_pren;
        this.talla_pren = talla_pren;
        this.stock_pren = stock_pren;
        this.precio_pren = precio_pren;
        this.estado_pren = estado_pren;
    }

    
    //SET AND GET
    public PrendaVO(int ide_pren) {
         this.ide_pren = ide_pren;
    }

    public int getIde_pren() {
        return ide_pren;
    }

    public void setIde_pren(int ide_pren) {
        this.ide_pren = ide_pren;
    }

    public String getIde_cat() {
        return ide_cat;
    }

    public void setIde_cat(String ide_cat) {
        this.ide_cat = ide_cat;
    }

    public String getNom_pren() {
        return nom_pren;
    }

    public void setNom_pren(String nom_pren) {
        this.nom_pren = nom_pren;
    }

    public String getDescrip_pren() {
        return descrip_pren;
    }

    public void setDescrip_pren(String descrip_pren) {
        this.descrip_pren = descrip_pren;
    }

    public String getUrl_pren() {
        return url_pren;
    }

    public void setUrl_pren(String url_pren) {
        this.url_pren = url_pren;
    }

    public String getColor_pren() {
        return color_pren;
    }

    public void setColor_pren(String color_pren) {
        this.color_pren = color_pren;
    }

    public int getTalla_pren() {
        return talla_pren;
    }

    public void setTalla_pren(int talla_pren) {
        this.talla_pren = talla_pren;
    }

    public int getStock_pren() {
        return stock_pren;
    }

    public void setStock_pren(int stock_pren) {
        this.stock_pren = stock_pren;
    }

    public double getPrecio_pren() {
        return precio_pren;
    }

    public void setPrecio_pren(double precio_pren) {
        this.precio_pren = precio_pren;
    }

    public String getEstado_pren() {
        return estado_pren;
    }

    public void setEstado_pren(String estado_pren) {
        this.estado_pren = estado_pren;
    }

}
