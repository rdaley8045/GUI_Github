package daley_raymond.savannah;

public class Cheetah extends Animal {
    private int health;
    private String name;

    public Cheetah(){
        health = 10;
        name = "Cheetah";
    }

    public int getHealth(){
        return health;
    }

    public void newDay(){
        health -=1;
    }

    public String getName(){
        String string = name+"/nHealth:"+health;
        return string;
    }

    public String getTileView(){
        String string = "C:"+ health;
        return string;
    }


}
