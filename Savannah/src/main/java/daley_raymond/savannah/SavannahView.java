package daley_raymond.savannah;

import javafx.event.ActionEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.ArrayList;


public class SavannahView extends GridPane {
    private int cols =3;
    private int rows =3;
    TileView buttons;
    Controller controller;
    ArrayList<TileView> grid;


    SavannahView(Controller ctrl){
        controller = ctrl;
    }

    public void setModel(Savannah savannah){

        grid = new ArrayList<>();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100);
        for (int i = 0; i < cols; i++) {
            this.getColumnConstraints().add(columnConstraints);
        }

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100);
        for (int i = 0; i < rows; i++) {
            this.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                buttons = new TileView(i,j);
                grid.add(buttons);
                buttons.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                buttons.addEventFilter(ActionEvent.ACTION, controller.getButtonEvent());
                add(buttons,i,j);
            }
        }
    }

    public void resize (int col, int row, Savannah savannah){
        cols = col;
        rows = row;
        this.getChildren().clear();
        this.getRowConstraints().clear();
        this.getColumnConstraints().clear();
        this.setModel(savannah);

    }

    public TileView getTileView (int i, int j){
        return grid.get(i*cols+j);
    }
}
