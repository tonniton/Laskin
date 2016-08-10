package drinkkikone;

import drinkkikone.graafinenkayttoliittyma.Kayttoliittyma;
import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import drinkkikone.tietokanta.Tiedostonlukija;
import drinkkikone.tietokanta.Tiedostoonkirjoittaja;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Kirjanpito kirjanpito = Kirjanpito.getInstance();
        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\koe.txt";
        Tiedostonlukija tl = new Tiedostonlukija(kirjanpito, polku);
        tl.lueTiedosto();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
        
        
//        File tiedosto = new File("tietokanta.txt");
//        Scanner lukija = new Scanner(tiedosto);
//        Tiedostonlukija tl = new Tiedostonlukija(tiedosto, lukija);
//        tl.lueTiedosto();
////        Kirjanpito tiedot = new Kirjanpito();
////        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\koe.txt";
////        Tiedostonlukija tl = new Tiedostonlukija(tiedot, polku);
////        tl.lueTiedosto();
////        Drinkki gt = new Drinkki("rommikola", "tarjoille jäillä");
////        gt.setAine(new Ainesosa("rommi", "4cl"));
////        gt.setAine(new Ainesosa("kola", "12cl"));
////        tiedot.setDrinkki(gt);
////        Tiedostoonkirjoittaja kirjoittaja = new Tiedostoonkirjoittaja(true, polku);
////        kirjoittaja.lisaaTiedostoon(gt);
////        for (Drinkki drinkki : tiedot.getDrinkit()) {
////            System.out.println(drinkki);
////        }
    }
}
