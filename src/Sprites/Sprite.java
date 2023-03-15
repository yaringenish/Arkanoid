package Sprites;
import biuoop.DrawSurface;
/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     * @param d DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();
}

