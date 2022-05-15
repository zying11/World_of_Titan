package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class is the main class which is used to run the application
 */
public class HelloApplication extends Application {
    /**
     * Override the start method from the Application class
     *
     * @param stage An instance of the Stage class
     * @throws IOException when the resource files are not found
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main-home-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("World of Titan");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * This main method is used to launch the application
     *
     * @param args A string array
     */
    public static void main(String[] args) {
        launch();
    }
}