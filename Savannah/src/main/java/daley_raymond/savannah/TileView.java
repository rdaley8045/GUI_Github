package daley_raymond.savannah;

import javafx.scene.control.Button;

public class TileView extends Button{
    private int iValue;
    private int jValue;

    public TileView(int i, int j){
        iValue = i;
        jValue = j;
        this.setText("N:0");
//        Tile tile = new Tile();
    }

    public int getI(){
        return iValue;
    }

    public int getJ(){
        return jValue;
    }
}
