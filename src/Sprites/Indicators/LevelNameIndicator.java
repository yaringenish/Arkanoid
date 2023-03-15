package Sprites.Indicators;

import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class LevelNameIndicator implements Sprite {
    private String name;

    /**
     * Constructor.
     *
     * @param name of the level
     */
    public LevelNameIndicator(String name) {
        this.name = name;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(550, 20, name, 20);
    }

    @Override
    public void timePassed() {
        return;
    }
}
