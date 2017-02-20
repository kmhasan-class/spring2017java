/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo;

/**
 *
 * @author kmhasan
 */
/*
public class Square {
    private double length;
    
    public Square(double l) {
        length = l;
    }
    
    public double getArea() {
        return length * length;
    }
    
    public double getPerimeter() {
        return 4 * length;
    }
}
*/

public class Square extends Rectangle {
    public Square(double l) {
        super(l, l);
        setName("Square");
    }
}
