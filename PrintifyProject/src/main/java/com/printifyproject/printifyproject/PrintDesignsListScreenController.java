package com.printifyproject.printifyproject;

import com.printifyproject.managers.ImageManager;
import com.printifyproject.orm.model.DesignEntity;
import com.printifyproject.orm.service.DesignService;
import com.printifyproject.orm.service.ServiceHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class PrintDesignsListScreenController implements Initializable {

    @FXML
    private ChoiceBox<String> existing_designs_choicebox;
    @FXML
    private TextField title_textbox;
    @FXML
    private TextArea desc_textbox;
    @FXML
    private TextField img_textbox;
    @FXML
    private Label notificationLabel;
    private DesignService designService;
    private ServiceHelper serviceHelper;


    public void initialize(URL arg0, ResourceBundle arg1) {
        ServiceHelper.initContext();
        serviceHelper = new ServiceHelper();
        loadDesignsList();
        existing_designs_choicebox.setOnAction(this::selectExistingDesign);
    }

    private void loadDesignsList() {
        existing_designs_choicebox.getItems().clear();
        designService = serviceHelper.getDesignService();
        List<DesignEntity> results = designService.findAll();
        List<String> names = getNames(results);
        existing_designs_choicebox.getItems().addAll(names);
    }

    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SelectionScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.setFill(Color.rgb(200, 200, 0));
    }


    public void saveNewDesign() {
        DesignEntity newDesignEntity = new DesignEntity();
        newDesignEntity.setTitle(title_textbox.getText());
        newDesignEntity.setDescription(desc_textbox.getText());
        newDesignEntity.setImage(img_textbox.getText());
        designService.add(newDesignEntity);
        loadDesignsList();
        notificationLabel.setText(newDesignEntity.getTitle() + " has been saved");
    }

    public void saveExistingDesign() {
        Optional<DesignEntity> newDesignEntity = designService.findDesignByTitle(title_textbox.getText());
        newDesignEntity.ifPresent(
                designEntity -> {
                    designEntity.setTitle(title_textbox.getText());
                    designEntity.setDescription(desc_textbox.getText());
                    designEntity.setImage(img_textbox.getText());
                    designService.update(designEntity);
                    loadDesignsList();
                    notificationLabel.setText(designEntity.getTitle() + " has been updated");
                }

        );

    }


    private void selectExistingDesign(ActionEvent event) {
        String selectedDesign = existing_designs_choicebox.getValue();
        Optional<DesignEntity> selectedDesignEntity = designService.findDesignByTitle(selectedDesign);
        selectedDesignEntity.ifPresent(
                designEntity -> {
                    title_textbox.setText(designEntity.getTitle());
                    desc_textbox.setText(designEntity.getDescription());
                    img_textbox.setText(designEntity.getImage());
                }
        );
    }

    public void createNewDesign() {
        desc_textbox.setText("");
        title_textbox.setText("");
        img_textbox.setText("");
    }

    public List<String> getNames(List<DesignEntity> list) {
        return list.stream()
                .map(DesignEntity::getTitle)
                .toList();

    }

    public void selectImage(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        ImageManager.copyFileToPackageDirectory(file.getAbsolutePath(), file.getName());
        img_textbox.setText(file.getAbsolutePath());

    }
}
