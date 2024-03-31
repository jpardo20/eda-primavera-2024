package files;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExempleIteracio {
    public static void main (String [] args ) {
        // Declaració de variables
        List nens = new LinkedList();
        List nenes = new LinkedList();
        List llarInfants = new LinkedList();
        Iterator iteracio;
        Object membre;
        Criatura criatura = null;

        // Inicialització de variables
        nens.add(new Criatura("NIL",0,Criatura.NEN));
        nens.add(new Criatura("PERE",1, Criatura.NEN));
        nens.add(new Criatura("DÍDAC",0, Criatura.NEN));
        nens.add(new Criatura("NIL",1, Criatura.NEN));
        nens.add(new Criatura("VICTOR", 2, Criatura.NEN));
        nens.add(new Criatura("PAU", 3, Criatura.NEN));

        nenes.add(new Criatura("NEUS",0, Criatura.NENA));
        nenes.add(new Criatura("ONA",1, Criatura.NENA));
        nenes.add(new Criatura("EVA",3, Criatura.NENA));
        nenes.add(new Criatura("FIONA",2, Criatura.NENA));
        nenes.add(new Criatura("ENIA",3, Criatura.NENA));

        llarInfants.addAll(nens);
        llarInfants.addAll(nenes);

        //-----------------------------------------------------
        System.out.println("Mostrar totes les criatures");
        iteracio = llarInfants.iterator();
        while (iteracio.hasNext()) {
            membre = iteracio.next();
            System.out.println(membre);
        }

        // --------------------------------------
        // calcular edat mitjana
        System.out.println("Calcul de l'edat mitjana");
        double sumaEdats = 0;
        double edatMitjana;
        iteracio = llarInfants.iterator();
        while (iteracio.hasNext()) {
            membre = iteracio.next(); // membre ha estat declarat Object
            criatura = (Criatura) membre;
            sumaEdats += criatura.getEdat();
        }
        edatMitjana = sumaEdats/llarInfants.size();
        System.out.println("L'edat mitjana és: " + edatMitjana);

        // -----------------------------------
        // Buscar una nena de tres anys
        System.out.println("Buscar una nena de tres anys");
        boolean trobada = false;
        iteracio = llarInfants.iterator();
        while (iteracio.hasNext() && !trobada) {
            criatura = (Criatura)iteracio.next();
            if (criatura.getSexe() == Criatura.NENA &&
                criatura.getEdat() == 3)
                trobada = true;
        }
        if (trobada) {
            System.out.println("La nena de tres anys trobada és:");
            System.out.println(criatura);
        }
        else {
            System.out.println("La cerca no ha tingut èxit");
        }

        //-------------------------------------
        // Eliminar les criatures de 0 o de 3 anys
        System.out.println("Eliminar les criatures de 0 o de 3 anys");
        iteracio = llarInfants.iterator();
        while (iteracio.hasNext()) {
            criatura = (Criatura)iteracio.next();
            if (criatura.getEdat() == 0 ||
                criatura.getEdat() == 3) {
                // llarInfants.remove(criatura); // incorrecte!!!
                iteracio.remove(); // OK. Elimina el darrer element
                // proporcionat per next
            }
        }

        //--------------------------------------
        // Mostrar totes les criatures després d'eliminar les de 0 o de 3 anys
        System.out.println("Mostrar totes les criatures després d'eliminar les de 0 o de 3 anys");
        iteracio = llarInfants.iterator();
        while (iteracio.hasNext()) {
            membre = iteracio.next();
            System.out.println(membre);
        }
    }
}