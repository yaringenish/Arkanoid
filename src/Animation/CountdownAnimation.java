package Animation;

import Sprites.SpriteCollection;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class CountdownAnimation implements Animation {
    private static final int FRAME_PER_SECOND = 60;
    private static final int MILLISECONDS = 1000;


    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private int milliseconds;

    /**
     * @param numOfSeconds is the number of seconds it wait until the end of the count.
     * @param countFrom    is the number of seconds it count from.
     * @param gameScreen   is the sprites we should show when we count.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.milliseconds = (int) (numOfSeconds * MILLISECONDS);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        if (this.milliseconds < 0) {
            countFrom--;
            milliseconds = (int) numOfSeconds * MILLISECONDS;
        }
        d.setColor(Color.gray);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, countFrom + "...", 32);
        milliseconds -= FRAME_PER_SECOND;
    }

    @Override
    public boolean shouldStop() {
        if (countFrom == 0) {
            return true;
        }
        return false;
    }
}
