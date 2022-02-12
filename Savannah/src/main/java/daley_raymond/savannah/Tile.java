package daley_raymond.savannah;

public class Tile{
    private Animal animal;

    public Tile(){
        animal = new None();
    }

    public String getName() {
        return animal.getName();
    }

    public Boolean isEmpty(){
        return animal instanceof None;
    }

    public Boolean newDay(){
        animal.newDay();
        Boolean dead = false;
        if (animal.getHealth() == 0 && !isEmpty()){
            animal = new None();
            dead = true;
        }
        return dead;
    }

    public void setEmpty(){
        animal = new None();
    }

    public void setCheetah(){
        animal = new Cheetah();
    }

    public void setZebra(){
        animal = new Zebra();
    }

}
