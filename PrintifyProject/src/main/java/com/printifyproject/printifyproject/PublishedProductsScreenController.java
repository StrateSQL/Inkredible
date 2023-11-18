package com.printifyproject.printifyproject;

import com.printifyproject.managers.PublicationManager;
import com.printifyproject.orm.model.ProductEntity;
import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class PublishedProductsScreenController implements Initializable {
    private ProductService productService;
    @FXML
    private ListView<String> allProductsList;
    @FXML
    private ListView<String> selectedProductsList;
    @FXML
    private Label notificationLabel;
    public List<Integer> productIdList;

    public void initialize(URL arg0, ResourceBundle arg1) {
        ServiceHelper.initContext();
        ServiceHelper serviceHelper = new ServiceHelper();
        productService = serviceHelper.getProductService();
        populateUnpublishedProductsList();


    }
    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectionScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addToSelectedList(){
        String selectedProduct = allProductsList.getSelectionModel().getSelectedItem();
        if (!selectedProductsList.getItems().contains(selectedProduct)) {
            selectedProductsList.getItems().add(selectedProduct);
        }
    }

    public int getIdFromProductName(String productName){
        return productIdList.get(allProductsList.getItems().indexOf(productName));

    }

    public void removeToSelectedList(){
        String selectedProduct = allProductsList.getSelectionModel().getSelectedItem();
        selectedProductsList.getItems().remove(selectedProduct);
    }

    public void uploadAllSelected(){
//        get all products from selected list
        List<String> listOfProducts =  selectedProductsList.getItems();

        for (String productString : listOfProducts){
            int productID = getIdFromProductName(productString);
            Optional<ProductEntity> productEntity = productService.findById(productID);
            productEntity.ifPresent(PublicationManager::UploadProductToPrintify);
        }

        notificationLabel.setText("All selected products have been uploaded");




    }

    private void populateUnpublishedProductsList(){
        // clear list to remove all previous entries
        allProductsList.getItems().clear();

        // get product entities and parse them out by design title and printspec name
        List<ProductEntity> productEntities = productService.findAll();
        productEntities = productEntities.stream().filter(productEntity -> !productEntity.isPublished()).toList();
        productIdList = new ArrayList<>();

        for (ProductEntity pEntity : productEntities){
            System.out.println(pEntity.isPublished());
            String designTitle = pEntity.getDesign().getTitle();
            String printSpecName = pEntity.getPrintSpec().getName();
            allProductsList.getItems().add(designTitle + "-" + printSpecName);
            productIdList.add(pEntity.getProductId());

        }
        allProductsList.refresh();

    }

    public void publishAllSelected(){
        //        get all products from selected list
        List<String> listOfProducts =  selectedProductsList.getItems();

        for (String productString : listOfProducts){
            int productID = getIdFromProductName(productString);
            Optional<ProductEntity> productEntity = productService.findById(productID);
            productEntity.ifPresent(PublicationManager::UploadProductToPrintify);
        }
        // Clear products in selected list and refresh non-published products
        selectedProductsList.getItems().clear();
        selectedProductsList.refresh();
        populateUnpublishedProductsList();
        notificationLabel.setText("All selected products have been published");



    }
}
