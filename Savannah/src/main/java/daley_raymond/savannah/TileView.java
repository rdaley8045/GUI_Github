package daley_raymond.savannah;


import javafx.scene.control.Button;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class TileView extends Button  implements PropertyChangeListener {
//    private int iValue;
//    private int jValue;
    Tile model;

    public TileView(){
        model = new Tile();
        this.setText("Help");
        model.addObserver(this);
    }
//
//    public int getI(){
//        return iValue;
//    }
//
//    public int getJ(){
//        return jValue;
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setText("N:0");
    }
}
