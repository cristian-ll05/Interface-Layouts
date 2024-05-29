module layouts.ejemplo {
    requires javafx.controls;
    requires javafx.fxml;

    opens layouts.ejemplo to javafx.fxml;
    exports layouts.ejemplo;
}
