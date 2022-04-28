package edu.sdsmt.stop_the_tribbles_daley_raymond;

import android.graphics.Color;

public class LowHungerWithBureaucrat extends State{

    public LowHungerWithBureaucrat(Game game, MainActivity ma, StateMachine sm) {
        super(game, ma, sm);
        collect = 10;
        backgroundColor = Color.LTGRAY;
    }

    @Override
    public void exitActivity(){
        mainActivity.findViewById(R.id.gameView).invalidate();
    }
    @Override
    public void entryActivity(){
        GameView gv = mainActivity.findViewById(R.id.gameView);
        gv.setBackgroundColor(backgroundColor);
        gv.setBureaucratPresent(game.isBureaucratPresent());
        mainActivity.findViewById(R.id.distractBtn).setClickable(true);
        mainActivity.findViewById(R.id.distractBtn).setEnabled(true);


    }

    @Override
    public void onUpdate(){
//        this.game.newTurn();
        doTask();
    }

    public void doTask(){
        // GRADING: TRANSITION_TO_MID
        if(this.game.isBureaucratPresent()){
            if(this.game.getHunger() >= 4 && this.game.getHunger() <= 7){
                this.stateMachine.setState(StateMachine.StateEnum.MB);
            }
            else if(this.game.getHunger() >= 0 && this.game.getHunger() <= 3){
                this.stateMachine.setState(StateMachine.StateEnum.LB);
            }
            else if(this.game.getHunger() >= 8 && this.game.getHunger() <=10){
                this.stateMachine.setState(StateMachine.StateEnum.HB);
            }
        }else{
            if(this.game.getHunger() >= 4 && this.game.getHunger() <= 7){
                this.stateMachine.setState(StateMachine.StateEnum.MN);
            }
            else if(this.game.getHunger() >= 0 && this.game.getHunger() <= 3){
                this.stateMachine.setState(StateMachine.StateEnum.LN);
            }
            else if(this.game.getHunger() >= 8 && this.game.getHunger() <=10){
                this.stateMachine.setState(StateMachine.StateEnum.HN);
            }
        }
    }

    @Override
    public int getCollect(){
        return collect;
    }

    @Override
    public void newDay() {
        this.game.newTurn();
        mainActivity.findViewById(R.id.eatBtn).setClickable(true);
        mainActivity.findViewById(R.id.eatBtn).setEnabled(true);
        doTask();
    }

    @Override
    public void eat() {
        this.game.eat();
        if (game.getMeals() <=0){
            mainActivity.findViewById(R.id.eatBtn).setClickable(false);
            mainActivity.findViewById(R.id.eatBtn).setEnabled(false);
        }
        doTask();
    }

    @Override
    public void distract() {
        this.game.distract();
        doTask();
    }

    @Override
    public void collect() {
        //        GRADING:COLLECT

        this.game.collectTribbles(collect);
        doTask();
    }
}
