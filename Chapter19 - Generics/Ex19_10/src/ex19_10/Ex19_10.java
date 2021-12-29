/*
    (Largest element in ArrayList) Write the following method that returns the largest
    element in an ArrayList:

    public static <E extends Comparable<E>> E max(ArrayList<E> list)
 */
package ex19_10;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author patpiet
 */
public class Ex19_10 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(99, 43, 54, 33, 5, 73, 518, 32));

        System.out.println(max(list));
        
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E maxElement = list.get(0);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(maxElement) == 1) {
                maxElement = list.get(i);
            }
        }

        return maxElement;
    }
}
