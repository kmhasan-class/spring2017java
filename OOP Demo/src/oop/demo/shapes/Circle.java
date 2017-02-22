/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo.shapes;

import oop.demo.shapes.Shape;

/**
 *
 * @author kmhasan
 */
public class Circle extends Shape {
    double radius;
    
    public Circle(double r) {
        name = "Circle";
        radius = r;
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
        
        // in C you could use M_PI from math.h
    }
    
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
