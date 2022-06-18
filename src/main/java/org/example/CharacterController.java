package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * This class acts as a controller for the character page
 */
public class CharacterController {

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
     * Table to show all the soldiers' characteristics
     */
    @FXML
    private TableView table;

    /**
     * A table column specific to soldiers' name
     */
    @FXML
    private TableColumn<CharacterData,String> name;

    /**
     * A table column specific to soldiers' height
     */
    @FXML
    private TableColumn<CharacterData,String> height;

    /**
     * A table column specific to soldiers' weight
     */
    @FXML
    private TableColumn<CharacterData,String> weight;

    /**
     * A table column specific to soldiers' strength
     */
    @FXML
    private TableColumn<CharacterData,String> strength;

    /**
     * A table column specific to soldiers' agility
     */
    @FXML
    private TableColumn<CharacterData,String> agility;

    /**
     * A table column specific to soldiers' intelligence
     */
    @FXML
    private TableColumn<CharacterData,String> intelligence;

    /**
     * A table column specific to soldiers' coordination
     */
    @FXML
    private TableColumn<CharacterData,String> coordination;

    /**
     * A table column specific to soldiers' leadership
     */
    @FXML
    private TableColumn<CharacterData,String> leadership;

    @FXML
    void initialize() throws IOException {

        //call the setCellValueFactory method in each column, pass the object.PropertyValueFactory in String
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        height.setCellValueFactory(new PropertyValueFactory<>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        strength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        agility.setCellValueFactory(new PropertyValueFactory<>("agility"));
        intelligence.setCellValueFactory(new PropertyValueFactory<>("intelligence"));
        coordination.setCellValueFactory(new PropertyValueFactory<>("coordination"));
        leadership.setCellValueFactory(new PropertyValueFactory<>("leadership"));

        for(int i=0;i<MainHomePageController.list.size();i++){
            //retrieve each soldier's information from class MainHomePageController
            //and display it in table view
            table.getItems().add(MainHomePageController.list.get(i));
        }
    }

    @FXML
    void HomeButtonPressed(MouseEvent event) throws IOException{
        //forward to Home page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-home-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SortingButtonPressed(MouseEvent event) throws  IOException{
        //forward to Character Sorting page when sorting button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sorting-character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BinarySearchButtonPressed(ActionEvent event) throws  IOException{
        //forward to character sorting page when sorting button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("binary-search-character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
