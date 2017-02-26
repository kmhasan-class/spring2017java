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
public class Shape {
    public double getPerimeter() {
        return 0.0;
    }
    
    public double getArea() {
        return 0.0;
    }
    
    public void printAreaAndPerimeter() {
        System.out.printf("Area of the shape: %.3f, perimeter of the shape: %.3f\n",
                getArea(), getPerimeter());
    }
    
}
