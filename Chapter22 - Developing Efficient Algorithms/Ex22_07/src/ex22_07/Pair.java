/*
 */
package ex22_07;

/**
 *
 * @author patpiet
 */
public class Pair {
    private Point p1;
    private Point p2;
    
    public Pair(){
    }
    
    public Pair(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    
    public double getDistance(){
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }
}
