package daley_raymond.savannah;


public class Tile{
    private Animal animal = null;

    Tile(){}

    void newAnimal(String action, String type){
        if (action == "Add" & type == "Cheetah"){
            animal = new Cheetah();
        }
        else if (action == "Add" & type == "Zebra"){
            animal = new Zebra();
        }
        else if (action == "" & type == "None"){
            animal = new None();
        }
        else{
            animal = null;
        }
    }

    public Animal getAnimal(){return animal;}

}
