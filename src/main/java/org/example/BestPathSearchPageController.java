package org.example;

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
import java.util.*;

import static org.example.BreadthFirstSearch.add_edge;

/**
 * This class acts as a controller for best path search page
 */
public class BestPathSearchPageController {

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

    private static List<List<Integer>> ansList=new ArrayList<>();

    public static String showOutput;

    private static String output;

    /**
     * A label to show error message when catch wrong input
     */
    @FXML
    private Label errorLabel;

    /**
     * A text field to enter the location of Titan
     */
    @FXML
    private TextField locationOfTitan;

    @FXML
    void GoFindBestPathButtonPressed(MouseEvent event) throws IOException {
        errorLabel.setText("");

        boolean inputError=false;

        boolean numeric = true;

        numeric = locationOfTitan.getText().matches("-?\\d+(\\.\\d+)?");

        // Number of vertices
        int n = 16;

        if(locationOfTitan.getText().isEmpty()){
            inputError=true;
            System.out.println("Empty field");
            errorLabel.setText("Please do not leave blank");
        }
        else if(!numeric){
            inputError=true;
            System.out.println("Invalid input");
            errorLabel.setText("Please enter digit");
        }
        else if(locationOfTitan.getText().equals("0")) {
            inputError = true;
            System.out.println("Invalid input");
            errorLabel.setText("You are at location 0");
        }
        else if(Integer.parseInt(locationOfTitan.getText())>=n) {
            inputError=true;
            System.out.println("Array out of bound");
            errorLabel.setText("Please enter value between 1-15");
        }
        else{

            showOutput = "";

            // array of vectors is used
            // to store the graph
            // in the form of an adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            // Given Graph
            add_edge(adj, 0, 1); add_edge(adj, 0, 5); add_edge(adj, 0, 7);
            add_edge(adj, 1, 2); add_edge(adj, 1, 4); add_edge(adj, 1, 6);
            add_edge(adj, 2, 3); add_edge(adj, 2, 11); add_edge(adj, 2, 13);
            add_edge(adj, 3, 10);
            add_edge(adj, 4, 6); add_edge(adj, 4, 10);
            add_edge(adj, 5, 6); add_edge(adj, 5, 7); add_edge(adj, 5, 12);
            add_edge(adj, 6, 8); add_edge(adj, 6, 15);
            add_edge(adj, 7, 9);
            add_edge(adj, 8, 10);
            add_edge(adj, 9, 12); add_edge(adj, 9, 15);
            add_edge(adj, 10, 14);
            add_edge(adj, 11, 13);
            add_edge(adj, 13, 14);
            add_edge(adj, 14, 15);

            // Given source and destination
            int src = 0;

            int dest = Integer.parseInt(locationOfTitan.getText());

            // Function Call
            BreadthFirstSearch.print_paths(adj, n, src, dest);

            ansList=BreadthFirstSearch.listOfList;

            System.out.println("Best paths:");

            for (int i = 0; i < ansList.size(); i++) {
                output = "";

                List<Integer> splitList = ansList.get(i);

                for (int j = 0; j <= splitList.size() - 1; j++) {

                    if (j != splitList.size() - 1) {
                        output = output + splitList.get(j) + "-->";
                    } else {
                        output = output + splitList.get(j);
                    }
                }
                showOutput = showOutput + output + "\n";
            }
            System.out.println(showOutput);
            System.out.println();

        }

        //when no error, show the result of best path by using pop up window
        if(!inputError) {
            Stage stage = new Stage();
            Parent root;
            stage.setTitle("Best path to kill Titan");
            //forward to Best Path Result window when go button pressed
            root = FXMLLoader.load((getClass().getResource("best-path-result-window.fxml")));
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to Path Finding Action page when back button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("path-finding-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
