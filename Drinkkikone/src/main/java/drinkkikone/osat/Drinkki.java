package drinkkikone.osat;

import java.util.ArrayList;

/**
 *
 * Luo rakenteen drinkkikoneessa käytettäville drinkeille.
 *
 * @author Viljami
 */
public class Drinkki {

    private final String nimi;
    private final ArrayList<Ainesosa> aineet;
    private final String resepti;

    /**
     *
     * @param nimi drinkin nimi
     * @param resepti drinkin teko-ohjeet
     */
    public Drinkki(String nimi, String resepti) {
        this.nimi = nimi;
        this.aineet = new ArrayList();
        this.resepti = resepti;
    }

    /**
     *
     * @return drinkin nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *
     * @return drinkin resepti
     */
    public String getResepti() {
        return resepti;
    }

    /**
     *
     * @param aine drinkissä käytettävä aine
     */
    public void setAine(Ainesosa aine) {
        this.aineet.add(aine);
    }

    /**
     *
     * @return kaikki drinkkiin tarvittavat aineet
     */
    public ArrayList<Ainesosa> getAineet() {
        return aineet;
    }

    @Override
    public String toString() {
        String palaute = nimi + "\n\n";
        for (Ainesosa aine : aineet) {
            palaute += aine.toString() + "\n";
        }
        return palaute + "\n" + resepti;
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
