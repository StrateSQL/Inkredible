package com.printifyproject.printifyproject;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.DesignEntity;
import com.printifyproject.orm.model.PrintSpecEntity;
import com.printifyproject.orm.model.ProductEntity;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PublishNewProductsScreenController implements Initializable {

    @FXML
    private ChoiceBox<String> designChoiceBox;
    @FXML
    private ChoiceBox<String> productSpecChoiceBox;
    @FXML
    private ListView<String> productSpecsPublishedList;

    private ServiceHelper serviceHelper = new ServiceHelper();

    public void initialize(URL arg0, ResourceBundle arg1) {
        ServiceHelper.initContext();
        serviceHelper = new ServiceHelper();
        DesignService designService = serviceHelper.getDesignService();
        PrintSpecService printSpecService = serviceHelper.getPrintSpecService();
        List<DesignEntity> designResults = designService.findAll();
        List<PrintSpecEntity> printSpecResults = printSpecService.findAll();

        List<String> designTitles = getDesignTitles(designResults);
        List<String> printSpecNames = getPrintSpecNames(printSpecResults);

//        Initialization code goes here





        designChoiceBox.getItems().addAll(designTitles);
        productSpecChoiceBox.getItems().addAll(printSpecNames);
        designChoiceBox.setOnAction(this::onSelectedDesignProfile);
    }

    public List<String> getDesignTitles(List<DesignEntity> list) {

        return list.stream()
                .map(DesignEntity::getTitle)
                .toList();
    }
    public List<String> getPrintSpecNames(List<PrintSpecEntity> list) {

        return list.stream()
                .map(PrintSpecEntity::getName)
                .toList();
    }

    public void onSelectedDesignProfile(ActionEvent event){
        ProductService productService = serviceHelper.getProductService();
        List<ProductEntity> productEntityResults = productService.findAll();

        productSpecsPublishedList.getItems().removeAll();

        for (ProductEntity entity : productEntityResults){
            if (entity.getDesign().getTitle().equals(designChoiceBox.getValue())){
                productSpecsPublishedList.getItems().add(entity.getPrintSpec().getName());
            }

        }
    }

    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
