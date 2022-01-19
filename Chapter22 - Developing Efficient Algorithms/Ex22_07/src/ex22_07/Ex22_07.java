/*
    (Closest pair of points) Section 22.8 introduced an algorithm for finding the
    closest pair of points using a divide-and-conquer approach. Implement the
    algorithm to meet the following requirements:
    ■ Define the classes Point and CompareY in the same way as in Programming
    Exercise 20.4.
    ■ Define a class named Pair with the data fields p1 and p2 to represent two
    points, and a method named getDistance() that returns the distance
    between the two points.
 */
package ex22_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author patpiet
 */
public class Ex22_07 {

    public static void main(String[] args) {
        // Set up the points
        ArrayList<Point> S = new ArrayList<>();
        S.add(new Point(4, 5));
        S.add(new Point(2, 6));
        S.add(new Point(2.4, 5.4));
        S.add(new Point(9.4, 2.3));
        S.add(new Point(-4.4, -3));
        S.add(new Point(-3, 3));
        S.add(new Point(0.4, 3.3));
        
        // Sort points by X
        Collections.sort(S);
        
        // Part the points
        List<Point> S1 = S.subList(0, (S.size() + 1)/2);
        List<Point> S2 = S.subList((S.size() + 1)/2, S.size());
        
        Point midPoint = S1.get(S1.size() - 1);
        
        // Get the closest pairs from two lists
        Pair p1 = getClosestPair(S1);
        Pair p2 = getClosestPair(S2);
        
        // Get the closest distance from two lists
        double d = Math.min(p1.getDistance(), p2.getDistance());
        
        // Store points ordered on Y
        ArrayList<Point> pointsOrderedOnY = new ArrayList<Point>(S);
        pointsOrderedOnY.sort(new CompareY());

        ArrayList<Point> stripL = new ArrayList<>();
        ArrayList<Point> stripR = new ArrayList<>();
        
        // Obtainig stripL and stripR
        for(Point p: pointsOrderedOnY){
            if(S1.contains(p) && midPoint.getX() - p.getX() <= d)
                stripL.add(p);
            else if(S2.contains(p) && midPoint.getX() - p.getX() <= d)
                stripR.add(p);
        }
        
        // Finding the Closest Pair
        int r = 0; // r is the index of a point in stripR
        for(Point p: stripL){
            while(r < stripR.size() && stripR.get(r).getY() <= p.getY() - d)
                r++;
            
            int r1 = r;
            while(r1 < stripR.size() && Math.abs(stripR.get(r1).getY() - p.getY()) <= d){
                // Check if (p, q[r1] is a pssible closest pair
                if(distance(p, stripR.get(r1)) < d){
                    d = distance(p, stripR.get(r1));
                }
                r1++;
            }
        }
        
        // return the closest distance
        System.out.println(d);
        
    }
    
    // Returns the closest pair in the list
    private static Pair getClosestPair(List<Point> S) {
        double closest = 1000000000;
        Pair closestPair = null;
        for (int i = 0; i < S.size(); i++) {
            for (int j = i + 1; j < S.size(); j++) {
                Pair pair = new Pair(S.get(i), S.get(j));
                double d = pair.getDistance();
                if(d < closest){
                    closest = d;
                    closestPair = pair;
                }
            }
        }
        return closestPair;
    }

    private static double distance(Point p1, Point p2) {
        Pair pair = new Pair(p1, p2);
        return pair.getDistance();
    }
    
}
