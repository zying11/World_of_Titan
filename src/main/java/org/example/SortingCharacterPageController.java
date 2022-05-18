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
import java.util.Collections;
import java.util.Objects;

public class SortingCharacterPageController {
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

    public static boolean inputHeight=false;
    public static boolean inputWeight=false;
    public static boolean inputStrength=false;
    public static boolean inputAgility=false;
    public static boolean inputIntelligence=false;
    public static boolean inputCoordination=false;
    public static boolean inputLeadership=false;

    /**
     * A text field to prompt user enter the types of attribute of soldiers
     */
    @FXML
    private TextField inputAttribute;

    @FXML
    private Label errorLabel;

    @FXML
    void SearchAttributeButtonPressed(ActionEvent actionEvent) throws IOException {
        boolean inputError = false;

        //if input is empty
        if (inputAttribute.getText().isEmpty()) {
            inputError=true;
            System.out.println("Empty input");
            errorLabel.setText("Please enter the attribution!");
        }
        //if input is in the scope of attribution
        else if (inputAttribute.getText().equalsIgnoreCase("height")) {
            inputHeight=true;
            Collections.sort(CharacterController.list, new HeightComparator());
        }
        else if(inputAttribute.getText().equalsIgnoreCase("weight")){
            inputWeight=true;
            Collections.sort(CharacterController.list, new WeightComparator());
        }
        else if(inputAttribute.getText().equalsIgnoreCase("strength")){
            inputStrength=true;
            Collections.sort(CharacterController.list,new StrengthComparator() );
        }
        else if(inputAttribute.getText().equalsIgnoreCase("agility")){
            inputAgility=true;
            Collections.sort(CharacterController.list,new AgilityComparator());
        }
        else if(inputAttribute.getText().equalsIgnoreCase("intelligence")){
            inputIntelligence=true;
            Collections.sort(CharacterController.list,new IntelligenceComparator());
        }
        else if(inputAttribute.getText().equalsIgnoreCase("coordination")){
            inputCoordination=true;
            Collections.sort(CharacterController.list,new CoordinationComparator());
        }
        else if(inputAttribute.getText().equalsIgnoreCase("leadership")){
            inputLeadership=true;
            Collections.sort(CharacterController.list,new LeadershipComparator());
        }
        //if input is out of scope of the attribution
        else{
            inputError=true;
            System.out.println("not found");
            errorLabel.setText("Attribution not found");
        }
        //when no error, go to character sorting result page
        if(!inputError){
            //forward to Character Sorting Result page when search button pressed
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sorting-character-result-page.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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
    void BackToCharacterButtonPressed(ActionEvent event) throws IOException {
        //forward to Home page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
