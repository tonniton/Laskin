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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        container.setLayout(new BorderLayout());

        container.add(new JButton("Pohjoinen (North)"), BorderLayout.NORTH);
//        container.add(new JButton("Itä (East)"), BorderLayout.EAST);
//        container.add(new JTextField("Länsi (West)"), BorderLayout.WEST);
//        container.add(new JButton("Keski (Center)"), BorderLayout.CENTER);
        JPanel menu = new JPanel(new GridLayout(1, 2));
        menu.add(new JButton("Suorita"));
        menu.add(new JButton("Testaa"));
        
        container.add(menu, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JLabel("Ainesosat"));
        panel.add(new JTextField("Drinkit"));

        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
