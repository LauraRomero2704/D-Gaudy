
package Modelo;

/**
 * @author Laura
 */

public class CategoriaVO 
{

    // Declarar Variables
    private int ide_cat;
    private String nom_cat, estado_cat;
    
    
    public CategoriaVO() 
    {
    }

    //Constructor
    public CategoriaVO(int ide_cat, String nom_cat, String estado_cat) {
        this.ide_cat = ide_cat;
        this.nom_cat = nom_cat;
        this.estado_cat = estado_cat;
    }

    //SET AND GET
    public CategoriaVO(int ide_cat) {
        this.ide_cat = ide_cat;
    }


    public int getIde_cat() {
        return ide_cat;
    }

    public void setIde_cat(int ide_cat) {
        this.ide_cat = ide_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getEstado_cat() {
        return estado_cat;
    }

    public void setEstado_cat(String estado_cat) {
        this.estado_cat = estado_cat;
    }

}    