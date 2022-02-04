package daley_raymond.savannah;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Controller {
   private Layout layout;
   private Savannah savannah;


    Controller(Savannah data, Layout lay){
        this.layout = lay;
        savannah = data;
        layout.newDay.addEventFilter(ActionEvent.ACTION, new NewDayButton());
    }

    public Savannah getSavannah(){
        return savannah;
    }
//

    public class NewDayButton implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            savannah.newDay();
            layout.setDay(savannah.getDayCount());
        }
    }

//    public static class New3x3Map implements EventHandler<MouseEvent>{
//
//        public void handle(MouseEvent event) {
//            savannah = new Savannah(3);
//            savannahView.getChildren().clear();
//            savannahView.setModel(savannah);
//            savannahView.resize(3,3);
//
//
//        }
//    }
//
//    public static class New5x5Map implements EventHandler<MouseEvent>{
//
//        public void handle(MouseEvent event) {
//
//            savannah = new Savannah(5);
//            savannahView.getChildren().clear();
//            savannahView.setModel(savannah);
//            savannahView.resize(5,5);
//
//        }
//    }
//
//    public static class New8x8Map implements EventHandler<MouseEvent>{
//
//        public void handle(MouseEvent event) {
//            savannah = new Savannah(8);
//            savannahView.getChildren().clear();
//            savannahView.setModel(savannah);
//            savannahView.resize(8,8);
//
//        }
//    }



}
