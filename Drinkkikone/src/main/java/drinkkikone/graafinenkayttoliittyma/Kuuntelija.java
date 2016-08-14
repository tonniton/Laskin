/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Kirjanpito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class Kuuntelija implements ActionListener {

    private JList osat;
    private JList drinkit;
    private JTextField syote;
    private JButton lisaa;
    private JButton poista;
    private JButton lisaaDrinkki;
    private Kirjanpito kirjanpito;
    private Vector osaTiedot;
    private Vector mahdolliset;
    private Drinkinlisaaja drinkinlisaaja;

    public Kuuntelija(JList kentta1, JList kentta2, JTextField kentta3, JButton lisaa, JButton poista, JButton lisaaDrinkki) {
        this.osat = kentta1;
        this.drinkit = kentta2;
        this.syote = kentta3;
        this.lisaa = lisaa;
        this.poista = poista;
        this.lisaaDrinkki = lisaaDrinkki;
        this.kirjanpito = Kirjanpito.getInstance();
        this.osaTiedot = kirjanpito.getOsat();
        this.mahdolliset = kirjanpito.getMahdolliset();
        this.drinkinlisaaja = new Drinkinlisaaja();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String lisattava = syote.getText();
        if (ae.getSource() == lisaa) {
            lisaaOsa(lisattava);
        } else if (ae.getSource() == poista) {
            poistaOsa();
        } else if (ae.getSource() == lisaaDrinkki) {
           lisaaDrinkki();
        }
    }    

    public void lisaaOsa(String lisattava) {
        if (!lisattava.isEmpty()) {
            syote.setText("");
//            kirjanpito.setOsa(new Ainesosa(lisattava));
            osaTiedot.addElement(new Ainesosa(lisattava));
            osat.setListData(osaTiedot);
            kirjanpito.paivitaMahdolliset();
            drinkit.setListData(mahdolliset);
        }
    }

    public void poistaOsa() {
        int valittu = osat.getSelectedIndex();
        if (valittu >= 0) {
            osaTiedot.removeElementAt(valittu);
            osat.setListData(osaTiedot);
            if (valittu >= osaTiedot.size()) {
                valittu = osaTiedot.size() - 1;
            }
            osat.setSelectedIndex(valittu);
            kirjanpito.paivitaMahdolliset();
            drinkit.setListData(mahdolliset);
        }
    }
    
    public void lisaaDrinkki() {
        drinkinlisaaja.run();
    }
}
