module login.formlogin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires java.sql;
    requires javafx.graphics;


    opens app to javafx.fxml;
    exports app;

}