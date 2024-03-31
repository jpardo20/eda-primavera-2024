package files;
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
