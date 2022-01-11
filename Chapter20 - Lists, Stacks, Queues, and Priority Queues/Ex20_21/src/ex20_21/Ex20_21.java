/*
    (Use Comparator) Write the following generic method using selection sort
    and a comparator.

    public static <E> void selectionSort(E[] list,
    Comparator<? super E> comparator)

    Write a test program that creates an array of 10 GeometricObjects and
    invokes this method using the GeometricObjectComparator introduced in
    Listing 20.4 to sort the elements. Display the sorted elements. Use the following
    statement to create the array.
    
    GeometricObject[] list = {new Circle(5), new Square(4, 5),
    new Circle(5.5), new Square(2.4, 5), new Circle(0.5),
    new Square(4, 65), new Circle(4.5), new Square(4.4, 1),
    new Circle(6.5), new Square(4, 5)};
 */
package ex20_21;

import java.util.Comparator;

/**
 *
 * @author patpiet
 */
public class Ex20_21 {

    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5), new Square(4, 5),
        new Circle(5.5), new Square(2.4, 5), new Circle(0.5),
        new Square(4, 65), new Circle(4.5), new Square(4.4, 1),
        new Circle(6.5), new Square(4, 5)};
        
        selectionSort(list, new GeometricObjectComparator());

        System.out.println("Sorted list:+");
        for(GeometricObject obj: list){
            System.out.println(obj.getArea());
        }
    }
    
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator){
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if(comparator.compare(list[i], list[j]) == 1){
                    E temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
    }
    

}
