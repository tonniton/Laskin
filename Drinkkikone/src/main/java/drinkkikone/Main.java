package drinkkikone;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Baarikaappi;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import drinkkikone.tietokanta.Tiedostonlukija;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
//        File tiedosto = new File("tietokanta.txt");
//        Scanner lukija = new Scanner(tiedosto);
//        Tiedostonlukija tl = new Tiedostonlukija(tiedosto, lukija);
//        tl.lueTiedosto();
        Kirjanpito tiedot = new Kirjanpito();
        Tiedostonlukija tl = new Tiedostonlukija(tiedot);
        tl.lueTiedosto();
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
