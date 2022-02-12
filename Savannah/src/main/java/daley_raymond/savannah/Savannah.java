package daley_raymond.savannah;

public class Savannah {

    private int dayCount;
    private int filledCount;
    private int deadCount;
    private int col = 3;
    private int row = 3;
    private SavannahView view;
    private boolean isAddAnimal;
    private boolean isViewAnimal;
    private String animal;


    public Savannah (){
        dayCount = 0;
        deadCount = 0;
        filledCount = 0;
    }

    public void setSize(int cols, int rows){
        col = cols;
        row = rows;

    }
    public int getDayCount() {return dayCount;}

    public int getDeadCount() {return deadCount;}

    public int getFilledCount() {return filledCount;}

    public int resetDayCount() {
        dayCount = 0;
        return dayCount;
    }

    public int resetDeadCount() {
        deadCount = 0;
        return deadCount;
    }

    public int resetFilledCount(){
        filledCount = 0;
        return filledCount;
    }

    public void newDay(){
        dayCount += 1;
    }

    public int getRowSize(){return row;}
    public int getColSize(){return col;}

    public void setIsAddAnimal(boolean value){ isAddAnimal = value;}
    public void setIsViewAnimal(boolean value){ isViewAnimal = value;}

    public void setAnimal(String value) {animal = value;}

    public boolean getIsAddAnimal(){return isAddAnimal;}

}
