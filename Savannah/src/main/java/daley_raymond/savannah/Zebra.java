package daley_raymond.savannah;

public class Zebra  extends  Animal{

    private int health;
    private String name;

    public Zebra(){
        health = 8;
        name = "Zebra";
    }

    public int getHealth(){
        return health;
    }

    public void newDay(){
        health -=2;
    }

    public String getName(){
        String string = name+"/nHealth:"+health;
        return string;
    }

    public String getTileView(){
        String string = "Z:"+health;
        return string;
    }
}
