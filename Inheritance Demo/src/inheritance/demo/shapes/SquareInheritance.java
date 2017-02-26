/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo.shapes;

import inheritance.demo.shapes.Rectangle;

/**
 *
 * @author kmhasan
 */
public class SquareInheritance extends Rectangle {
    public SquareInheritance(double length) {
        super(length, length);
    }
    
    @Override
    public double getArea() {
        return length * length + 2 * length;
    }
}
