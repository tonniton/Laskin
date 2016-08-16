/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Viljami
 */
public class Drinkinkuuntelija implements ActionListener {

    private Container container;
    private JButton lisaaNappi;
    private Kirjanpito kirjanpito;

    public Drinkinkuuntelija(Container container) {
        this.container = container;
        lisaaNappi = (JButton) container.getComponent(45);
        this.kirjanpito = Kirjanpito.getInstance();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lisaaNappi) {
            lisaaDrinkki();
        }
    }
    
    public void lisaaDrinkki() {
        String nimi = ((JTextField) container.getComponent(1)).getText();
        String resepti = ((JTextField) container.getComponent(3)).getText();
        if (nimi.isEmpty() || resepti.isEmpty()) {
            return;
        }
        Drinkki drinkki = new Drinkki(nimi, resepti);
        for (int i = 6; i < 44; i += 4) {
            String osanimi = ((JTextField) container.getComponent(i)).getText();
            String maara = ((JTextField) container.getComponent(i + 1)).getText();
            if (osanimi.isEmpty() || maara.isEmpty()) {
                break;
            }
            drinkki.setAine(new Ainesosa(osanimi, maara));
        }
        kirjanpito.setDrinkki(drinkki);
        tyhjennaTekstit();
    }
    
    public void tyhjennaTekstit() {
        ((JTextField) container.getComponent(1)).setText("");
        ((JTextField) container.getComponent(3)).setText("");
        for (int i = 6; i < 44; i += 4) {
            ((JTextField) container.getComponent(i)).setText("");
            ((JTextField) container.getComponent(i + 1)).setText("");
        }
    }
}
