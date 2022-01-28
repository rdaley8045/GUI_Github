package CookieClicker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CookieClone extends Application  {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String resPath = "src/main/resources/";

    //for compactness, CookieCLone will also act as the model
    private int clickCnt = 0;
    private ArrayList<UpgradeModel> upgradeModel = new ArrayList<>();
    private int upgradeCount = 0;
    private PropertyChangeSupport subject;

    //View
    private Layout layout;

    //Controller
    private Controller ctrl;


    public static void main(String[] args) {
        launch(args);
    }

    public void AddUpgrade(String s) {
        UpgradeModel u = new UpgradeModel(s);
        upgradeModel.add(u);
        ctrl.addUpgrade(u, subject);

        clickCookie(0);
    }

    public void ApplyAutoClick() {
        for( UpgradeModel up : upgradeModel){
            clickCookie(up.getAutoClick());
        }
    }

    //method to handle setting the model's click
    public void clickCookie() {
        clickCookie(1);
    }

    public void clickCookie(int amount) {
        clickCnt+=amount;

        //toy version
        updateViews();

        //notify upgrade views
        subject.firePropertyChange("click", null, clickCnt);
    }

    public int getClickCnt() {
        return clickCnt;
    }

    //standard start code
    @Override
    public void start(Stage primaryStage) {

        //make remaining model
        //upgradeModel.add(new UpgradeModel(resPath+"upgrade1.txt")); //old direct way
        upgradeModel.add(new UpgradeModel("upgrade1.txt"));
        upgradeModel.add(new UpgradeModel("upgrade2.txt"));

        //create MVC and GUI form
        layout = new Layout();
        ctrl = new Controller(this, layout);

        Scene scene = new Scene(layout.root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cookie Clone!");

        //observer pattern example
        //and add upgrade buttons to side pane
        subject = new PropertyChangeSupport(this);
        for(UpgradeModel u : upgradeModel)
        {
            ctrl.addUpgrade(u, subject);
        }

        //refresh everything
        clickCookie(0);

        primaryStage.show();
    }

    /**
     * Makes sure all are up to date
     * "Toy" version of Observer pattern
     */
    public void updateViews(){

        //re-enable upgradeViews if available for purchase
        //also determine auto-click amount
        double sum = 0;
        upgradeCount = 0;
        for( UpgradeModel up : upgradeModel){
            sum += up.getAutoClick();
            upgradeCount += up.getLevel();
        }

        layout.information.setText("Count: " + clickCnt + "\nUpgrads: " + upgradeCount +
                "\ntotal auto-click " + sum);
    }
}
