module rebenitsch {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    exports Basics;
    exports CookieClicker;
    exports LayoutExamples;
    exports ObserverPatternExample_SDK_8up;

    opens sampleWYSIWYG to javafx.fxml;
    exports sampleWYSIWYG;
}