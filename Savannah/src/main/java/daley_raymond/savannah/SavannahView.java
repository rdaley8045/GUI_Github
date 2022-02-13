package daley_raymond.savannah;

import javafx.beans.binding.DoubleExpression;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;


public class SavannahView extends GridPane {
    private int col;
    private int row;
    TileView[][] grid;
    private TileView buttons;

    public void setModel(Savannah savannah){
        row = savannah.getRowSize();
        col = savannah.getColSize();

        grid = new TileView[row][col];

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(100);
        for (int i = 0; i < col; i++) {
            this.getColumnConstraints().add(columnConstraints);
        }

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100);
        for (int i = 0; i < row; i++) {
            this.getRowConstraints().add(rowConstraints);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                buttons = new TileView();
                this.add(buttons,i,j);
                buttons.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                grid[i][j] = buttons;
            }
        }
    }

    public void resize (int col, int row){
        this.getChildren().clear();
        this.getRowConstraints().clear();
        this.getColumnConstraints().clear();
        Savannah savannah = new Savannah();
        savannah.setSize(col,row);
        this.setModel(savannah);
    }

}
