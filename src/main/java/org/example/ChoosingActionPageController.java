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
 * This class acts as a controller for the binary search character page
 */
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

    @FXML
    void GenerateTitanButtonPressed(MouseEvent event) throws IOException{
        //forward to Prompt User Enter Number of Titan page when generate titan button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("prompt-user-enter-numTitan-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PathFindingButtonPressed(MouseEvent event) throws IOException{
        //forward to Path Finding Action page when path finding button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("path-finding-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void MarleyWordButtonPressed(MouseEvent event) throws IOException{
        //forward to Marley Word Converter page when word button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("marley-word-converter-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void WeakestWallButtonPressed(MouseEvent event) throws IOException{
        //forward to Weakest Wall Search page when weakest wall button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("weakest-wall-search-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
