package com.printifyproject.printifyproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Selection Screen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPrintDesignsListScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Print Designs List Screen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToProductProfilesListScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Product Profiles List Screen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPublishedProductsScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Published Products Screen List Screen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
