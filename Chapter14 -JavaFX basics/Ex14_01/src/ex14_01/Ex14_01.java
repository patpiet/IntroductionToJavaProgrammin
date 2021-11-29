package ex14_01;

//*********************************************************************************
//* (Display images) Write a program that displays four images in a grid pane, as  *
//* shown in Figure 14.43a.                                                        *
//*********************************************************************************/
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Ex14_01 extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a pane to hold the images views
		GridPane pane = new GridPane();
                pane.setHgap(10);
                pane.setVgap(10);

		// Place nodes in the pane
		pane.add(new ImageView(new Image("image/us.png")), 0, 0);
		pane.add(new ImageView(new Image("image/uk.png")), 1, 0);
		pane.add(new ImageView(new Image("image/uk.png")), 0, 1);
		pane.add(new ImageView(new Image("image/us.png")), 1, 1);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise_14_01"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage.
	}
        
        public static void main(String[] args) {
            Application.launch(args);
    }
}