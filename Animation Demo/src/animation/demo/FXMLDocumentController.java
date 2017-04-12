/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.demo;

import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas drawingCanvas;
    private GraphicsContext gc;
    private int frameCount;
    private ArrayList<Ball> ballsList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        frameCount = 1;
        ballsList = new ArrayList<>();
        ballsList.add(new Ball());
        ballsList.add(new Ball());
        ballsList.add(new Ball());

        ballsList.get(1).setvX(1);
        ballsList.get(1).setColor(Color.RED);
        ballsList.get(1).setxPos(200);
        
        ballsList.get(2).setvY(2);
        ballsList.get(2).setColor(Color.BLUE);
        ballsList.get(2).setxPos(400);
        
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(.05), event -> {
            gc.clearRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
            Image image = new Image("images/RBH3.jpg");
            for (Ball ball : ballsList) {
                // draw the ball
                gc.setFill(ball.getColor());
                //
                gc.fillOval(ball.getxPos(), ball.getyPos(), ball.getRadius() * 2, ball.getRadius() * 2);
                gc.drawImage(image, ball.getxPos(), ball.getyPos());
                ball.updateBall();
            }
            
            for (int i = 0; i < ballsList.size(); i++)
                for (int j = i + 1; j < ballsList.size(); j++) {
                    if (ballsList.get(i).isColliding(ballsList.get(j))) {
                        System.out.println("COLLISSION between " + i + " " + j);
                        double tvX = ballsList.get(j).getvX();
                        double tvY = ballsList.get(j).getvY();
                        ballsList.get(j).setvX(ballsList.get(i).getvX());
                        ballsList.get(j).setvY(ballsList.get(i).getvY());
                        ballsList.get(i).setvX(tvX);
                        ballsList.get(i).setvY(tvY);
                    }
                }
        });

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        /*
        gc.strokeRect(10, 10, 20, 20);
        gc.strokeRect(20, 10, 20, 20);
        gc.strokeRect(30, 10, 20, 20);
         */
    }

}
