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
public class AinesosaTest {

    Ainesosa osa;
    Ainesosa osa2;

    public AinesosaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        osa = new Ainesosa("gin");
        osa2 = new Ainesosa("tonic", "12cl");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    }

    @Test
    public void asettaaNimenOikein() {
        assertEquals("gin", osa.getNimi());
        assertEquals("tonic", osa2.getNimi());
    }

    @Test
    public void asettaaMaaranOikein() {
        assertEquals("", osa.getMaara());
        assertEquals("12cl", osa2.getMaara());
    }
    
    @Test
    public void toStringOikein() {
        assertEquals("gin ", osa.toString());
        assertEquals("tonic 12cl", osa2.toString());
    }
}
