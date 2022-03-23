package daley_raymond.savannah;

/**
 * @file Cheetah.java
 * @author Raymond Daley
 * @details
 * This class extends Animal and holds all of the value for the cheetah
 * */

public class Cheetah extends Animal {
    Cheetah(){
        name = "Cheetah";
        code = "C:";
        health = 10;
        lossRate = 1;
        //GRADING:COLOR
        color = "-fx-background-color:rgba(61, 235, 52, 0.76);";
    }
}
