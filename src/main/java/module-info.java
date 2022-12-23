module com.github.nutt1101.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.nutt1101.calculator to javafx.fxml;
    exports com.github.nutt1101.calculator;
}