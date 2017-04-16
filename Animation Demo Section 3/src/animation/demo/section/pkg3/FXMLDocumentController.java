/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.demo.section.pkg3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas drawingCanvas;
    private GraphicsContext gc;

    private double cx;
    private double cy;
    private double px;
    private double py;
    private double r;
    private double theta;
    private double dtheta;
    
    private double w;
    private double h;
    Image oneImage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        w = drawingCanvas.getWidth();
        h = drawingCanvas.getHeight();
        r = 200;
        cx = 0;
        cy = 0;
        theta = - Math.PI / 2.0;
        dtheta = 2 * Math.PI / 60.0;
        oneImage = new Image("resources/one.jpg");
        // Labtask: animate the second's hand for an analog clock
        // hometask:
        // 1. put image labels for the different hour marks on the dial
        // 2. animate the hour hand and the minute hand
        // 3. fix the time so that it is synchronized with the current time
        
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
            gc.strokeOval(cx + w / 2 - r, cy + h / 2 - r, r * 2, r * 2);
            px = r * Math.cos(theta);
            py = r * Math.sin(theta);
            gc.drawImage(oneImage, px + w / 2, py + h / 2);
            gc.strokeLine(cx + w / 2, cy + h / 2, px + w / 2, py + h / 2);
            theta += dtheta;
        });
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        // KeyFrame
        // Timeline
    }    
    
}
