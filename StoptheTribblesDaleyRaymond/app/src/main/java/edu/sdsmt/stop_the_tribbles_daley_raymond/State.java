package edu.sdsmt.stop_the_tribbles_daley_raymond;

public abstract class State {
    protected Game game;
    protected MainActivity mainActivity;
    protected StateMachine stateMachine;
    protected GameView gv;

    protected int collect;
    protected int backgroundColor;

    public State(Game game, MainActivity ma, StateMachine sm){
        this.game = game;
        this.mainActivity = ma;
        this.stateMachine = sm;
    }

    public abstract void exitActivity();
    public abstract void entryActivity();
    public abstract void doTask();
    public abstract void onUpdate();
    public abstract void eat();
    public abstract void distract();
    public abstract void collect();
    public abstract int getCollect();
    public abstract void newDay();
}
