package Animation;

import biuoop.DrawSurface;
import Observers.Counter;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class EndGameScreen implements Animation {
    private Counter score;
    private boolean flag;
    private boolean stop;

    /**
     * Constructor.
     *
     * @param score score is the final score of the player.
     * @param flag  indicating win or lose
     */
    public EndGameScreen(Counter score, boolean flag) {
        this.score = score;
        this.flag = flag;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (flag) {
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is: " + score.getValue(), 32);
        } else {
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is: " + score.getValue(), 32);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
