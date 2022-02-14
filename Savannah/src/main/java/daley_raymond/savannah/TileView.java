package daley_raymond.savannah;


import javafx.scene.control.Button;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class TileView extends Button  implements PropertyChangeListener {
    private int iValue;
    private int jValue;

    public TileView(int i, int j) {
        this.setText("N:0");
        iValue = i;
        jValue = j;
    }

    public int getI(){
        return iValue;
    }

    public int getJ(){
        return jValue;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Animal newAnimal = (Animal) evt.getNewValue();
        if (newAnimal != null){
            setText(newAnimal.getCode() + newAnimal.getHealth());
        }
        else
        {
            setText("N:0");
        }
    }

}
