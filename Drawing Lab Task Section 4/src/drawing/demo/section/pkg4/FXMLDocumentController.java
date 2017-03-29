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
        for (int x = 0; x <= width; x += 20)
            gc.strokeLine(x, 0, x, height);
        
        for (int y = 0; y <= height; y += 20)
            gc.strokeLine(0, y, width, y);
        
        gc.setStroke(Color.BLUE);
        for (int x = 0; x <= width; x += 100)
            gc.strokeLine(x, 0, x, height);
        
        for (int y = 0; y <= height; y += 100)
            gc.strokeLine(0, y, width, y);
        
    }
    
    public double f(double x) {
        // y = f(x) = x^2
//        return (x * x * x - 3 * x * x)/ 5000;
        return Math.sin(x);
    }
    
    public void plotFunction() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        
        double width = drawingCanvas.getWidth();
        double height = drawingCanvas.getHeight();
        
        double dx = 0.1;
        
        for (double x = -width; x < width; x += dx) {
            double x1 = x;
            double y1 = f(x1);
            
            double x2 = x1 + dx;
            double y2 = f(x2);
            
            gc.strokeLine(x1 + width / 2, -y1 + height / 2, x2 + width / 2, -y2 + height / 2);
        }
            
    }
    
    public void draw() {
        drawGrid();
        
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);

        plotFunction();
        
        // Hometasks:
        // 1. Draw a circle right at the center with radius of 150 pixels
        // 2. Draw 20 concentric circles in the top left box
        // 3. Draw a sun (circle + rays)
        // 4. Draw a regular n-gon (like pentagon)
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        draw();
    }    
    
}
