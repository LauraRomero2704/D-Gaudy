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
public class EmpleadoVO {

    // Declarar Variables
    private int ide_emp;
    private String ide_usu, prof_emp;
    private int doc_emp;
    private String nom_emp, ape_emp, perfil_emp, fecha_nac, ciudad_emp, dir_emp, corr_emp, tel_emp, estado_emp;
  
     // Constructor

    public EmpleadoVO(int ide_emp, String ide_usu, String prof_emp, int doc_emp, String nom_emp, String ape_emp, String perfil_emp, String fecha_nac, String ciudad_emp, String dir_emp, String corr_emp, String tel_emp, String estado_emp) {
        this.ide_emp = ide_emp;
        this.ide_usu = ide_usu;
        this.prof_emp = prof_emp;
        this.doc_emp = doc_emp;
        this.nom_emp = nom_emp;
        this.ape_emp = ape_emp;
        this.perfil_emp = perfil_emp;
        this.fecha_nac = fecha_nac;
        this.ciudad_emp = ciudad_emp;
        this.dir_emp = dir_emp;
        this.corr_emp = corr_emp;
        this.tel_emp = tel_emp;
        this.estado_emp = estado_emp;
    }

 
    public EmpleadoVO() {
    }
    
    //SET AND GET
    public EmpleadoVO(int ide_emp) {
        this.ide_emp = ide_emp;
    }

    public int getIde_emp() {
        return ide_emp;
    }

    public void setIde_emp(int ide_emp) {
        this.ide_emp = ide_emp;
    }

    public String  getIde_usu() {
        return ide_usu;
    }

    public void setIde_usu(String  ide_usu) {
        this.ide_usu = ide_usu;
    }

    public String getProf_emp() {
        return prof_emp;
    }

    public void setProf_emp(String prof_emp) {
        this.prof_emp = prof_emp;
    }

    public int getDoc_emp() {
        return doc_emp;
    }

    public void setDoc_emp(int doc_emp) {
        this.doc_emp = doc_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getApe_emp() {
        return ape_emp;
    }

    public void setApe_emp(String ape_emp) {
        this.ape_emp = ape_emp;
    }

    public String getPerfil_emp() {
        return perfil_emp;
    }

    public void setPerfil_emp(String perfil_emp) {
        this.perfil_emp = perfil_emp;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCiudad_emp() {
        return ciudad_emp;
    }

    public void setCiudad_emp(String ciudad_emp) {
        this.ciudad_emp = ciudad_emp;
    }

    public String getDir_emp() {
        return dir_emp;
    }

    public void setDir_emp(String dir_emp) {
        this.dir_emp = dir_emp;
    }

    public String getCorr_emp() {
        return corr_emp;
    }

    public void setCorr_emp(String corr_emp) {
        this.corr_emp = corr_emp;
    }

    public String getTel_emp() {
        return tel_emp;
    }

    public void setTel_emp(String tel_emp) {
        this.tel_emp = tel_emp;
    }

    public String getEstado_emp() {
        return estado_emp;
    }

    public void setEstado_emp(String estado_emp) {
        this.estado_emp = estado_emp;
    }
   
}
