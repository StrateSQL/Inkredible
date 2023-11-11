package com.printifyproject.printifyproject;

import com.printifyproject.orm.model.*;
import com.printifyproject.orm.service.*;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public class ProductProfilesListScreenController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private ChoiceBox<String> productBlueprintChoiceBox;
    @FXML
    private ChoiceBox<String> printProviderChoiceBox;
    @FXML
    private ListView<String> colorsList;
    @FXML
    private ChoiceBox<String> colorsChoiceBox;
    private BlueprintService blueprintService;
    private BlueprintPrintProviderService blueprintPrintProviderService;
    private ServiceHelper serviceHelper;

    private BlueprintEntity selectedBlueprintEntity;
    private PrintProviderEntity selectedPrintProviderEntity;
    private BlueprintPrintProviderEntity selectedBlueprintPrintProviderEntity;



    public void initialize(URL arg0, ResourceBundle arg1) {
        ServiceHelper.initContext();
        serviceHelper = new ServiceHelper();
        blueprintService = serviceHelper.getBlueprintService();
        List<BlueprintEntity> results = blueprintService.findAll();

        List<String> blueprintTitles = getTitles(results);


//        Initialization code goes here
        productBlueprintChoiceBox.getItems().addAll(blueprintTitles);
        productBlueprintChoiceBox.setOnAction(this::onSelectedBlueprint);
        printProviderChoiceBox.setOnAction(this::onSelectedPrintProvider);
    }

    public List<String> getTitles(List<BlueprintEntity> list) {

        return list.stream()
                .map(BlueprintEntity::getTitle)
                .toList();
    }

    public void onSelectedBlueprint(ActionEvent event){


        Optional<BlueprintEntity> selectedBlueprint = blueprintService.getBlueprintByTitle(productBlueprintChoiceBox.getValue());


        blueprintPrintProviderService = serviceHelper.getBlueprintPrintProviderService();


        selectedBlueprint.ifPresent(
                blueprintEntity -> {
                    List<String> printProviderNames = blueprintPrintProviderService.getPrintProviderNames(blueprintEntity.getBlueprintId());
                    printProviderChoiceBox.getItems().addAll(printProviderNames);
                    selectedBlueprintEntity = blueprintEntity;
                }
        );

    }

    public void onSelectedPrintProvider(ActionEvent event){
        PrintProviderService printProviderService = serviceHelper.getPrintProviderService();
        Optional<PrintProviderEntity> selectedPrintProvider = printProviderService.getPrintProviderByName(printProviderChoiceBox.getValue());

        selectedPrintProvider.ifPresent(printProviderEntity -> {
            selectedPrintProviderEntity = printProviderEntity;
            Optional<BlueprintPrintProviderEntity> blueprintPrintProviderEntity =  blueprintPrintProviderService.findByKeys(selectedBlueprintEntity,selectedPrintProviderEntity);
            blueprintPrintProviderEntity.ifPresent(blueprintPrintProviderEntity1 -> {
                ColorService colorService = serviceHelper.getColorService();
                Set<String> colorEntitySet =  colorService.getColorsByBlueprintPrintProviderId(blueprintPrintProviderEntity1.getId());
                colorsChoiceBox.getItems().addAll(colorEntitySet);
                selectedBlueprintPrintProviderEntity = blueprintPrintProviderEntity1;
            });

        });



    }

    public void addColorToColorList(ActionEvent event){
        String color = colorsChoiceBox.getValue();
        colorsList.getItems().add(color);
    }


    public void testButton(ActionEvent event) {
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

    public void saveProductProfile(){
        PrintSpecService printSpecService = serviceHelper.getPrintSpecService();
        PrintSpecEntity printSpecEntity= new PrintSpecEntity();
        printSpecEntity.setBlueprintPrintProvider(selectedBlueprintPrintProviderEntity);
        printSpecEntity.set
    }


}
