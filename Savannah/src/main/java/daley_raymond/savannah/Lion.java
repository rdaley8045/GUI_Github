package daley_raymond.savannah;

/**
 * @file Lion.java
 * @author Raymond Daley
 * @details
 * This class extends Animal and holds all of the value for the lion
 * */

//GRADING: NEW ANIMAL
public class Lion extends Animal {
    Lion(){
        name = "Lion";
        code = "L:";
        health = 15;
        lossRate = 1;
        //GRADING:COLOR
        color = "-fx-background-color: rgba(52, 122, 235, 0.76);";

    }
}
