/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex22_07;

import java.util.Comparator;

/**
 *
 * @author patpiet
 */
public class CompareY implements Comparator<Point> {

    @Override
    public int compare(Point p1, Point p2) {
        if (p1.getY() > p2.getY()) {
            return 1;
        } else if (p1.getY() < p2.getY()) {
            return -1;
        } else {
            if (p1.getX() > p2.getX()) {
                return 1;
            } else if (p1.getX() < p2.getX()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
