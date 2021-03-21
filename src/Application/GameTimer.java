package Application;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer is involved with managing the countdown function of
 * the game.
 *
 * @author francesjulaton   300410036
 * */

public class GameTimer {
    private Main currentGame;
    private int minutesLeft;
    public int secondsLeft;
    public int period;
    public Timer timer;

    /**
     * Timer constructor
     *
     * @param min minutes left in current game level
     * @param period time between successive tasks performed
     * @param game current game its playing on
     * */
    public GameTimer(Main game ,int min, int period){
        currentGame = game;
        min = this.minutesLeft;
        this.period=period;

        resumeTimer();
    }

    /**
     * Pause timer of game
     * */
    public void pause(){
        timer.cancel();
    }

    /**
     * Resume game timer
     * */
    public void resumeTimer(){
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                if (minutesLeft == 0 && secondsLeft == 0) {
                    cancel();
                    return;
                }

                if (secondsLeft == 0) {
                    secondsLeft = 59;
                    minutesLeft--;
                } else {
                    secondsLeft--;
                }

            }
        };

        timer = new Timer();
        timer.schedule(t, 5000,period);
    }



    /**
     *set time on Timer when game starts
     *
     * @param min minutes left from when game starts
     * @param sec seconds left from when game starts
     * */
    public void setTime(int min, int sec){
        this.minutesLeft=min;
        this.secondsLeft=sec;
    }

    /**
     * Gets the remaining number of seconds in current game
     *
     * @return secondsLeft
     * */
    public int getSeconds(){
        return secondsLeft;
    }

    /**
     *  Gets the remaining number of minutes in current game
     *
     * @return minutesLeft
     * */
    public int getMinutes(){
        return minutesLeft;
    }
}
