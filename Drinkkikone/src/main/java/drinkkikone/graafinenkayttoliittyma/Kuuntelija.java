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
    private JTextField lisaa;
    private JButton plus;
    private JButton miinus;
    private JButton nollaa;
    private Vector listData;

    public Kuuntelija(JList kentta1, JTextField kentta2, JButton lisaa, JButton miinus, JButton nollaa, Vector listData) {
        this.osat = kentta1;
        this.lisaa = kentta2;
        this.plus = lisaa;
        this.miinus = miinus;
        this.nollaa = nollaa;
        this.listData  = listData;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String lisattava = lisaa.getText();
            if (ae.getSource() == plus) {
                lisaa.setText("");
                listData.addElement(lisattava);
                osat.setListData(listData);
            }
        } catch (Exception e) {

        }
        
    }
}
