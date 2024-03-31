package files;
public interface Mainaderia {

    // Afegeix una criatura.
    // Excepció si ja hi ha una criatura igual
    public void matricular (Criatura criaturaAMatricular) throws IllegalArgumentException;
    
    // Desmatricula la criatura de nom donat.
    // Retorna la criatura que es desmatricula.
    // Si no n'hi ha cap amb aquell nom retorna null
    public Criatura desMatricular(String nomDeLaCriaturaADesmatricular);

    // Retorna la criatura que té el nom especificat.
    // Retorna null si no n'hi ha cap
    public Criatura buscar(String nom);
    
    // Retorna el nombre de criatures matriculades
    public int numCriatures();

    // Retorna el nombre de criatures del sexe especificat com a paràmetre
    public int quantsSexe (int sexe);

    // Retorna la i-èssima criatura.
    // Excepció si el paràmetre està fora dels límits actuals
    public Criatura get(int i) throws IndexOutOfBoundsException;
    
}