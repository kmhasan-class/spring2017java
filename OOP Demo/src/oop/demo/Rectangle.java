/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo;

/**
 *
 * @author kmhasan
 */
public class Rectangle {
    private double width;
    private double height;
    private String name;
    
    public Rectangle(double w, double h) {
        name = "Rectangle";
        width = w;
        height = h;
    }
    
    // setter/mutator method
    public void setName(String n) {
        name = n;
    }
    
    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
    public String getName() {
        return name;
    }
}
