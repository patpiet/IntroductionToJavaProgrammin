/*
    (Sort points in a plane) Write a program that meets the following requirements:
    
    ■ Define a class named Point with two data fields x and y to represent a
    point’s x- and y-coordinates. Implement the Comparable interface for comparing
    the points on x-coordinates. If two points have the same x-coordinates,
    compare their y-coordinates.
    
    ■ Define a class named CompareY that implements Comparator<Point>.
    Implement the compare method to compare two points on their y-coordinates.
    If two points have the same y-coordinates, compare their x-coordinates.
    
    ■ Randomly create 100 points and apply the Arrays.sort method to display
    the points in increasing order of their x-coordinates and in increasing order
    of their y-coordinates, respectively.
 */
package ex20_04;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author patpiet
 */
public class Ex20_04 {

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        
        for (int i = 0; i < 100; i++) {
            points.add(new Point((int) (Math.random() * 10), (int) (Math.random() * 10)));
        }
        
        // Sort by x
        Collections.sort(points);
        
        for(Point point: points){
            System.out.println(point.toString());
        }
        
        System.out.println("BREAK!");
        
        // sort by y
        Collections.sort(points, new CompareY());
        
        for(Point point: points){
            System.out.println(point.toString());
        }
        
        
        
    }
    
}
