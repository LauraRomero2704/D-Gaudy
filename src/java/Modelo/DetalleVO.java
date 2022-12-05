/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Janus
 */
public class DetalleVO {
    
    // Declarar Variables
    private int ide_det, ide_ped, ide_pren, cantPren_det;
    private double precio_ped;
    PrendaVO prendavo;

    // Constructor

    public DetalleVO(int ide_det, int ide_ped, int ide_pren, int cantPren_det, double precio_ped, PrendaVO prendavo) {
        this.ide_det = ide_det;
        this.ide_ped = ide_ped;
        this.ide_pren = ide_pren;
        this.cantPren_det = cantPren_det;
        this.precio_ped = precio_ped;
        this.prendavo = prendavo;
    }
    
     public DetalleVO(int ide_det, int ide_ped, int ide_pren, int cantPren_det, double precio_ped) {
        this.ide_det = ide_det;
        this.ide_ped = ide_ped;
        this.ide_pren = ide_pren;
        this.cantPren_det = cantPren_det;
        this.precio_ped = precio_ped;
      
    }
 
    public DetalleVO() {
    }

    //SET AND GET
    public DetalleVO(int ide_det) {
      this.ide_det = ide_det;
    }

    public int getIde_det() {
        return ide_det;
    }

    public void setIde_det(int ide_det) {
        this.ide_det = ide_det;
    }

    public int getIde_ped() {
        return ide_ped;
    }

    public void setIde_ped(int ide_ped) {
        this.ide_ped = ide_ped;
    }

    public int getIde_pren() {
        return ide_pren;
    }

    public void setIde_pren(int ide_pren) {
        this.ide_pren = ide_pren;
    }

    public int getCantPren_det() {
        return cantPren_det;
    }

    public void setCantPren_det(int cantPren_det) {
        this.cantPren_det = cantPren_det;
    }

    public double getPrecio_ped() {
        return precio_ped;
    }

    public void setPrecio_ped(double precio_ped) {
        this.precio_ped = precio_ped;
    }

    public PrendaVO getPrendavo() {
        return prendavo;
    }

    public void setPrendavo(PrendaVO prendavo) {
        this.prendavo = prendavo;
    }

    
}



