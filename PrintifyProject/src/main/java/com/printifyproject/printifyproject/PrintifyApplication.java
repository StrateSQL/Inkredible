package com.printifyproject.printifyproject;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class PrintifyApplication extends Application {

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrintifyApplication.class.getResource("SelectionScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 300);
        stage.setTitle("Printify API - Desktop User Interface");
        stage.setScene(scene);
        stage.show();
        createComboBoxDataSet();
    }

    public static void createComboBoxDataSet() {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        BlueprintService blueprintService = serviceHelper.getBlueprintService();
        List<BlueprintEntity> blueprints = blueprintService.findAll();

        ObservableList<BlueprintEntity> blueprintList = FXCollections.observableArrayList(blueprints);
        ComboBox<BlueprintEntity> comboBox = new ComboBox<>(blueprintList);
    }

    public static void main(String[] args) {
        launch();
    }
}