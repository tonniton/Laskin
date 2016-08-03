package drinkkikone;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import drinkkikone.tietokanta.Tiedostonlukija;
import drinkkikone.tietokanta.Tiedostoonkirjoittaja;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        File tiedosto = new File("tietokanta.txt");
//        Scanner lukija = new Scanner(tiedosto);
//        Tiedostonlukija tl = new Tiedostonlukija(tiedosto, lukija);
//        tl.lueTiedosto();
        Kirjanpito tiedot = new Kirjanpito();
        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\koe.txt";
        Tiedostonlukija tl = new Tiedostonlukija(tiedot, polku);
        tl.lueTiedosto();
        Drinkki gt = new Drinkki("rommikola", "tarjoille jäillä");
        gt.setAine(new Ainesosa("rommi", "4cl"));
        gt.setAine(new Ainesosa("kola", "12cl"));
        tiedot.setDrinkki(gt);
        Tiedostoonkirjoittaja kirjoittaja = new Tiedostoonkirjoittaja(true);
        kirjoittaja.lisaaTiedostoon(gt);
        for (Drinkki drinkki : tiedot.getDrinkit()) {
            System.out.println(drinkki);
        }
        
//
//        tiedot.setOsa(new Ainesosa("gin"));
//        tiedot.setOsa(new Ainesosa("tonic"));
//        
//        tiedot.poistaOsa("gin");
//        for (Ainesosa osa : tiedot.getOsat()) {
//            System.out.println(osa.toString());
//        }
//
//        Drinkki gt = new Drinkki("gin & tonic", "sekoita");
//        gt.setAine(new Ainesosa("gin", "4cl"));
//        gt.setAine(new Ainesosa("tonic", "12cl"));
//        tiedot.setDrinkki(gt);

//        System.out.println(gt.toString());
//        System.out.println("");
//        System.out.println(tiedot.getDrinkit().get(0));
//        System.out.println("");
    }
}
