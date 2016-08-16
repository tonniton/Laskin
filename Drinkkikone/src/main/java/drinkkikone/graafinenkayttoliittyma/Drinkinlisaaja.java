/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Viljami
 */
public class Drinkinlisaaja implements Runnable {

    private JFrame frame;
    private JList lista;

    public Drinkinlisaaja(JList lista) {
        this.lista = lista;
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
        GridLayout layout = new GridLayout(23, 2);
        container.setLayout(layout);

        JLabel drinkinNimi = new JLabel("Drinkin nimi: ");
        JTextField nimiKentta = new JTextField();
        JLabel resepti = new JLabel("Resepti: ");
        JTextField reseptiKentta = new JTextField();
        JButton lisaaNappi = new JButton("LisÃ¤Ã¤ Drinkki!");

        container.add(drinkinNimi);
        container.add(nimiKentta);
        container.add(resepti);
        container.add(reseptiKentta);
        
        for (int i = 0; i < 10; i++) {
            container.add(new JLabel("Ainesosan nimi: "));
            container.add(new JLabel("Ainesosan mÃ¤Ã¤rÃ¤: "));
            container.add(new JTextField());
            container.add(new JTextField());
        }
        
        container.add(new JLabel(""));
        container.add(lisaaNappi);
        
        Drinkinkuuntelija kuuntelija = new Drinkinkuuntelija(container);
        lisaaNappi.addActionListener(kuuntelija);
        DrinkinIkkunaKuuntelija kuuntelija2 = new DrinkinIkkunaKuuntelija(lista);
        frame.addWindowListener(kuuntelija2);
    }

    public JFrame getFrame() {
        return frame;
    }
}
