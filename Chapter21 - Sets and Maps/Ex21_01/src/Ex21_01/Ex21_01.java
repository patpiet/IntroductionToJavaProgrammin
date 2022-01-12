/*
    Perform set operations on hash sets) Create two linked hash sets {"George",
    "Jim", "John", "Blake", "Kevin", "Michael"} and {"George", "Katie",
    "Kevin", "Michelle", "Ryan"} and find their union, difference, and intersection.
    (You can clone the sets to preserve the original sets from being changed by
    these set methods.)
 */
package Ex21_01;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author patpiet
 */
public class Ex21_01 {

    public static void main(String[] args) {
        // Set up the sets
        Set<String> set1 = new HashSet<>();
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");
        
        Set<String> set2 = new HashSet<>();
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");
        
        System.out.println("UNION");
        System.out.println(union(set1, set2));
        
        System.out.println("DIFFERENCE");
        System.out.println(diff(set1, set2));
        
        System.out.println("INTERSECTION");
        System.out.println(intersect(set1, set2));
    }

    private static Set<String> union(Set<String> set1, Set<String> set2) {
        Set<String> temp = new HashSet<>(set1);

        temp.addAll(set2);
        
        return temp;
    }

    private static Set<String> diff(Set<String> set1, Set<String> set2) {
        Set<String> temp = new HashSet<>(set1);
        
        temp.removeAll(set2);
        
        return temp;
    }

    private static Set<String> intersect(Set<String> set1, Set<String> set2) {
        Set<String> temp = new HashSet<>(set1);
        
        temp.retainAll(set2);
        
        return temp;
    }
    
}
