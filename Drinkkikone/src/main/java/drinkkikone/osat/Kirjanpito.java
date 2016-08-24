package drinkkikone.osat;

import java.util.Vector;

/**
 * 
 * Luokka pitää kirjaa käytössä olevista ainesosista ja mahdollisista drinkeistä.
 *
 * @author Viljami
 */
public class Kirjanpito {
    private static Kirjanpito kirjanpito;
    private Vector<Ainesosa> osat;
    private Vector<Drinkki> drinkit;
    private Vector<Drinkki> mahdolliset;

    /**
     *
     */
    public Kirjanpito() {
        this.osat = new Vector();
        this.drinkit = new Vector();
        this.mahdolliset = new Vector();
    }

    /**
     * 
     * Poistaa parametrina annetun ainesosan nimisen ainesosan jos mahdollista.
     *
     * @param nimi ainesosan nimi
     */
    public void poistaOsa(String nimi) {
        Ainesosa osa = new Ainesosa(nimi);
        if (osat.contains(osa)) {
            osat.remove(osa);
        }
    }
    
    /**
     * 
     * Poistaa parametrina annetun drinkin nimisen drinkin jos mahdollista.
     *
     * @param nimi drinkin nimi
     */
    public void poistaDrinkki(String nimi) {
        Drinkki drinkki = new Drinkki(nimi, "");
        if (drinkit.contains(drinkki)) {
            drinkit.remove(drinkki);
        }
    }

    /**
     *
     * @param drinkki lisattava drinkki
     */
    public void addDrinkki(Drinkki drinkki) {
        this.drinkit.add(drinkki);
    }

    /**
     *
     * @param osa lisattava ainesosa
     */
    public void addOsa(Ainesosa osa) {
        this.osat.add(osa);
    }

    /**
     *
     * @return listan drinkeistä
     */
    public Vector<Drinkki> getDrinkit() {
        return drinkit;
    }

    /**
     *
     * @return listan ainesosista
     */
    public Vector<Ainesosa> getOsat() {
        return osat;
    }

    /**
     *
     * @return listan drinkeista, jotka voidaan tehdä
     */
    public Vector<Drinkki> getMahdolliset() {
        return mahdolliset;
    }

    /**
     *
     * @param drinkki tutkittava drinkki
     * @return voiko drinkin tehdä
     */
    public boolean onnistuukoDrinkki(Drinkki drinkki) {
        for (Ainesosa osa : drinkki.getAineet()) {
            if (!osat.contains(osa) && osa.isTarkea()) {
                return false;
            }
        }
        return true;
    }
    
    /**
     *
     * Päivittää tilanteen mahdollisista drinkeistä.
     * 
     */
    public void paivitaMahdolliset() {
        mahdolliset.clear();
        for (Drinkki drinkki : drinkit) {
            if (onnistuukoDrinkki(drinkki)) {
                mahdolliset.add(drinkki);
            }
        }
    }
    
    /**
     * 
     * luo uuden kirjanpito olion jos sellaista ei vielä ole ja palauttaa sen.
     *
     * @return kirjanpito olio
     */
    public static Kirjanpito getInstance() {
      if(kirjanpito == null) {
         kirjanpito = new Kirjanpito();
      }
      return kirjanpito;
    }
}
