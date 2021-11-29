/*
    Write a program that places four fans in a GridPane with two
    rows and two columns, as shown in Figure 14.45b.
 */
package ex14_09;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ex14_09 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ArrayList<Pane> panes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            addFan(panes);
        }

        int index = 0;
        GridPane gPane = new GridPane();
        gPane.setAlignment(Pos.CENTER);
        gPane.setHgap(10);
        gPane.setVgap(10);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                gPane.add(panes.get(index), i, j);
                index++;
            }

        }
        // Create a scene and place it in the stage
        Scene scene = new Scene(gPane);
        primaryStage.setTitle("Exercise_14_09"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    // Adds fan to the list of panes
    public static void addFan(ArrayList<Pane> panes) {
        Pane pane = new Pane();
        //  Create a circle
        Circle c = new Circle(150, 135, 135, Color.WHITE);
        c.setStroke(Color.BLACK);

        Arc[] a = new Arc[4];
        for (int j = 0; j < 4; j++) {
            a[j] = new Arc(150, 135, 120, 120, 90 * j, 30);
            a[j].setStroke(Color.BLACK);
            a[j].setFill(Color.BLACK);
            a[j].setType(ArcType.ROUND);
        }
        pane.getChildren().add(c);
        pane.getChildren().addAll(a);
        panes.add(pane);
    }
}

