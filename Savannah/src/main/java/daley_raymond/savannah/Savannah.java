package daley_raymond.savannah;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import java.beans.PropertyChangeSupport;

/**
 * @file Savannah.java
 * @author Raymond Daley
 * @details
 *
 * This is the main controller for the model of the MVC this is where all of the functions that manipulate the data.
 * */

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

    /**
     * Returns the value of the day count to the calling function
     * @return
     */
    public int getDayCount() {return dayCount;}

    /**
     * Returns the value of the dead count to the calling function
     * @return
     */
    public int getDeadCount() {return deadCount;}

    /**
     * Returns the value of the filled count to the calling function
     * @return
     */
    public int getFilledCount() {return filledCount;}

    /**
     * Returns the value of the animal information to the calling function
     * @return
     */
    public String getAnimalInfo() {return info;}


    /**
     * This is creates a new mapping of the grid view for the model.
     * @param row
     * @param col
     */
    public void createNewMap(int row, int col){
        model = new Tile[row][col];
        subject = new PropertyChangeSupport[row][col];

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                model[i][j] = new Tile();
                subject[i][j] = new PropertyChangeSupport(this);
                //GRADING: SUBJECT
                subject[i][j].addPropertyChangeListener(view.getTheTile(i,j));
            }
        }
        dayCount = 0;
        deadCount = 0;
        filledCount = 0;
        info = "Animal Info";

    }

    /**
     * This gets a copy of the Savannah view for the new mapping to be created.
     * @param newView
     */
    public void setDisplay(SavannahView newView){
        view= newView;
    }

    /**
     * This function gets the value of the combobox and stores the value
     * @param e
     */
    public void setAction(ComboBox e){
        type = (String) e.getSelectionModel().getSelectedItem();
    }

    /**
     * This function gets the value of the Radiobuttons and stores the value
     * @param e
     */
    public void setOption(RadioButton e){
        option = e.getText();
    }

    /**
     * This is the model manipulation of the new day button action. It adds days to the count. Calls the newday function
     * for the animal and reduces the fill and increase dead count when needed.
     */
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
                    //GRADING: TRIGGER
                    subject[i][j].firePropertyChange("Update", 0, model[i][j].getAnimal());
                }
            }
        }
    }

    /**
     * This function handles adding new animals to the tiles.
     * @param i
     * @param j
     */
    public void handleAdd(int i, int j) {
        Boolean doesNotHaveAnimal = false;
        if (model[i][j].getAnimal() == null || model[i][j].getAnimal().getName() == "None") {
            doesNotHaveAnimal = true;
        }

        model[i][j].newAnimal(option, type);
        if (doesNotHaveAnimal) {
            filledCount++;
        }
        //GRADING: TRIGGER
        subject[i][j].firePropertyChange("Add", 0, model[i][j].getAnimal());
    }

    /**
     * This handles getting the view for each of the animals.
     * @param i
     * @param j
     */
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
        //GRADING: TRIGGER
        subject[i][j].firePropertyChange("View Info", 0, model[i][j].getAnimal());
    }

    /**
     * Return if the option is Add is true or not.
     * @return
     */
    public boolean isAdd(){
        if (option == "Add"){
            return true;
        }
        else{
            return false;
        }
    }

}
