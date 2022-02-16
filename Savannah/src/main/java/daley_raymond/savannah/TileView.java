package daley_raymond.savannah;


import javafx.scene.control.Button;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @file TileView.java
 * @author Raymond Daley
 * @details
 * This is the tile view class that extends buttons and implements the property change listner
 * */
public class TileView extends Button  implements PropertyChangeListener {
    private int iValue;
    private int jValue;

    /**
     * This is the contructor for the Tile View takes in the row and col position
     * @param i
     * @param j
     */
    public TileView(int i, int j) {
        this.setText("N:0");
        iValue = i;
        jValue = j;
    }

    /**
     * This is a base call function to get the row/I value
     * @return
     */
    public int getI(){
        return iValue;
    }

    /**
     * This is a base call function to get the col/j value
     * @return
     */
    public int getJ(){
        return jValue;
    }

    /**
     * This acts as the observer updating code. This sets the button value to N:0 or to the appropriate
     * animal code and health
     * @param evt
     */

    //GRADING: OBSERVE
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Animal animal = (Animal) evt.getNewValue();
        setText(animal.getCode() + animal.getHealth());
        //GRADING:COLOR
        setStyle(animal.getColor());
    }

}
