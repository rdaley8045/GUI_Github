package CookieClicker;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

import java.beans.PropertyChangeSupport;

public class Controller {
    private Layout layout;
    private CookieClone model;
    private long firstCall = 0;
    private boolean hidden = true;
    
    public Controller(CookieClone clone, Layout layout) {
        this.layout = layout;
        model = clone;
        
        layout.output.addEventFilter(ActionEvent.ACTION, new CountListener());

        Timeline timer = new Timeline(new KeyFrame(Duration.seconds(1),new Tick()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        firstCall = System.currentTimeMillis();

    }

    public void addUpgrade(UpgradeModel upgrade, PropertyChangeSupport subject) {
        ObservableList<Node> list = layout.panel.getChildren();
        UpgradeView v = new UpgradeView(upgrade);
        subject.addPropertyChangeListener(v);
        v.addEventHandler(ActionEvent.ACTION,  new BuyUpgrade());
        list.add(v);
    }


    /**
     * Handles purchasing upgradeViews
     */
    private class BuyUpgrade implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            int money = model.getClickCnt();
            UpgradeView button = (UpgradeView)e.getSource();
            model.clickCookie(button.getModel().purchase(money));
        }
    }

    /**
     * Handles normal click increase in money
     */
    private class CountListener implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent e) {
            model.clickCookie(); // tell the model to update
        }
    }

    /**
     * Handles the autoclick increase in "money"
     */
    private class Tick implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            //add autoclick to total...observer pattern handles the rest
            model.ApplyAutoClick();

            long currentTime = System.currentTimeMillis();

            //debugging statement
            // wait 5 seconds to display last upgrade
            System.out.println((currentTime - firstCall)/1000.0);

            if(hidden && (currentTime - firstCall)/1000.0 > 10){
                model.AddUpgrade("upgrade3.txt");
                hidden = false;
            }
        }
    }
}
