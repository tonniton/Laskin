/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Kirjanpito;
import drinkkikone.tietokanta.Tiedostonlukija;
import drinkkikone.tietokanta.Tiedostoonkirjoittaja;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 * 
 * Luokka lukee tiedostossa olevat drinkit käynnistyksen yhteydessä.
 * Sulkemisen yhteydessä luokka tyhjentää tiedoston ja kirjoittaa sen uudestaan päivitetyllä drinkkilistalla.
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
        polku = "src/main/resources/tietokanta.txt";
        try {
            lukija = new Tiedostonlukija(kirjanpito, polku);
        } catch (FileNotFoundException ex) {
        }
        try {
            kirjoittaja = new Tiedostoonkirjoittaja(false, polku);
        } catch (IOException ex) {
        }
    }
    

    @Override
    public void windowOpened(WindowEvent e) {
        lukija.lueTiedosto();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            kirjoittaja.lisaaTiedostoon(kirjanpito.getDrinkit());
        } catch (IOException ex) {
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
