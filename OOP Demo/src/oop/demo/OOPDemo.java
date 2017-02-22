package oop.demo;

import oop.demo.shapes.Circle;
import oop.demo.shapes.Polygon;
import oop.demo.shapes.Square;
import oop.demo.shapes.Rectangle;
import oop.demo.shapes.Shape;
import oop.demo.shapes.Triangle;

// import is just a shorthand

public class OOPDemo {

    static double getDistance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    static int convertStringToInteger(String input) {
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            /*
            sum = sum * 10;
            char ch = input.charAt(i);
            int digit = ch - '0';
            sum = sum + digit;
            */
            sum = sum * 10 + input.charAt(i) - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
        double x1 = 10, y1 = 5;
        double x2 = 3, y2 = 15;
        System.out.printf("Distance %f\n", getDistance(x1, y1, x2, y2));

        // Point is a class (data type)
        // p1 is an object (variable)
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        System.out.printf("Distance %.2f\n", p1.getDistance(p2));
        
        // Home Work: see if you can handle a + or - prefix
        String str = "1356";
        int x = convertStringToInteger(str);
        System.out.println(x);
        */
        /*
        Point p1; // declaration
        p1 = new Point(2, 3); // instanciation
        p1.translate(5, -2);
        //p1.rotate(53);
        System.out.printf("(%.2f, %.2f)\n", p1.getX(), p1.getY());
        */
        
        Point pointArray[] = new Point[3];
        pointArray[0] = new Point(0, 0);
        pointArray[1] = new Point(1, 0);
        pointArray[2] = new Point(0, 1);
  
        Shape shapes[] = new Shape[6];
        shapes[0] = new Rectangle(5, 4);
        shapes[1] = new Square(50);
        shapes[2] = new Circle(10);
        shapes[3] = new Triangle(4, 5, 8);
        shapes[4] = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        shapes[5] = new Polygon(pointArray);
        
        for (int i = 0; i < shapes.length; i++)
            shapes[i].printAreaAndPerimeter();

    }

}
