package daley_raymond.savannah;
/*
Initial Java FX check for the program. By clicking on the New Day button it should update the
day counter.
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;


public class Main extends Application {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 600;

//    Model
    private Savannah savannah;

//    View
    private Layout layout;

//    Controller
    private Controller ctrl;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //group is an area that can hold Nodes (non resizable)
        savannah = new Savannah();

        layout = new Layout(savannah);

        Scene scene = new Scene(layout.root,WIDTH , HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Savannah Simulator");

        ctrl = new Controller (savannah,layout);

        //make visible
        primaryStage.show();

    }
}