package daley_raymond.savannah;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import java.beans.PropertyChangeSupport;

public class Savannah {

    private int dayCount;
    private int filledCount;
    private int deadCount;
    private int col = 3;
    private int row = 3;
    private Tile[][] model;
    private String type = "Cheetah"; //Cheetah, Zebra
    private String  option = "Add";
    private PropertyChangeSupport[][] subject;
    private SavannahView view;
    private String info;



    public Savannah (){
        dayCount = 0;
        deadCount = 0;
        filledCount = 0;
    }

    public void setSize(int cols, int rows){
        col = cols;
        row = rows;

        createNewMap();
    }
    public int getDayCount() {return dayCount;}

    public int getDeadCount() {return deadCount;}

    public int getFilledCount() {return filledCount;}

    public String getAnimalInfo() {return info;}

    public void createNewMap(){
        model = new Tile[row][col];
        subject = new PropertyChangeSupport[row][col];
        dayCount = 0;
        deadCount = 0;
        filledCount = 0;
        info = "Animal Info";

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                model[i][j] = new Tile();
                subject[i][j] = new PropertyChangeSupport(this);
                subject[i][j].addPropertyChangeListener(view.getTileView(i,j));
            }
        }
    }

    public void setDisplay(SavannahView newView){
        view= newView;
    }

    public void setAction(ComboBox e){
        type = (String) e.getSelectionModel().getSelectedItem();
        System.out.println(type);
    }

    public void setOption(RadioButton e){
        option = e.getText();
        System.out.println(option);
    }

    public void newDay(){
        dayCount += 1;

        for (int i= 0; i < row; i++){
            for (int j= 0; j < col; j++){
                Animal temp = model[i][j].getAnimal();
                if (temp != null){
                    if (temp.newDay() == 0 && temp.getName() != "None"){
                        model[i][j].newAnimal("","None");
                        deadCount ++;
                        filledCount --;
                    }
                    subject[i][j].firePropertyChange("Update", 0, model[i][j].getAnimal());
                }
            }
        }
    }

    public void handleAdd(int i, int j) {
        Boolean hasAnimal = false;
        if (model[i][j].getAnimal() == null || model[i][j].getAnimal().getName() == "None") {
            hasAnimal = true;
        }

        model[i][j].newAnimal(option, type);
        if (hasAnimal) {
            filledCount++;
        }

        subject[i][j].firePropertyChange("Add", 0, model[i][j].getAnimal());
    }

    public void handleView (int i, int j){
        Animal animal = model[i][j].getAnimal();

        if (animal != null){
            if (animal.getName() != "None") {
                info = animal.getName() + "\nHealth: " + animal.getHealth();
            }
            else{
                info = "Animal Info";
            }
        }
        else{
            info = "Animal Info";
        }
        subject[i][j].firePropertyChange("Update Info", 0, model[i][j].getAnimal());
    }

    public boolean isAdd(){
        if (option == "Add"){
            return true;
        }
        else{
            return false;
        }
    }

}
