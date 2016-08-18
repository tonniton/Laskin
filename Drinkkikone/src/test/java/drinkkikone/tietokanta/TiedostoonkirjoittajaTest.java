/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tietokanta;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viljami
 */
public class TiedostoonkirjoittajaTest {
    
    Tiedostonlukija lukija;
    Kirjanpito kirjanpito;
    String polku;
    Tiedostoonkirjoittaja kirjoittaja;
    
    public TiedostoonkirjoittajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws FileNotFoundException, IOException {
        kirjanpito = new Kirjanpito();
        polku = "src/main/resources/testi2.txt";
        lukija = new Tiedostonlukija(kirjanpito, polku);
        kirjoittaja = new Tiedostoonkirjoittaja(false, polku);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
     @Test
     public void toimiikoKirjoitus() throws IOException {
        Drinkki gt = new Drinkki("gin & tonic", "tarjoille jäillä");
        gt.setAine(new Ainesosa("gin", "4cl"));
        gt.setAine(new Ainesosa("tonic", "12cl"));
        Vector<Drinkki> drinkit = new Vector();
        drinkit.add(gt);
        kirjoittaja.lisaaTiedostoon(drinkit);
        lukija.lueTiedosto();
        assertEquals(kirjanpito.getDrinkit().get(0).getNimi(), gt.getNimi());
        assertEquals(kirjanpito.getDrinkit().get(0).getResepti(), gt.getResepti());
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(0).getNimi(), gt.getAineet().get(0).getNimi());
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(0).getMaara(), gt.getAineet().get(0).getMaara());
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(1).getNimi(), gt.getAineet().get(1).getNimi());
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(1).getMaara(), gt.getAineet().get(1).getMaara());
     }
}
