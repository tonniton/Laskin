/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Kuuntelija implements ActionListener {
    private JTextField kentta1;
    private JTextField kentta2;
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;

    public Kuuntelija(JTextField kentta1, JTextField kentta2, JButton plus, JButton miinus, JButton nollaa) {
        this.kentta1 = kentta1;
        this.kentta2 = kentta2;
        this.plus = plus;
        this.miinus = miinus;
        this.nollaa = nollaa;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String luku2 = kentta2.getText();
//        int luku2 = muutaluvuksi(kentta2);
        try {
            String luku1 = kentta1.getText();
//            int luku1 = muutaluvuksi(kentta1);
        
            if (ae.getSource() == plus) {
//                luku2 += luku1;
                kentta2.setText(kentta2.getText() + "\n" + luku1);
                kentta1.setText("");
            } else if (ae.getSource() == miinus) {
//                luku2 -= luku1;
                kentta2.setText("" + luku2);
                kentta1.setText("");
            } else {
                kentta2.setText("0");
                kentta1.setText("");
            }

            if (kentta2.getText().equals("0")) {
                nollaa.setEnabled(false);
            } else {
                nollaa.setEnabled(true);
            }
        } catch (Exception e) {
            kentta1.setText("");
        }
        
    }
    
    public int muutaluvuksi(JTextField kentta) {
        String teksti = kentta.getText();
        if (teksti.isEmpty()) {
            return 0;
        }
        int luku = Integer.parseInt(teksti);
        return luku;
    }
}
