/*
    Modify the GeometricObject class
    to implement the Comparable interface, and define a static max method in the
    GeometricObject class for finding the larger of two GeometricObject objects.
    Draw the UML diagram and implement the new GeometricObject class. Write
    a test program that uses the max method to find the larger of two circles and the
    larger of two rectangles.
*/
package ex20_21;

import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject>, Colorable{
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    
    // Construct default geometric object
    public GeometricObject(){
        dateCreated = new java.util.Date();
    }
    // Construct a geometric object with specified details
    public GeometricObject(String color, boolean filled){
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    // Return color
    public String getColor(){
        return color;
    }
    
    // Set a new color
    public void setColor(String color){
        this.color = color;
    }
    
    // Return filled
    public boolean isFilled(){
        return filled;
    }
    
    // Set a new filled
    public void setFilled(boolean filled){
        this.filled = filled;
    }
    // Get dateCreated
    public Date getDateCreated(){
        return dateCreated;
    }
    
    // Return a string representation of this object
    @Override
    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
    // Returns larger GeometricObject
    public static GeometricObject max(GeometricObject obj, GeometricObject obj2) {
        
        return (obj.getArea() >= obj2.getArea()) ? obj : obj2;
        
    }
}
