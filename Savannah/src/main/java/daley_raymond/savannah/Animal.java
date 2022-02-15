package daley_raymond.savannah;

/**
 * @file Animal.java
 * @author Raymond Daley
 * @details
 * This is the abstract class for all the animals in that is in the program.
 * */

public abstract class Animal{

    protected String name;
    protected String code;
    protected int health;
    protected int lossRate;

    /**
     * This function is called when the new day button is pressed is decrease the health by that animals loss rate
     * and sets the value to 0 if the health get to less than or equal to zero.
     * @return
     */
    public int newDay() {
        health -= lossRate;

        if (health <= 0){
            health = 0;
        }

        return health;
    }

    /**
     * Returns the health for the animal
     * @return
     */
    public int getHealth(){return health;}

    /**
     * Returns the name for the animal
     * @return
     */
    public String getName(){return name;}

    /**
     * Returns the single digit code for the animal
     * @return
     */
    public String getCode(){return code;}


}
