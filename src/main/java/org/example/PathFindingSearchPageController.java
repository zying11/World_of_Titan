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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PathFindingSearchPageController {
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

    static List<List<Integer>> ans=new ArrayList<>();

    static String showOutput;

    static String output;

    @FXML
    private TextField startingPoint;

    @FXML
    private Label errorLabel;

    @FXML
    void GoSearchPathButtonPressed(MouseEvent event) throws IOException {
        errorLabel.setText("");

        ans.clear();

        boolean inputError=false;

        boolean numeric = true;

        numeric = startingPoint.getText().matches("-?\\d+(\\.\\d+)?");

        if(startingPoint.getText().isEmpty()){
            inputError=true;
            System.out.println("Empty field");
            errorLabel.setText("Please do not leave blank");
        }
        else if(!numeric){
            inputError=true;
            System.out.println("Invalid input");
            errorLabel.setText("Please enter digit");
        }
        else{
            try {

                showOutput = "";

                //vertices
                int vertices[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

                //starting node
                int startNode = Integer.parseInt(startingPoint.getText());

                System.out.println("Enter staring point: " + startNode);

                //adjacency matrix
                int adjacencyM[][] = {
                        {0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},//0-> 1 5 7
                        {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},//1-> 0 2 4 6
                        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},//2-> 1 3 11 13
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},//3-> 2 10
                        {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},//4-> 1 6 10
                        {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},//5-> 0 6 7 12
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},//6-> 1 4 5 8 15
                        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},//7-> 0 5 9
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},//8-> 6 10
                        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},//9-> 7 12 15
                        {0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},//10-> 3 4 8 14
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},//11-> 2 13
                        {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},//12-> 5 9
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},//13-> 2 11 14
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},//14-> 10 13 15
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0}};//15-> 6 9 14

                //Driver code
                HamiltonianCycle hamiltonian = new HamiltonianCycle(startNode, vertices, adjacencyM);
                hamiltonian.findCycle();

                //if the graph doesn't have any Hamiltonian Cycle
                if (!hamiltonian.hasCycle) {
                    showOutput = "No path found";
                    System.out.println("No path found");
                } else {
                    ans = HamiltonianCycle.ansList;

                    for (int i = 0; i < ans.size(); i++) {
                        output = "";

                        List<Integer> splitList = ans.get(i);

                        for (int j = 0; j <= splitList.size() - 1; j++) {

                            if (j != splitList.size() - 1) {
                                output = output + splitList.get(j) + "-->";
                            } else {
                                output = output + splitList.get(j);
                            }
                        }
                        showOutput = showOutput + "Path found!\n" + output + "\n\n";
                    }
                    System.out.println(showOutput);
                }
            }catch(ArrayIndexOutOfBoundsException ignored){
                inputError=true;
                System.out.println("Array out of bound");
                errorLabel.setText("Please enter value between 0-15");
            }
        }

        //when no error, show the result of path finding by using pop up window
        if(!inputError) {
            Stage stage = new Stage();
            Parent root;
            stage.setTitle("Weakest Part");
            //forward to Path Finding Result window when go button pressed
            root = FXMLLoader.load((getClass().getResource("path-finding-result-window.fxml")));
            stage.setScene(new Scene(root));
            stage.setResizable(false);

            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to path finding action page when back button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("path-finding-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
