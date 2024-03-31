package files;
import java.util.*;

public class MainaderiaList implements Mainaderia {
    // Atributs
    // Referencia a objecte de la classe List on "guardarem" les criatures...
    private List contingut;

    //Constructor
    public MainaderiaList() {
        // Crear la llista. Inicialment serà buida, clar...
        this.contingut = new ArrayList();
    }

    // Mètodes
    // Afegeix una criatura. Excepció si ja hi ha una criatura igual
    public void matricular(Criatura criaturaRebuda) throws IllegalArgumentException {
        if (this.contingut.contains(criaturaRebuda))
            throw new IllegalArgumentException("matricular: criatura repetida");
        contingut.add(criaturaRebuda);
    }

    // Desmatricula la criatura de nom donat.
    // Retorna la criatura que es desmatricula.
    // Si no n'hi ha cap amb aquell nom retorna null
    public Criatura desMatricular(String nom) {
        Criatura target = new Criatura(nom, Criatura.MIN_EDAT, Criatura.NEN);
        int index = contingut.indexOf(target);
        if (index == -1) {
            return null;
        } else {
            return (Criatura) contingut.remove(index);
        }
    }

    // Retorna la criatura que té el nom especificat.
    // Retorna null si no n'hi ha cap
    public Criatura buscar(String nom) {
        Criatura target = new Criatura(nom, Criatura.MIN_EDAT, Criatura.NEN);
        int index = contingut.indexOf(target);
        if (index == -1) {
            return null;
        } else {
            return (Criatura) contingut.get(index);
        }
    }

    // Retorna el nombre de criatures matriculades
    public int numCriatures() {
        return contingut.size();
    }

    // Retorna el número de criatures del sexe especificat com a paràmetre
    public int quantsSexe(int sexe) {
       Criatura criaturaActual;
       int quants = 0;
       // Iterem sobre el contingut, però sense fer us de l'iterador
       // És una mala solució -> Sempre és millor fer ús de l'iterador!
       for (int i = 0; i < contingut.size(); i++) {
           criaturaActual = (Criatura) contingut.get(i);
           if (criaturaActual.getSexe() == sexe)
               quants++;
       }
       return quants;
    }

    // Retorna la i-èssima criatura.
    // Excepció si el paràmetre està fora dels límits actuals
    public Criatura get(int i) throws IndexOutOfBoundsException {
        return (Criatura) contingut.get(i);
        // NOTA: get ja llença IndexOutOfBoundsException si el paràmetre està
        // fora de limits
    }
}