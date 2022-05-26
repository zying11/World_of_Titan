package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PromptUserEnterNumTitanWindowController {
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
    private TextField numOfTitanGenerate;

    @FXML
    private Label errorLabel;

    @FXML
    void GoGenerateTitanButtonPressed(ActionEvent actionEvent) throws IOException{
        boolean inputError = false;

        //if input is empty
        if (numOfTitanGenerate.getText().isEmpty()) {
            inputError=true;
            System.out.println("Empty input");
            errorLabel.setText("Empty field!!");
        }
    }
}
