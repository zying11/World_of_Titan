package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class ChoosingActionPageController {
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
    void HomeButtonPressed(MouseEvent event) throws IOException {
        //forward to Home page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-home-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Generate titan button at choosing action page
     * A window will pop up after user clicking it
     * This window is used to let user input number of titan to be generated
     *
     * @throws IOException when the resource file is not found
     */
    @FXML
    void GenerateTitanButtonPressed(MouseEvent event) throws IOException{
        //forward to prompt user enter number of titan template when generate titan button pressed
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prompt-user-enter-numTitan-window.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Generate Titan");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
