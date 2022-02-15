package daley_raymond.savannah;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * @file Controller.java
 * @author Raymond Daley
 * @details
 * The purpose of this file is handle all of the controls of the program.
 */
public class Controller {
   private static Layout layout;
   private static Savannah savannah;

    /**
     * Provides the controller with a copy of the layout.
     * @param lay
     */
    public void setLayout(Layout lay){
        layout = lay;
    }

    /**
     * This set the view of the grid for the layout.
     * @param model
     */
    public void setModel(Savannah model){
        savannah = model;
        layout.grid.setModel();
        savannah.setDisplay(layout.grid);
        savannah.createNewMap(3,3);
    }

    /**
     * Base function that calls the NewDayButton Class
     * @return
     */
    public NewDayButton getNewDay(){
        return new NewDayButton();
    }

    /**
     * This is the NewDayButton Class that is the EventHandler for the NewDay button press.
     */
    public static class NewDayButton implements EventHandler<ActionEvent>{
        public void handle(ActionEvent event) {
            savannah.newDay();
            layout.setDay(savannah.getDayCount());
            layout.setDied(savannah.getDeadCount());
            layout.setFilled(savannah.getFilledCount());

        }
    }

    /**
     * This function is the pass through for the ResizeMap class
     * @param i
     * @param j
     * @return
     */
    public ResizeMap setNewMap(int i, int j){return new ResizeMap(i,j);}


    /**
     * This class acts as the event handler whenever the resize buttons are clicked.
     */
    private class ResizeMap implements EventHandler<ActionEvent>{
        private int row;
        private int cols;

        ResizeMap (int i, int j){
            row = i;
            cols = j;
        }

        @Override
        public void handle (ActionEvent e){
            layout.grid.resize(row, cols);
            savannah.createNewMap(row,cols);
            layout.setDay(savannah.getDayCount());
            layout.setDied(savannah.getDeadCount());
            layout.setFilled(savannah.getFilledCount());
            layout.setAnimalInfo(savannah.getAnimalInfo());

        }
    }

    /**
     * This acts as a pass through function for the comboBox selections
     * @return
     */
    public UpdateSelection getComboBox(){
        return new UpdateSelection();
    }

    /**
     * This class acts as the event handler whenever the Combobox selection is changed.
     */
    private class UpdateSelection implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            savannah.setAction((ComboBox)e.getSource());
        }
    }

    /**
     * This acts as pass through function when ever teh add radio button is selected.
     * @return
     */
    public UpdateRadio getAddRadioButton(){
        return new UpdateRadio();
    }

    /**
     * This acts as a pass through function when ever the view radio button is select
     * @return
     */
    public UpdateRadio getViewRadioButton(){
        return new UpdateRadio();
    }

    /**
     * This class updates the radio button to which ever button is clicked on.
     */
    private class UpdateRadio implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
            savannah.setOption((RadioButton)e.getSource());
        }
    }

    /**
     * This function acts as a pass through function to the AddViewAnimal class
     * @return
     */
    public AddViewAnimal getTileEvent(){
        return new AddViewAnimal();
    }

    /**
     * This class handles all of the event handling for the tile buttons.
     */
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
