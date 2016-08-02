/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Viljami
 */
public class Tiedostoonkirjoittaja {
    OutputStreamWriter kirjoittaja;

    public Tiedostoonkirjoittaja() throws IOException {
        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\koe.txt";
        kirjoittaja = new OutputStreamWriter(new FileOutputStream(polku, true),"UTF-8");
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
