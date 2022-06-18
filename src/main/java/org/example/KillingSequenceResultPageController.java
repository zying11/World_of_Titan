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
import java.util.Objects;

/**
 * This class acts as a controller for killing sequence result page
 */
public class KillingSequenceResultPageController {

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
     * this label is used as title
     */
    @FXML
    private Label label1;

    /**
     * this label is used as heading 1
     */
    @FXML
    private Label label2;

    @FXML
    private Label killingSequenceLabel;

    @FXML
    private Label distanceMovedLabel;

    @FXML
    void initialize()throws IOException{
        CharacterData soldierData;

        //to calculate the sum of strength and agility of soldier
        int sumSoldierAbility=0;

        //check which button is chosen by user
        //store the characteristic of the specific soldier's info to soldierData
        if(KillingSequenceActionPageController.Reiner){
            soldierData=MainHomePageController.list.get(0);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                               Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Armin){
            soldierData=MainHomePageController.list.get(1);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Annie){
            soldierData=MainHomePageController.list.get(2);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Bertholdt){
            soldierData=MainHomePageController.list.get(3);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Jean){
            soldierData=MainHomePageController.list.get(4);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Sasha){
            soldierData=MainHomePageController.list.get(5);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Connie){
            soldierData=MainHomePageController.list.get(6);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Mikasa){
            soldierData=MainHomePageController.list.get(7);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Eren){
            soldierData=MainHomePageController.list.get(8);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Historia){
            soldierData=MainHomePageController.list.get(9);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Levi){
            soldierData=MainHomePageController.list.get(10);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Erwin){
            soldierData=MainHomePageController.list.get(11);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }

        else if(KillingSequenceActionPageController.Hange){
            soldierData=MainHomePageController.list.get(12);
            sumSoldierAbility= Integer.parseInt(soldierData.getStrength())+
                    Integer.parseInt(soldierData.getAgility());
        }
        System.out.println("\n"+sumSoldierAbility);

        //calculate distance moved and killing sequence
        boolean ableToKillTitan=false;
        int previousPosition=0,currentPosition=0;
        int totalDistanceMoved=0;
        int count=0;
        int counter=1;
        String outputKillingSequence="";
        String title="Titan ";
        String arrow=" --> ";

        for(TitanData titanData:GenerateTitanLoadingPageController.titanToKilledList){

            if(sumSoldierAbility>titanData.getSumDangerRisk()){
                ableToKillTitan=true;
                System.out.println("process the killing process");

                // killing sequence
                // if count is at the last index of the killing list, skip for "-->" arrow
                if(count<GenerateTitanLoadingPageController.titanToKilledList.size()-1){
                    outputKillingSequence = outputKillingSequence + title + titanData.getIndex() + arrow;
                    count++;
                    counter++;
                    //continue output to start from next row
                    if(counter==4){
                        counter=1;
                        outputKillingSequence = outputKillingSequence+"\n";
                    }

                }
                else{
                    outputKillingSequence = outputKillingSequence + title + titanData.getIndex();
                }

                // calculate the distance moved from soldier to kill titan
                currentPosition=titanData.getIndex();
                if(currentPosition>previousPosition){
                    totalDistanceMoved=totalDistanceMoved+(currentPosition-previousPosition);
                    previousPosition=currentPosition;
                }
                else{
                    totalDistanceMoved=totalDistanceMoved-(currentPosition-previousPosition);
                    previousPosition=currentPosition;
                }

            }
            else{
                // killing sequence
                outputKillingSequence = outputKillingSequence + title + titanData.getIndex()
                                        + arrow +"Soldier run back to starting point 0";

                // calculate the distance moved from soldier to kill titan
                totalDistanceMoved=(titanData.getIndex()-0)*2;
                break;
            }

        }

        if(ableToKillTitan){
            label1.setText("YOU WIN");
            label2.setText("Your soldier's ability manage to kill all the dangerous titans");
            killingSequenceLabel.setText(outputKillingSequence);
            distanceMovedLabel.setText(String.valueOf(totalDistanceMoved));
            System.out.println("YOU WIN");
            System.out.println("Your soldier's ability manage to kill all the dangerous titans");
            System.out.println("Sequence to be killed:"+outputKillingSequence);
            System.out.println("distance moved:"+totalDistanceMoved);

        }
        else{
            label1.setText("YOU LOSE");
            label2.setText("Your soldier's ability not manage to kill the dangerous titan");
            killingSequenceLabel.setText(outputKillingSequence);
            distanceMovedLabel.setText(String.valueOf(totalDistanceMoved));
            System.out.println("YOU LOSE");
            System.out.println("Your soldier's ability not manage to kill the dangerous titan");
            System.out.println("Sequence to be killed:"+outputKillingSequence);
            System.out.println("distance moved:"+totalDistanceMoved);
        }
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to Killing Sequence Action page when back button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
