package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GenerateTitanResultPageController {
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
    private VBox vBoxTitan;

    @FXML
    private Label killingSequenceLabel;

    @FXML
    private Label distanceMovedLabel;

    @FXML
    void initialize() throws IOException {
        int previousPosition=0,currentPosition=0;
        int totalDistanceMoved=0;
        int count=0;
        String outputKillingSequence="";
        String title="Titan ";
        String arrow=" --> ";

        for (TitanData titanData : GenerateTitanLoadingPageController.titanToKilledList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("generate-titan-result-template.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                GenerateTitanResultTemplateController resultTemplateController = fxmlLoader.getController();
                resultTemplateController.setTitanData(titanData);
                vBoxTitan.getChildren().add(anchorPane);

                // if count is at the last index of the killing list, skip for "-->" arrow
                if(count<GenerateTitanLoadingPageController.titanToKilledList.size()-1){
                    outputKillingSequence = outputKillingSequence + title + titanData.getIndex() + arrow;
                    count++;
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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.print("Sequence to be killed: ");
        System.out.println(outputKillingSequence);
        killingSequenceLabel.setText(outputKillingSequence);

        System.out.print("Total distance moved: "+totalDistanceMoved);
        distanceMovedLabel.setText(String.valueOf(totalDistanceMoved));
    }

    @FXML
    void BattleButtonPressed(MouseEvent event) throws IOException {
        //forward to Choosing Action Page when battle button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choosing-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
