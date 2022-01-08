/*
    (Game: hangman) Programming Exercise 7.35 presents a console version of the
    popular hangman game. Write a GUI program that lets a user play the game. The
    user guesses a word by entering one letter at a time, as shown in Figure 20.18.
    If the user misses seven times, a hanging man swings. Once a word is finished,
    the user can press the Enter key to continue to guess another word.
 */
package ex20_07;

import javafx.application.Application;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.ENTER;
import javafx.stage.Stage;

/**
 *
 * @author patpiet
 */
public class Ex20_07 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HangmanPane pane = new HangmanPane();
        
        String word = "laptop";
        pane.setWord(word);
        
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 270, 250);
        primaryStage.setTitle("Exercise_20_07"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage.

        scene.setOnKeyPressed(e ->{
            if(e.getCode().isLetterKey()){
                String letter = e.getCode().toString().toLowerCase();
                pane.checkLetter(letter);
            }else if(e.getCode() == ENTER){
                pane.resetGame();
            }
        });
    }
    
}
