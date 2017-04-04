/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.demo.section.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas drawingCanvas;

    private void drawGrid() {
        double width = drawingCanvas.getWidth();
        double height = drawingCanvas.getHeight();
        double dx = 20;
        double dy = 20;

        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.LIGHTGRAY);

        // write two for loops to draw the horizontal and vertical lines
        // vertical lines
        for (double x = 0; x <= width; x = x + dx) {
            gc.strokeLine(x, 0, x, height);
        }

        // horizontal lines
        for (double y = 0; y <= height; y = y + dy) {
            gc.strokeLine(0, y, width, y);
        }

        dx = 100;
        dy = 100;

        gc.setStroke(Color.DARKGRAY);

        // write two for loops to draw the horizontal and vertical lines
        // vertical lines
        for (double x = 0; x <= width; x = x + dx) {
            gc.strokeLine(x, 0, x, height);
        }

        // horizontal lines
        for (double y = 0; y <= height; y = y + dy) {
            gc.strokeLine(0, y, width, y);
        }
        // Hometask:
        // 2. brush up on your trigonometry and polar coordinate knowledge

    }

    private void drawRegularNGons() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setFill(Color.YELLOW);
        gc.setLineWidth(5);

        double r = 200;
        double theta;

        for (theta = 0; theta <= 360; theta += 72) {
            double x1 = 0;
            double y1 = 0;
            double x2 = r * Math.cos(theta * Math.PI / 180.0);
            double y2 = r * Math.sin(theta * Math.PI / 180.0);

            double w = drawingCanvas.getWidth();
            double h = drawingCanvas.getHeight();
            gc.strokeLine(x1 + w / 2, -y1 + h / 2, x2 + w / 2, -y2 + h / 2);
        }
    }

    private void drawTriangle() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.strokeLine(200, 0, 200, 150); // line segment C
        gc.strokeLine(200, 150, 400, 150); // line segment A
        gc.strokeLine(400, 150, 200, 0); // line segment B
    }

    private void drawShapes() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setFill(Color.YELLOW);
        gc.setLineWidth(5);
        double w = 100;
        double h = 100;
        double width = drawingCanvas.getWidth();
        double height = drawingCanvas.getHeight();

        gc.fillRect(width / 2 - w / 2, height / 2 - h / 2, w, h);
        gc.strokeRect(width / 2 - w / 2, height / 2 - h / 2, w, h);

        double initialX = 100;
        double initialY = 200;
        double dr = -20;
        for (double radius = 100; radius >= 20; radius += dr, initialX -= dr, initialY -= dr) {
            gc.strokeOval(initialX, initialY, 2 * radius, 2 * radius);
        }

        // Hometasks:
        // 1. draw a sun!
        // 2. draw regular ngons (fix the function that I wrote)
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drawGrid();
        drawRegularNGons();
    }

}
