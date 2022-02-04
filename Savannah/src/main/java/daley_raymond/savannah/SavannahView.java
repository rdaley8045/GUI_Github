package daley_raymond.savannah;

import javafx.beans.binding.DoubleExpression;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class SavannahView extends GridPane{
    private int col = 3;
    private int row = 3;
    TileView[][] grid;

    public void setModel(Savannah savannah){
        grid = new TileView[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                TileView buttons = new TileView(i, j);
                this.add(buttons,i,j);
                Tile tile = new Tile();
//                tile.addObserver(plant);
//                savannah.setTile(tile, i, j);
                grid[i][j] = buttons;
            }
        }
    }

    public void resize (int col, int row){

    }


}
