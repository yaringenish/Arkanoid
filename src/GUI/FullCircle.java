package GUI;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class FullCircle extends Circle {
    /**
     * Constructor.
     *
     * @param center center of circle
     * @param radius radius of circle
     * @param color  color of circle
     */
    public FullCircle(Point center, int radius, Color color) {
        super(center, radius, color);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillCircle((int) getCenter().getX(), (int) getCenter().getY(), getRadius());
    }
}
