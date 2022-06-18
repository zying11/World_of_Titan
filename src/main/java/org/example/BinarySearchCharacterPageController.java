package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class acts as a controller for the binary search character page
 */
public class BinarySearchCharacterPageController {

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
     * A text field to prompt user enter the types of attribute of soldiers
     */
    @FXML
    private TextField inputAttribute;

    /**
     * A text field to prompt user enter the attribution value of soldiers
     */
    @FXML
    private TextField inputAttributeValue;

    /**
     * A label to show error message when catch wrong input
     */
    @FXML
    private Label errorLabel;

    /**
     * A list to store the sorting result based on attribution
     */
    private List<String> nameSort = new ArrayList<>();

    private List<Integer> heightSort = new ArrayList<>();

    private List<Integer> weightSort = new ArrayList<>();

    private List<Integer> strengthSort = new ArrayList<>();

    private List<Integer> agilitySort = new ArrayList<>();

    private List<Integer> intelligenceSort = new ArrayList<>();

    private List<Integer> coordinationSort = new ArrayList<>();

    private List<Integer> leadershipSort = new ArrayList<>();

    /**
     * Catch which attribution entered by user
     */
    public static boolean inputHeight = false;

    public static boolean inputWeight = false;

    public static boolean inputStrength = false;

    public static boolean inputAgility = false;

    public static boolean inputIntelligence = false;

    public static boolean inputCoordination = false;

    public static boolean inputLeadership = false;

    //output for corresponding names
    public static String output;

    //to get user's input attribute value for display purpose in popup window
    public static String input_attribute_value;

