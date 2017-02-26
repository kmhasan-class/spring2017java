/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

/**
 *
 * @author kmhasan
 */
public class Square {

    private double length;

    public Square() {
        length = 0.0;
    }

    public Square(double l) {
        length = l;
    }

    public double getArea() {
        return length * length;
    }

    public double getPerimeter() {
        return 4 * length;
    }

    public void printAreaAndPerimeter() {
        System.out.printf("Area of the shape: %.2f, perimeter of the shape: %.2f\n",
                getArea(), getPerimeter());
    }
}
