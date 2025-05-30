package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class acts as a controller for the sorting character result page
 */
public class SortingCharacterResultPageController {

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
     * List to store the soldiers' name and sorting height info
     */
    private List<CharacterData> heightRanking=new ArrayList<>();

    /**
     * List to store the soldiers' name and sorting weight info
     */
    private List<CharacterData> weightRanking=new ArrayList<>();

    /**
     * List to store the soldiers' name and sorting strength info
     */
    private List<CharacterData> strengthRanking=new ArrayList<>();

    /**
     * List to store the soldiers' name and sorting agility info
     */
    private List<CharacterData> agilityRanking=new ArrayList<>();

    /**
     * List to store the soldiers' name and sorting intelligence info
     */
    private List<CharacterData> intelligenceRanking=new ArrayList<>();

    /**
     * List to store the soldiers' name and sorting coordination info
     */
    private List<CharacterData> coordinationRanking=new ArrayList<>();

    /**
     * List to store the soldiers' name and sorting leadership info
     */
    private List<CharacterData> leadershipRanking=new ArrayList<>();

    /**
     * this vbox is to add template by row everytime to display the sorting attribution result
     */
    @FXML
    private VBox vBox;

    /**
     * this label is used to set title name based on attribution entered by user
     */
    @FXML
    private Label RankingLabel;

    /**
     * this label is set unit of the attribution
     */
    @FXML
    private Label valueLabel;

    @FXML
    void initialize() throws IOException {

        //result of height ranking
        if(SortingCharacterPageController.inputHeight){
            heightRanking.clear();
            RankingLabel.setText("Height Ranking");
            valueLabel.setText("Value (cm)");

            //add sorting height to heightRanking list
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Height: " + character.getHeight());
                heightRanking.add(new CharacterData(character.getName(), character.getHeight()));
            }
            System.out.println();

            //set specific data that need to be display to template
            //then add template by row to vbox to display it
            for (CharacterData data : heightRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputHeight=false;
        }

        //result of weight ranking
        else if(SortingCharacterPageController.inputWeight){
            weightRanking.clear();
            RankingLabel.setText("Weight Ranking");
            valueLabel.setText("Value (kg)");

            //add sorting weight to weightRanking list
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Weight: " + character.getWeight());
                weightRanking.add(new CharacterData(character.getName(), character.getWeight()));
            }
            System.out.println();

            for (CharacterData data : weightRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputWeight=false;
        }

        //result of strength ranking
        else if(SortingCharacterPageController.inputStrength){
            strengthRanking.clear();
            RankingLabel.setText("Strength Ranking");

            //add sorting strength to strengthRanking list
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Strength: " + character.getStrength());
                strengthRanking.add(new CharacterData(character.getName(), character.getStrength()));
            }
            System.out.println();

            for (CharacterData data : strengthRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputStrength=false;
        }

        //result of agility ranking
        else if(SortingCharacterPageController.inputAgility){
            agilityRanking.clear();
            RankingLabel.setText("Agility Ranking");

            //add sorting agility to agilityRanking list
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Agility: " + character.getAgility());
                agilityRanking.add(new CharacterData(character.getName(), character.getAgility()));
            }
            System.out.println();

            for (CharacterData data : agilityRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputAgility=false;
        }

        //result of intelligence ranking
        else if(SortingCharacterPageController.inputIntelligence){
            intelligenceRanking.clear();
            RankingLabel.setText("Intelligence Ranking");

            //add sorting intelligence to intelligenceRanking list
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Intelligence: " + character.getIntelligence());
                intelligenceRanking.add(new CharacterData(character.getName(), character.getIntelligence()));
            }
            System.out.println();

            for (CharacterData data : intelligenceRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputIntelligence=false;
        }

        //result of coordination ranking
        else if(SortingCharacterPageController.inputCoordination){
            coordinationRanking.clear();
            RankingLabel.setText("Coordination Ranking");
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Coordination: " + character.getCoordination());
                coordinationRanking.add(new CharacterData(character.getName(), character.getCoordination()));
            }
            System.out.println();

            //add sorting coordination to coordinationRanking list
            for (CharacterData data : coordinationRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputCoordination=false;
        }

        //result of leadership ranking
        else if(SortingCharacterPageController.inputLeadership){
            leadershipRanking.clear();
            RankingLabel.setText("Leadership Ranking");

            //add sorting leadership to leadershipRanking list
            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Leadership: " + character.getLeadership());
                leadershipRanking.add(new CharacterData(character.getName(), character.getLeadership()));
            }
            System.out.println();

            for (CharacterData data : leadershipRanking) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sorting-result-template.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();
                    SortingResultTemplateController resultTemplateController = fxmlLoader.getController();
                    resultTemplateController.setData(data);
                    vBox.getChildren().add(anchorPane);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            SortingCharacterPageController.inputLeadership=false;
        }
    }

    @FXML
    void ExitButtonPressed(ActionEvent event) throws IOException{
        //forward to Character Sorting page when exit button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sorting-character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
