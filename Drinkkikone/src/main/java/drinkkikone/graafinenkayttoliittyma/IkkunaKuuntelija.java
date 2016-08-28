/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.Main;
import drinkkikone.osat.Kirjanpito;
import drinkkikone.tietokanta.Tiedostonlukija;
import drinkkikone.tietokanta.Tiedostoonkirjoittaja;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * Luokka lukee tiedostossa olevat drinkit käynnistyksen yhteydessä. Sulkemisen
 * yhteydessä luokka tyhjentää tiedoston ja kirjoittaa sen uudestaan
 * päivitetyllä drinkkilistalla.
 *
 * @author Viljami
 */
public class IkkunaKuuntelija implements WindowListener {

    private Kirjanpito kirjanpito;
    private JList lista;
    private String polku;
    private Tiedostonlukija lukija;
    private Tiedostoonkirjoittaja kirjoittaja;

    public IkkunaKuuntelija(JList lista) {
        kirjanpito = Kirjanpito.getInstance();
        this.lista = lista;
        try {
            //        polku = "src/main/resources/tietokannat/tietokanta.txt";
            polku = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "tietokannat/tietokanta.txt";
        } catch (URISyntaxException ex) {
            System.out.println("polku");
            Logger.getLogger(IkkunaKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            lukija = new Tiedostonlukija(kirjanpito, polku);
        } catch (FileNotFoundException ex) {
            System.out.println("open");
        }
        lukija.lueTiedosto();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            kirjoittaja = new Tiedostoonkirjoittaja(false, polku);
        } catch (IOException ex) {
            System.out.println("close");
        }
        try {
            kirjoittaja.lisaaTiedostoon(kirjanpito.getDrinkit());
        } catch (IOException ex) {
            System.out.println("close2");
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        kirjanpito.paivitaMahdolliset();
        lista.setListData(kirjanpito.getMahdolliset());
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

}
