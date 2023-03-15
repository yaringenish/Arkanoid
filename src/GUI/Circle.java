package GUI;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Circle implements Shape {
    private Point center;
    private int radius;
    private  Color color;

    /**
     * Constructor.
     *
     * @param center center of circle
     * @param radius radius of circle
     * @param color  color of circle
     */
    public Circle(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    /**
     * @return the center point of the ball
     */
    public Point getCenter() {
        return center;
    }
    /**
     * @return the radius of this circle.
     */
    public int getRadius() {
        return radius;
    }
    /**
     * @return the color of this ball
     */
    public Color getColor() {
        return color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawCircle((int) center.getX(), (int) center.getY(), radius);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
