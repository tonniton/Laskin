package drinkkikone.osat;

import java.util.ArrayList;
import java.util.Vector;

public class Kirjanpito {
    private static Kirjanpito kirjanpito;
    private Vector<Ainesosa> osat;
    private Vector<Drinkki> drinkit;

    public Kirjanpito() {
        this.osat = new Vector();
        this.drinkit = new Vector();
    }

    public void poistaOsa(String nimi) {
        Ainesosa osa = new Ainesosa(nimi);
        if (osat.contains(osa)) {
            osat.remove(osa);
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

    public boolean onnistuukoDrinkki(Drinkki drinkki) {
        for (Ainesosa osa : drinkki.getAineet()) {
            if (!osat.contains(osa)) {
                return false;
            }
        }
        return true;
    }
    
    public static Kirjanpito getInstance() {
      if(kirjanpito == null) {
         kirjanpito = new Kirjanpito();
      }
      return kirjanpito;
   }
}
