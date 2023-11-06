package com.printifyproject.printifyproject;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.PrintProviderEntity;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import com.printifyproject.orm.service.PrintProviderService;

public class ProductProfilesListScreenController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ChoiceBox<String> myChoiceBox;
    private String[] food= {"pizza","sushi","ramen"};

    public void initialize(URL  arg0, ResourceBundle arg1){
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        PrintProviderService blueprintService = serviceHelper.getPrintProviderService();
        List<PrintProviderEntity> results = blueprintService.findAll();

        List<String> names = getNames(results);


//        Initialization code goes here
        myChoiceBox.getItems().addAll(names);
    }

    public List<String> getNames(List<PrintProviderEntity> list){

        return list.stream()
                    .map(PrintProviderEntity::getName)
                    .toList();

    }

    public void testButton(ActionEvent event){
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        PrintProviderService blueprintService = serviceHelper.getPrintProviderService();
        List<PrintProviderEntity> results = blueprintService.findAll();

        System.out.println(results);
    }


    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
