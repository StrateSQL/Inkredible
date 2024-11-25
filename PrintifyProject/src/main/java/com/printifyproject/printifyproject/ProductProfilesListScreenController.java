package com.printifyproject.printifyproject;

import com.printifyproject.orm.model.*;
import com.printifyproject.orm.service.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;


public class ProductProfilesListScreenController implements Initializable {

    @FXML
    private ChoiceBox<String> productBlueprintChoiceBox;
    @FXML
    private ChoiceBox<String> printProviderChoiceBox;
    @FXML
    private ListView<String> colorsList;
    @FXML
    private ChoiceBox<String> colorsChoiceBox;
    @FXML
    private TextField gossMarginTextbox;
    @FXML
    private TextField titleTextBox;
    @FXML
    private Label notificationLabel;
    @FXML
    private BlueprintService blueprintService;
    private BlueprintPrintProviderService blueprintPrintProviderService;
    private ColorService colorService;
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
                colorService = serviceHelper.getColorService();
                Set<String> colorEntitySet =  colorService.getColorsByBlueprintPrintProviderId(blueprintPrintProviderEntity1.getId());
                colorsChoiceBox.getItems().addAll(colorEntitySet);
                selectedBlueprintPrintProviderEntity = blueprintPrintProviderEntity1;
            });
        });
    }

    public void addColorToColorList(){
        String color = colorsChoiceBox.getValue();
        colorsList.getItems().add(color);
    }

    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectionScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void saveProductProfile(){
        PrintSpecService printSpecService = serviceHelper.getPrintSpecService();
        PrintSpecEntity printSpecEntity= new PrintSpecEntity();

        // printSpec takes in a name, goss margin, blueprintPrintProvider, a set of print spec color entities
        printSpecEntity.setBlueprintPrintProvider(selectedBlueprintPrintProviderEntity);
        printSpecEntity.setGossMargin(Double.parseDouble(gossMarginTextbox.getText()));
        printSpecEntity.setName(titleTextBox.getText());

        // get selected colors
        List<String> colors =  colorsList.getItems();
        Set<PrintSpecColorEntity> printSpecColorSet = new HashSet<>();

        for (String color : colors){
            PrintSpecColorEntity printSpecColorEntity = new PrintSpecColorEntity(printSpecEntity,colorService.findByColor(color));
            printSpecColorSet.add(printSpecColorEntity);
        }

        printSpecEntity.setColors(printSpecColorSet);
        printSpecService.add(printSpecEntity);
        notificationLabel.setText(printSpecEntity.getName() + " was saved");

    }


}
