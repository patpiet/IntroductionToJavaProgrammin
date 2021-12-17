/*
    (Display country flag and flag description) Listing 16.4, ComboBoxDemo.java,
    gives a program that lets the user view a country’s flag image and description
    by selecting the country from a combo box. The description is a string coded
    in the program. Rewrite the program to read the text description from a file.
    Suppose that the descriptions are stored in the files description0.txt, . . . , and
    description8.txt under the text directory for the nine countries Canada, China,
    Denmark, France, Germany, India, Norway, United Kingdom, and United States,
    in this order.
*/
package ex16_27;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex16_27 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Declare an array of String for flag titles
        final String[] flagTitles = {"Canada", "China", "Denmark", "France",
                                     "Germany", "India", "Norway", "Poland"};
        // Declare an array of ImageView for flag images
        final ImageView[] flagImage = {new ImageView("image/canada.png"),
                                       new ImageView("image/china.png"),
                                       new ImageView("image/denmark.png"),
                                       new ImageView("image/france.png"),
                                       new ImageView("image/germany.png"),
                                       new ImageView("image/india.png"),
                                       new ImageView("image/norway.png"),
                                       new ImageView("image/poland.png")};
        // Create border pane
        BorderPane pane = new BorderPane();
        
        // Create HBOX
        HBox paneForTop = new HBox(5);
        Label lbCountry = new Label("Select a country: ");
        ComboBox<String> cboCountry = new ComboBox<>();
        cboCountry.setPrefWidth(450);
        cboCountry.setValue("Canada");
        cboCountry.getItems().addAll(flagTitles);
        paneForTop.getChildren().addAll(lbCountry, cboCountry);
       
        // Creat hbox for flag image and description
        HBox paneForBottom = new HBox(20);
        flagImage[0].setFitHeight(150);
        flagImage[0].setFitWidth(250);
        
        paneForBottom.getChildren().addAll(flagImage[0], getDescription(0));
        
        pane.setTop(paneForTop);
        pane.setCenter(paneForBottom);
        
        cboCountry.setOnAction(e ->{
            // Get index of the country
            int index = cboCountry.getItems().indexOf(cboCountry.getValue());
            // Clear the pane
            paneForBottom.getChildren().clear();
            // Set up the flag and description
            ScrollPane description = null;
            ImageView flag = flagImage[index];
            flag.setFitWidth(250);
            flag.setFitHeight(150);
            try {
                description = getDescription(index);
            } catch (FileNotFoundException ex) {
                System.out.println("No description for that country");
            }
            // Add the nodes to the pane
            paneForBottom.getChildren().addAll(flag, description);
        });
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 550, 190);
        primaryStage.setTitle("Exercise_16_27"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }
    
    // Returns text field with description of country with specified index
    public ScrollPane getDescription(int index) throws FileNotFoundException{
        Scanner input = new Scanner(new File("description/description" + index +".txt"));
        String description = "";
        while(input.hasNextLine()){
            description += input.nextLine() + "\n";
        }
        TextArea ta = new TextArea(description);
        ta.setPrefColumnCount(30);
        ta.setPrefRowCount(10);
        ScrollPane scrollPane = new ScrollPane(ta);
        return scrollPane;
    }
}
