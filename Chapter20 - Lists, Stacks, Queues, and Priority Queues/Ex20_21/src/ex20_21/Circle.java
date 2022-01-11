/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex20_21;

/**
 *
 * @author User
 */
public class Circle extends GeometricObject implements Comparable<GeometricObject>{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius,
            String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    /**
     * Return radius
     * @return 
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Set a new radius
     * @param radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Return area
     */
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Return diameter
     * @return 
     */
    public double getDiameter() {
        return 2 * radius;
    }

    /**
     * Return perimeter
     * @return 
     */
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Print the circle info
     */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated()
                + " and the radius is " + radius);
    }

    @Override
    public int compareTo(GeometricObject t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void howToColor() {
        System.out.println("All the circle");
    }
    
    public boolean equals(Circle obj){
        return (obj.radius - this.radius == 0);
    }
}
