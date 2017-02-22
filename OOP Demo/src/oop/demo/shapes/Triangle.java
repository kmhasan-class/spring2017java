/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo.shapes;

import oop.demo.Point;

/**
 *
 * @author kmhasan
 */
public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double x, double y, double z) {
        a = x;
        b = y;
        c = z;
        name = "Triangle";
    }
    
    public Triangle(Point p1, Point p2, Point p3) {
        a = p1.getDistance(p2);
        b = p2.getDistance(p3);
        c = p3.getDistance(p1);
        name = "Triangle";
    }
    
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
