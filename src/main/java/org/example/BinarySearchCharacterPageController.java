package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BinarySearchCharacterPageController {

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

    /**
     * A text field to prompt user enter the types of attribute of soldiers
     */
    @FXML
    private TextField inputAttribute;

    @FXML
    private TextField inputAttributeValue;

    @FXML
    private Label errorLabel;

    @FXML
    void SearchAttributeButtonPressed(ActionEvent actionEvent) throws IOException {

        boolean indicator = true;

        String output;

        //if any search field is empty
        if (inputAttribute.getText().isEmpty() || inputAttributeValue.getText().isEmpty() || inputAttribute.getText().isEmpty() && inputAttributeValue.getText().isEmpty()) {
            indicator = true;
            System.out.println("There is an empty input!");
            errorLabel.setText("Please do not leave search field empty!");

        }
        if (inputAttribute.getText().equalsIgnoreCase("height")) {
            int low = 0;
            int high = SortingCharacterResultPageController.heightRanking.size()-1;
            int middle;
            //get the start index of the attribute value
            int startIndex = -1;
            while (low <= high) {
                middle = (low + high) / 2 + low;
                if (inputAttributeValue.getText().equals(SortingCharacterResultPageController.heightRanking.get(middle).getHeight())) {
                    startIndex = middle;
                    high = middle - 1;
                    output = SortingCharacterResultPageController.heightRanking.get(middle).getName();
                    System.out.println(output);
                } else if (Integer.parseInt(inputAttributeValue.getText()) > Integer.parseInt(SortingCharacterResultPageController.heightRanking.get(middle).getHeight())) {
                    high = middle - 1;
                } else
                    low = middle + 1;

            }

            // get the end index of the attribute value
            int endIndex = -1;
            low = 0;
            high = 12;
            while (low <= high) {
                middle = (low + high) / 2 + low;
                if (inputAttributeValue.getText().equals(SortingCharacterResultPageController.heightRanking.get(middle).getHeight())) {
                    endIndex = middle;
                    low = middle + 1;
                    output = SortingCharacterResultPageController.heightRanking.get(middle).getName();
                    System.out.println(output);

                    } else if (Integer.parseInt(inputAttributeValue.getText()) > Integer.parseInt(SortingCharacterResultPageController.heightRanking.get(middle).getHeight())) {
                    high = middle - 1;
                } else
                    low = middle + 1;

            }

            //to find the remaining attribute value
            if (startIndex != -1 && endIndex != -1) {
                for (int i = 0; i + startIndex <= endIndex; i++) {
                    if (i > 0)
                        System.out.print(',');
                    System.out.print(i + startIndex);
                }

            }
        }


    }



    void BinarySearch(CharacterData list, String attributeValue){
        //low element subscript
        int low = 0;
        //high element subscript -> we have 13 soldiers
        int high = 12;
        int middle;

        while(low<=high) {
            middle = (low + high) / 2;

        }

    }


    @FXML
    void HomeButtonPressed(MouseEvent event) throws IOException {
        //forward to Home page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-home-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BackToCharacterButtonPressed(ActionEvent event) throws IOException {
        //forward to Sorted Character page when back button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
