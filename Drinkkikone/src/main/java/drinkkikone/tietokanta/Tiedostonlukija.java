/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkkikone.tietokanta;

import drinkkikone.osat.Kirjanpito;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Viljami
 */
public class Tiedostonlukija {
    private File tiedosto;
    private Scanner lukija;
    private Kirjanpito kirjanpito;

//    public Tiedostonlukija(File tiedosto, Scanner lukija) {
//        this.tiedosto = tiedosto;
//        this.lukija = lukija;
//    }
    public Tiedostonlukija() throws FileNotFoundException {
        this.tiedosto = new File("C:\\Users\\Viljami\\Documents\\GitHub\\repo\\Drinkkikone\\src\\main\\resources\\koe.txt");
//        System.out.println(tiedosto.exists());
        this.lukija = new Scanner(tiedosto);
    }

    public void lueTiedosto() {
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            System.out.println(rivi);
        }

        lukija.close();
    }
    
    
}
