/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tietokanta;

import drinkkikone.osat.Kirjanpito;
import java.io.FileNotFoundException;
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
public class TiedostonlukijaTest {

    Tiedostonlukija lukija;
    Kirjanpito kirjanpito;
    String polku;

    public TiedostonlukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FileNotFoundException {
        kirjanpito = new Kirjanpito();
        polku = "src/main/resources/testi.txt";
        lukija = new Tiedostonlukija(kirjanpito, polku);
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
    public void lukee() {
        lukija.lueTiedosto();
        assertEquals(kirjanpito.getDrinkit().get(0).getNimi(), "rommikola");
        assertEquals(kirjanpito.getDrinkit().get(0).getResepti(), "sekoita");
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(0).getNimi(), "rommi");
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(0).getMaara(), "4cl");
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(1).getNimi(), "kola");
        assertEquals(kirjanpito.getDrinkit().get(0).getAineet().get(1).getMaara(), "12cl");
    }

}
