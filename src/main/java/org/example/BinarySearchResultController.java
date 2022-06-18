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
 * This class acts as a controller for the sorting character page
 */
public class BinarySearchResultController {

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
     * this label is used to set ability title name entered by user
     */
    @FXML
    private Label outputAbility;

    /**
     * this label is used to set ability value entered by user
     */
    @FXML
    private Label outputAbilityValue;

    /**
     * this label is used to set output of the soldier's name
     */
    @FXML
    private Label outputNames;

    @FXML
    void initialize() throws IOException {
        if(BinarySearchCharacterPageController.inputHeight){
            outputAbility.setText("Height");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputHeight=false;
        }
        else if(BinarySearchCharacterPageController.inputWeight){
            outputAbility.setText("Weight");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputWeight=false;
        }
        else if(BinarySearchCharacterPageController.inputStrength){
            outputAbility.setText("Strength");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputStrength=false;
        }
        else if(BinarySearchCharacterPageController.inputAgility){
            outputAbility.setText("Agility");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputAgility=false;
        }
        else if(BinarySearchCharacterPageController.inputIntelligence){
            outputAbility.setText("Intelligence");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputIntelligence=false;
        }
        else if(BinarySearchCharacterPageController.inputCoordination){
            outputAbility.setText("Coordination");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputCoordination=false;
        }
        else if(BinarySearchCharacterPageController.inputLeadership){
            outputAbility.setText("Leadership");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
            BinarySearchCharacterPageController.inputLeadership=false;
        }
    }

    @FXML
    void OKButtonPressed(ActionEvent event) {
        //close the popup window when 'OK' is pressed
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
