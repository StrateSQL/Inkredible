package com.printifyproject.printifyproject;

import com.printifyproject.printifyapi.loader.PrintifyLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class ManagementScreenController {
    @FXML
    private Label loadingAPILabel;

    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectionScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void callPrintifyLoader() throws InterruptedException {
        loadingAPILabel.setText("Refreshing Printify API ... Please wait");
        callLoaderFunction();
        loadingAPILabel.setText("Printify API has been refreshed");
    }

    private void callLoaderFunction(){PrintifyLoader.process();}

}
