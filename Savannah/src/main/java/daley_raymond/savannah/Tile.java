package daley_raymond.savannah;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tile{
    private String name = "nano";
    private PropertyChangeSupport subject;

    public Tile(){
        subject = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener obv){
        subject.addPropertyChangeListener(obv);
    }

    public void adjustTileSquare(){
        subject.firePropertyChange("click",null,this.name);
    }
}
