package edu.sdsmt.stop_the_tribbles_daley_raymond;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Random;

public class GameView  extends View {

    Paint tribble;
    Paint bureaucrat;
    boolean bureaucratPresent;
    Game game;

    public GameView(Context context) {
        super(context);
        init();
    }
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        tribble = new Paint(Paint.ANTI_ALIAS_FLAG);
        tribble.setColor(Color.BLACK);
        tribble.setStyle(Paint.Style.FILL);

        bureaucrat = new Paint (Paint.ANTI_ALIAS_FLAG);
        bureaucrat.setColor(Color.RED);
        bureaucrat.setStyle(Paint.Style.STROKE);
        bureaucrat.setStrokeWidth(5);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        Random randInt = new Random();

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        if(bureaucratPresent){
            canvas.drawRect(0,0,getWidth(),getHeight(), bureaucrat);
        }

        if (game.getTribbleCount() <= 20) {
            for (int i = 0; i < 3; i++) {
                int randHeight = randInt.nextInt(height) + 25;
                int randWidth = randInt.nextInt(width) + 25;

                if (randWidth + 25 > width) {
                    randWidth = width - 25;
                }
                if (randHeight + 25 > height) {
                    randHeight = height - 25;
                }

                canvas.drawCircle(randWidth, randHeight, 25, tribble);
            }
        } else if(game.getTribbleCount() > 20 && game.getTribbleCount()  <= 100){
            for (int i = 0; i < 6; i++) {
                int randHeight = randInt.nextInt(height) + 25;
                int randWidth = randInt.nextInt(width) + 25;

                if (randWidth + 25 > width) {
                    randWidth = width - 25;
                }
                if (randHeight + 25 > height) {
                    randHeight = height - 25;
                }

                canvas.drawCircle(randWidth, randHeight, 25, tribble);
            }
        }else if(game.getTribbleCount()  > 100){
            for (int i = 0; i < 10; i++) {
                int randHeight = randInt.nextInt(height) + 25;
                int randWidth = randInt.nextInt(width) + 25;

                if (randWidth + 25 > width) {
                    randWidth = width - 25;
                }
                if (randHeight + 25 > height) {
                    randHeight = height - 25;
                }

                canvas.drawCircle(randWidth, randHeight, 25, tribble);
            }
        }

    }

    public boolean isBorderOn() {
        return true;
    }

    public void setBureaucratPresent(boolean bp) {
        bureaucratPresent = bp;
    }

    public void setGame(Game gm) { game = gm;}
}
