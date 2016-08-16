package drinkkikone.osat;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import javax.swing.ListModel;

public class Kirjanpito {
    private static Kirjanpito kirjanpito;
    private Vector<Ainesosa> osat;
    private Vector<Drinkki> drinkit;
    private Vector<Drinkki> mahdolliset;

    public Kirjanpito() {
        this.osat = new Vector();
        this.drinkit = new Vector();
        this.mahdolliset = new Vector();
    }

    public void poistaOsa(String nimi) {
        Ainesosa osa = new Ainesosa(nimi);
        if (osat.contains(osa)) {
            osat.remove(osa);
        }
    }
    
    public void poistaDrinkki(String nimi) {
        Drinkki drinkki = new Drinkki(nimi, "");
        if (drinkit.contains(drinkki)) {
            drinkit.remove(drinkki);
        }
    }

    public void setDrinkki(Drinkki drinkki) {
        this.drinkit.add(drinkki);
    }

    public void setOsa(Ainesosa osa) {
        this.osat.add(osa);
    }

    public Vector<Drinkki> getDrinkit() {
        return drinkit;
    }

    public Vector<Ainesosa> getOsat() {
        return osat;
    }

    public Vector<Drinkki> getMahdolliset() {
        return mahdolliset;
    }

    public boolean onnistuukoDrinkki(Drinkki drinkki) {
        for (Ainesosa osa : drinkki.getAineet()) {
            if (!osat.contains(osa)) {
                return false;
            }
        }
        return true;
    }
    
    public void paivitaMahdolliset() {
        mahdolliset.clear();
        for (Drinkki drinkki : drinkit) {
            if (onnistuukoDrinkki(drinkki)) {
                mahdolliset.add(drinkki);
            }
        }
    }
    
    public static Kirjanpito getInstance() {
      if(kirjanpito == null) {
         kirjanpito = new Kirjanpito();
      }
      return kirjanpito;
    }
}
