package com.printifyproject.printifyproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.printifyproject.orm.examples.BlueprintExample.createComboBoxDataSet;

public class HelloApplication extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Selection Screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Printify Application");
        stage.setScene(scene);
        stage.show();
        createComboBoxDataSet();
    }

    public static void main(String[] args) {
        launch();
    }
}