package edu.sdsmt.stop_the_tribbles_daley_raymond;

public class Game {
    private int tribbleCount;
    private int turns;
    private int hunger;
    private int score;
    private int meals;
    private boolean bureaucratPresent;
    private boolean lost;

    public Game(){
        tribbleCount = 100;
        turns = 1;
        hunger = 0;
        score = 0;
        meals = 3;

        bureaucratPresent = false;
        lost = false;

    }

    public boolean isBureaucratPresent() {
        return bureaucratPresent;
    }

    public int getTribbleCount() {
        return tribbleCount;
    }

    public int getTurns() {
        return turns;
    }

    public int getHunger() {
        return hunger;
    }

    public int getScore() {
        return score;
    }

    public int getMeals() {
        return meals;
    }

    public void reset() {
        tribbleCount = 100;
        turns = 1;
        hunger = 0;
        score = 0;
        meals = 3;
        bureaucratPresent = false;
    }

    public void newTurn() {
        turns += 1;
        tribbleCount = (int)(tribbleCount*1.25+.5);
        if ((turns-1)%2 == 0){
            bureaucratPresent = true;
        }
//        hunger += 2;
//        if (hunger > 10){
//            hunger = 10;
//        }
        meals = 3;
        if (tribbleCount > 200){
            lost = true;
        }
    }

    public void eat() {
        meals -= 1;
        if (hunger == 0){
            tribbleCount = tribbleCount*2;
        }else {
            tribbleCount += 10;
        }

        if (hunger >= 3){
            hunger -= 3;
        }else if (hunger >=0 && hunger <3){
            hunger = 0;
        }

        if (tribbleCount > 200){
            lost = true;
        }
    }

    public void collectTribbles(int i) {
        tribbleCount -= i;
        hunger += 2;
        if (hunger > 10){
            hunger = 10;
        }
        score += 1;

        if (tribbleCount <= 0){
            lost = false;
        }
    }

    //GRADING: NO_BUREAUCRAT
    public void distract() {
        bureaucratPresent = false;
        hunger = 10;
    }

    public boolean isLost() {
        return lost;
    }
}
