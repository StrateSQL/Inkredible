package com.printifyproject.printifyproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class SelectionScreenController
{
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPrintDesignsListScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PrintDesignsListScreen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToProductProfilesListScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ProductProfilesListScreen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPublishedProductsScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PublishedProductsScreen.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void switchToPublishNewProductScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("PublishNewProducts.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
