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
import java.util.Random;

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
    private TextField input;

    @FXML
    private Label errorLabel;

    static MyHashMap map = new MyHashMap();
    static MyHashMap encryptMap = new MyHashMap();
    static MyHashMap decryptMap = new MyHashMap();

    static String translation;

    //to catch empty text field
    boolean isEmpty;
    //to catch invalid char
    boolean indicator;
    //to check validation of parentheses
    boolean parenthesesChecking;
    //for cipher
    static String encryptedWord;
    static String decryptedWord;

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

        //cipher
        Random g = new Random();
        //to avoid duplicate values
        boolean[] duplicate = new boolean[26];

        //encrypt a-z
        for (int i = 0; i < 26; i++) {
            //generate random ascii code of a-z
            int k = g.nextInt(26) + 97;
            if(duplicate[k-97]==false) {
                duplicate[k-97] = true;
                encryptMap.put((char) (i + 97), (char) (k));
                decryptMap.put((char) (k), (char) (i + 97));
            }
            else
                i--;
        }

        //encrypt A-Z
        //to avoid duplicate values
        boolean[] duplicate2 = new boolean[26];
        for (int i = 0; i < 26; i++) {
            //generate random ascii code of A-Z
            int k = g.nextInt(26) + 65;
            if(duplicate2[k-65]==false) {
                duplicate2[k-65] = true;
                encryptMap.put((char) (i + 65), (char) (k));
                decryptMap.put((char) (k), (char) (i + 65));
            }
            else
                i--;
        }

        //encrypt space and comma
        encryptMap.put(' ', '1');
        decryptMap.put('1',' ');

        encryptMap.put(',', '2');
        decryptMap.put('2',',');

        System.out.println(input.getText());


    }


    @FXML
    void TranslateButtonPressed(MouseEvent event) throws IOException {

        errorLabel.setText("");
        indicator = false;
        parenthesesChecking = false;

        if (input.getText().isEmpty()) {
            System.out.println("Please do not leave text field empty!");
            errorLabel.setText("Please do not leave text field empty!");
            isEmpty = true;
        } else
            isEmpty = false;


        if (!isEmpty) {
            //catch invalid char input with ASCII
            for (int i = 0; i < input.getText().length(); i++) {
                if (!((input.getText().charAt(i) >= 97 && input.getText().charAt(i) <= 122) ||
                        input.getText().charAt(i) == 94 ||
                        input.getText().charAt(i) == 36 ||
                        input.getText().charAt(i) == 44 ||
                        input.getText().charAt(i) == 40 ||
                        input.getText().charAt(i) == 41)
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
        if (parenthesesChecking) {

            int cnt = 0;

            for (int i = 0; i < input.getText().length(); i++) {
                if (cnt < 0) {
                    break;

                } else {
                    if (input.getText().charAt(i) == '(')
                        cnt++;
                    if (input.getText().charAt(i) == ')')
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

            translation = WordConverter(input.getText());

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

            //cipher
            encryptedWord = cipher(translation, encryptMap);

            System.out.println("The word is encrypted!!");
            System.out.println(encryptedWord);


            //forward to marley encryption window
            Stage stage = new Stage();
            Parent root;
            stage.setTitle("Cipher");

            root = FXMLLoader.load((getClass().getResource("marley-word-encryption-page.fxml")));
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            //code for popup window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(input.getScene().getWindow());
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

    //encryption and decryption method
    static String cipher(String str, MyHashMap map) {
        String temp;
        if (str.length() == 0) {
            return "";
        } else {
            if (map.get(str.charAt(str.length() - 1)) > 0)
                temp = map.get(str.charAt(str.length() - 1)) + "";
            else
                temp = str.charAt(str.length() - 1) + "";

            return cipher(str.substring(0, str.length() - 1), map) + temp;

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
