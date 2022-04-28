package edu.sdsmt.stop_the_tribbles_daley_raymond;

import android.graphics.Color;

public class HighHungerNoBureaucrat extends State{

    public HighHungerNoBureaucrat(Game game, MainActivity ma, StateMachine sm) {
        super(game, ma, sm);
        collect = 0;
        backgroundColor = Color.DKGRAY;
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
        //GRADING: DISABLE
        mainActivity.findViewById(R.id.distractBtn).setClickable(false);
        mainActivity.findViewById(R.id.distractBtn).setEnabled(false);
    }

    @Override
    public void onUpdate(){
//        this.game.newTurn();
        doTask();
    }

    @Override
    public void doTask(){
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
