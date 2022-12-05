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
public class PedidoVO 
{

    // Declarar Variables
    private int ide_ped, ide_cli, tallaPrenda_ped;
    private String fecha_ped, medioPago_ped, dir_ped;
    private double subTotal_ped, descuento_ped, total_ped;
    private String estado_ped;
    
    
    public PedidoVO() 
    {
    }

    //Constructor

    public PedidoVO(int ide_ped, int ide_cli, int tallaPrenda_ped, String fecha_ped, String medioPago_ped, String dir_ped, double subTotal_ped, double descuento_ped, double total_ped, String estado_ped) {
        this.ide_ped = ide_ped;
        this.ide_cli = ide_cli;
        this.tallaPrenda_ped = tallaPrenda_ped;
        this.fecha_ped = fecha_ped;
        this.medioPago_ped = medioPago_ped;
        this.dir_ped = dir_ped;
        this.subTotal_ped = subTotal_ped;
        this.descuento_ped = descuento_ped;
        this.total_ped = total_ped;
        this.estado_ped = estado_ped;
    }

     
    //SET AND GET
    public PedidoVO(int ide_ped) {
      this.ide_ped = ide_ped;
    }

    public int getIde_ped() {
        return ide_ped;
    }

    public void setIde_ped(int ide_ped) {
        this.ide_ped = ide_ped;
    }

    public int getIde_cli() {
        return ide_cli;
    }

    public void setIde_cli(int ide_cli) {
        this.ide_cli = ide_cli;
    }

    public int getTallaPrenda_ped() {
        return tallaPrenda_ped;
    }

    public void setTallaPrenda_ped(int tallaPrenda_ped) {
        this.tallaPrenda_ped = tallaPrenda_ped;
    }

    public String getFecha_ped() {
        return fecha_ped;
    }

    public void setFecha_ped(String fecha_ped) {
        this.fecha_ped = fecha_ped;
    }

    public String getMedioPago_ped() {
        return medioPago_ped;
    }

    public void setMedioPago_ped(String medioPago_ped) {
        this.medioPago_ped = medioPago_ped;
    }

    public String getDir_ped() {
        return dir_ped;
    }

    public void setDir_ped(String dir_ped) {
        this.dir_ped = dir_ped;
    }

    public double getSubTotal_ped() {
        return subTotal_ped;
    }

    public void setSubTotal_ped(double subTotal_ped) {
        this.subTotal_ped = subTotal_ped;
    }

    public double getDescuento_ped() {
        return descuento_ped;
    }

    public void setDescuento_ped(double descuento_ped) {
        this.descuento_ped = descuento_ped;
    }

    public double getTotal_ped() {
        return total_ped;
    }

    public void setTotal_ped(double total_ped) {
        this.total_ped = total_ped;
    }

    public String getEstado_ped() {
        return estado_ped;
    }

    public void setEstado_ped(String estado_ped) {
        this.estado_ped = estado_ped;
    }
 
} 