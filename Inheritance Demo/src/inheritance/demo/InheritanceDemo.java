/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

import inheritance.demo.shapes.Circle;
import inheritance.demo.shapes.SquareInheritance;
import inheritance.demo.shapes.Rectangle;
import inheritance.demo.shapes.Shape;
import inheritance.demo.shapes.Triangle;
/**
 *
 * @author kmhasan
 */
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Rectangle r = new Rectangle(10, 15);
        SquareInheritance s = new SquareInheritance(15);
        Circle c = new Circle(15);
        Triangle t = new Triangle(4, 5, 6);
        
        Rectangle sh; // declaration
        sh = new SquareInheritance(10); // instantiation
        sh.printAreaAndPerimeter();
        
        r.printAreaAndPerimeter();
        s.printAreaAndPerimeter();
        c.printAreaAndPerimeter();
        t.printAreaAndPerimeter();
        */
        
        Shape shapes[] = new Shape[6];
        shapes[0] = new Triangle(10, 20, 15);
        shapes[1] = new SquareInheritance(10);
        shapes[2] = new Rectangle(10, 20);
        shapes[3] = new Circle(10);
        shapes[4] = new Circle(20);
        
        for (int i = 0; i < shapes.length; i++)
            if (shapes[i] != null)
                shapes[i].printAreaAndPerimeter();
    }
    
}
