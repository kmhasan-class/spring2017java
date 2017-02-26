/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo.shapes;

/**
 *
 * @author kmhasan
 */
public class Rectangle extends Shape {
    protected double length;
    private double width;
    
    // default constructor
    public Rectangle() {
        
    }
    
    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }
    
    @Override
    public double getArea() {
        return length * width;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
    
}
