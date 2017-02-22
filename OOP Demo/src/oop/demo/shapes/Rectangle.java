/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo.shapes;

/**
 *
 * @author kmhasan
 */
public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double w, double h) {
        name = "Rectangle";
        width = w;
        height = h;
    }

    public double getArea() {
        return width * height;
    }
    
    public double getPerimeter() {
        return 2 * (width + height);
    }

}
