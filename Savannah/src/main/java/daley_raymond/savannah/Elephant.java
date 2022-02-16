package daley_raymond.savannah;

/**
 * @file Elephant.java
 * @author Raymond Daley
 * @details
 * This class extends Animal and holds all of the value for the Elephant
 * */

//GRADING: NEW ANIMAL
public class Elephant extends Animal{
    Elephant(){
        name = "Elephant";
        code = "E:";
        health = 20;
        lossRate = 3;
        //GRADING:COLOR
        color = "-fx-background-color: rgba(191, 186, 189, 0.8);";
    }
}
