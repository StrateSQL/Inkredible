package com.printifyproject.printifyproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SelectionScreenController
{
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectionScreen.fxml")));
        setStage(event,root);
    }

    public void switchToPrintDesignsListScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PrintDesignsListScreen.fxml")));
        setStage(event,root);
    }
    public void switchToProductProfilesListScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProductProfilesListScreen.fxml")));
        setStage(event,root);
    }

    public void switchToPublishedProductsScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PublishedProductsScreen.fxml")));
        setStage(event,root);;
    }

    public void switchToPublishNewProductScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PublishNewProducts.fxml")));
        setStage(event,root);
    }

    public void switchToManagementScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ManagementScreen.fxml")));
        setStage(event,root);
    }

    public void switchToEditProductsScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditProductsScreen.fxml")));
        setStage(event,root);
    }

    private void setStage(ActionEvent event, Parent root){
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
