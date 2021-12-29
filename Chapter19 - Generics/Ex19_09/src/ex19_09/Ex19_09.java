/*
    (Sort ArrayList) Write the following method that sorts an ArrayList:

    public static <E extends Comparable<E>> void sort(ArrayList<E> list)
 */
package ex19_09;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author patpiet
 */
public class Ex19_09 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(99, 43, 54, 33, 5, 73, 58, 32));

        sort(list);

        System.out.println(list);
    }

    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        if (list.size() < 2) {  // base case
            return;
        }

        int mid = list.size() / 2;  // get midpoint of the list

        // create lists for two halfs
        ArrayList<E> leftHalf = new ArrayList<>();
        ArrayList<E> rightHalf = new ArrayList<>();

        // split the array to two arrays
        for (int i = 0; i < mid; i++) {
            leftHalf.add(list.get(i));
        }

        for (int i = mid; i < list.size(); i++) {
            rightHalf.add(list.get(i));
        }

        // recursive calls for both lists
        sort(leftHalf);
        sort(rightHalf);

        // merging the lists
        merge(list, leftHalf, rightHalf);
    }

    public static <E extends Comparable<E>> void merge(ArrayList<E> list, ArrayList<E> leftHalf, ArrayList<E> rightHalf) {
        // i for index of left half, j for inde of right half, and k for the original list
        int i = 0, j = 0, k = 0;

        // sort out the lists
        while (i < leftHalf.size() && j < rightHalf.size()) {
            if (leftHalf.get(i).compareTo(rightHalf.get(j)) >= 1) {
                list.set(k, rightHalf.get(j));
                j++;
            } else {
                list.set(k, leftHalf.get(i));
                i++;
            }
            k++;
        }
        
        // fill out original list with elements left
        while(i < leftHalf.size()){
            list.set(k++, leftHalf.get(i++));
        }
        
        while(j < rightHalf.size() - 1){
            list.set(k++, rightHalf.get(j++));
        }
    }
}
