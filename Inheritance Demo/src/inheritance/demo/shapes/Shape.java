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
public abstract class Shape {
    protected String name;
    
    public abstract double getPerimeter();
    
    public abstract double getArea();
    
    public void printAreaAndPerimeter() {
        System.out.printf("Area of the %s: %.3f, perimeter of the %s: %.3f\n",
                name, getArea(), name, getPerimeter());
    }
    
}
