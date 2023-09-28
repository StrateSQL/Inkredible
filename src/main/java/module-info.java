module com.capstone.inkredible {
    requires javafx.controls;
    requires javafx.fxml;
	requires org.slf4j;
	requires java.net.http;

    opens com.capstone.inkredible to javafx.fxml;
    exports com.capstone.inkredible;
}
