package daley_raymond.savannah;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;

public class Controller {
   private static Layout layout;
   private static Savannah savannah;


    Controller(Layout lay){
        this.layout = lay;
        savannah = new Savannah();


//        layout.insertionSelector.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//                boolean temp1 = layout.addAnimal.isSelected();
//                boolean temp2 = layout.viewAnimal.isSelected();
//                savannah.setIsAddAnimal(temp1);
//                savannah.setIsViewAnimal(temp2);
//
//            }
//        });
//
//        layout.animalList.addEventFilter(ActionEvent.ACTION,actionEvent -> {
//            String selectedAnimal = layout.animalList.getSelectionModel().getSelectedItem();
////            savannah.setAnimal(selectedAnimal);
//        });

//        layout.grid.addEventFilter(ActionEvent.ACTION, new UpdateSquare());
    }


    public static class NewDayButton implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            savannah.newDay();
            layout.setDay(savannah.getDayCount());
            layout.setDied(savannah.getDeadCount());
            layout.setFilled(savannah.getFilledCount());

        }
    }

    public static class New3x3Map implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            layout.resize(3,3);
            layout.setDay(savannah.resetDayCount());
            layout.setDied(savannah.resetDeadCount());
            layout.setFilled(savannah.resetFilledCount());
        }
    }
    public static class New5x5Map implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            layout.resize(5,5);
            layout.setDay(savannah.resetDayCount());
            layout.setDied(savannah.resetDeadCount());
            layout.setFilled(savannah.resetFilledCount());
        }
    }

    public static class New8x8Map implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            layout.resize(8,8);
            layout.setDay(savannah.resetDayCount());
            layout.setDied(savannah.resetDeadCount());
            layout.setFilled(savannah.resetFilledCount());
        }
    }

//    public class UpdateSquare implements EventHandler<ActionEvent>{
//        @Override
//        public void handle(ActionEvent event){
//            if (savannah.getIsAddAnimal()){
//                System.out.println("Test");
//            }
//        }
//    }





}
