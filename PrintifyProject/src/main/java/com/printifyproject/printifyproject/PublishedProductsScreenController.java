package com.printifyproject.printifyproject;

import com.printifyproject.managers.PublicationManager;
import com.printifyproject.orm.model.BlueprintEntity;
import com.printifyproject.orm.model.ProductEntity;
import com.printifyproject.orm.service.ProductService;
import com.printifyproject.orm.service.ServiceHelper;
import jakarta.persistence.criteria.CriteriaBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



public class PublishedProductsScreenController implements Initializable {
    private ServiceHelper serviceHelper;
    private ProductService productService;

    @FXML
    private ListView<String> allProductsList;
    @FXML
    private ListView<String> selectedProductsList;

    public List<Integer> productIdList;



    public void initialize(URL arg0, ResourceBundle arg1) {
        ServiceHelper.initContext();
        serviceHelper = new ServiceHelper();
        productService = serviceHelper.getProductService();
        List<ProductEntity> productEntities = productService.findAll();

        productEntities = productEntities.stream().filter(productEntity -> !productEntity.isPublished()).toList();

        productIdList = new ArrayList<Integer>();

        for (ProductEntity pEntity : productEntities){
            System.out.println(pEntity.isPublished());
            String designTitle = pEntity.getDesign().getTitle();
            String printSpecName = pEntity.getPrintSpec().getName();

            allProductsList.getItems().add(designTitle + "-" + printSpecName);
            productIdList.add(pEntity.getProductId());

        }

    }
    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addToSelectedList(ActionEvent event){
        String selectedProduct = allProductsList.getSelectionModel().getSelectedItem();
        if (!selectedProductsList.getItems().contains(selectedProduct)) {
            selectedProductsList.getItems().add(selectedProduct);

            Optional<ProductEntity> product =  productService.findById(productIdList.get(allProductsList.getSelectionModel().getSelectedIndex()));
            product.ifPresent(productEntity -> {
                String designTitle = productEntity.getDesign().getTitle();
                String printSpecName = productEntity.getPrintSpec().getName();
            }

            );


        }
    }

    public int getIdFromProductName(String productName){

        return productIdList.get(allProductsList.getItems().indexOf(productName));

    }

    public void removeToSelectedList(ActionEvent event){
        String selectedProduct = allProductsList.getSelectionModel().getSelectedItem();
        selectedProductsList.getItems().remove(selectedProduct);
    }

    public void uploadAllSelected(ActionEvent event){
//        get all products from selected list
        List<String> listOfProducts =  selectedProductsList.getItems();

        for (String productString : listOfProducts){
            int productID = getIdFromProductName(productString);
            Optional<ProductEntity> productEntity = productService.findById(productID);
            productEntity.ifPresent(PublicationManager::UploadProductToPrintify);
        }



    }

    public void publishAllSelected(ActionEvent event){

    }
}
