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
public abstract class Shape {
    protected String name;
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
    public String getName() {
        return name;
    }   
    
    public void printAreaAndPerimeter() {
        System.out.printf("Area of %s = %f\n", name, getArea());
        System.out.printf("Perimeter of %s = %f\n", name, getPerimeter());
    }
}
