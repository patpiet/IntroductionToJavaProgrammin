/*
    Write a program that plots the sine function
    in red and cosine in blue, as shown in Figure 14.48c.
    Hint: The Unicode for p is \u03c0. To display -2p, use Text(x, y, "-2\u03c0").
    For a trigonometric function like sin(x), x is in radians
 */
package ex14_19;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_19 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create pane
        Pane pane = new Pane();

        // Create cosinus
        Polyline cosinus = new Polyline();
        ObservableList<Double> listCos = cosinus.getPoints();
        double scaleFactor = 50;
        for (int x = -225; x <= 225; x++) {
            listCos.add(x + 225.0);
            listCos.add(100 - 50 * Math.cos((x / 100.0) * 2 * Math.PI) + 75);
        }
        cosinus.setStroke(Color.BLUE);
        
        // Create sinus
        Polyline sinus = new Polyline();
        ObservableList<Double> listSin = sinus.getPoints();
        for (int x = -225; x <= 225; x++) {
            listSin.add(x + 225.0);
            listSin.add(100 - 50 * Math.sin((x / 100.0) * 2 * Math.PI) + 75);
        }
        sinus.setStroke(Color.RED);
        
        // Create y and x axis
        Line lineX = new Line(0, 175, 480, 175);

        Line lineY = new Line(225, 250, 225, 30);

        // Create arrows linked with bots axis
        Polyline arrowY = new Polyline();
        arrowY.getPoints().addAll(new Double[]{
            210.0, 45.0,
            225.0, 30.0,
            240.0, 45.0
        });

        Polyline arrowX = new Polyline();
        arrowX.getPoints().addAll(new Double[]{
            460.0, 160.0,
            480.0, 175.0,
            460.0, 190.0
        });

        // Create text objects to label axis
        Text x = new Text("x");
        x.setX(480);
        x.setY(160);
        x.setFont(new Font("Times Roman", 20));

        Text y = new Text("y");
        y.setX(245);
        y.setY(30);
        y.setFont(new Font("Times Roman", 20));
        
        // Create axis values
        Text zero = new Text("0");
        zero.setX(228);
        zero.setY(185);
        

        pane.getChildren().add(cosinus);
        pane.getChildren().add(sinus);
        pane.getChildren().add(lineX);
        pane.getChildren().add(lineY);
        pane.getChildren().add(arrowX);
        pane.getChildren().add(arrowY);
        pane.getChildren().add(x);
        pane.getChildren().add(y);
        pane.getChildren().add(zero);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 250);
        primaryStage.setTitle("Exercise_14_18"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

}
