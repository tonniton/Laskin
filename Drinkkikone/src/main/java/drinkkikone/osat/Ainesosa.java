package drinkkikone.osat;

/**
 *
 * @author Viljami
 */
public class Ainesosa {

    private String nimi;
    private String maara;

    /**
     *
     * @param nimi
     */
    public Ainesosa(String nimi) {
        this.nimi = nimi;
        this.maara = "";
    }

    /**
     *
     * @param nimi
     * @param maara
     */
    public Ainesosa(String nimi, String maara) {
        this.nimi = nimi;
        this.maara = maara;
    }

    /**
     *
     * @return
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *
     * @return
     */
    public String getMaara() {
        return maara;
    }

    /**
     *
     * @param maara
     */
    public void setMaara(String maara) {
        this.maara = maara;
    }

    @Override
    public String toString() {
        return nimi + " " + maara;
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
