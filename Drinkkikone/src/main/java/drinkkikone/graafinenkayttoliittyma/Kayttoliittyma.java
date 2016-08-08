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
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
        
        Vector listData = new Vector();
        JList listbox = new JList(listData);
//        listbox.addListSelectionListener(this);
        JTextField syote = new JTextField();
        
        JPanel menu = new JPanel(new GridLayout(1, 3));
        menu.add(listbox);
        menu.add(syote);
        container.add(menu);
        
        JPanel valikko = luovalikko(listbox, syote, listData);
        container.add(valikko, BorderLayout.SOUTH);
    }
    
    private JPanel luovalikko(JList vasen, JTextField oikea, Vector listData) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        JButton miinus = new JButton("-");
        JButton nollaa = new JButton("Z");
        Kuuntelija kuuntelija = new Kuuntelija(vasen, oikea, plus, miinus, nollaa, listData);
        plus.addActionListener(kuuntelija);
        miinus.addActionListener(kuuntelija);
//        nollaa.addActionListener(kuuntelija);
        panel.add(plus);
        panel.add(miinus);
//        nollaa.setEnabled(false);
//        panel.add(nollaa);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}

//    private void luoKomponentit(Container container) {
////        container.add(new JButton("Pohjoinen (North)"), BorderLayout.NORTH);
//        
//        Vector listData = new Vector();
//        JList listbox = new JList(listData);
////        listbox.addListSelectionListener(this);
//
//        JTextField vasen = new JTextField("0");
//        vasen.setEnabled(false);
//        JTextField oikea = new JTextField("");
//////        String	listData[] = {"Item 1"};
//////        JList listbox = new JList(listData);
////        JPanel valikko = luovalikko(vasen, oikea);
////        container.add(valikko, BorderLayout.SOUTH);
//        
//        JPanel menu = new JPanel(new GridLayout(1, 3));
//        menu.add(vasen);
//        menu.add(oikea);
//        menu.add(listbox);
//        container.add(menu);
//    }
//    
//    private JPanel luovalikko(JTextField vasen, JTextField oikea) {
//        JPanel panel = new JPanel(new GridLayout(1, 3));
//        JButton plus = new JButton("+");
//        JButton miinus = new JButton("-");
//        JButton nollaa = new JButton("Z");
//        Kuuntelija kuuntelija = new Kuuntelija(oikea, vasen, plus, miinus, nollaa);
//        plus.addActionListener(kuuntelija);
//        miinus.addActionListener(kuuntelija);
//        nollaa.addActionListener(kuuntelija);
//        panel.add(plus);
//        panel.add(miinus);
//        nollaa.setEnabled(false);
//        panel.add(nollaa);
//        return panel;
//    }