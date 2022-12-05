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
public class ClienteVO {

    //Declarar Variables
    private int ide_cli; 
    private String ide_usu;
    private int doc_cli; 
    private String nom_cli, ape_cli, ciudad_cli, dir_cli, corr_cli, tel_cli , estado_cli;

    //Constructor 
    public ClienteVO(int ide_cli, String ide_usu, int doc_cli, String nom_cli, String ape_cli, String ciudad_cli, String dir_cli, String corr_cli, String tel_cli, String estado_cli) {
        this.ide_cli = ide_cli;
        this.ide_usu = ide_usu;
        this.doc_cli = doc_cli;
        this.nom_cli = nom_cli;
        this.ape_cli = ape_cli;
        this.ciudad_cli = ciudad_cli;
        this.dir_cli = dir_cli;
        this.corr_cli = corr_cli;
        this.tel_cli = tel_cli;
        this.estado_cli = estado_cli;
    }
      
    public ClienteVO() {
    }

    public ClienteVO(int ide_cli) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //SET AND GET
    public int getIde_cli() {
        return ide_cli;
    }

    public void setIde_cli(int ide_cli) {
        this.ide_cli = ide_cli;
    }

    public String  getIde_usu() {
        return ide_usu;
    }

    public void setIde_usu(String  ide_usu) {
        this.ide_usu = ide_usu;
    }

    public int getDoc_cli() {
        return doc_cli;
    }

    public void setDoc_cli(int doc_cli) {
        this.doc_cli = doc_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getApe_cli() {
        return ape_cli;
    }

    public void setApe_cli(String ape_cli) {
        this.ape_cli = ape_cli;
    }

    public String getCiudad_cli() {
        return ciudad_cli;
    }

    public void setCiudad_cli(String ciudad_cli) {
        this.ciudad_cli = ciudad_cli;
    }

    public String getDir_cli() {
        return dir_cli;
    }

    public void setDir_cli(String dir_cli) {
        this.dir_cli = dir_cli;
    }

    public String getCorr_cli() {
        return corr_cli;
    }

    public void setCorr_cli(String corr_cli) {
        this.corr_cli = corr_cli;
    }

    public String getTel_cli() {
        return tel_cli;
    }

    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

    public String getEstado_cli() {
        return estado_cli;
    }

    public void setEstado_cli(String estado_cli) {
        this.estado_cli = estado_cli;
    }   
    
}