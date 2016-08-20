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
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * Luokka kuuntelee drinkin lisäys nappia.
 * 
 * @author Viljami
 */
public class Drinkinkuuntelija implements ActionListener {

    private Container container;
    private JButton lisaaNappi;
    private Kirjanpito kirjanpito;

    /**
     *
     * @param container käytössä oleva container olio.
     */
    public Drinkinkuuntelija(Container container) {
        this.container = container;
        lisaaNappi = (JButton) container.getComponent(68);
        this.kirjanpito = Kirjanpito.getInstance();
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lisaaNappi) {
            lisaaDrinkki();
        }
    }
    
    /**
     *
     * Lisää drinkin syötetietojen perusteella ja tyhjentää sen jälkeen syöte lokerot.
     * 
     */
    public void lisaaDrinkki() {
        String nimi = ((JTextField) container.getComponent(1)).getText();
        String resepti = ((JTextField) container.getComponent(4)).getText();
        if (nimi.isEmpty() || resepti.isEmpty()) {
            return;
        }
        Drinkki drinkki = new Drinkki(nimi, resepti);
        for (int i = 9; i < 66; i += 6) {
            String osanimi = ((JTextField) container.getComponent(i)).getText();
            String maara = ((JTextField) container.getComponent(i + 1)).getText();
            boolean tarkea = ((JCheckBox) container.getComponent(i + 2)).isSelected();
            if (osanimi.isEmpty()) {
                break;
            }
            if (maara.isEmpty()) {
                maara = " ";
            }
            drinkki.setAine(new Ainesosa(osanimi, maara, tarkea));
        }
        kirjanpito.addDrinkki(drinkki);
        tyhjennaTekstit();
    }

    private void tyhjennaTekstit() {
        ((JTextField) container.getComponent(1)).setText("");
        ((JTextField) container.getComponent(4)).setText("");
        for (int i = 9; i < 66; i += 6) {
            ((JTextField) container.getComponent(i)).setText("");
            ((JTextField) container.getComponent(i + 1)).setText("");
            ((JCheckBox) container.getComponent(i + 2)).setSelected(false);
        }
    }
}
