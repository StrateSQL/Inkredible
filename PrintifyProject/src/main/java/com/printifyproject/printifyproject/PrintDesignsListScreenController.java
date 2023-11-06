package com.printifyproject.printifyproject;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

public class PrintDesignsListScreenController {

    public void switchToSelectionScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectionScreen.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
