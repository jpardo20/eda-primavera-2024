package files;

@SuppressWarnings("rawtypes")
public class Criatura implements Comparable {
// Constants
    public static final int NEN = 10;
    public static final int NENA = 20;

    public static final int MIN_EDAT = 0;
    public static final int MAX_EDAT = 3;

    // Atributs
    private String nom;
    private int edat;
    private int sexe;

    // Constructors
    public Criatura(String nom, int edat, int sexe) {
        if (edat < MIN_EDAT || edat > MAX_EDAT)
            throw new IllegalArgumentException("edat no vàlida: " + edat);
        if (sexe != NEN && sexe != NENA)
            throw new IllegalArgumentException("sexe no vàlid: " + sexe);
        this.nom = nom;
        this.edat = edat;
        this.sexe = sexe;
    }

    // Setters & Getters
    public String getNom() {
        return this.nom;
    }

    public int getEdat() {
        return this.edat;
    }

    public int getSexe() {
        return this.sexe;
    }

    // Redefinició del mètode toString heretat d'Object
    public String toString() {
        String resultat;
        // resultat = "Criatura de nom: " + nom
        // + " té " + edat + " anys. ";
        resultat = "Criatura de nom " + nom
           + "\tamb " + ((edat<=1) ? ((edat==0) ? "menys d'1 any" : edat + " any\t") : edat + " anys\t");
        // if (sexe == NEN)
        //     resultat += "Sexe: nen";
        // else
        //     resultat += "Sexe: nena";
        resultat += "\ti amb sexe de " + ((sexe == NEN) ? "nen." : "nena.");
        return resultat;
    }

    // Implementació de la interfície Comparable
    public int compareTo(Object objecte) {
        // comparació basada en l'ordre lexicogràfic sense distingir
        // majúscules de minúscules.
        Criatura unaAltraCriatura = (Criatura) objecte;
        return this.nom.compareToIgnoreCase(unaAltraCriatura.nom);
    }
    
    // Redefinició del mètode equals heretat d'object.
    public boolean equals(Object objecte) {
    // redefinició compatible amb compareTo
        try {
            return (this.compareTo(objecte) == 0);
        } catch(ClassCastException excepcio) {
            return false;
        }
    }
}