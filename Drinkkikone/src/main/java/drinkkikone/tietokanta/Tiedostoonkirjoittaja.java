package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Tiedostoonkirjoittaja {
    OutputStreamWriter kirjoittaja;

    public Tiedostoonkirjoittaja(boolean sailyykoVanha) throws IOException {
        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\tietokanta.txt";
        kirjoittaja = new OutputStreamWriter(new FileOutputStream(polku, sailyykoVanha),"UTF-8");
    }

    public void lisaaTiedostoon(Drinkki drinkki) throws IOException {
        kirjoittaja.write(drinkki.getNimi() + "#" + drinkki.getResepti() + "\n");
        for (Ainesosa osa : drinkki.getAineet()) {
            kirjoittaja.write(osa.getNimi() + "#" + osa.getMaara() + "\n");
        }
        kirjoittaja.write("\n");
        kirjoittaja.close();
    }
}
