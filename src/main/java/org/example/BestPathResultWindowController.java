package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class acts as a controller for best path result window
 */
public class BestPathResultWindowController {

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
    private Label bestPathLabel;

    @FXML
    void initialize() throws IOException {
        bestPathLabel.setText(BestPathSearchPageController.showOutput);
    }

    @FXML
    void OKButtonPressed(ActionEvent event) {
        //close the popup window when 'OK' is pressed
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
