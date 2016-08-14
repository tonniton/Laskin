package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Tiedostoonkirjoittaja {
    OutputStreamWriter kirjoittaja;

    public Tiedostoonkirjoittaja(boolean sailyykoVanha, String polku) throws IOException {
        kirjoittaja = new OutputStreamWriter(new FileOutputStream(polku, sailyykoVanha),"UTF-8");
    }

    public void lisaaTiedostoon(Vector <Drinkki> drinkit) throws IOException {
        for (Drinkki drinkki : drinkit) {
            lisaaDrinkki(drinkki);
        }
        kirjoittaja.close();
    }
    
    public void lisaaDrinkki(Drinkki drinkki) throws IOException {
        kirjoittaja.write(drinkki.getNimi() + "#" + drinkki.getResepti() + "\n");
        for (Ainesosa osa : drinkki.getAineet()) {
            kirjoittaja.write(osa.getNimi() + "#" + osa.getMaara() + "\n");
        }
        kirjoittaja.write("\n");
    }

    public OutputStreamWriter getKirjoittaja() {
        return kirjoittaja;
    }
    
    
}
