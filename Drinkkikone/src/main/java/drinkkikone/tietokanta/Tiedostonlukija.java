/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Viljami
 */
public class Tiedostonlukija {
    private File tiedosto;
    private Scanner lukija;
    private Kirjanpito kirjanpito;

    public Tiedostonlukija(Kirjanpito kirjanpito) throws FileNotFoundException {
        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\koe.txt";
        this.tiedosto = new File(polku);
        this.lukija = new Scanner(tiedosto, "UTF-8");
        this.kirjanpito = kirjanpito;
    }

    public void lueTiedosto() {
        while (lukija.hasNextLine()) {
            Drinkki drinkki = lisaaDrinkki();
            lisaaAineet(drinkki);
            kirjanpito.setDrinkki(drinkki);
        }
        lukija.close();
    }
    
    public Drinkki lisaaDrinkki() {
        String rivi = lukija.nextLine();
        String[] sanat = rivi.split(",");
        return new Drinkki(sanat[0], sanat[1]);
    }
    
    public void lisaaAineet(Drinkki drinkki) {
        String rivi = lukija.nextLine();
        while (!rivi.isEmpty()) {
            String[] sanat = rivi.split(",");
            drinkki.setAine(new Ainesosa(sanat[0], sanat[1]));
            if (!lukija.hasNextLine()) break;
            rivi = lukija.nextLine();
        } 
    }
    
//    public void lueTiedosto() {
//        while (lukija.hasNextLine()) {
//            String rivi = lukija.nextLine();
//            String[] sanat = rivi.split(",");
//            Drinkki drinkki = new Drinkki(sanat[0], sanat[1]);
//            kirjanpito.setDrinkki(drinkki);
//            rivi = lukija.nextLine();
//            System.out.println(rivi);
//            while (!rivi.isEmpty()) {
//                sanat = rivi.split(",");
//                drinkki.setAine(new Ainesosa(sanat[0], sanat[1]));
//                if (!lukija.hasNextLine()) break;
//                rivi = lukija.nextLine();
//            } 
//        }
//        lukija.close();
//    }
    
    
}
