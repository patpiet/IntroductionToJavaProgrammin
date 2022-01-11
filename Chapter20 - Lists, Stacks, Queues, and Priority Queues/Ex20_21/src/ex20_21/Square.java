/*
    Design a class named Square that extends
    GeometricObject and implements Colorable. Implement howToColor to
    display the message Color all four sides.
 */
package ex20_21;

public class Square extends GeometricObject{
    private double side1;
    private double side2;
    
    public Square(){
        this.side1 = 1;
        this.side2 = 1;
    }
    
    public Square(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }
    
    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(GeometricObject t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }
    
}
