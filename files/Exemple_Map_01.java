package files;

import java.util.*;
public class Exemple_Map_01 {
    public static void main(String[] args) {
        Criatura[] poblacio = {
                new Criatura("NIL", 0, Criatura.NEN),
                new Criatura("PERE", 1, Criatura.NEN),
                new Criatura("NEUS", 0, Criatura.NENA),
                new Criatura("ONA", 1, Criatura.NENA),
                new Criatura("DÍDAC", 0, Criatura.NEN),
                new Criatura("NÚRIA", 1, Criatura.NEN),
                new Criatura("EVA", 3, Criatura.NENA),
                new Criatura("FIONA", 2, Criatura.NENA),
                new Criatura("ENIA", 3, Criatura.NENA)
        };

        // Map per aparellar cada criatura amb el nom del seu pediatra
        Map<Criatura, String> serveiPediatria;
        String nomPediatra;
        serveiPediatria = new HashMap<Criatura, String>();
        
        // Els tres primers amb el Dr. Abelardo
        for (int i = 0; i < 3; i++) {
            serveiPediatria.put(poblacio[i], "Abelardo");
        }

        // Els tres següents amb la Dra. Banach
        for (int i = 3; i < 6; i++) {
            serveiPediatria.put(poblacio[i], "Banach");
        }

        // I tota la resta amb la Dra. Canyet
        for (int i = 6; i < poblacio.length; i++) {
            serveiPediatria.put(poblacio[i], "Canyet");
        }

        // Ara podem consultar qui es el pediatra de cada criatura:
        System.out.println();
        for (Criatura c : poblacio) {
            nomPediatra = serveiPediatria.get(c);
            System.out.println("El/la pediatra de la critura");
            System.out.println(" " + c);
            System.out.println(" és el/la Dr./Dra. " + nomPediatra);
        }

        // Map també ens permet recuperar el conjunt de claus
        // en aquest cas les claus són les criatures
        Set<Criatura> criaturesAteses;
            criaturesAteses = serveiPediatria.keySet();
            System.out.println("\n Les criatures ateses pel servei són:");
            for (Criatura criaturaActual : criaturesAteses)
                System.out.println(" "+criaturaActual);

        // Map ens permet recuperar la col·lecció de valors associats
        // a les claus (en aquest exemple els valors són els pediatres
        // -Strings-)
        Collection<String> pediatres;
        pediatres = serveiPediatria.values();
        System.out.println("\n Els/les pediatres del servei són:");
        for (String ped : pediatres)
            System.out.println(" "+ped);
    }
}