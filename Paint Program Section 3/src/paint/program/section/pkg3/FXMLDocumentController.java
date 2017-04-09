/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.program.section.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Canvas drawingCanvas;
    private GraphicsContext gc;
    private double oldX = 0;
    private double oldY = 0;
    private double radius = 10;
    private boolean isFirstTime;
    @FXML
    private ColorPicker colorPicker;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setLineWidth(2 * radius);
        isFirstTime = true;
        gc.setStroke(Color.RED);
        colorPicker.setValue(Color.RED);
    }    

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        gc.strokeOval(event.getX() - radius, event.getY() - radius, 2 * radius, 2 * radius);
        isFirstTime = true;
    }

    @FXML
    private void handleMouseDragAction(MouseEvent event) {
        gc.fillOval(event.getX() - radius, event.getY() - radius, radius * 2, radius * 2);
        double newX = event.getX();
        double newY = event.getY();
        if (!isFirstTime)
            gc.strokeLine(oldX, oldY, newX, newY);
        isFirstTime = false;
        oldX = newX;
        oldY = newY;
    }

    @FXML
    private void handleColorPickerAction(ActionEvent event) {
        gc.setStroke(colorPicker.getValue());
    }
    
}
