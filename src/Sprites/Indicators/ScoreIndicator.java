package Sprites.Indicators;

import GUI.Point;
import GUI.Rectangle;
import Observers.Counter;
import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;


/**
 * ScoreIndicator will be in charge of displaying the current score and it The will hold a reference
 * to the scores counter.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    /**
     * constructor.
     *
     * @param score counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * @return current score.
     */
    public Counter getScore() {
        return score;
    }

    /**
     * drawing on the drawsurface the score box.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        String score = "Score: " + getScore().getValue();
        Color color = new Color(0x9595AF);
        Rectangle scoreBox = new Rectangle(new Point(0, 0), 800, 25, color);
        scoreBox.drawRectangle(d, color);
        d.setColor(Color.BLACK);
        d.drawText(375, 20, score, 20);
    }

    /**
     * unused func part of interface contract.
     */
    public void timePassed() {
        return;
    }
}