    @FXML
    void SearchAttributeButtonPressed(ActionEvent actionEvent) throws IOException {
        // clear the error label each time when the pop up window close
        errorLabel.setText("");

        // control whether go to next page when search button click
        boolean indicator = true;

        //if any search field is empty
        if (inputAttribute.getText().isEmpty() || inputAttributeValue.getText().isEmpty() || inputAttribute.getText().isEmpty() && inputAttributeValue.getText().isEmpty()) {
            System.out.println("There is an empty input!");
            errorLabel.setText("Please do not leave search field empty!");
            return;
        }

        else if (inputAttribute.getText().equalsIgnoreCase("height")) {
            indicator = false;
            inputHeight = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            heightSort.clear();
            Collections.sort(MainHomePageController.list, new HeightComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Height: " + character.getHeight());
                nameSort.add(character.getName());
                heightSort.add(Integer.valueOf(character.getHeight()));
            }
            output = (countOccurrences(nameSort, heightSort, heightSort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        } else if (inputAttribute.getText().equalsIgnoreCase("weight")) {
            indicator = false;
            inputWeight = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            weightSort.clear();
            Collections.sort(MainHomePageController.list, new WeightComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Weight: " + character.getWeight());
                nameSort.add(character.getName());
                weightSort.add(Integer.valueOf(character.getWeight()));
            }
            output = (countOccurrences(nameSort, weightSort, weightSort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        } else if (inputAttribute.getText().equalsIgnoreCase("strength")) {
            indicator = false;
            inputStrength = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            strengthSort.clear();
            Collections.sort(MainHomePageController.list, new StrengthComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Strength: " + character.getStrength());
                nameSort.add(character.getName());
                strengthSort.add(Integer.valueOf(character.getStrength()));
            }
            output = (countOccurrences(nameSort, strengthSort, strengthSort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        } else if (inputAttribute.getText().equalsIgnoreCase("agility")) {
            indicator = false;
            inputAgility = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            agilitySort.clear();
            Collections.sort(MainHomePageController.list, new AgilityComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Agility: " + character.getAgility());
                nameSort.add(character.getName());
                agilitySort.add(Integer.valueOf(character.getAgility()));
            }
            output = (countOccurrences(nameSort, agilitySort, agilitySort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        } else if (inputAttribute.getText().equalsIgnoreCase("intelligence")) {
            indicator = false;
            inputIntelligence = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            intelligenceSort.clear();
            Collections.sort(MainHomePageController.list, new IntelligenceComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Intelligence: " + character.getIntelligence());
                nameSort.add(character.getName());
                intelligenceSort.add(Integer.valueOf(character.getIntelligence()));
            }
            output = (countOccurrences(nameSort, intelligenceSort, intelligenceSort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        } else if (inputAttribute.getText().equalsIgnoreCase("coordination")) {
            indicator = false;
            inputCoordination = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            coordinationSort.clear();
            Collections.sort(MainHomePageController.list, new CoordinationComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Coordination: " + character.getCoordination());
                nameSort.add(character.getName());
                coordinationSort.add(Integer.valueOf(character.getCoordination()));
            }
            output = (countOccurrences(nameSort, coordinationSort, coordinationSort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        } else if (inputAttribute.getText().equalsIgnoreCase("leadership")) {
            indicator = false;
            inputLeadership = true;
            input_attribute_value = inputAttributeValue.getText();

            nameSort.clear();
            leadershipSort.clear();
            Collections.sort(MainHomePageController.list, new LeadershipComparator());

            for (CharacterData character : MainHomePageController.list) {
                System.out.println("Name: " + character.getName() + ", " + "Leadership: " + character.getLeadership());
                nameSort.add(character.getName());
                leadershipSort.add(Integer.valueOf(character.getLeadership()));
            }
            output = (countOccurrences(nameSort, leadershipSort, leadershipSort.size(),
                    Integer.parseInt(inputAttributeValue.getText())));

        }
        //if input attribute does not exist
        else if (!(inputAttribute.getText().equalsIgnoreCase("height") ||
                inputAttribute.getText().equalsIgnoreCase("weight") ||
                inputAttribute.getText().equalsIgnoreCase("strength") ||
                inputAttribute.getText().equalsIgnoreCase("agility") ||
                inputAttribute.getText().equalsIgnoreCase("intelligence") ||
                inputAttribute.getText().equalsIgnoreCase("coordination") ||
                inputAttribute.getText().equalsIgnoreCase("leadership"))
        ) {
            errorLabel.setText("Invalid attribute!!");
            System.out.println("Invalid attribute!!");
        }

        // check whether the target value found or not
        if(output.isEmpty()){
            indicator=true;
            errorLabel.setText("Attribute value not found");
            System.out.println("Attribute value not found");
        }
        else{
            System.out.println(output);
        }

        if (!indicator) {
            Stage stage = new Stage();
            Parent root;
            stage.setTitle("Result Window");
            //forward to Binary Search Result window when search button pressed
            root = FXMLLoader.load((getClass().getResource("binary-search-result.fxml")));
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            //code for popup window
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(inputAttribute.getScene().getWindow());
            stage.showAndWait();
        }
    }
 
    static int binarySearch(List<Integer> arr, int l, int r, int target) {
        if (r < l)
            return -1;

        int mid = l + (r - l) / 2;

        // If the element is present
        // at the middle itself
        if (arr.get(mid) == target)
            return mid;

        // If element is smaller than
        // mid, then it can only be
        // present in right sub array
        if (arr.get(mid) > target)
            return binarySearch(arr, mid + 1, r, target);

        // Else the element can
        // only be present in
        // left sub array
        return binarySearch(arr, l, mid - 1, target);
    }

    // Returns number of times x
    // occurs in arr[0..n-1]
    static String countOccurrences(List<String> name, List<Integer> arr, int n, int target) {
        List<String> res = new ArrayList<>();
        String result;

        int ind = binarySearch(arr, 0, n - 1, target);

        // If element is not present
        if (ind == -1)
            return "";

        else {
            // Count elements on left side.
            int count = 1;
            int left = ind - 1;
            while (left >= 0 &&
                    arr.get(left) == target) {
                res.add(name.get(left));
                count++;
                left--;
            }

            //get element in middle
            res.add(name.get(ind));

            // Count elements
            // on right side.
            int right = ind + 1;
            while (right < n &&
                    arr.get(right) == target) {
                res.add(name.get(right));
                count++;
                right++;
            }
        }
        result = display(res);
        return result;
    }

    //display method
    public static String display(List list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                result += list.get(i);
            } else {
                result += list.get(i) + ", ";
            }
        }
        return result;
    }

    @FXML
    void HomeButtonPressed(MouseEvent event) throws IOException {
        //forward to Home page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("main-home-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BackToCharacterButtonPressed(ActionEvent event) throws IOException {
        //forward to Character page when back button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("character-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
