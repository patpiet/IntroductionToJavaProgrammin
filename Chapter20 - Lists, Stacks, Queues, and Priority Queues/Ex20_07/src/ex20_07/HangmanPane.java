/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex20_07;

import java.util.ArrayList;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

/**
 *
 * @author patpiet
 */
public class HangmanPane extends Pane {

    private Arc base;
    private Line verticalLine, horizontalLine, rope,
            body, leftArm, rightArm, rightLeg, leftLeg;
    private Circle head;
    private Label lbWord, lbLetters;
    private Text txWord, txLetters;
    private String word, letters = "";
    private ArrayList<Shape> hangmanShapes;
    private boolean finished = false;

    public HangmanPane() {
        startGame();
    }

    // Starts the game from the beggining
    private void startGame() {
        getChildren().clear();
        // Create arc object
        base = new Arc(40, 190, 30, 15, 0, 180);
        base.setFill(Color.WHITE);
        base.setStroke(Color.BLACK);

        // Create vertical line
        verticalLine = new Line(40, 175, 40, 20);

        // Create horizontal line
        horizontalLine = new Line(40, 20, 140, 20);

        // Create rope
        rope = new Line(140, 20, 140, 35);
        rope.setStroke(null);

        // Create head
        head = new Circle(140, 50, 15);
        head.setFill(null);
        head.setStroke(null);

        // Create body
        body = new Line(140, 65, 140, 120);
        body.setStroke(null);

        // Create legs
        leftLeg = new Line(140, 120, 120, 170);
        leftLeg.setStroke(null);
        rightLeg = new Line(140, 120, 160, 170);
        rightLeg.setStroke(null);

        // Create arms
        leftArm = new Line(128.5, 62, 90, 90);
        leftArm.setStroke(null);
        rightArm = new Line(151.5, 62, 190, 90);
        rightArm.setStroke(null);

        // Set up labels for words
        lbWord = new Label("Guess a word: ");
        lbWord.setLayoutX(70);
        lbWord.setLayoutY(200);

        lbLetters = new Label("Missed letters: ");
        lbLetters.setLayoutX(70);
        lbLetters.setLayoutY(215);

        txWord = new Text("");
        txWord.setLayoutX(150);
        txWord.setLayoutY(213);

        txLetters = new Text("");
        txLetters.setLayoutX(150);
        txLetters.setLayoutY(228);

        // Add hangman shaped to the list
        hangmanShapes = new ArrayList<>();
        hangmanShapes.add(rope);
        hangmanShapes.add(head);
        hangmanShapes.add(leftArm);
        hangmanShapes.add(rightArm);
        hangmanShapes.add(body);
        hangmanShapes.add(leftLeg);
        hangmanShapes.add(rightLeg);

        // Add nodes to the pane
        getChildren().addAll(base, verticalLine, horizontalLine, rope,
                head, leftArm, rightArm, body, leftLeg, rightLeg,
                lbWord, lbLetters, txWord, txLetters);
    }

    public void setWord(String word) {
        // Set a word to guess
        this.word = word;

        // Encrypt the word
        for (int i = 0; i < word.length(); i++) {
            txWord.setText(txWord.getText() + "*");
        }
    }

    // Return the word to be guessed
    public String getWord() {
        return word;
    }

    // Note missed letter
    private void addLetter(String letter) {
        if (!letters.contains(letter)) {
            letters += letter;
            txLetters.setText(letters);
        }
    }

    // Check the guessed letter
    public void checkLetter(String letter) {
        if (!finished) {  // Continue if not finished
            if (word.contains(letter)) {    // guessed letter case
                String wordToBe = "";
                // Update the name on the GUI
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == letter.charAt(0)) {
                        wordToBe += letter;
                    } else if (txWord.getText().charAt(i) != '*') {
                        wordToBe += word.charAt(i);
                    } else {
                        wordToBe += "*";
                    }
                }
                txWord.setText(wordToBe);
            } else {    // Letter not guessed case
                addLetter(letter);
                addHangman();
                // User lost case
                if (letters.length() >= 6) {
                    finish();
                }
            }
            // User won case
            if (!txWord.getText().contains("*")) {
                finish();
            }
        }
    }

    private void addHangman() {
        // Update hangman visualization
        for (int i = 0; i <= letters.length(); i++) {
            hangmanShapes.get(i).setStroke(Color.BLACK);
        }
    }

    // GUI when round finished
    private void finish() {
        finished = true;
        txWord.setText(word);
        txLetters.setText("");
        lbLetters.setText("To continue the game, press ENTER");
    }

    public void resetGame() {
        finished = false;
        startGame();    // reset the GUI
        setWord("word");    // Set up a new word - an example here
        letters = "";
    }

}
