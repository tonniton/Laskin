package drinkkikone.osat;

import java.util.ArrayList;

public class Drinkki {

    private String nimi;
    private ArrayList<Ainesosa> aineet;
    private String resepti;

    public Drinkki(String nimi, String resepti) {
        this.nimi = nimi;
        this.aineet = new ArrayList();
        this.resepti = resepti;
    }

    public String getNimi() {
        return nimi;
    }

    public String getResepti() {
        return resepti;
    }

    public void setAine(Ainesosa aine) {
        this.aineet.add(aine);
    }

    public ArrayList<Ainesosa> getAineet() {
        return aineet;
    }

    @Override
    public String toString() {
        String palaute = nimi + "\n";
        for (Ainesosa aine : aineet) {
            palaute += aine.toString() + "\n";
        }
        return palaute + resepti;
    }

    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }
        if (getClass() != olio.getClass()) {
            return false;
        }
        Drinkki verrattava = (Drinkki) olio;
        if (this.nimi == null || !this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        return true;
    }

}
