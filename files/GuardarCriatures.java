package files;

import java.util.LinkedList;
import java.util.List;

public class GuardarCriatures {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main (String [] args) {
        Criatura [] vectorCriatures = {
            new Criatura("NIL",0,Criatura.NEN),
            new Criatura("PERE",1, Criatura.NEN),
            new Criatura("NEUS",0, Criatura.NENA),
            new Criatura("ONA",1, Criatura.NENA),
            new Criatura("DÍDAC",0, Criatura.NEN),
            new Criatura("NIL",1, Criatura.NEN),
            new Criatura("EVA",3, Criatura.NENA),
            new Criatura("FIONA",2, Criatura.NENA),
            new Criatura("ENIA",3, Criatura.NENA)
        };

        List llarDInfants;
        llarDInfants = new LinkedList();
        
        // List té tots els mètode de Collection
        // per exemple el metode add(Object o)
        for (int i=0; i<vectorCriatures.length; i++) {
            llarDInfants.add(vectorCriatures[i]);
        }
        
        // add(Object o) afegeix al final de la llista
        llarDInfants.add(new Criatura("OLGA", 2, Criatura.NENA));
        
        //---------------
        
        // add(Object o, int i) afegeix a la posició i-èssima
        // desplaçant elements cap a índexs superiors si cal
        
        llarDInfants.add(3, new Criatura("JOAN", 1, Criatura.NEN));
        // Les llistes són accessibles per posició, quasi bé
        // con si fossin taules (arrays) però usant get
        for (int i=0; i<llarDInfants.size(); i++) {
            System.out.println(llarDInfants.get(i));
        }
        // les llistes permeten de canviar el contingut d'una posició
        llarDInfants.set(8, new Criatura("ELISA", 3, Criatura.NENA));
        llarDInfants.set(2, llarDInfants.get(7));
        // les llistes permeten de fer cerques basades en EQUALS
        int primerNil, darrerNil;
        Criatura target = new Criatura("nil", 3, Criatura.NEN);
        primerNil = llarDInfants.indexOf(target);
        darrerNil = llarDInfants.lastIndexOf(target);

        System.out.println("primerNil = " + primerNil);
        System.out.println("darrerNil = " + darrerNil);

    }
}