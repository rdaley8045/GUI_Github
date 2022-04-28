package edu.sdsmt.stop_the_tribbles_daley_raymond;

public class StateMachine {

    public enum StateEnum{LN,LB,MN,MB,HN,HB}
    private StateEnum state = StateEnum.LN;
    private Game gm;
    private MainActivity ma;
    private State[] stateArray = null;

    public StateMachine(Game game, MainActivity ma_mock) {
        stateArray = new State[]{
                new LowHungerNoBureaucrat(game, ma_mock, this),
                new LowHungerWithBureaucrat(game, ma_mock, this),
                new MidHungerNoBureaucrat(game, ma_mock, this),
                new MidHungerWithBureaucrat(game, ma_mock, this),
                new HighHungerNoBureaucrat(game, ma_mock, this),
                new HighHungerWithBureaucrat(game, ma_mock, this)
        };

    }

    public void setState(StateEnum newstate){
//        Exit Activities
        stateArray[this.state.ordinal()].exitActivity();

//        New State
        this.state = newstate;

//        Entry Activities
        stateArray[this.state.ordinal()].entryActivity();
    }

    public int getCollection() { return stateArray[this.state.ordinal()].getCollect();}

    public void eat(){ stateArray[this.state.ordinal()].eat();}

    public String getCurrentStateName() {
        State curState = stateArray[this.state.ordinal()];
        return curState.getClass().getName();
    }

    public void onUpdate() {
        stateArray[state.ordinal()].onUpdate();
    }

    public void collect() {stateArray[this.state.ordinal()].collect();}

    public void distract() {stateArray[this.state.ordinal()].distract();}

    public void newDay() { stateArray[this.state.ordinal()].newDay();}
}
