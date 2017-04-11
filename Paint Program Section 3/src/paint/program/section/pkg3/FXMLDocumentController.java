/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.program.section.pkg3;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

    @FXML
    private Canvas drawingCanvas;
    private GraphicsContext gc;
    private double oldX = 0;
    private double oldY = 0;
    private double radius = 10;
    private boolean isFirstTime;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Slider brushSizeSlider;
    @FXML
    private TextField brushSizeField;

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
        //gc.strokeOval(event.getX() - radius, event.getY() - radius, 2 * radius, 2 * radius);
        isFirstTime = true;
    }

    @FXML
    private void handleMouseDragAction(MouseEvent event) {
        gc.fillOval(event.getX() - radius, event.getY() - radius, radius * 2, radius * 2);
        double newX = event.getX();
        double newY = event.getY();
        if (!isFirstTime) {
            gc.strokeLine(oldX, oldY, newX, newY);
        }
        isFirstTime = false;
        oldX = newX;
        oldY = newY;
    }

    @FXML
    private void handleColorPickerAction(ActionEvent event) {
        gc.setStroke(colorPicker.getValue());
    }

    @FXML
    private void handleSliderDragAction(MouseEvent event) {
        double brushSize = brushSizeSlider.getValue();
        brushSizeField.setText(brushSize + "");
        gc.setLineWidth(brushSize);
    }

    @FXML
    private void handleBrushSizeFieldAction(ActionEvent event) {
        double brushSize = Double.parseDouble(brushSizeField.getText());
        brushSizeSlider.setValue(brushSize);
    }

    @FXML
    private void handleFileSaveAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(null);
        System.out.println("Saving #" + file + "#");
        if (file != null) {
            // Stole the following part from:
            // http://java-buddy.blogspot.com/2013/04/save-canvas-to-png-file.html
            try {
                WritableImage writableImage = new WritableImage((int) drawingCanvas.getWidth(), (int) drawingCanvas.getHeight());
                drawingCanvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                // hometask: make sure you can save files in any format (not just png)
                // hints: find the extension of the file from the filename, then use substring
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                System.err.println("Couldn't save the file!");
                // hometask: throw an alert dialog from here
            }
        }
    }

}
