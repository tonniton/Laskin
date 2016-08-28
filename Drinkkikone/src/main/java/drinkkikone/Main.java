package drinkkikone;

import drinkkikone.graafinenkayttoliittyma.Kayttoliittyma;
import java.io.File;
import java.net.URISyntaxException;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
//        String ohjelmanSuoritusPolku = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
//        System.out.println("Suorituspolku: " + ohjelmanSuoritusPolku);
//        File file = null;
//        file = new File(ohjelmanSuoritusPolku + "tietokannat/tietokanta.txt");
//        System.out.println("Kansisosa");
//        if (file.exists()) {
//            System.out.println("tiedosto löytyi!");
//        } else {
//            System.out.println("tiedosto ei löytynyt!");
//        }
        System.out.println(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
    }

}
