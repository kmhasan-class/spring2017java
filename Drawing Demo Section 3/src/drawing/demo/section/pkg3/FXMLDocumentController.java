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
        for (double x = 0; x <= width; x = x + dx)
            gc.strokeLine(x, 0, x, height);
        
        // horizontal lines
        for (double y = 0; y <= height; y = y + dy)
            gc.strokeLine(0, y, width, y);
        
        // Hometask:
        // 1. draw major gridlines every 100 pixels apart
        // 2. brush up on your trigonometry and polar coordinate knowledge
        
    }
    
    private void drawTriangle() {
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.strokeLine(200, 0, 200, 150); // line segment C
        gc.strokeLine(200, 150, 400, 150); // line segment A
        gc.strokeLine(400, 150, 200, 0); // line segment B
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        drawGrid();
        drawTriangle();
    }    
    
}
