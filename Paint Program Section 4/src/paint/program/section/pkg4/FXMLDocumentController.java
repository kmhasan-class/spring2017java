/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.program.section.pkg4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    private double oldX;
    private double oldY;
    private boolean isFirstLine;
    private GraphicsContext gc;
    
    @FXML
    private Canvas drawingCanvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private TextField brushSizeField;
    @FXML
    private Slider brushSizeSlider;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isFirstLine = true;
        brushSizeSlider.setMin(10);
        brushSizeSlider.setMax(50);
        brushSizeField.setText("" + brushSizeSlider.getValue());
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setLineWidth(brushSizeSlider.getValue());
        colorPicker.setValue(Color.BLACK);
    }    

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if (!isFirstLine)
            gc.strokeLine(oldX, oldY, x, y);
        
        isFirstLine = false;
        
        oldX = x;
        oldY = y;
        
        System.out.printf("(%f, %f)\n", x, y);
    }

    @FXML
    private void handleMouseReleasedAction(MouseEvent event) {
        isFirstLine = true;
    }

    @FXML
    private void handleColorSelectionAction(ActionEvent event) {
        Color color = colorPicker.getValue();
        gc.setStroke(color);
    }

    @FXML
    private void handleChangeBrushSizeAction(ActionEvent event) {
        double strokeWidth = Double.parseDouble(brushSizeField.getText());
        gc.setLineWidth(strokeWidth);
    }

    @FXML
    private void handleSliderDragAction(MouseEvent event) {
        double brushSize = brushSizeSlider.getValue();
        brushSizeField.setText("" + brushSize);
        double strokeWidth = Double.parseDouble(brushSizeField.getText());
        gc.setLineWidth(strokeWidth);
    }
    
}
