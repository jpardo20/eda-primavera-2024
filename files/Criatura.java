package files;

public class Criatura implements Comparable {
    // Definició de constants
    public static final int NEN = 10;
    public static final int NENA = 20;
    public static final int MIN_EDAT = 0;
    public static final int MAX_EDAT = 3;
    // Atributs
    private String nom;
    private int edat;
    private int sexe;
    // Constructor (Tots 3 atributs)
    public Criatura(String nom, int edat, int sexe) {
        if (edat < MIN_EDAT || edat > MAX_EDAT)
            throw new IllegalArgumentException("edat no vàlida: " + edat);
        if (sexe != NEN && sexe != NENA)
            throw new IllegalArgumentException("sexe no vàlid: " + sexe);
        this.nom = nom;
        this.edat = edat;
        this.sexe = sexe;
    }
    // Implementació dels Getters
    public String getNom() { return this.nom; }
    public int getEdat() { return this.edat; }
    public int getSexe() { return this.sexe; }
    // Implementació dels Setters
    public void setNom(String nouNom) { this.nom = nouNom; }
    public void setEdat(int novaEdat) { this.edat  = novaEdat; }
    public void setSexe(int nouSexe) { this.sexe = nouSexe; }
    // Redefinició del mètode toString heretat d'Object'
    public String toString() {
        String resultat;
        resultat = "Criatura de nom: " +
                ((sexe == NEN) ? "Sexe: nen" : "Sexe: nena");
        return resultat;
    }
    // Implementació de la interfície Comparable
    public int compareTo(Object o) {
        // comparació basada en l'ordre
        // lexicogràfic sense distingir
        // majúscules de minúscules.
        Criatura altra = (Criatura) o;
        return this.nom.compareToIgnoreCase(altra.nom);
    }
    // Redefinició del mètode equals heretat d'object.
    public boolean equals (Object o) {
        // Redefinició compatible amb compareTo
        try { return this.compareTo(o)==0; }
        catch(ClassCastException e) { return false;}
    }
}