//        __D__ * Grading tags completed
//        __D__ ** Done in the WYSIWYG
//
//
//        Tier 1: Base Main Activity  15
//        __D__ All items there
//        __D__ Correct starting values/text
//        __D__ Different landscape layouts with all items present
//
//        Tier 2: View and Events  21
//        __D__ Background starts with LTGRAY
//        __D__ Game area has majority of screen
//        __D__ Tribbles are present
//        __D__ Collect works properly with 3 consecutive presses
//        __D__ Reset button works with tribbles, hunger, and score
//
//        Tier 3a: State Machine/Event Rules
//        __D__ Reset button still works with all required values
//        __D__ Eat button affects hunger and tribbles properly
//        __D__ Eat button limited to 3 times a day
//        __D__ New day resets the Eat and increases tribbles
//        __D__ Bureaucrat shows up at correct times.
//        __D__ Distract removes bureaucrat and increases hunger
//        __D__ Distract properly enabled/disabled  *
//        __D__ Collection removes tribbles
//        __D__ Collection affects hunger properly
//        __I__ Game lost/win triggered appropriately *
//        __I__ Dialog boxes correct
//        __D__ Bureaucrat red border when needed *
//
//        Tier 3b: Floating Action  18
//        __I__ All buttons there
//        __I__ Icons set and distinguishable
//        __I__ Opens/closes properly
//        __I__ Tribble color updated
//
//        Tier 3c: Layout ** 26
//        __D__ Custom’s View’s aspect ratio constant
//        __D__ Relative size of objects in view maintained
//        __D__ Works in required screen sizes
//
//        Tier 3d: Game Area Content  12
//        __D__ Correct grey color according to hunger
//        __D__ Correct number of tribbles according to count
//
//        Tier 3e: Rotation 20
//        __I__ Required state saved on rotation
//
//        Tier 4: Extensions  30
//


package edu.sdsmt.stop_the_tribbles_daley_raymond;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Game game;
    StateMachine sm;
    private String score;
    private String tribbles;
    private String hunger;
    private String days;
    private String eat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        sm = new StateMachine(game,this);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        updateUI();
        sm.setState(StateMachine.StateEnum.LN);
        GameView gv = this.findViewById(R.id.gameView);
        gv.setGame(game);
    }


    public void onReset(View view){
        game.reset();
        sm = new StateMachine(game,this);
        setContentView(R.layout.activity_main);
        init();
    }

    public void onEat(View view){
        sm.eat();
        updateUI();
    }

    public void onNewDay(View view){
        sm.newDay();
        updateUI();
    }

    public void onCollect(View view){
        sm.collect();
        updateUI();
    }

    public void onDistract(View view){
        sm.distract();
        updateUI();
    }

    public void updateUI(){
        score = "Score: " + game.getScore();
        ((TextView)findViewById(R.id.scoreCnt)).setText(score);
        tribbles = "Tribbles: " + game.getTribbleCount();
        ((TextView)findViewById(R.id.tribbleCnt)).setText(tribbles);
        hunger = "Hunger: " + game.getHunger();
        ((TextView)findViewById(R.id.hungerCnt)).setText(hunger);
        days = "Days: " + game.getTurns();
        ((TextView)findViewById(R.id.daysCnt)).setText(days);
        eat = "Eat: " + game.getMeals();
        ((Button)findViewById(R.id.eatBtn)).setText(eat);

    }
}