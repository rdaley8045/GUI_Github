package daley_raymond.savannah;

/**
 * @file Tile.java
 * @author Raymond Daley
 * @details
 * Thi is the tile class that acts as the observer to the tile view.
 * */
public class Tile{
    private Animal animal = null;

    /**
     * This is the function that sets the tile to which ever animal that is called.
     * @param action
     * @param type
     */
    void newAnimal(String action, String type){
        if (action == "Add" & type == "Cheetah"){
            animal = new Cheetah();
        }
        else if (action == "Add" & type == "Zebra"){
            animal = new Zebra();
        }
        else{
            animal = new None();
        }
    }

    /**
     * This function gets the animal for the tile.
     * @return
     */
    public Animal getAnimal(){return animal;}

}
