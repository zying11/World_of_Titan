package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class WeakestWallSearchPageController {
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

    private List<List<Integer>> listOfList=new ArrayList<>();

    private List<Integer> innerList=new ArrayList<>();

    public static int weakestWallPosition;

    @FXML
    private TextField numberOfLayers;

    @FXML
    private TextArea numberOfEdges;

    @FXML
    private Label errorLabel;

    private static int weakestPosition(List<List<Integer>> array , int width) {
        // TODO Auto-generated method stub
        int[]hash=new int[width]; // HashSet to store the occurrences of edges
        int max=0;

        // iterating over input array
        for(int i=0;i<array.size();i++) {
            //int sum=0;
            for(int j=0;j<array.get(i).size();j++) {
                hash[array.get(i).get(j)]+=1; // storing the occurrences of edges.
            }
        }

        int ans=0;
        // Loop to iterate over the input array which now contains the position of edges
        for(int i=0;i<array.size();i++) {
            for(int j=0;j<array.get(i).size();j++) {
                int ele=array.get(i).get(j);
                int val=hash[ele]; // retrieving the occurrence of the edge from hash array
                if(val>max) {
                    max = val; //finding the maximum of occurrences of all edges
                    ans=ele;
                }
            }
        }
        return ans;
    }

    @FXML
    void GoFindWeakestPart(MouseEvent event) throws IOException{
        boolean inputError=false;

        listOfList.clear();

        errorLabel.setText("");

        String arrLayerOfEdges[]=numberOfEdges.getText().split("\n");

        int width=11;

        if(numberOfLayers.getText().isEmpty() || numberOfEdges.getText().isEmpty()){
            inputError=true;
            System.out.println("Empty field");
            errorLabel.setText("Please do not leave blank for any input field");
        }

        else {

            try {

                if (Integer.parseInt(numberOfLayers.getText()) == (arrLayerOfEdges.length)) {

                    for (int i = 0; i < arrLayerOfEdges.length; i++) {
                        //clear the previous layer of the value of edges
                        innerList.clear();

                        String valueOfEdges = arrLayerOfEdges[i];

                        String[] edges = valueOfEdges.split(" ");

                        for (int j = 0; j < edges.length; j++) {
                            innerList.add(Integer.valueOf(edges[j]));
                        }

                        listOfList.add(new ArrayList<>(innerList));
                    }

                    System.out.println(listOfList);

                    weakestWallPosition=weakestPosition(listOfList,width);

                    System.out.println(weakestWallPosition);

                } else {
                    inputError = true;
                    System.out.println("Length of input 1 does not match with length of input 2");
                    errorLabel.setText("Length of input 1 does not match with length of input 2");
                }

            } catch (NumberFormatException nfe) {
                inputError = true;
                System.out.println("NumberFormat Exception: invalid input string");
                errorLabel.setText("Please enter digit");
            }
        }

        //when no error, show the weakest part of the wall by using pop up window
        if(!inputError) {
            Stage stage = new Stage();
            Parent root;
            stage.setTitle("Weakest Part");
            //forward to Binary Search Result window when search button pressed
            root = FXMLLoader.load((getClass().getResource("weakest-wall-result-window.fxml")));
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to choosing action page when home button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("choosing-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
