package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GenerateTitanResultTemplateController{
    @FXML
    private Label index;

    @FXML
    private Label type;

    @FXML
    private Label height;

    @FXML
    private Label walkingLeg;

    @FXML
    private Label runSpeed;

    @FXML
    private Label walkPattern;

    @FXML
    private Label climbSkill;

    @FXML
    private Label dangerRisk;

    public void setTitanData(TitanData titanData){
        index.setText(String.valueOf(titanData.getIndex()));
        type.setText(titanData.getType());

        //set for label height,walking leg and running speed
        if(titanData.getType().equalsIgnoreCase("abnormal titan")||
           titanData.getType().equalsIgnoreCase("nine titan")){
            height.setText("");
            walkingLeg.setText("");
            runSpeed.setText("");

        }
        else{
            height.setText(String.valueOf(titanData.getHeight()));
            walkingLeg.setText(String.valueOf(titanData.getWalkingLeg()));
            runSpeed.setText(String.valueOf(titanData.getRunningSpeed()));
        }

        walkPattern.setText(titanData.getWalkingPattern());
        climbSkill.setText(titanData.getClimbingSkill());
        dangerRisk.setText(String.valueOf(titanData.getSumDangerRisk()));
    }
}
