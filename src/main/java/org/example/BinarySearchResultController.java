package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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

    @FXML
    private Label outputAbility;

    @FXML
    private Label outputAbilityValue;

    @FXML
    private Label outputNames;

    @FXML
    void initialize() throws IOException {
        if(BinarySearchCharacterPageController.inputHeight){
            outputAbility.setText("Height");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }
        else if(BinarySearchCharacterPageController.inputWeight){
            outputAbility.setText("Weight");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }
        else if(BinarySearchCharacterPageController.inputStrength){
            outputAbility.setText("Strength");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }
        else if(BinarySearchCharacterPageController.inputAgility){
            outputAbility.setText("Agility");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }
        else if(BinarySearchCharacterPageController.inputIntelligence){
            outputAbility.setText("Intelligence");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }
        else if(BinarySearchCharacterPageController.inputCoordination){
            outputAbility.setText("Coordination");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }
        else if(BinarySearchCharacterPageController.inputLeadership){
            outputAbility.setText("Leadership");
            outputAbilityValue.setText(BinarySearchCharacterPageController.input_attribute_value);
            outputNames.setText(BinarySearchCharacterPageController.output);
        }


    }


    @FXML
    void OKButtonPressed(ActionEvent event) {
        //close the popup window when 'OK' is pressed
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }



}
