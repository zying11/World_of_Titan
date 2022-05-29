package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PromptUserEnterNumTitanPageController {
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

    static String input;

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

        else if(Character.isDigit(numOfTitanGenerate.getText().charAt(0))){
            input=numOfTitanGenerate.getText();
            System.out.println("Generating titan");
        }

        else{
            inputError=true;
            System.out.println("Please enter number");
            errorLabel.setText("Please enter number");
        }

        //when no error, go to generate titan loading page
        if(!inputError){
            //forward to generate titan loading page
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generate-titan-loading-page.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
