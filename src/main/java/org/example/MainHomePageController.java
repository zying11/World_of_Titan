package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class MainHomePageController {

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
     * A list to store each character's characteristic in CharacterData class
     */
    public static LinkedList<CharacterData> list=new LinkedList<>();

    /**
     * A list to store each character's name
     */
    private  LinkedList<String> nameList=new LinkedList<>();

    /**
     * A list to store each character's height
     */
    private LinkedList<String> heightList=new LinkedList<>();

    /**
     * A list to store each character's weight
     */
    private LinkedList<String> weightList=new LinkedList<>();

    /**
     * A list to store each character's strength
     */
    private LinkedList<String> strengthList=new LinkedList<>();

    /**
     * A list to store each character's agility
     */
    private LinkedList<String> agilityList=new LinkedList<>();

    /**
     * A list to store each character's intelligence
     */
    private LinkedList<String> intelligenceList=new LinkedList<>();

    /**
     * A list to store each character's coordination
     */
    private LinkedList<String> coordinationList=new LinkedList<>();

    /**
     * A list to store each character's leadership
     */
    private LinkedList<String> leadershipList=new LinkedList<>();

    @FXML
    void initialize()throws IOException{
        //clear element in the list everytime when come back to this method
        //to avoid duplicate
        nameList.clear();
        heightList.clear();
        weightList.clear();
        strengthList.clear();
        agilityList.clear();
        intelligenceList.clear();
        coordinationList.clear();
        leadershipList.clear();
        list.clear();

        //catch the text file,
        //if TRUE -> store the information of characters to specific characteristic lists
        try {
            Scanner input = new Scanner(new FileInputStream("characters.txt"));

            while(input.hasNext()){
                nameList.add(input.nextLine());
                heightList.add(input.nextLine());
                weightList.add(input.nextLine());
                strengthList.add(input.nextLine());
                agilityList.add(input.nextLine());
                intelligenceList.add(input.nextLine());
                coordinationList.add(input.nextLine());
                leadershipList.add(input.nextLine());
            }
            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        //add all the information of characters to a list
        for (int i = 0; i < nameList.size(); i++) {
            list.add(new CharacterData(nameList.get(i), heightList.get(i), weightList.get(i),
                    strengthList.get(i), agilityList.get(i), intelligenceList.get(i),
                    coordinationList.get(i), leadershipList.get(i)));

        }
    }

    @FXML
    void CharacterButtonPressed(MouseEvent event) throws IOException {
        //forward to Character page when character button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styling.css")).toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void PlayButtonPressed(MouseEvent event) throws IOException{
        //forward to Choosing Action Page when play button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choosing-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
