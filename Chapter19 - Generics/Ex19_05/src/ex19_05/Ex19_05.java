/*
    (Maximum element in an array) Implement the following method that returns the
    maximum element in an array.

    public static <E extends Comparable<E>> E max(E[] list)
 */
package ex19_05;

/**
 *
 * @author patpiet
 */
public class Ex19_05 {

    public static void main(String[] args) {

        Integer[] list = {5, 4, 6, 57, 4, 3, 23};
        
        System.out.println(max(list));

    }

    public static <E extends Comparable> E max(E[] list) {
        E maxElement = list[0];

        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(maxElement) == 1) {
                maxElement = list[i];
            }
        }
        return maxElement;
    }
}
