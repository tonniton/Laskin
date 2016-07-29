/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.osat;

/**
 *
 * @author Viljami
 */
public class Ainesosa {
    
    private String nimi;
    private String maara;

    public Ainesosa(String nimi) {
        this.nimi = nimi;
        this.maara = "";
    }

    public void setMaara(String maara) {
        this.maara = maara;
    }

    @Override
    public String toString() {
        return nimi + " " + maara;
    }
    
    
    
    
}
