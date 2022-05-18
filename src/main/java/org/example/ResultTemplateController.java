package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultTemplateController {
    @FXML
    private Label characterName;

    @FXML
    private Label attribute;

    public void setData(CharacterData data) {
        if(SortingCharacterPageController.inputHeight){
            characterName.setText(data.getName());
            attribute.setText(data.getHeight());
        }
        else if(SortingCharacterPageController.inputWeight){
            characterName.setText(data.getName());
            attribute.setText(data.getWeight());
        }
        else if(SortingCharacterPageController.inputStrength){
            characterName.setText(data.getName());
            attribute.setText(data.getStrength());
        }
        else if(SortingCharacterPageController.inputAgility){
            characterName.setText(data.getName());
            attribute.setText(data.getAgility());
        }
        else if(SortingCharacterPageController.inputIntelligence){
            characterName.setText(data.getName());
            attribute.setText(data.getIntelligence());
        }
        else if(SortingCharacterPageController.inputCoordination){
            characterName.setText(data.getName());
            attribute.setText(data.getCoordination());
        }
        else if(SortingCharacterPageController.inputLeadership){
            characterName.setText(data.getName());
            attribute.setText(data.getLeadership());
        }
    }
}
