package daley_raymond.savannah;

public abstract class Animal implements Cloneable {

    protected String name;
    protected String code;
    protected int health;
    protected int lossRate;
    protected Boolean visited;

    public int newDay() {
        health -= lossRate;

        if (health <= 0){
            health = 0;
        }

        return health;
    }

    public int getHealth(){return health;}
    public String getName(){return name;}
    public String getCode(){return code;}


    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

}
