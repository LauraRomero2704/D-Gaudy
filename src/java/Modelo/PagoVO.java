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
public class PagoVO {

    private int ide_pago;
    private double monto;

    public PagoVO() {
    }

    public PagoVO(int ide_pago, double monto) {
        this.ide_pago = ide_pago;
        this.monto = monto;
    }

    public int getIde_pago() {
        return ide_pago;
    }

    public void setIde_pago(int ide_pago) {
        this.ide_pago = ide_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

   
   

   

}
