/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;

/**
 *
 * Luokka kuuntelee drinkin lisäys nappia.
 *
 * @author Viljami
 */
public class Drinkinkuuntelija implements ActionListener {

    private final JButton lisaaNappi;
    private final Kirjanpito kirjanpito;
    private final JPanel paneeli;
    private final JPanel paneeli2;

    /**
     *
     * @param paneeli
     * @param paneeli2
     */
    public Drinkinkuuntelija(JPanel paneeli, JPanel paneeli2) {
        lisaaNappi = (JButton) paneeli2.getComponent(2);
        this.kirjanpito = Kirjanpito.getInstance();
        this.paneeli = paneeli;
        this.paneeli2 = paneeli2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lisaaNappi) {
            lisaaDrinkki();
        }
    }

    /**
     *
     * Lisää drinkin syötetietojen perusteella ja tyhjentää sen jälkeen syöte
     * lokerot.
     *
     */
    public void lisaaDrinkki() {
        String nimi = ((JTextField) paneeli.getComponent(1)).getText();
        JTextArea ohje = (JTextArea) ((JViewport) (((JScrollPane) paneeli2.getComponent(1)).getViewport())).getView();
        String[] data = ohje.getText().split("\n");
        String resepti = listaStringiksi(data);
        if (nimi.isEmpty() || resepti.isEmpty()) {
            return;
        }
        Drinkki drinkki = new Drinkki(nimi, resepti);
        for (int i = 6; i < 36; i += 3) {
            String osanimi = ((JTextField) paneeli.getComponent(i)).getText();
            String maara = ((JTextField) paneeli.getComponent(i + 1)).getText();
            boolean tarkea = ((JCheckBox) paneeli.getComponent(i + 2)).isSelected();
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
        ((JTextField) paneeli.getComponent(1)).setText("");
        JTextArea ohje = (JTextArea) ((JViewport) (((JScrollPane) paneeli2.getComponent(1)).getViewport())).getView();
        ohje.setText("");
        for (int i = 6; i < 36; i += 3) {
            ((JTextField) paneeli.getComponent(i)).setText("");
            ((JTextField) paneeli.getComponent(i + 1)).setText("");
            ((JCheckBox) paneeli.getComponent(i + 2)).setSelected(false);
        }
    }

    String listaStringiksi(String[] data) {
        String palaute = "";
        for (String s : data) {
            palaute += s + " ";
        }
        return palaute;
    }
}
