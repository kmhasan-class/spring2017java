/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.program.section.pkg4;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

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
    @FXML
    private ToggleButton polygonButton;
    @FXML
    private ToggleButton freehandButton;
    private ArrayList<Double> xValues;
    private ArrayList<Double> yValues;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        xValues = new ArrayList<>();
        yValues = new ArrayList<>();
        isFirstLine = true;
        brushSizeSlider.setMin(10);
        brushSizeSlider.setMax(50);
        brushSizeField.setText("" + brushSizeSlider.getValue());
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setLineWidth(brushSizeSlider.getValue());
        colorPicker.setValue(Color.BLACK);
        freehandButton.setSelected(true);
        polygonButton.setSelected(false);
    }    

    @FXML
    private void handleMouseClickAction(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if (!isFirstLine && freehandButton.isSelected())
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

    @FXML
    private void handlePolygonToggleAction(ActionEvent event) {
        polygonButton.setSelected(true);
        freehandButton.setSelected(false);
    }

    @FXML
    private void handleFreehandToggleAction(ActionEvent event) {
        polygonButton.setSelected(false);
        freehandButton.setSelected(true);
    }

    @FXML
    private void handlePolygonClickAction(MouseEvent event) {
        if (polygonButton.isSelected()) {
            if (event.isSecondaryButtonDown()) {
                double[] xArray = new double[xValues.size()];
                double[] yArray = new double[yValues.size()];
                for (int i = 0; i < xArray.length; i++) {
                    xArray[i] = xValues.get(i);
                    yArray[i] = yValues.get(i);
                }
                gc.fillPolygon(xArray, yArray, xArray.length);
            } else {
                xValues.add(event.getX());
                yValues.add(event.getY());
                if (xValues.size() > 1) {
                    gc.strokeLine(xValues.get(xValues.size() - 2), yValues.get(yValues.size() - 2),
                            xValues.get(xValues.size() - 1), yValues.get(yValues.size() - 1));
                }
            }
        }
    }

    @FXML
    private void handleFileSaveAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(null);
        
        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage((int) drawingCanvas.getWidth(), (int) drawingCanvas.getHeight());
                drawingCanvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);            
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
