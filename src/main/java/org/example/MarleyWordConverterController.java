package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MarleyWordConverterController {

    /**
     * Stage is used to represent a window in a JavaFX desktop application
     */
    private Stage stage;

    /**
     * Scene is the container for all content in a scene graph
     */
    private Scene scene;

    /**
     * Root provides a solution to the issue of defining a reusable component with FXML
     */
    private Parent root;

    @FXML
    private TextField inputWord;

    @FXML
    private Label errorLabel;

    static MyHashMap map = new MyHashMap();
    static String translation;

    //to catch empty text field
    boolean isEmpty;
    //to catch invalid char
    boolean indicator;
    //to check validation of parentheses
    boolean parenthesesChecking;

    @FXML
    void initialize() throws IOException {
        //input all the translation
        map.put('a', 'j');
        map.put('b', 'c');
        map.put('c', 't');
        map.put('d', 'a');
        map.put('e', 'k');
        map.put('f', 'z');
        map.put('g', 's');
        map.put('h', 'i');
        map.put('i', 'w');
        map.put('j', 'x');
        map.put('k', 'o');
        map.put('l', 'n');
        map.put('m', 'g');
        map.put('n', 'b');
        map.put('o', 'f');
        map.put('p', 'h');
        map.put('q', 'l');
        map.put('r', 'd');
        map.put('s', 'e');
        map.put('t', 'y');
        map.put('u', 'm');
        map.put('v', 'v');
        map.put('w', 'u');
        map.put('x', 'p');
        map.put('y', 'q');
        map.put('z', 'r');
        map.put('$', ' ');

    }

    @FXML
    void TranslateButtonPressed(MouseEvent event) throws IOException {
        errorLabel.setText("");
        indicator=false;
        parenthesesChecking=false;

        if(inputWord.getText().isEmpty()){
            System.out.println("Please do not leave text field empty!");
            errorLabel.setText("Please do not leave text field empty!");
            isEmpty = true;
        }
        else
            isEmpty = false;


        if(!isEmpty) {
            //catch invalid char input with ASCII
            for (int i = 0; i < inputWord.getText().length(); i++) {
                if (!((inputWord.getText().charAt(i) >= 97 && inputWord.getText().charAt(i) <= 122) ||
                        inputWord.getText().charAt(i) == 94 ||
                        inputWord.getText().charAt(i) == 36 ||
                        inputWord.getText().charAt(i) == 44 ||
                        inputWord.getText().charAt(i) == 40 ||
                        inputWord.getText().charAt(i) == 41)
                ) {
                    indicator = false;
                    parenthesesChecking = false;
                    System.out.println("There is an invalid character!");
                    errorLabel.setText("There is an invalid character!");
                    break;

                } else {
                    indicator = true;
                    parenthesesChecking = true;

                }

            }
        }

        //to check validation of parentheses
        if(parenthesesChecking) {

            int cnt = 0;

            for (int i = 0; i < inputWord.getText().length(); i++) {

                if (inputWord.getText().charAt(i) == '(') {
                    cnt++;
                }
                if (inputWord.getText().charAt(i) == ')') {
                    cnt--;
                }
            }
            if (cnt == 0) {
                indicator = true;
            } else {
                indicator = false;
                System.out.println("There is a grammar mistake!");
                errorLabel.setText("There is a grammar mistake!");
            }
        }


        if (indicator) {

            translation = WordConverter(inputWord.getText());

            //grammar in Marley Word
            for (int i = 0; i < translation.length(); i++) {

                if (translation.charAt(i) == '^') {
                    char upperCase = Character.toUpperCase(translation.charAt(i + 1));
                    int start = translation.indexOf(translation.charAt(i));
                    translation = translation.substring(0, start) + upperCase + translation.substring(start + 2);


                }

            }
            for (int i = 0; i < translation.length(); i++) {
                if (translation.charAt(i) == '(') {
                    int startIndex = translation.indexOf(translation.charAt(i));
                    int endIndex = translation.indexOf(')', startIndex);

                    String reverseSubstring = reverse(translation.substring(startIndex + 1, endIndex));

                    translation = translation.substring(0, startIndex) + reverseSubstring + translation.substring(endIndex + 1);
                }

            }
            System.out.println(translation);

            //forward to marley pop up window
            Stage stage = new Stage();
            Parent root;
            stage.setTitle("Translation Window");

            root = FXMLLoader.load((getClass().getResource("marley-pop-up-page.fxml")));
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            //code for popup window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(inputWord.getScene().getWindow());
            stage.showAndWait();

        }
    }


    //translation method with recursion
    static String WordConverter(String str) {
        String temp;
        if (str.length() == 0) {
            return "";
        } else {
            if (map.get(str.charAt(str.length() - 1)) > 0)
                temp = map.get(str.charAt(str.length() - 1)) + "";
            else
                temp = str.charAt(str.length() - 1) + "";

            return WordConverter(str.substring(0, str.length() - 1)) + temp;

        }

    }

    //reverse String method with recursion
    static String reverse(String str) {
        if (str.length() == 0) {
            return "";
        } else {
            return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
        }
    }


    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to choosing action page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choosing-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
