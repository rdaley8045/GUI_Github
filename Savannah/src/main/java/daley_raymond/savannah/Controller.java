package daley_raymond.savannah;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Controller {
   private static Layout layout;
   private static Savannah savannah;



    Controller(){
    }

    public void setLayout(Layout lay){
        layout = lay;
    }

    public void setModel(Savannah model){
        savannah = model;
        layout.grid.setModel(model);
        savannah.setDisplay(layout.grid);
        savannah.setSize(3,3);
    }

    public static class NewDayButton implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            savannah.newDay();
            layout.setDay(savannah.getDayCount());
            layout.setDied(savannah.getDeadCount());
            layout.setFilled(savannah.getFilledCount());

        }
    }

    public ResizeMap setNewMap(int i, int j){return new ResizeMap(i,j);}

    private class ResizeMap implements EventHandler<ActionEvent>{
        private int row;
        private int cols;

        ResizeMap (int i, int j){
            row = i;
            cols = j;
        }

        @Override
        public void handle (ActionEvent e){
            layout.grid.resize(row, cols,savannah);
            savannah.setSize(row,cols);
            layout.setDay(savannah.getDayCount());
            layout.setDied(savannah.getDeadCount());
            layout.setFilled(savannah.getFilledCount());
            layout.setAnimalInfo(savannah.getAnimalInfo());

        }
    }

    public UpdateSelection getComboBox(){
        return new UpdateSelection();
    }

    private class UpdateSelection implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            savannah.setAction((ComboBox)e.getSource());
        }
    }

    public UpdateRadio getAddRadioButton(){
        return new UpdateRadio();
    }

    public UpdateRadio getViewRadioButton(){
        return new UpdateRadio();
    }

    private class UpdateRadio implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            savannah.setOption((RadioButton)e.getSource());
        }
    }

    public AddViewAnimal getButtonEvent(){
        return new AddViewAnimal();
    }

    private class AddViewAnimal implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            TileView button = (TileView) e.getSource();

            if(savannah.isAdd()) {
                savannah.handleAdd(button.getI(), button.getJ());
                layout.setDay(savannah.getDayCount());
                layout.setDied(savannah.getDeadCount());
                layout.setFilled(savannah.getFilledCount());
            }
            else{
                savannah.handleView(button.getI(), button.getJ());
                layout.setAnimalInfo(savannah.getAnimalInfo());
            }
        }
    }

}
