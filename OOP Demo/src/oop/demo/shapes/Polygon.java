/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.demo.shapes;

import oop.demo.Point;
import java.util.ArrayList;
/**
 *
 * @author kmhasan
 */
public class Polygon extends Shape {
    Point array[];
    
    public Polygon(Point p[]) {
        array = new Point[p.length];
        for (int i = 0; i < p.length; i++)
            array[i] = p[i];
        name = "Polygon";
    }
    
    public Polygon(ArrayList<Point> points) {
        // this((Point[]) points.toArray());

        array = new Point[points.size()];
        for (int i = 0; i < points.size(); i++)
            array[i] = points.get(i);
        name = "Polygon";
    }
    
    @Override
    public double getArea() {
        return 0.0;
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0.0;
        for (int i = 0; i < array.length - 1; i++)
            perimeter += array[i].getDistance(array[i + 1]);
        perimeter += array[array.length - 1].getDistance(array[0]);
        return perimeter;
    }
    
}
