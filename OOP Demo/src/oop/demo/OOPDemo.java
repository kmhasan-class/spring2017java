package oop.demo;

public class OOPDemo {

    static double getDistance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    public static void main(String[] args) {
        double x1 = 10, y1 = 5;
        double x2 = 3, y2 = 15;
        System.out.printf("Distance %f\n", getDistance(x1, y1, x2, y2));
        
        // Point is a class (data type)
        // p1 is an object (variable)
        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        System.out.printf("Distance %f\n", p1.getDistance(p2));
    }

}
