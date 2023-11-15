package com.printifyproject.printifyproject;

import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.DesignEntity;
import com.printifyproject.orm.model.PrintSpecEntity;
import com.printifyproject.orm.service.BlueprintService;
import com.printifyproject.orm.service.DesignService;
import com.printifyproject.orm.service.PrintSpecService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
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

    public void initialize(URL arg0, ResourceBundle arg1) {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        DesignService designService = serviceHelper.getDesignService();
        PrintSpecService printSpecService = serviceHelper.getPrintSpecService();
        List<DesignEntity> designResults = designService.findAll();
//        List<PrintSpecEntity> printSpecResults = printSpecService.findAll();

        List<String> designTitles = getDesignTitles(designResults);
//        List<String> printSpecNames = getPrintSpecNames(printSpecResults);

//        Initialization code goes here

        designChoiceBox.getItems().addAll(designTitles);
//        productSpecChoiceBox.getItems().addAll(printSpecNames);
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

    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
