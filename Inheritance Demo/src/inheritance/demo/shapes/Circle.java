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
public class Circle extends Shape {
    private double radius;
    
    public Circle(double r) {
        radius = r;
        name = "Circle";
    }
    
    public Circle() {
        radius = 0.0;
        name = "Circle";
    }
    
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
  
}
