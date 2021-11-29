/*
    Write a program that displays a string Welcome to
    Java around the circle, as shown in Figure 14.44b. Hint: You need to display each
    character in the right location with appropriate rotation using a loop.
 */
package ex14_05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex14_05 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(600, 600);
        
        String str = "Welcome To Java";
        double rotation = 90;
        double offset = pane.getPrefWidth() / 2;
        double radius = 100;
        double x;
        double y;
        
        for (int i = 0; i < str.length(); i++) {
            x = offset + Math.cos(Math.toRadians(rotation)) * radius;
            y = offset + Math.sin(Math.toRadians(rotation)) * radius;
            Text text = new Text(x, y , str.charAt(i) + "");
            text.setFont(new Font(22));
            text.setRotate(rotation);
            pane.getChildren().add(text);
            rotation += 22.5;
        }
        
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_14_05"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
}
