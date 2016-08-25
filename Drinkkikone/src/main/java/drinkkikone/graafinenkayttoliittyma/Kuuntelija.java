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
import java.util.Random;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Luokka toteuttaa graafisessa käyttöliittymässä annetut komennot.
 *
 * @author Viljami
 */
public class Kuuntelija implements ActionListener {

    private JList osat;
    private JList drinkit;
    private JTextField syote;
    private JButton lisaa;
    private JButton poista;
    private JButton lisaaDrinkki;
    private JButton poistaDrinkki;
    private JButton randomDrinkki;
    private Kirjanpito kirjanpito;
    private Vector osaTiedot;
    private Vector mahdolliset;
    private Drinkinlisaaja drinkinlisaaja;

    /**
     *
     * @param kentta1 lista Ainesosia
     * @param kentta2 lista Drinkkejä
     * @param panel paneeli joka sisältää annettavat komennot
     */
    public Kuuntelija(JList kentta1, JList kentta2, JPanel panel) {
        this.osat = kentta1;
        this.drinkit = kentta2;
        this.syote = (JTextField) panel.getComponent(0);
        this.lisaa = (JButton) panel.getComponent(1);
        this.poista = (JButton) panel.getComponent(2);
        this.lisaaDrinkki = (JButton) panel.getComponent(3);
        this.poistaDrinkki = (JButton) panel.getComponent(4);
        this.randomDrinkki = (JButton) panel.getComponent(5);
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
        } else if (ae.getSource() == poistaDrinkki) {
            poistaDrinkki();
        } else if (ae.getSource() == randomDrinkki) {
            randomDrinkki();
            return;
        }
        kirjanpito.paivitaMahdolliset();
        drinkit.setListData(mahdolliset);
    }

    /**
     *
     * Lisaa parametrina annetun nimisen ainesosan.
     *
     * @param lisattava lisattava ainesosa
     */
    public void lisaaOsa(String lisattava) {
        if (!lisattava.isEmpty()) {
            syote.setText("");
            kirjanpito.addOsa(new Ainesosa(lisattava));
            osat.setListData(osaTiedot);
        }
    }

    /**
     *
     * Poistaa valitun osan.
     *
     */
    public void poistaOsa() {
        int valittu = osat.getSelectedIndex();
        if (valittu >= 0) {
            osaTiedot.removeElementAt(valittu);
            osat.setListData(osaTiedot);
            if (valittu >= osaTiedot.size()) {
                valittu = osaTiedot.size() - 1;
            }
            osat.setSelectedIndex(valittu);
        }
    }

    /**
     *
     * Käynnistää drinkin lisäys ikkunan, jossa voi lisätä drinkkejä.
     *
     */
    public void lisaaDrinkki() {
        drinkinlisaaja.run();
    }

    /**
     *
     * Poistaa valitun drinkin valikoimasta.
     *
     */
    public void poistaDrinkki() {
        int valittu = drinkit.getSelectedIndex();
        if (valittu >= 0) {
            Drinkki poistettava = Kirjanpito.getInstance().getMahdolliset().get(valittu);
            kirjanpito.poistaDrinkki(poistettava.getNimi());
            if (valittu >= mahdolliset.size()) {
                valittu = mahdolliset.size() - 1;
            }
            drinkit.setSelectedIndex(valittu);
        }
    }

    /**
     *
     * Antaa satunnaisen drinkin mahdollisista vaihtoehdoista.
     *
     */
    public void randomDrinkki() {
        if (kirjanpito.getMahdolliset().size() > 0) {
            Random random = new Random();
            int valittu = random.nextInt(mahdolliset.size());
            drinkit.setSelectedIndex(valittu);
        }
    }
}
