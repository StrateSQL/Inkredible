module com.printifyproject.printifyproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.validation;
    requires org.hibernate.orm.core;
    requires org.slf4j;
    requires okhttp3;
    requires java.persistence;
    requires annotations;


    opens com.printifyproject.printifyproject to javafx.fxml;
    exports com.printifyproject.printifyproject;
}