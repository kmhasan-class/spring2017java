package oop.demo;

public class Point {
    double x;
    double y;
    
    Point(double xn, double yn) {
        x = xn;
        y = yn;
    }
    
    double getDistance(Point p2) {
        double dx = this.x - p2.x;
        double dy = this.y - p2.y;
        
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }
}
