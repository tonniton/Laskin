/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.osat;

import java.util.ArrayList;
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
public class KirjanpitoTest {
    
    Kirjanpito kirjanpito;
    Drinkki gt;
    
    public KirjanpitoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kirjanpito = new Kirjanpito();
        gt = new Drinkki("gin & tonic", "sekoita");
        gt.setAine(new Ainesosa("gin", "4cl"));
        gt.setAine(new Ainesosa("tonic", "12cl"));
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
    public void AlustaaMuuttujatOikein() {
        assertEquals(new ArrayList(), kirjanpito.getDrinkit());
        assertEquals(new ArrayList(), kirjanpito.getOsat());
    }
    
    @Test
    public void OnnistuukoDrinkkiIlmanAineita() {
        assertEquals(kirjanpito.onnistuukoDrinkki(gt), false);
    }
    
    @Test
    public void OnnistuukoDrinkkiOsallaAineista() {
        kirjanpito.addOsa(new Ainesosa("gin"));  
        assertEquals(kirjanpito.onnistuukoDrinkki(gt), false);
    }
    
    @Test
    public void OnnistuukoDrinkkiKaikillaAineilla() {
        kirjanpito.addOsa(new Ainesosa("gin"));
        kirjanpito.addOsa(new Ainesosa("tonic"));
        assertEquals(kirjanpito.onnistuukoDrinkki(gt), true);
    }
    
    @Test
    public void OnnistuukoOsanPoisto() {
        Ainesosa osa = new Ainesosa("gin");
        kirjanpito.addOsa(osa);
        kirjanpito.poistaOsa("gin");
        assertEquals(kirjanpito.getOsat().contains(osa), false);
    }
    
    @Test
    public void OnnistuukoDrinkinPoisto() {
        kirjanpito.addDrinkki(gt);
        kirjanpito.poistaDrinkki("gin & tonic");
        assertEquals(kirjanpito.getDrinkit().isEmpty(), true);
    }
    
    @Test
    public void paivitaMahdolliset() {
        kirjanpito.addOsa(new Ainesosa("gin"));
        kirjanpito.addOsa(new Ainesosa("tonic"));
        kirjanpito.addDrinkki(gt);
        kirjanpito.paivitaMahdolliset();
        assertEquals(kirjanpito.getMahdolliset().get(0), gt);
    }
    
//    @Test
//    public void OnnistuukoInstance() {
//        Kirjanpito kirjanpito2;
//        kirjanpito2 = Kirjanpito.getInstance();
//        assertEquals(kirjanpito2, new Kirjanpito());
//    }
}
