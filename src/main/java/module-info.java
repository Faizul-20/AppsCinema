module net.javaguides.cinemaapps {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens net.javaguides.cinemaapps to javafx.fxml;
    exports net.javaguides.cinemaapps;
    exports net.javaguides.cinemaapps.DataBaseConnector;
    opens net.javaguides.cinemaapps.DataBaseConnector to javafx.fxml;
    exports net.javaguides.cinemaapps.Controller;
    opens net.javaguides.cinemaapps.Controller to javafx.fxml;
}