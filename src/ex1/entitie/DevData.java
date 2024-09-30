/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1.entitie;

/**
 *
 * @author salam
 */
public class DevData {
    private String developpeurs;
    private String jour;
    private int nbscript;

    public DevData(String developpeurs, String jour, int nbscript) {
        this.developpeurs = developpeurs;
        this.jour = jour;
        this.nbscript = nbscript;
    }
    
    

    public String getDeveloppeurs() {
        return developpeurs;
    }

    public String getJour() {
        return jour;
    }

    public void setDeveloppeurs(String developpeurs) {
        this.developpeurs = developpeurs;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setNbscript(int nbscript) {
        this.nbscript = nbscript;
    }

    public int getNbscript() {
        return nbscript;
    }

    @Override
    public String toString() {
        return "DevData{" + "developpeurs=" + developpeurs + ", jour=" + jour + ", nbscript=" + nbscript + '}';
    }
    
    
    
    
}
