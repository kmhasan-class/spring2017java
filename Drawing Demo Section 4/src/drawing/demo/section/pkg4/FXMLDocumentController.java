/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.demo.section.pkg4;

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

    public void drawGrid() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        // Task: draw a grid paper with horizontal lines 20 pixels apart
        // and the vertical lines 20 pixels apart, as well

        double width = drawingCanvas.getWidth();
        double height = drawingCanvas.getHeight();

        gc.setStroke(Color.RED);
        for (int x = 0; x <= width; x += 20) {
            gc.strokeLine(x, 0, x, height);
        }

        for (int y = 0; y <= height; y += 20) {
            gc.strokeLine(0, y, width, y);
        }

        gc.setStroke(Color.BLUE);
        for (int x = 0; x <= width; x += 100) {
            gc.strokeLine(x, 0, x, height);
        }

        for (int y = 0; y <= height; y += 100) {
            gc.strokeLine(0, y, width, y);
        }

    }

    public void draw() {
        drawGrid();

        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.setFill(Color.YELLOW);
        gc.fillRect(300 - 50, 200 - 50, 100, 100);
        gc.strokeRect(300 - 50, 200 - 50, 100, 100);
        gc.setFill(Color.GREEN);
        gc.fillOval(100, 100, 200, 100);
        gc.strokeOval(100, 100, 200, 100);

        // Hometasks:
        // 1. Draw a circle right at the center with radius of 150 pixels
        // 2. Draw 20 concentric circles in the top left box
        // 3. Draw a sun (circle + rays)
        // 4. Draw a regular n-gon (like pentagon)
    }

    public void task1() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();

        double radius = 150;
        gc.setFill(new Color(9 / 255.0, 59 / 255.0, 220 / 255.0, 0.75));
        gc.fillOval(drawingCanvas.getWidth() / 2 - radius, drawingCanvas.getHeight() / 2 - radius, radius * 2, radius * 2);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(drawingCanvas.getWidth() / 2 - radius, drawingCanvas.getHeight() / 2 - radius, radius * 2, radius * 2);
    }

    public void task2() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();

        for (double radius = 50; radius > 0; radius -= 2.5) {
            gc.strokeOval(50 - radius, 50 - radius, radius * 2, radius * 2);
        }
    }

    public void task3() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        double w = drawingCanvas.getWidth();
        double h = drawingCanvas.getHeight();
        double radius = 50;

        gc.setFill(new Color(1.0, 1.0, 0.0, 0.75));
        gc.fillOval(w / 2 - radius, h / 2 - radius, radius * 2, radius * 2);
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(3);
        gc.strokeOval(w / 2 - radius, h / 2 - radius, radius * 2, radius * 2);

        for (double theta = 0; theta <= Math.PI * 2; theta += Math.PI * 2 / 20.0) {
            double r2 = 200;
            double r1 = 50;
            double x1 = r1 * Math.cos(theta);
            double y1 = -r1 * Math.sin(theta);
            double x2 = r2 * Math.cos(theta);
            double y2 = -r2 * Math.sin(theta);
            gc.strokeLine(x1 + w / 2, y1 + h / 2, x2 + w / 2, y2 + h / 2);
        }

        for (double theta = Math.PI / 20; theta <= Math.PI * 2; theta += Math.PI * 2 / 20.0) {
            double r2 = 150;
            double r1 = 50;
            double x1 = r1 * Math.cos(theta);
            double y1 = -r1 * Math.sin(theta);
            double x2 = r2 * Math.cos(theta);
            double y2 = -r2 * Math.sin(theta);
            gc.strokeLine(x1 + w / 2, y1 + h / 2, x2 + w / 2, y2 + h / 2);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //draw();
        drawGrid();
        task3();
    }

}
