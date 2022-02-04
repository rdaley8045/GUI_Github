package daley_raymond.savannah;

public class Savannah {

    private int dayCount;
    private int filledCount;
    private int deadCount;
    private int size;


    public Savannah (){
        dayCount = 0;
        deadCount = 0;
        filledCount = 0;
    }

    public int getSavannahSize (){
        return size;
    }

    public int getDayCount() {return dayCount;}

    public int getDeadCount() {return deadCount;}

    public int getFilledCount() {return filledCount;}

    public void newDay(){
        dayCount += 1;
    }

}
