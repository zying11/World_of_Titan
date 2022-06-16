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

public class MarleyWordKeyController {

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
    private TextField inputKey;

    @FXML
    private Label errorLabel;

    String key = "zhiyingyyds";

    @FXML
    void initialize() throws IOException {
        System.out.println("Please enter the required key to decrypt the message!");

    }

    @FXML
    void GoButtonPressed(MouseEvent event) throws IOException {
        if(inputKey.getText().isEmpty()){
            System.out.println("Do not leave text field empty!");
            errorLabel.setText("Do not leave text field empty!");
        }
        else if(!(inputKey.getText().equals(key))){
            System.out.println("Incorrect key! Get away, imposter!");
            errorLabel.setText("Incorrect key! Get away, imposter!");
        }
        else {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("marley-pop-up-page.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}
