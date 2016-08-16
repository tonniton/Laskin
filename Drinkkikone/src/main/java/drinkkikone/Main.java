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
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException, InvocationTargetException {
        Kirjanpito kirjanpito = Kirjanpito.getInstance();
        String polku = "C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\tietokanta.txt";
        Tiedostonlukija tl = new Tiedostonlukija(kirjanpito, polku);
        tl.lueTiedosto();
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        kayttoliittyma.run();
//        SwingUtilities.invokeLater(kayttoliittyma);
////        Tiedostoonkirjoittaja kirjoittaja = new Tiedostoonkirjoittaja(false, polku);
////        kirjoittaja.lisaaTiedostoon(kirjanpito.getDrinkit());
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
//            System.out.println("In shutdown hook");
        Tiedostoonkirjoittaja kirjoittaja = null;
            try {
                kirjoittaja = new Tiedostoonkirjoittaja(false, polku);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                kirjoittaja.lisaaTiedostoon(kirjanpito.getDrinkit());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }, "Shutdown-thread"));
        
        
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
