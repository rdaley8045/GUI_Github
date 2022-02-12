package daley_raymond.savannah;

public class None extends Animal {
    private int health;
    private String name;

    public None(){
        health = 0;
        name = "None";
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        String string = name+"/nHealth:"+String.valueOf(health);
        return string;
    }

    public String getTileView(){
        String string = "N:0";
        return string;
    }

}
