package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class acts as a controller for the path finding action page
 */
public class PathFindingActionPageController {

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
    void FindPathButtonPressed(MouseEvent event) throws IOException {
        //forward to Path Finding Search page when find path button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("path-finding-search-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void FindBestPathButtonPressed(MouseEvent event) throws IOException {
        //forward to Best Path Search page when find best path button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("best-path-search-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to Choosing Action page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choosing-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
