package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * soghdagerhgöih
 * @author Viljami
 */
public class Tiedostonlukija {
    private File tiedosto;
    private Scanner lukija;
    private Kirjanpito kirjanpito;

    /**
     * fth
     * @param kirjanpito
     * @throws FileNotFoundException 
     */
    public Tiedostonlukija(Kirjanpito kirjanpito, String polku) throws FileNotFoundException {
        this.tiedosto = new File(polku);
        this.lukija = new Scanner(tiedosto, "UTF-8");
        this.kirjanpito = kirjanpito;
    }

    /**
     * 
     */
    public void lueTiedosto() {
        while (lukija.hasNextLine()) {
            Drinkki drinkki = lisaaDrinkki();
            lisaaAineet(drinkki);
            kirjanpito.setDrinkki(drinkki);
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
            drinkki.setAine(new Ainesosa(sanat[0], sanat[1]));
            if (!lukija.hasNextLine()) break;
            rivi = lukija.nextLine();
        } 
    }

//    public void lueTiedosto() {
//        while (lukija.hasNextLine()) {
//            String rivi = lukija.nextLine();
//            String[] sanat = rivi.split("#");
//            Drinkki drinkki = new Drinkki(sanat[0], sanat[1]);
//            kirjanpito.setDrinkki(drinkki);
//            rivi = lukija.nextLine();
//            System.out.println(rivi);
//            while (!rivi.isEmpty()) {
//                sanat = rivi.split("#");
//                drinkki.setAine(new Ainesosa(sanat[0], sanat[1]));
//                if (!lukija.hasNextLine()) break;
//                rivi = lukija.nextLine();
//            } 
//        }
//        lukija.close();
//    }
    
    
}
