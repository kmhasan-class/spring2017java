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
        
        gc.setStroke(Color.LIGHTGRAY);
        for (int x = 0; x <= width; x += 20)
            gc.strokeLine(x, 0, x, height);
        
        for (int y = 0; y <= height; y += 20)
            gc.strokeLine(0, y, width, y);
        
    }
    
    public void draw() {
        drawGrid();
        
        GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.strokeLine(300, 175, 600, 0);
        gc.strokeLine(300, 150, 600, 0);
        gc.strokeLine(300, 200, 600, 0);
        gc.strokeLine(0, 200, 600, 200);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        draw();
    }    
    
}
