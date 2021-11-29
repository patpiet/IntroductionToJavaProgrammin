/*
    Write a program that displays a rectanguloid, as shown
    in Figure 14.47a. The cube should grow and shrink as the window grows or
    shrinks.
 */
package ex14_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex14_13 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        
        Rectangle back = new Rectangle();
        back.xProperty().bind(pane.widthProperty().multiply(0.2));
        back.yProperty().bind(pane.heightProperty().multiply(0.1));
        back.widthProperty().bind(pane.widthProperty().multiply(0.7));
        back.heightProperty().bind(pane.heightProperty().multiply(0.6));
        back.setFill(null);
        back.setStroke(Color.BLACK);
        
        Rectangle front = new Rectangle();
        front.xProperty().bind(pane.widthProperty().multiply(0.1));
        front.yProperty().bind(pane.heightProperty().multiply(0.3));
        front.widthProperty().bind(pane.widthProperty().multiply(0.7));
        front.heightProperty().bind(pane.heightProperty().multiply(0.6));
        front.setFill(null);
        front.setStroke(Color.BLACK);
        
        Line leftLine1 = new Line();
        leftLine1.startXProperty().bind(back.xProperty());
        leftLine1.startYProperty().bind(back.yProperty());
        leftLine1.endXProperty().bind(front.xProperty());
        leftLine1.endYProperty().bind(front.yProperty());
        
        Line leftLine2 = new Line();
        leftLine2.startXProperty().bind(back.xProperty());
        leftLine2.startYProperty().bind(back.yProperty().add(back.heightProperty()));
        leftLine2.endXProperty().bind(front.xProperty());
        leftLine2.endYProperty().bind(front.yProperty().add(front.heightProperty()));
        
        Line rightLine1 = new Line();
        rightLine1.startXProperty().bind(back.xProperty().add(back.widthProperty()));
        rightLine1.startYProperty().bind(back.yProperty());
        rightLine1.endXProperty().bind(front.xProperty().add(front.widthProperty()));
        rightLine1.endYProperty().bind(front.yProperty());
        
        Line rightLine2 = new Line();
        rightLine2.startXProperty().bind(back.xProperty().add(back.widthProperty()));
        rightLine2.startYProperty().bind(back.yProperty().add(back.heightProperty()));
        rightLine2.endXProperty().bind(front.xProperty().add(front.widthProperty()));
        rightLine2.endYProperty().bind(front.yProperty().add(front.heightProperty()));
        
        
        pane.getChildren().add(back);
        pane.getChildren().add(front);
        pane.getChildren().add(leftLine1);
        pane.getChildren().add(leftLine2);
        pane.getChildren().add(rightLine1);
        pane.getChildren().add(rightLine2);
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Exercise_14_01"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
