/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.graafinenkayttoliittyma;

import drinkkikone.osat.Drinkki;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Viljami
 */
public class DrinkinRenderoija extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> lista,
                                 Object arvo,
                                 int index,
                                 boolean valittu,
                                 boolean cellHasFocus) 
    {
        super.getListCellRendererComponent(lista, arvo, index, valittu, cellHasFocus);
//        if (value instanceof Drinkki) {
            Drinkki drinkki = (Drinkki)arvo;
            setText(drinkki.getNimi());
//            setToolTipText(drinkki.getResepti());
            // setIcon(ingredient.getIcon());
//        }
//            if (valittu) {
//                setText(drinkki.toString());
//            }
        return this;
    }
}