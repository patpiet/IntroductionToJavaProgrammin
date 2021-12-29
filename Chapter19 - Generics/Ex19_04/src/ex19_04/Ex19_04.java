/*
    (Generic linear search) Implement the following generic method for linear search.

    public static <E extends Comparable<E>>
        int linearSearch(E[] list, E key)
 */
package ex19_04;

/**
 *
 * @author patpiet
 */
public class Ex19_04 {

    public static void main(String[] args) {
        Integer[] list = {5, 4, 6, 7, 4, 3, 23};
        
        System.out.println(linearSearch(list, 23));     //expected: 6
        
        
        String[] listStrings = {"Adam", "Patrick", "Colt", "Jamie"};
    
        System.out.println(linearSearch(listStrings, "Colt"));  //expected: 2
        System.out.println(linearSearch(listStrings, "Colt:D")); //expected: -1 
    }

    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
