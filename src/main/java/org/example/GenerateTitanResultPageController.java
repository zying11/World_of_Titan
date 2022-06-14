package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    void initialize() throws IOException {

        for (TitanData titanData : GenerateTitanLoadingPageController.titanToKilledList) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("generate-titan-result-template.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                GenerateTitanResultTemplateController resultTemplateController = fxmlLoader.getController();
                resultTemplateController.setTitanData(titanData);
                vBoxTitan.getChildren().add(anchorPane);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void KillingSequenceButtonPressed(MouseEvent event) throws IOException{
        //forward to Killing Sequence Action Page when killing sequence button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-action-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
