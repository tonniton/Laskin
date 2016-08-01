package drinkkikone.osat;

import java.util.ArrayList;

public class Kirjanpito {

    private ArrayList<Ainesosa> osat;
    private ArrayList<Drinkki> drinkit;

    public Kirjanpito() {
        this.osat = new ArrayList();
        this.drinkit = new ArrayList();
    }

    public void poistaOsa(String nimi) {
        Ainesosa osa = new Ainesosa(nimi);
        if (osat.contains(osa)) osat.remove(osa);
    }

    public void setDrinkki(Drinkki drinkki) {
        this.drinkit.add(drinkki);
    }

    public void setOsa(Ainesosa osa) {
        this.osat.add(osa);
    }

    public ArrayList<Drinkki> getDrinkit() {
        return drinkit;
    }

    public ArrayList<Ainesosa> getOsat() {
        return osat;
    }

    public boolean onnistuukoDrinkki(Drinkki drinkki) {
        for (Ainesosa osa : drinkki.getAineet()) {
            if (!osat.contains(osa)) return false;
        }
        return true;
    }
    
    public void luoDrinkit() {
        Drinkki gt = new Drinkki("gin & tonic", "sekoita");
        gt.setAine(new Ainesosa("gin", "4cl"));
        gt.setAine(new Ainesosa("tonic", "12cl"));
        setDrinkki(gt);
    }
}
