package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * This class acts as a controller for generate titan loading page
 */
public class GenerateTitanLoadingPageController {

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
     * this list is to store the generated titan information
     * in priority queue form, which priority the danger risk of titan
     * the most dangerous titan will come out first
    */
    public static List<TitanData> titanToKilledList=new ArrayList<>();

    private int randomType;

    private int dangerRisk;

    private int walkingLeg;

    private String walkingPattern;

    private String clmbingSkill;

    private String titanType;

    Random random =new Random();

    /**
     * A label to set the number of titan which need to be generated
     */
    @FXML
    private Label numberTitanLabel;

    @FXML
    void initialize() throws IOException{
        titanToKilledList.clear();

        System.out.println("Generating "+PromptUserEnterNumTitanPageController.input+" Titans...");

        // to show the number entered by user in the loading page
        numberTitanLabel.setText(PromptUserEnterNumTitanPageController.input);

        PriorityQueue<TitanData> priorityQueue=new PriorityQueue<>(new DangerRiskComparator());

        // loop the number of titan that need to be generated, which entered by user
        for(int i=1;i<=Integer.parseInt(PromptUserEnterNumTitanPageController.input);i++){

            //generate titan type
            //0-> normal titan  1-> abnormal titan  2-> nine titan
            //(maximum – minimum) + 1) + minimum
            randomType=random.nextInt(3);

            // normal titan
            if(randomType == 0){
                titanType="Normal Titan";

                int randomHeight=random.nextInt(1000)+1;
                int randomWalkingLeg=random.nextInt(3);
                int randomRunningSpeed=random.nextInt(10000)+1;
                int randomWalkingPattern=random.nextInt(3);
                int randomClimbingSkill=random.nextInt(2);
                int totalDangerRisk=0;

                if(randomHeight>20){
                    dangerRisk=3;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else if(randomHeight>10){
                    dangerRisk=2;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else{
                    dangerRisk=1;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }

                // walking leg
                // 0-> 4 legs
                // 1-> 2 legs
                // 2-> 0 legs
                if(randomWalkingLeg==0){
                    walkingLeg=4;
                    dangerRisk=3;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else if(randomWalkingLeg==1){
                    walkingLeg=2;
                    dangerRisk=2;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else{
                    walkingLeg=0;
                    dangerRisk=1;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }

                //running speed
                if(randomRunningSpeed>20){
                    dangerRisk=3;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else if(randomRunningSpeed>10){
                    dangerRisk=2;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else{
                    dangerRisk=1;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }

                // walking pattern
                // 0-> Not repeated pattern
                // 1-> Repeated pattern
                // 2-> Normal pattern
                if(randomWalkingPattern==0) {
                    walkingPattern="Not repeated pattern";
                    dangerRisk = 3;
                    totalDangerRisk=totalDangerRisk + dangerRisk;
                }
                else if(randomWalkingPattern==1){
                    walkingPattern="Repeated pattern";
                    dangerRisk=2;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else{
                    walkingPattern="Normal pattern";
                    dangerRisk=1;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }

                // climbing skill
                // 0-> can climb
                // 1-> cannot climb
                if(randomClimbingSkill==0){
                    clmbingSkill="Can climb";
                    dangerRisk=3;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }
                else{
                    clmbingSkill="Cannot climb";
                    dangerRisk=1;
                    totalDangerRisk=totalDangerRisk+dangerRisk;
                }

                priorityQueue.add(new TitanData(i,titanType,randomHeight,walkingLeg,randomRunningSpeed,
                                  walkingPattern,clmbingSkill,totalDangerRisk));
            }

            // abnormal titan
            else if(randomType == 1){
                dangerRisk=15;
                titanType="Abnormal Titan";
                priorityQueue.add(new TitanData(i,titanType,dangerRisk));
            }

            // nine titan
            else{
                dangerRisk=19;
                titanType="Nine Titan";
                priorityQueue.add(new TitanData(i,titanType,dangerRisk));
            }
        }

        while(!priorityQueue.isEmpty()) {
            TitanData e = priorityQueue.poll();
            titanToKilledList.add(e);
            System.out.println(e);
        }
    }

    @FXML
    void ResultButtonPressed(MouseEvent event) throws IOException{
        //forward to Generate Titan Result page when result button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generate-titan-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
