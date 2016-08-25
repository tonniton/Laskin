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

/**
 *
 * Luokka asettaa mahdollisten drinkkien listassa olevista drinkeistä näkyviin
 * ainostaan niiden nimen.
 *
 * @author Viljami
 */
public class DrinkinRenderoija extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> lista,
            Object arvo,
            int index,
            boolean valittu,
            boolean cellHasFocus) {
        super.getListCellRendererComponent(lista, arvo, index, valittu, cellHasFocus);
        Drinkki drinkki = (Drinkki) arvo;
        setText(drinkki.getNimi());
        return this;
    }
}
