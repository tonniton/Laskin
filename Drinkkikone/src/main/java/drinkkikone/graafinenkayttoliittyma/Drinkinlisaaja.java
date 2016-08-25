/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * Luokka luo uuden ikkunan drinkkien lisäystä varten.
 *
 * @author Viljami
 */
public class Drinkinlisaaja implements Runnable {

    private JFrame frame;

    /**
     *
     *
     */
    public Drinkinlisaaja() {
    }

    @Override
    public void run() {
        frame = new JFrame("Otsikko");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JPanel paneeli = new JPanel();
        paneeli.setLayout(new GridLayout(12, 3));
        container.add(paneeli, BorderLayout.CENTER);

        paneeli.add(new JLabel("Drinkin nimi: "));
        paneeli.add(new JTextField());
        paneeli.add(new JLabel(""));

        paneeli.add(new JLabel("Ainesosan nimi: "));
        paneeli.add(new JLabel("Ainesosan määrä: "));
        paneeli.add(new JLabel("Välttämätön: "));
        for (int i = 0; i < 10; i++) {
            paneeli.add(new JTextField());
            paneeli.add(new JTextField());
            paneeli.add(new JCheckBox());
        }

        JPanel paneeli2 = new JPanel();
        paneeli2.setLayout(new BorderLayout());
        container.add(paneeli2, BorderLayout.EAST);

        JLabel resepti = new JLabel("Resepti: ");
        JTextArea reseptikentta = new JTextArea(10, 10);
        reseptikentta.setLineWrap(true);
        reseptikentta.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(reseptikentta);
        JButton lisaaNappi = new JButton("Lisää Drinkki!");

        paneeli2.add(resepti, BorderLayout.NORTH);
        paneeli2.add(scrollPane, BorderLayout.CENTER);
        paneeli2.add(lisaaNappi, BorderLayout.SOUTH);

        Drinkinkuuntelija kuuntelija = new Drinkinkuuntelija(paneeli, paneeli2);
        lisaaNappi.addActionListener(kuuntelija);
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }
}
