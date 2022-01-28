module daley_raymond.savannah {
    requires javafx.controls;
    requires javafx.fxml;


    opens daley_raymond.savannah to javafx.fxml;
    exports daley_raymond.savannah;
}