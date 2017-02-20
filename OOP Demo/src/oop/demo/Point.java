package oop.demo;

public class Point {
    // private, public are access modifiers
    private double x;
    private double y;
    
    // CONSTRUCTOR
    public Point(double xn, double yn) {
        x = xn;
        y = yn;
    }
    
    // DEFAULT CONSTRUCTOR 
    public Point() {
        x = 0.0;
        y = 0.0;
    }
    
    public void translate(double h, double k) {
        x = x + h;
        y = y + k;
    }

    private void rotate(double angle) {
        // this is wrong
        // Homework: fix this code
        x = 5;
        y = 3;
    }
    
    public double getDistance(Point p2) {
        double dx = this.x - p2.x;
        double dy = this.y - p2.y;
        
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }
    
    // getter/accessor method
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
}
