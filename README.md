# Estructures de Dades i Algorismes "Collections"

### Codi dels exemple

### Dr. Enric Sesa i Nogueras

<details><summary>Pitja per veure l'Índex</summary>

> ## Índex
> 
> **1.** [Implementació de la **Classe** **`Element`**](#1-la-classe-element-classe-utilitzada-en-els-següents-exemples)
> 
> **2.** [Exemple de la **Classe** **`Interfície`** **`Collection`**](#2-un-exemple-de-la-classe-interfície-collection)
> 
> **3.** [Implementació de la **Classe** **`Criatura`**](#3-la-classe-criatura-classe-utilitzada-en-els-següents-exemples)
> 
> **4.** [Exemple de la **Classe** **`GuardarCriatures`**](#4-un-exemple-de-la-classe-guardarcriatures-que-dutilitza-la-classe-list-de-java)
>
> **5.** [Exemple de la **Classe** **`Interfície`** **`Mainaderia`**](#5-un-exemple-de-la-classe-interfície-mainaderia)
>
> **6.** [Implementació de la **`Interfície`** **`Mainaderia`**](#6-una-implementació-de-la-interfície-mainaderia-que-utilitza-un-objecte-list)
>
> **7.** [Exemple de la **Classe** **`ExempleIteracio`**](#7-un-exemple-de-la-classe-exempleiteracio)
>
> <hr>
>
</details>

## **1.** La **Classe `Element`** (classe utilitzada en els següents exemples)

<details><summary>Pitja per veure el codi</summary>

```java
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
```
<hr>
</details>

#### Aquí podeu trobar el codi de la **Classe** [**`Element.java`**](./files/Element.java)

<hr>

## **2.** Un exemple de la **Classe** **`Interfície`** **`Collection`**

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

public class ExempleCollection {
    public static void main (String [] args) {
        Collection total, subOne, subTwo;

        Element [] some = {
                new Element ("Epsilon", 6),
                new Element ("Delta", 20),
                new Element ("Alpha", 12)
        };
    // ArrayList, LinkedList and Vector
    // are classes that implement Collection
        total = new ArrayList();
        subOne = new LinkedList();
        subTwo = new Vector();
    // Use add to add elements one by one
        subOne.add(new Element("Alpha", 4));
        subOne.add(new Element("Beta", 3));
        subOne.add(new Element("Gamma", 8));
        subOne.add(new Element("Delta", 3));
        subOne.add(new Element("Alpha", 5));
    // use add to add elements one by one
        for (int i=0; i<some.length; i++) {
            subTwo.add(some[i]);
        }

    // use addAll to add elements all at once
        total.addAll(subOne);
        total.addAll(subTwo);

    // contains and containsAll are based on equals
        System.out.println(subOne.contains(some[0]));
        System.out.println(subOne.contains(some[1]));
        System.out.println(subOne.contains(some[2]));
    
    // remove and removeAll are based on equals
        subOne.remove(some[1]);
        total.removeAll(subTwo);
    
    // toArray provides the contents in an array
        Object [] contents = total.toArray();
        for (int i=0; i<contents.length; i++) {
            System.out.println(contents[i]);
        }

    // Remember: REFERENCES EVERYWHERE
        some[1].setValor(12);
        some[2].setValor(some[0].getValor()+3);
    
    // Remember: REFERENCES EVERYWHERE
        subTwo.add(some[2]);
        contents = subTwo.toArray();
        int sum = 0;
        for (int i = 0; i < contents.length; i++) {
            System.out.println(contents[i]);
            sum += ((Element)contents[i]).getValor();
        }
        System.out.println("Sum is: "+sum);
    }
}
```

#### Aquí podeu trobar el codi de la **`interfície`** [**`ExempleCollection.java`**](./files/ExempleCollection.java)

#### Sortida de l'execució de la **`interfície`** **`ExempleCollection`**. 

<pre>
false
true
true
Element[Epsilon 6]
Element[Delta 12]
Element[Alpha 9]
Element[Alpha 9]
Sum is: 36
</pre>

<hr>

## **3.** La **Classe** **`Criatura`** (classe utilitzada en els següents exemples)

```java
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
```

> ### [Implementa la **Classe** **`Interfície`** de **Java** **`Comparable<T>`**](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html)

#### Aquí podeu trobar el codi de la **`Classe`** [**`Criatura.java`**](./files/Criatura.java)

<hr>

## **4.** Un exemple de la **Classe** **`GuardarCriatures`** que d’utilitza la **`Classe`** **`List`** de **Java**

```java
import java.util.LinkedList;
import java.util.List;

public class GuardarCriatures {
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
    }
}
```

#### Aquí podeu trobar el codi de la **`Classe`** [**`GuardarCriatures.java`**](./files/GuardarCriatures.java)

#### Sortida de l'execució de la **`Classe`** **`GuardarCriatures`**. 

<pre>
Criatura de nom NIL     amb menys d'1 any       i amb sexe de nen.
Criatura de nom PERE    amb 1 any               i amb sexe de nen.
Criatura de nom NEUS    amb menys d'1 any       i amb sexe de nena.
Criatura de nom JOAN    amb 1 any               i amb sexe de nen.
Criatura de nom ONA     amb 1 any               i amb sexe de nena.
Criatura de nom DÍDAC   amb menys d'1 any       i amb sexe de nen.
Criatura de nom NIL     amb 1 any               i amb sexe de nen.
Criatura de nom EVA     amb 3 anys              i amb sexe de nena.
Criatura de nom FIONA   amb 2 anys              i amb sexe de nena.
Criatura de nom ENIA    amb 3 anys              i amb sexe de nena.
Criatura de nom OLGA    amb 2 anys              i amb sexe de nena.
</pre>

<hr>

## **5.** Un exemple de la **Classe** **`Interfície`** **`Mainaderia`**

```java
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
```

#### Aquí podeu trobar el codi de la **`Interfície`** [**`Mainaderia.java`**](./files/Mainaderia.java)

<hr>

## **6.** Una implementació de la **`Interfície`** **`Mainaderia`** que utilitza un objecte List

```java
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
```

#### Aquí podeu trobar el codi de la **`Classe`** [**`MainaderiaList.java`**](./files/MainaderiaList.java)

<hr>

## **7.** Un exemple de la **Classe** **`ExempleIteracio`**

```java
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
public class ExempleIteracio {
   public static void main (String [] args ) {
      List nens = new LinkedList();
      List nenes = new LinkedList();
      List llarInfants = new LinkedList();
      Iterator it;
      Object membre;
      Criatura criatura = null;
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
      it = llarInfants.iterator();
      while (it.hasNext()) {
         membre = it.next();
         System.out.println(membre);
      }
// --------------------------------------
// calcular edat mitjana
      System.out.println("Calcular l'edat mitjana");
      double sumaEdats = 0;
      double edatMitjana;
      it = llarInfants.iterator();
      while (it.hasNext()) {
         membre = it.next(); // membre ha estat declarat Object
         criatura = (Criatura) membre;
         sumaEdats += criatura.getEdat();
      }
      edatMitjana = sumaEdats/llarInfants.size();
      System.out.println("L'edat mitjana és: " + edatMitjana);
// -----------------------------------
// buscar una nena de tres anys
      System.out.println("Buscar una nena de tres any");
      boolean trobada = false;
      it = llarInfants.iterator();
      while (it.hasNext() && !trobada) {
         criatura = (Criatura)it.next();
         if (criatura.getSexe()==Criatura.NENA && criatura.getEdat()==3)
            trobada = true;
      }
      if (trobada) {
         System.out.println("Nena de tres anys trobada: ");
         System.out.println(criatura);
      }
      else {
         System.out.println("La cerca no ha tingut èxit");
      }
//-------------------------------------
// Eliminar critatures de 0 o de 3 anys
      System.out.println("Eliminar criatures de 0 o de 3 anys");
      it = llarInfants.iterator();
      while (it.hasNext()) {
         criatura = (Criatura)it.next();
         if (criatura.getEdat()==0 || criatura.getEdat()==3) {
            // llarInfants.remove(criatura); // incorrecte!!!
            it.remove(); // OK. Elimina el darrer element
            // proporcionat per next
         }
      }
//--------------------------------------
      System.out.println("Mostrar totes les criatures després d'eliminar les de 0 o de 3 anys");
      it = llarInfants.iterator();
      while (it.hasNext()) {
         membre = it.next();
         System.out.println(membre);
      }
   }
}
```

#### Aquí podeu trobar el codi de la **`Classe`** [**`ExempleIteracio.java`**](./files/ExempleIteracio.java)

#### Sortida de l'execució de la **`Classe`** **`ExempleIteracio`**. 

<pre>
Mostrar totes les criatures
Criatura de nom: NIL, té 0 anys. Sexe: nen
Criatura de nom: PERE, té 1 anys. Sexe: nen
Criatura de nom: DÍDAC, té 0 anys. Sexe: nen
Criatura de nom: NIL, té 1 anys. Sexe: nen
Criatura de nom: VICTOR, té 2 anys. Sexe: nen
Criatura de nom: PAU, té 3 anys. Sexe: nen
Criatura de nom: NEUS, té 0 anys. Sexe: nena
Criatura de nom: ONA, té 1 anys. Sexe: nena
Criatura de nom: EVA, té 3 anys. Sexe: nena
Criatura de nom: FIONA, té 2 anys. Sexe: nena
Criatura de nom: ENIA, té 3 anys. Sexe: nena
Calcular l'edat mitjana
L'edat mitjana és: 1.4545454545454546
Buscar una nena de tres any
Nena de tres anys trobada: 
Criatura de nom: EVA, té 3 anys. Sexe: nena
Eliminar criatures de 0 o de 3 anys
Mostrar totes les criatures després d'eliminar les de 0 o de 3 anys
Criatura de nom: PERE, té 1 anys. Sexe: nen
Criatura de nom: NIL, té 1 anys. Sexe: nen
Criatura de nom: VICTOR, té 2 anys. Sexe: nen
Criatura de nom: ONA, té 1 anys. Sexe: nena
Criatura de nom: FIONA, té 2 anys. Sexe: nena
</pre>

<hr>

## **8.** Primer exemple (**`Exemple_Map_01.java`**) de la **Classe** **`Criatura`** amb **`Maps`**

```java
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
```

#### Aquí podeu trobar el codi de la **`Classe`** [**`Exemple_Map_01.java`**](./files/Exemple_Map_01.java)


