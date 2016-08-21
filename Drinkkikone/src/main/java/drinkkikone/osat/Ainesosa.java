package drinkkikone.osat;

/**
 *
 * Luo rakenteen drinkeissä käytetäville juomille 
 * 
 * @author Viljami
 */
public class Ainesosa {

    private String nimi;
    private String maara;
    private boolean tarkea;

    /**
     *
     * @param nimi ainesosan nimi
     */
    public Ainesosa(String nimi) {
        this.nimi = nimi;
        this.maara = "";
    }

    /**
     *
     * @param nimi ainesosan nimi
     * @param maara ainesosan määrä
     */
    public Ainesosa(String nimi, String maara) {
        this.nimi = nimi;
        this.maara = maara;
    }

    public Ainesosa(String nimi, String maara, boolean tarkea) {
        this.nimi = nimi;
        this.maara = maara;
        this.tarkea = tarkea;
    }

    public boolean isTarkea() {
        return tarkea;
    }

    /**
     *
     * @return ainesosan nimi
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *
     * @return ainesosan määrä
     */
    public String getMaara() {
        return maara;
    }

    /**
     *
     * @param maara ainesosan määrä
     */
    public void setMaara(String maara) {
        this.maara = maara;
    }

    @Override
    public String toString() {
        String palaute = nimi + " " + maara;
        if (!tarkea) {
            palaute += " (valinnainen)";
        }
        return palaute;
    }

    @Override
    public boolean equals(Object olio) {
        if (olio == null) {
            return false;
        }
        if (getClass() != olio.getClass()) {
            return false;
        }
        Ainesosa verrattava = (Ainesosa) olio;
        if (this.nimi == null || !this.nimi.equals(verrattava.getNimi())) {
            return false;
        }
        return true;
    }
}
