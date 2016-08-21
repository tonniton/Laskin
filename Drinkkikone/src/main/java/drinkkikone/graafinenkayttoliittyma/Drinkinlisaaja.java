/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
        GridLayout layout = new GridLayout(13, 3);
        JPanel paneeli = new JPanel();
        paneeli.setLayout(layout);
        container.add(paneeli, BorderLayout.CENTER);
        JPanel paneeli2 = new JPanel();
        paneeli2.setLayout(new BorderLayout());
        container.add(paneeli2, BorderLayout.EAST);
//        container.setLayout(layout);
        
        JLabel drinkinNimi = new JLabel("Drinkin nimi: ");
        JTextField nimiKentta = new JTextField();
        JLabel resepti = new JLabel("Resepti: ");
        JTextField reseptiKentta = new JTextField();
        JButton lisaaNappi = new JButton("Lisää Drinkki!");

        JTextArea textArea = new JTextArea(10, 10);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        paneeli.add(drinkinNimi);
        paneeli.add(nimiKentta);
        paneeli.add(new JLabel(""));
//        paneeli.add(lisaaNappi);
        paneeli2.add(resepti, BorderLayout.NORTH);
        paneeli2.add(scrollPane, BorderLayout.CENTER);
//        container.add(reseptiKentta);
//        container.add(scrollPane);
//        container.add(new JLabel(""));
        
        paneeli.add(new JLabel("Ainesosan nimi: "));
        paneeli.add(new JLabel("Ainesosan määrä: "));
        paneeli.add(new JLabel("Välttämätön: "));
        for (int i = 0; i < 10; i++) {
            paneeli.add(new JTextField());
            paneeli.add(new JTextField());
            paneeli.add(new JCheckBox());
        }
        paneeli.add(lisaaNappi);
        
        Drinkinkuuntelija kuuntelija = new Drinkinkuuntelija(container, paneeli, paneeli2);
        lisaaNappi.addActionListener(kuuntelija);
    }
    
    private void luoReseptiOsa() {
        
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }
}
