/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.InputStream;

/**
 *
 * @author Janus
 */
public class ReporteVO {
    private int ide_rept;
    private String ide_emp, nom_rept, cat_rept, pdf_rept, estado_rept;
    
    public ReporteVO() {
    }

    public ReporteVO(int ide_rept, String ide_emp, String nom_rept, String cat_rept, String pdf_rept, String estado_rept) {
        this.ide_rept = ide_rept;
        this.ide_emp = ide_emp;
        this.nom_rept = nom_rept;
        this.cat_rept = cat_rept;
        this.pdf_rept = pdf_rept;
        this.estado_rept = estado_rept;
    }

    
    public ReporteVO(int ide_rept) {
      this.ide_rept = ide_rept;
    }

    public int getIde_rept() {
        return ide_rept;
    }

    public void setIde_rept(int ide_rept) {
        this.ide_rept = ide_rept;
    }

    public String getIde_emp() {
        return ide_emp;
    }

    public void setIde_emp(String ide_emp) {
        this.ide_emp = ide_emp;
    }

    public String getNom_rept() {
        return nom_rept;
    }

    public void setNom_rept(String nom_rept) {
        this.nom_rept = nom_rept;
    }

    public String getCat_rept() {
        return cat_rept;
    }

    public void setCat_rept(String cat_rept) {
        this.cat_rept = cat_rept;
    }

    public String getPdf_rept() {
        return pdf_rept;
    }

    public void setPdf_rept(String pdf_rept) {
        this.pdf_rept = pdf_rept;
    }

    public String getEstado_rept() {
        return estado_rept;
    }

    public void setEstado_rept(String estado_rept) {
        this.estado_rept = estado_rept;
    }
     
   
}
