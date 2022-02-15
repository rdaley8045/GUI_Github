package daley_raymond.savannah;

import javafx.event.ActionEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.ArrayList;

/**
 * @file SavannahView.java
 * @author Raymond Daley
 * @details
 *
 * This is the class that build out the view of the grid.
 * */

public class SavannahView extends GridPane {
    private int cols =3;
    private int rows =3;
    TileView buttons;
    Controller controller;
    ArrayList<TileView> grid;


    /**
     * This is the contructor of the class and takes in the controller to handle the button clicks.
     * @param ctrl
     */
    SavannahView(Controller ctrl){
        controller = ctrl;
    }

    /**
     * This is the setModel function that build out the grid passed on the row and cols that are passed in.
     */
    public void setModel(){
        //Create an Array list of the grid
        grid = new ArrayList<>();

        //build out column constraints
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100);
        for (int i = 0; i < cols; i++) {
            this.getColumnConstraints().add(columnConstraints);
        }

        //build out the row constraints
        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100);
        for (int i = 0; i < rows; i++) {
            this.getRowConstraints().add(rowConstraints);
        }

        //Double for loop that creates all of the buttons for the grid.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons = new TileView(i,j);
                grid.add(buttons);
                buttons.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                buttons.addEventFilter(ActionEvent.ACTION, controller.getTileEvent());
                add(buttons,i,j);
            }
        }
    }

    /**
     * This is the resize function that clears out all of the row and columns constraints and build a new grid
     * with the new sizes
     * @param col
     * @param row
     */
    public void resize (int col, int row){
        cols = col;
        rows = row;
        this.getChildren().clear();
        this.getRowConstraints().clear();
        this.getColumnConstraints().clear();
        this.setModel();

    }

    /**
     * This is the getter for the tile tiles.
     * @param i
     * @param j
     * @return
     */
    public TileView getTheTile (int i, int j){
        return grid.get(i*cols+j);
    }
}
