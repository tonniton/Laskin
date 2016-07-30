package drinkkikone.osat;

import java.util.ArrayList;

public class Kirjanpito {

    private ArrayList<Ainesosa> osat;
    private ArrayList<Drinkki> drinkit;

    public Kirjanpito() {
        this.osat = new ArrayList();
        this.drinkit = new ArrayList();
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

}
