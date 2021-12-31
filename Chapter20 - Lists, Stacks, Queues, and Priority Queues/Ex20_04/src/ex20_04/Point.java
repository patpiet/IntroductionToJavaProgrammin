/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex20_04;

/**
 *
 * @author patpiet
 */
public class Point implements Comparable {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public int compareTo(Object t) {
        Point point = (Point) t;
        if (this.x > point.getX()) {
            return 1;
        } else if (this.x < point.getX()) {
            return -1;
        } else {
            if(this.y > point.getY()){
                return 1;
            }
            else if(this.y < point.getY()){
                return -1;
            }
            else return 0;
        }
    }
    
    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
