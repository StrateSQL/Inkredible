module com.printifyproject.printifyproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.printifyproject.printifyproject to javafx.fxml;
    exports com.printifyproject.printifyproject;
}