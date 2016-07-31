package drinkkikone;

import drinkkikone.osat.Ainesosa;
import drinkkikone.osat.Baarikaappi;
import drinkkikone.osat.Drinkki;
import drinkkikone.osat.Kirjanpito;

public class Main {

    public static void main(String[] args) {
        Kirjanpito tiedot = new Kirjanpito();
        Baarikaappi b = new Baarikaappi(tiedot);

        tiedot.setOsa(new Ainesosa("gin"));
        tiedot.setOsa(new Ainesosa("tonic"));
        
        tiedot.poistaOsa("gin");
        for (Ainesosa osa : tiedot.getOsat()) {
            System.out.println(osa.toString());
        }

        Drinkki gt = new Drinkki("gin & tonic", "sekoita");
        gt.setAine(new Ainesosa("gin", "4cl"));
        gt.setAine(new Ainesosa("tonic", "12cl"));
        tiedot.setDrinkki(gt);

//        System.out.println(gt.toString());
//        System.out.println("");
//        System.out.println(tiedot.getDrinkit().get(0));
//        System.out.println("");
//        for (Drinkki drinkki : tiedot.getDrinkit()) {
//            boolean onko = false;
//            boolean apu = true;
//            for (Ainesosa osa : drinkki.getAineet()) {
//                for (Ainesosa kaapista : tiedot.getOsat()) {
//                    if (kaapista.getNimi().equals(osa.getNimi())) {
//                        onko = true;
//                        break;
//                    }
//                }
//                if (onko == false) {
//                    apu = false;
//                    break;
//                }
//                onko = false;
//            }
//            if (apu == true) System.out.println(tiedot.getDrinkit().get(0));
//        }
    }
}
