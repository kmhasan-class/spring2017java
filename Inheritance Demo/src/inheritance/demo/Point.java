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
public class Point {
    private double x;
    private double y;
    
    public Point() {
        x = 0.0;
        y = 0.0;
    }
    
    public Point(double a, double b) {
        x = a;
        y = b;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}
