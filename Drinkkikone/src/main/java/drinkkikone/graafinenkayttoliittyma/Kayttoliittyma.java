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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * Luokka luo käytettävän graafisen käyttöliittymän.
 *
 * @author Viljami
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    /**
     *
     */
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
        drinkit.setCellRenderer(new DrinkinRenderoija());
        JTextArea tiedot = new JTextArea();
        tiedot.setLineWrap(true);
        tiedot.setWrapStyleWord(true);
        tiedot.setEnabled(false);
        tiedot.setDisabledTextColor(Color.BLACK);
        JScrollPane resepti = new JScrollPane(tiedot);
        
        luoDrinkkiTiedonpaivittaja(drinkit, tiedot);
        luoTekstiAlue(osat, drinkit, tiedot, container);

        JPanel valikko = luovalikko(osat, drinkit);
        container.add(valikko, BorderLayout.SOUTH);
        
        frame.addWindowListener(new IkkunaKuuntelija(drinkit));
        luoOtsikot(container);
    }

    private JPanel luovalikko(JList vasen, JList oikea) {
        JPanel panel = new JPanel(new GridLayout(2, 3));
        JTextField syote = new JTextField();
        JButton lisaa = new JButton("lisaa ainesosa");
        JButton poista = new JButton("poista ainesosa");
        JButton lisaaDrinkki = new JButton("Lisaa drinkki");
        JButton poistaDrinkki = new JButton("poista drinkki");
        JButton randomDrinkki = new JButton("random Drinkki");
        
        panel.add(syote);
        panel.add(lisaa);
        panel.add(poista);
        panel.add(lisaaDrinkki);
        panel.add(poistaDrinkki);
        panel.add(randomDrinkki);

        Kuuntelija kuuntelija = new Kuuntelija(vasen, oikea, panel);
        
        syote.addActionListener(kuuntelija);
        lisaa.addActionListener(kuuntelija);
        poista.addActionListener(kuuntelija);
        lisaaDrinkki.addActionListener(kuuntelija);
        poistaDrinkki.addActionListener(kuuntelija);
        randomDrinkki.addActionListener(kuuntelija);

        return panel;
    }
    
    private void luoTekstiAlue(JList osat, JList drinkit, JTextArea tiedot, Container container) {
        JPanel menu = new JPanel(new GridLayout(1, 3));
        
        JScrollPane scrollPane = new JScrollPane();
	scrollPane.getViewport().add(osat);
        menu.add(scrollPane);
        JScrollPane scrollPane2 = new JScrollPane();
	scrollPane2.getViewport().add(drinkit);
        menu.add(scrollPane2);
        JScrollPane scrollPane3 = new JScrollPane();
	scrollPane3.getViewport().add(tiedot);
        menu.add(scrollPane3);
        
        container.add(menu);
    }
    
    private void luoDrinkkiTiedonpaivittaja(JList drinkit, JTextArea tiedot) {
        drinkit.addListSelectionListener((ListSelectionEvent ev) -> {
//            if(drinkit.getLastVisibleIndex() != -1) {
                JList list = (JList) ev.getSource();
                if (!list.getSelectedValuesList().isEmpty()) {
                    ArrayList selectionValues = (ArrayList) list.getSelectedValuesList();
                    tiedot.setText(selectionValues.get(0).toString());
                } else {
                    tiedot.setText("");
                }
//            } else {
//                tiedot.setText("");
//            }
        });
    }
    
    private void luoOtsikot(Container container) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JLabel otsikko1 = new JLabel("Ainesosat: ");
        JLabel otsikko2 = new JLabel("Drinkit: ");
        JLabel otsikko3 = new JLabel("Ohje: ");
        panel.add(otsikko1);
        panel.add(otsikko2);
        panel.add(otsikko3);
        container.add(panel, BorderLayout.NORTH);
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }
}
