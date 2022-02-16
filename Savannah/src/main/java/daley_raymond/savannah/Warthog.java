package daley_raymond.savannah;

/**
 * @file Warthog.java
 * @author Raymond Daley
 * @details
 * This class extends Animal and holds all of the value for the warthog
 * */

//GRADING: NEW ANIMAL
public class Warthog extends Animal{
    Warthog(){
        name = "Warthog";
        code = "W:";
        health = 5;
        lossRate = 4;
        //GRADING:COLOR
        color = "-fx-background-color: rgba(156, 106, 7, 0.76);";

    }
}
