package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class CharacterController {
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

    public static LinkedList<CharacterData> list=new LinkedList<>();

    private  LinkedList<String> nameList=new LinkedList<>();

    private LinkedList<String> heightList=new LinkedList<>();

    private LinkedList<String> weightList=new LinkedList<>();

    private LinkedList<String> strengthList=new LinkedList<>();

    private LinkedList<String> agilityList=new LinkedList<>();

    private LinkedList<String> intelligenceList=new LinkedList<>();

    private LinkedList<String> coordinationList=new LinkedList<>();

    private LinkedList<String> leadershipList=new LinkedList<>();

    @FXML
    private TableView table;

    @FXML
    private TableColumn<CharacterData, String> img;

    @FXML
    private TableColumn<CharacterData,String> name;

    @FXML
    private TableColumn<CharacterData,String> height;

    @FXML
    private TableColumn<CharacterData,String> weight;

    @FXML
    private TableColumn<CharacterData,String> strength;

    @FXML
    private TableColumn<CharacterData,String> agility;

    @FXML
    private TableColumn<CharacterData,String> intelligence;

    @FXML
    private TableColumn<CharacterData,String> coordination;

    @FXML
    private TableColumn<CharacterData,String> leadership;

    @FXML
    void initialize() throws IOException {
        //clear element in the list everytime when come back to this method
        nameList.clear();
        heightList.clear();
        weightList.clear();
        strengthList.clear();
        agilityList.clear();
        intelligenceList.clear();
        coordinationList.clear();
        leadershipList.clear();
        list.clear();

        //catch the text file, if TRUE -> store the information of characters in linked list
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

        //for checking purpose, to see what is the output
        System.out.println(nameList.toString());
        System.out.println(heightList.toString());
        System.out.println(weightList.toString());
        System.out.println(strengthList.toString());
        System.out.println(agilityList.toString());
        System.out.println(intelligenceList.toString());
        System.out.println(coordinationList.toString());
        System.out.println(leadershipList.toString());

        //call the setCellValueFactory method in each column, pass the object.PropertyValueFactory in String
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        height.setCellValueFactory(new PropertyValueFactory<>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        strength.setCellValueFactory(new PropertyValueFactory<>("strength"));
        agility.setCellValueFactory(new PropertyValueFactory<>("agility"));
        intelligence.setCellValueFactory(new PropertyValueFactory<>("intelligence"));
        coordination.setCellValueFactory(new PropertyValueFactory<>("coordination"));
        leadership.setCellValueFactory(new PropertyValueFactory<>("leadership"));

        //add all the information of characters to a list
        for (int i = 0; i < nameList.size(); i++) {
            list.add(new CharacterData(nameList.get(i), heightList.get(i), weightList.get(i),
                    strengthList.get(i), agilityList.get(i), intelligenceList.get(i),
                    coordinationList.get(i), leadershipList.get(i)));

            //add the list information to table view, to display it in the table view
            table.getItems().add(list.get(i));
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
    void SortingButtonPressed(MouseEvent event) throws  IOException{
        //forward to character sorting page when sorting button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sorting-character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BinarySearchButtonPressed(ActionEvent event) throws  IOException{
        //forward to character sorting page when sorting button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("binary-search-character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
