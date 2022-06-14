package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class KillingSequenceActionPageController {
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

    static boolean Reiner;
    static boolean Armin;
    static boolean Annie;
    static boolean Bertholdt;
    static boolean Jean;
    static boolean Sasha;
    static boolean Connie;
    static boolean Mikasa;
    static boolean Eren;
    static boolean Historia;
    static boolean Levi;
    static boolean Erwin;
    static boolean Hange;

    @FXML
    void initialize() throws IOException{
        Reiner=false;
        Armin=false;
        Annie=false;
        Bertholdt=false;
        Jean=false;
        Sasha=false;
        Connie=false;
        Mikasa=false;
        Eren=false;
        Historia=false;
        Levi=false;
        Erwin=false;
        Hange=false;

    }

    @FXML
    void ReinerButtonPressed(MouseEvent event) throws IOException{
        //forward to killing sequence result page when soldier button pressed
        Reiner=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ArminButtonPressed(MouseEvent event) throws IOException{
        Armin=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void AnnieButtonPressed(MouseEvent event) throws IOException{
        Annie=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BertholdtButtonPressed(MouseEvent event) throws IOException{
        Bertholdt=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void JeanButtonPressed(MouseEvent event) throws IOException{
        Jean=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void SashaButtonPressed(MouseEvent event) throws IOException{
        Sasha=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ConnieButtonPressed(MouseEvent event) throws IOException{
        Connie=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void MikasaButtonPressed(MouseEvent event) throws IOException{
        Mikasa=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ErenButtonPressed(MouseEvent event) throws IOException{
        Eren=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void HistoriaButtonPressed(MouseEvent event) throws IOException{
        Historia=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void LeviButtonPressed(MouseEvent event) throws IOException{
        Levi=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void ErwinButtonPressed(MouseEvent event) throws IOException{
        Erwin=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void HangeButtonPressed(MouseEvent event) throws IOException{
        Hange=true;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("killing-sequence-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void BackButtonPressed(MouseEvent event) throws IOException {
        //forward to generate titan result page when back button pressed
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("generate-titan-result-page.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
