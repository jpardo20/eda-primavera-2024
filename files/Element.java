package files;
public class Element {
    // Atributs
    private String nom;
    private int valor;
    
    // Constructor
    public Element (String nomRebut, int valorRebut) {
        this.nom = nomRebut;
        this.valor = valorRebut;
    }
    
    // Setters & Getters
    public String getNom() {
        return this.nom;
    }

    public int getValor() {
        return this.valor;
    }
    
    public void setValor(int nouValor) {
        this.valor = nouValor;
    }
    
    // equality (overriding of superclass equals)
    public boolean equals(Object objecte) {
        Element unAltreObjecte;
        try {
            unAltreObjecte = (Element) objecte;
            return this.nom.equals(unAltreObjecte.nom);
        } catch(Exception e) {
            return false;
        }
    }

    // toString (overriding of superclass toString)
    public String toString () {
        return "Element[" + nom + " " + valor + "]";
    }

    // hashCode (overriding of superclass hashCode)
    public int hashCode() {
            return this.nom.hashCode();
    }
}