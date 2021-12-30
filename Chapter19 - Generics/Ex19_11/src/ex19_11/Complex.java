/*
    Design a class named Complex for representing complex numbers and the
    methods add, subtract, multiply, divide, and abs for performing complexnumber
    operations, and override toString method for returning a string representation
    for a complex number. The toString method returns (a + bi) as a
    string. If b is 0, it simply returns a. Your Complex class should also implement the
    Cloneable interface.
    Provide three constructors Complex(a, b), Complex(a), and Complex().
    Complex() creates a Complex object for number 0 and Complex(a) creates
    a Complex object with 0 for b. Also provide the getRealPart() and
    getImaginaryPart() methods for returning the real and imaginary part of the
    complex number, respectively.
 */
package ex19_11;

public class Complex implements Cloneable{
    private double realPart;
    private double imaginaryPart;
    
    // Default constructor
    public Complex(){
        realPart = 0;
        imaginaryPart = 0;
    }
    
    // Constructor with specified real part 
    public Complex(double a){
        this.realPart = a;
        this.imaginaryPart = 0;
    }
    
    // Constructor with specified both parts
    public Complex(double a, double b){
        this.realPart = a;
        this.imaginaryPart = b;
    }
    
    // returns sum of Complex numbers
    public Complex add(Complex number){
        this.realPart += number.realPart;
        this.imaginaryPart += number.imaginaryPart;
        return this;
    }
    
    // returns substraction of Complex numbers
    public String substract(Complex number){
        return (this.realPart - number.realPart) + " - " + (this.imaginaryPart - number.imaginaryPart) + "i";
    }
    
    // returns multiplication of Complex numbers
    public Complex multiply(Complex number){
        this.realPart = this.realPart * number.realPart - this.imaginaryPart * number.imaginaryPart;
        this.imaginaryPart = this.imaginaryPart * number.realPart + this.realPart * number.imaginaryPart;
        return this;
    }
    // returns division of Complex numbers
    public String divide(Complex number){
        return (this.realPart * number.realPart + this.imaginaryPart * number.imaginaryPart) /
                (Math.pow(number.realPart, 2) + Math.pow(number.imaginaryPart, 2)) + 
                " + " + (this.imaginaryPart * number.realPart - this.realPart * number.imaginaryPart) /
                (Math.pow(number.realPart, 2) + Math.pow(number.imaginaryPart, 2)) + "i";
    }
    
    // returns the absolute value for a complex number
    public double abs(){
        return Math.pow(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2), 0.5);
    }
    
    // returns a real part of number
    public double getRealPart(){
        return this.realPart;
    }
    
    // Returns a imaginary part of a number
    public double getImaginaryPart(){
        return this.imaginaryPart;
    }
    
    // Returns (a + bi) as a string
    @Override
    public String toString(){
        if(this.imaginaryPart != 0)
            return this.realPart + " + " + this.imaginaryPart + "i";
        else
            return this.realPart + "";
            
    }
}
