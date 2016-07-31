package drinkkikone.osat;

public class Ainesosa {

    private String nimi;
    private String maara;

    public Ainesosa(String nimi) {
        this.nimi = nimi;
        this.maara = "";
    }

    public Ainesosa(String nimi, String maara) {
        this.nimi = nimi;
        this.maara = maara;
    }

    public String getNimi() {
        return nimi;
    }

    public String getMaara() {
        return maara;
    }

    public void setMaara(String maara) {
        this.maara = maara;
    }

    @Override
    public String toString() {
        return nimi + " " + maara;
    }

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
