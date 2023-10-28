module com.printifyproject.printifyproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires jakarta.persistence;
    requires org.slf4j;
    requires okhttp3;
    requires annotations;
    requires javafx.graphics;
    requires jakarta.validation;

    opens com.printifyproject.printifyapi.model.catalog to com.fasterxml.jackson.databind;
    opens com.printifyproject.printifyapi.model.product to com.fasterxml.jackson.databind;
    opens com.printifyproject.printifyapi.model.shop to com.fasterxml.jackson.databind;
    opens com.printifyproject.printifyproject to javafx.fxml;
    exports com.printifyproject.printifyproject;
}