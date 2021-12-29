/*
    (Maximum element in a two-dimensional array) Write a generic method that
    returns the maximum element in a two-dimensional array.

    public static <E extends Comparable<E>> E max(E[][] list)
 */
package ex19_06;

/**
 *
 * @author patpiet
 */
public class Ex19_06 {

    public static void main(String[] args) {
        Integer[][] a = {
            {1, 2, 3},
            {4, 5, 6, 9},
            {7},};
        
        System.out.println(max(a));
    }

    public static <E extends Comparable> E max(E[][] list) {
        E maxElement = list[0][0];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(maxElement) == 1) {
                    maxElement = list[i][j];
                }
            }
        }
        return maxElement;
    }
}
