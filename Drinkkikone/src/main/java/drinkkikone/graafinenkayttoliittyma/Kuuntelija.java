/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

public class Kuuntelija implements ActionListener {

    private JList osat;
    private JTextField syote;
    private JButton lisaa;
    private JButton poista;
    private JButton nollaa;
    private Vector osaTiedot;

    public Kuuntelija(JList kentta1, JTextField kentta2, JButton lisaa, JButton poista, JButton nollaa, Vector osaTiedot) {
        this.osat = kentta1;
        this.syote = kentta2;
        this.lisaa = lisaa;
        this.poista = poista;
        this.nollaa = nollaa;
        this.osaTiedot = osaTiedot;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String lisattava = syote.getText();
        if (ae.getSource() == lisaa) {
            lisaaOsa(lisattava);
        } else if (ae.getSource() == poista) {
            poistaOsa();
        }
    }

    public void lisaaOsa(String lisattava) {
        if (!lisattava.isEmpty()) {
            syote.setText("");
            osaTiedot.addElement(lisattava);
            osat.setListData(osaTiedot);
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
        }
    }
}
