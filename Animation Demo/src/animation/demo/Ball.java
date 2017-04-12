    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.demo;

import javafx.scene.paint.Color;

/**
 *
 * @author kmhasan
 */
public class Ball {

    private double xPos;
    private double yPos;
    private double radius;
    private double vX;
    private double vY;
    private int signX;
    private int signY;
    private double screenWidth;
    private double screenHeight;
    private Color color;
    
    public Ball() {
        xPos = 0;
        yPos = 0;
        signX = +1;
        signY = +1;
        radius = 50;
        vX = +12;
        vY = +10;
        screenWidth = 1024;
        screenHeight = 640;
        color = Color.BLACK;
    }

    public void updateBall() {
        xPos = xPos + signX * vX;
        yPos = yPos + signY * vY;

        if (xPos < 0 || xPos + radius * 2 > screenWidth) {
            signX = -signX;
        }

        if (yPos < 0 || yPos + radius * 2 > screenHeight) {
            signY = -signY;
        }
    }

    public double getyPos() {
        return yPos;
    }

    public double getRadius() {
        return radius;
    }

    public double getvX() {
        return vX;
    }

    public double getvY() {
        return vY;
    }

    public int getSignX() {
        return signX;
    }

    public int getSignY() {
        return signY;
    }

    public double getScreenWidth() {
        return screenWidth;
    }

    public double getScreenHeight() {
        return screenHeight;
    }

    public double getxPos() {
        return xPos;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
}
