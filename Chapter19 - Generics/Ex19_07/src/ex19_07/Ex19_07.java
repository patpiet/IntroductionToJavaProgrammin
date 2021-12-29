/*
    (Generic binary search) Implement the following method using binary search.

    public static <E extends Comparable<E>>
        int binarySearch(E[] list, E key)
 */
package ex19_07;

/**
 *
 * @author patpiet
 */
public class Ex19_07 {

    public static void main(String[] args) {

        Integer[] list = {4, 6, 8, 10 , 15, 54, 104, 554, 1095, 1534};
        
        System.out.println(binarySearch(list, 1534));
    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
        
        int mid = list.length / 2;
        
        while(!list[mid].equals(key)){
            if(list[mid].compareTo(key) == 1){
                mid /= 2;
            }else{
                mid = (mid + list.length) / 2;
            }
        }
        return mid;
    }
}
