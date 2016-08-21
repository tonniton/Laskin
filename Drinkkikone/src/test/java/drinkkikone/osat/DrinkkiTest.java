/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.osat;

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
public class DrinkkiTest {
    
    Drinkki drinkki;
    
    public DrinkkiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        drinkki = new Drinkki("gt", "sekoita");
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
    public void asettaaNimenOikein() {
        assertEquals("gt", drinkki.getNimi());
    }

    @Test
    public void asettaaReseptinOikein() {
        assertEquals("sekoita", drinkki.getResepti());
    }
    
    @Test
    public void toStringOikein() {
        assertEquals("gt" + "\n\n\n" + "sekoita", drinkki.toString());
    }
    
    @Test
    public void toStringAineellaOikein() {
        Ainesosa osa = new Ainesosa("gin", "4cl", true);
        drinkki.setAine(osa);
        assertEquals("gt" + "\n\n" + "gin 4cl" + "\n\n" + "sekoita", drinkki.toString());
    }
    
    @Test
    public void equalsOikein() {
        Drinkki drinkki2 = new Drinkki("gt", "sekoita");
        assertEquals(drinkki.equals(drinkki2), true);
        assertEquals(drinkki.equals(null), false);
        assertEquals(drinkki.equals(new String()), false);
        Drinkki drinkki3 = new Drinkki("aa", "sekoita");
        assertEquals(drinkki.equals(drinkki3), false);
    }
}
