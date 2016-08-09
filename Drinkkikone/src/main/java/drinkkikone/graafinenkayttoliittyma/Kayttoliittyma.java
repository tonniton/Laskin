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
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.WindowConstants;

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
        JList drinkit = new JList(kirjanpito.getDrinkit());
        JTextField syote = new JTextField();

        JPanel menu = new JPanel(new GridLayout(1, 2));
        menu.add(osat);
        menu.add(drinkit);
        container.add(menu);

        JPanel valikko = luovalikko(osat, syote, kirjanpito.getOsat());
        container.add(valikko, BorderLayout.SOUTH);
        container.add(syote, BorderLayout.NORTH);
    }

    private JPanel luovalikko(JList vasen, JTextField syote, Vector osaTiedot) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton lisaa = new JButton("lisaa");
        JButton poista = new JButton("poista");
        JButton nollaa = new JButton("Z");
        Kuuntelija kuuntelija = new Kuuntelija(vasen, syote, lisaa, poista, nollaa, osaTiedot);
        lisaa.addActionListener(kuuntelija);
        poista.addActionListener(kuuntelija);
//        nollaa.addActionListener(kuuntelija);
        panel.add(lisaa);
        panel.add(poista);
//        nollaa.setEnabled(false);
//        panel.add(nollaa);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
