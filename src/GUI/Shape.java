package GUI;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public interface Shape {
    /**
     * @param d draw the shape to there.
     */
     void drawOn(DrawSurface d);

    /**
     * @param color set the shape to be in this color.
     */
     void setColor(Color color);

}
