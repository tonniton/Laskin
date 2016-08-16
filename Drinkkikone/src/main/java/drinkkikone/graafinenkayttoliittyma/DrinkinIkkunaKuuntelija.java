/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JList;

/**
 *
 * @author Viljami
 */
public class DrinkinIkkunaKuuntelija implements WindowListener {
    private Kirjanpito kirjanpito;
    private JList lista;

    public DrinkinIkkunaKuuntelija(JList lista) {
        kirjanpito = Kirjanpito.getInstance();
        this.lista = lista;
    }
    

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        kirjanpito.paivitaMahdolliset();
        lista.setListData(kirjanpito.getMahdolliset());
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
    
}
