/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

        Kirjanpito kirjanpito = Kirjanpito.getInstance();

        JList osat = new JList(kirjanpito.getOsat());
        JList drinkit = new JList(kirjanpito.getMahdolliset());
        JTextField syote = new JTextField();
        drinkit.setCellRenderer(new DrinkinRenderoija());
        JLabel tiedot = new JLabel("", SwingConstants.CENTER);
        
        luoDrinkkiTiedonpaivittaja(drinkit, tiedot);
        luoTekstiAlue(osat, drinkit, tiedot, container);

        JPanel valikko = luovalikko(osat, drinkit, syote);
        container.add(valikko, BorderLayout.SOUTH);
        container.add(syote, BorderLayout.NORTH);
    }

    private JPanel luovalikko(JList vasen, JList oikea, JTextField syote) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton lisaa = new JButton("lisaa");
        JButton poista = new JButton("poista");
        JButton lisaaDrinkki = new JButton("Lisaa drinkki");
        Kuuntelija kuuntelija = new Kuuntelija(vasen, oikea, syote, lisaa, poista, lisaaDrinkki);
        lisaa.addActionListener(kuuntelija);
        poista.addActionListener(kuuntelija);
        lisaaDrinkki.addActionListener(kuuntelija);
        panel.add(lisaa);
        panel.add(poista);
        panel.add(lisaaDrinkki);
        return panel;
    }
    
    private void luoTekstiAlue(JList osat, JList drinkit, JLabel tiedot, Container container) {
        JPanel menu = new JPanel(new GridLayout(1, 3));
        menu.add(osat);
        menu.add(drinkit);
        menu.add(tiedot);
        container.add(menu);
    }
    
    private void luoDrinkkiTiedonpaivittaja(JList drinkit, JLabel tiedot) {
        drinkit.addListSelectionListener((ListSelectionEvent ev) -> {
            if(drinkit.getLastVisibleIndex() != -1) {
                JList list = (JList) ev.getSource();
                if (!list.getSelectedValuesList().isEmpty()) {
                    ArrayList selectionValues = (ArrayList) list.getSelectedValuesList();
                    tiedot.setText(selectionValues.get(0).toString());
                }
            } else {
                tiedot.setText("");
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }
}
