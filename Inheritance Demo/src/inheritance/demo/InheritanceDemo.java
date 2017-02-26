/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

import inheritance.demo.shapes.SquareInheritance;
import inheritance.demo.shapes.Rectangle;
/**
 *
 * @author kmhasan
 */
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 15);
        SquareInheritance s = new SquareInheritance(15);

        r.printAreaAndPerimeter();
        s.printAreaAndPerimeter();
    }
    
}
