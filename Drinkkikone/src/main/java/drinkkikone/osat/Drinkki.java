/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.osat;

import java.util.ArrayList;

/**
 *
 * @author Viljami
 */
public class Drinkki {
    
    private String nimi;
    private ArrayList<Ainesosa> aineet;
    private String resepti;

    public Drinkki(String nimi, String resepti) {
        this.nimi = nimi;
        this.aineet = new ArrayList();
        this.resepti = resepti;
    }
    
    
}
