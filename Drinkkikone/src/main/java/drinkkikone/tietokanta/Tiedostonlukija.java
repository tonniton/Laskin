package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * Luokka lukee tiedostosta sinne kirjoitetut drinkit.
 *
 * @author Viljami
 */
public class Tiedostonlukija {

    private File tiedosto;
    private Scanner lukija;
    private Kirjanpito kirjanpito;

    /**
     * fth
     *
     * @param kirjanpito kirjanpito olio
     * @param polku luettavan tiedoston sijainti
     * @throws FileNotFoundException
     */
    public Tiedostonlukija(Kirjanpito kirjanpito, String polku) throws FileNotFoundException {
        this.tiedosto = new File(polku);
        this.lukija = new Scanner(tiedosto, "UTF-8");
        this.kirjanpito = kirjanpito;
    }

    /**
     * 
     * Lukee tiedostossa olevat drinkit ja siirtää tiedot kirjanpito-olioon.
     *
     */
    public void lueTiedosto() {
        while (lukija.hasNextLine()) {
            Drinkki drinkki = lisaaDrinkki();
            lisaaAineet(drinkki);
            kirjanpito.addDrinkki(drinkki);
        }
        lukija.close();
    }

    private Drinkki lisaaDrinkki() {
        String rivi = lukija.nextLine();
        String[] sanat = rivi.split("#");
        return new Drinkki(sanat[0], sanat[1]);
    }

    private void lisaaAineet(Drinkki drinkki) {
        String rivi = lukija.nextLine();
        while (!rivi.isEmpty()) {
            String[] sanat = rivi.split("#");
            boolean tarkea = onkoTarkea(sanat[2]);
            drinkki.setAine(new Ainesosa(sanat[0], sanat[1], tarkea));
            if (!lukija.hasNextLine()) {
                break;
            }
            rivi = lukija.nextLine();
        }
    }
    
    private boolean onkoTarkea(String onko) {
        if (onko.equals("true")) {
            return true;
        }
        return false;
    }
}
