package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Vector;

/**
 * 
 * Luokka kirjoittaa tiedostoon listan drinkkejä
 *
 * @author Viljami
 */
public class Tiedostoonkirjoittaja {
    OutputStreamWriter kirjoittaja;

    /**
     *
     * @param sailyykoVanha boolean joka päättää poistetaanko tiedoston alkuperäinen tieto sinne kirjoittaessa
     * @param polku kertoo tiedoston sijainnin
     * @throws IOException
     */
    public Tiedostoonkirjoittaja(boolean sailyykoVanha, String polku) throws IOException {
        kirjoittaja = new OutputStreamWriter(new FileOutputStream(polku, sailyykoVanha),"UTF-8");
    }

    /**
     *
     * Kirjoittaa drinkit tiedostoon.
     * 
     * @param drinkit lista drinkkejä
     * @throws IOException
     */
    public void lisaaTiedostoon(Vector <Drinkki> drinkit) throws IOException {
        for (Drinkki drinkki : drinkit) {
            lisaaDrinkki(drinkki);
        }
        kirjoittaja.close();
    }

    private void lisaaDrinkki(Drinkki drinkki) throws IOException {
        kirjoittaja.write(drinkki.getNimi() + "#" + drinkki.getResepti() + "\n");
        for (Ainesosa osa : drinkki.getAineet()) {
            kirjoittaja.write(osa.getNimi() + "#" + osa.getMaara() + "#" + osa.isTarkea() + "\n");
        }
        kirjoittaja.write("\n");
    }

    /**
     *
     * @return 
     */
    public OutputStreamWriter getKirjoittaja() {
        return kirjoittaja;
    }
    
    
}
