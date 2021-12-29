/*
    Shuffle ArrayList) Write the following method that shuffles an ArrayList:

    public static <E> void shuffle(ArrayList<E> list)
 */
package ex19_08;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author patpiet
 */
public class Ex19_08 {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(
                4, 5, 6, 5, 7, 4, 554, 
                543, 5, 34, 534, 51, 3,
                12321, 765756, 423, 423, 645));

        // unshuffled list
        System.out.println(list);

        shuffle(list);
        // shuffled list
        System.out.println(list);

    }

    public static <E> void shuffle(ArrayList<E> list) {
        int originalSize = list.size();

        ArrayList<E> tempList = new ArrayList<>();

        for (int i = 0; i < originalSize; i++) {
            int randomElementIndex = (int) (Math.random() * list.size());

            tempList.add(list.get(randomElementIndex));

            list.remove(randomElementIndex);
        }

        list.addAll(tempList);
    }
}
