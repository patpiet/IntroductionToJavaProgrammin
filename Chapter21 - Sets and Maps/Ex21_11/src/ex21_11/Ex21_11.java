/*
    (Baby name popularity ranking) Use the data files from Programming
    Exercise 12.31 to write a program that enables the user to select a year, gender,
    and enter a name to display the ranking of the name for the selected year and
    gender, as shown in Figure 21.9. To achieve the best efficiency, create two arrays
    for boy’s names and girl’s names, respectively. Each array has 10 elements for
    10 years. Each element is a map that stores a name and its ranking in a pair
    with the name as the key.
 */
package ex21_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex21_11 extends Application {
    private final Integer[] years = getYears();
    private final String[] genderArray = {"Male", "Female"};
    
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // CREATE GUI
        // Create border pane
        BorderPane pane = new BorderPane();
        
        // Craete GridPane
        GridPane gridPane = new GridPane();
        
        ComboBox<Integer> cboYears = new ComboBox<>(observableArrayList(years));
        
        ComboBox<String> cboGender = new ComboBox<>(observableArrayList(genderArray));
                
        TextField tfName = new TextField();
                
        Button btFind = new Button("Find Ranking");

        Label lbRanking = new Label("");
        
        gridPane.add(new Label("Select a years: "), 0, 0);
        gridPane.add(cboYears, 1, 0);
        gridPane.add(new Label("Boy or a girl? "), 0, 1);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(new Label("Enter a name: "), 0, 2);
        gridPane.add(tfName, 1, 2);
        gridPane.add(new Label(""), 0, 3);
        gridPane.add(btFind, 1, 3);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        btFind.setOnAction(e ->{
            // Create file
            File file = new File("names/babynamesranking" + cboYears.getValue() + ".txt");
            String name = tfName.getText();
            String gender = cboGender.getValue();
            
            try {
                HashMap<String, Integer> map = getRanking(file, gender);
                
                if(map.containsKey(name)){
                    String gend = (gender.equals("Female")) ? "Girl" : "Boy";
                    lbRanking.setText(gend + " name " + name + " is ranked #" + map.get(name)
                                      + " in year " + cboYears.getValue());
                }else{
                    lbRanking.setText("Not such name in that year.");
                }
            } catch (FileNotFoundException ex) {
                System.out.println("File not found");
            }
        });
        
        pane.setCenter(gridPane);
        pane.setBottom(lbRanking);
        pane.setPrefWidth(270);
        pane.setPadding(new Insets(10));
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise_21_11"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.
    }

    private Integer[] getYears() {
        Integer[] years = new Integer[10];
        int index = 0;
        for (int i = 2001; i <= 2010; i++) {
            years[index] = i;
            index++;
        }
        return years;
    }

    private HashMap<String, Integer> getRanking(File file, String gender) throws FileNotFoundException {
        // Store all names of the gender and its ranking
        HashMap<String, Integer> map = new HashMap<>();
        
        // Create scanner object
        try(Scanner input = new Scanner(file);){
            // Loop through the file
            while(input.hasNext()){
                String line = input.nextLine();
                String[] words = line.split("\\s+");
                
                // Loop through the line
                for (int i = 0; i < words.length; i++) {
                    switch(gender){
                        case "Female":{     // Add female name
                            map.put(words[3], Integer.parseInt(words[0]));
                            break;
                        }
                        case "Male":{   // Add male name
                            map.put(words[1], Integer.parseInt(words[0]));
                            break;
                        }
                    }
                }
            }
        }
        return map;
    }

}
