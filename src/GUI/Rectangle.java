package GUI;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Rectangle implements Shape {
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * constructor.
     *
     * @param upperLeft is the upper left point of the rectangle
     * @param width     is the width of the rectangle.
     * @param height    is the height of the rectangle.
     * @param color     is the color of the rectangle
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * constructor without color.
     *
     * @param upperLeft .
     * @param width     .
     * @param height    .
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * @param line .
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> list = new ArrayList<>();

        if (line.isIntersecting(this.getTop()) && line.intersectionWith(this.getTop()) != null) {
            list.add(line.intersectionWith(this.getTop()));
        }
        if (line.isIntersecting(this.getBottom()) && line.intersectionWith(this.getBottom()) != null) {
            list.add(line.intersectionWith(this.getBottom()));
        }
        if (line.isIntersecting(this.getRight()) && line.intersectionWith(this.getRight()) != null) {
            list.add(line.intersectionWith(this.getRight()));
        }
        if (line.isIntersecting(this.getLeft()) && line.intersectionWith(this.getLeft()) != null) {
            list.add(line.intersectionWith(this.getLeft()));
        }
        return list;
    }

    /**
     * @return the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @return the upper left point of the rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @return the color of the rectangle
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return x value of upper left point of rectangle.
     */
    public double getStartX() {
        return this.getUpperLeft().getX();
    }

    /**
     * @return y value of upper left point of rectangle
     */
    public double getStartY() {
        return this.getUpperLeft().getY();
    }

    /**
     * @return x value of down right point of rectangle
     */
    public double getFinishX() {
        return this.getUpperLeft().getX() + this.getWidth();
    }

    /**
     * @return y value of down right point of rectangle
     */
    public double getFinishY() {
        return this.getUpperLeft().getY() + this.getHeight();
    }

    /**
     * @return the top line of the rectangle.
     */
    public Line getTop() {
        return new Line(this.getStartX(), this.getStartY(), this.getFinishX(), this.getStartY());
    }

    /**
     * @return the bottom line of the rectangle.
     */
    public Line getBottom() {
        return new Line(this.getStartX(), this.getFinishY(), this.getFinishX(), this.getFinishY());
    }

    /**
     * @return the right line of the rectangle.
     */
    public Line getRight() {
        return new Line(this.getFinishX(), this.getStartY(), this.getFinishX(), this.getFinishY());
    }

    /**
     * @return the left line of the rectangle.
     */
    public Line getLeft() {
        return new Line(this.getStartX(), this.getStartY(), this.getStartX(), this.getFinishY());
    }

    /**
     * draw a full rectangle.
     *
     * @param d      DrawSurface
     * @param inside color of rectangle.
     */
    public void drawRectangle(DrawSurface d, Color inside) {
        d.setColor(inside);
        d.fillRectangle((int) getStartX(), (int) getStartY(), (int) getWidth(), (int) getHeight());
    }

    /**
     * draw a frame to the rectangle.
     *
     * @param d DrawSurface
     */
    public void drawFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.drawRectangle((int) getStartX(), (int) getStartY(), (int) getWidth(), (int) getHeight());
    }

    @Override
    public void drawOn(DrawSurface d) {
        drawRectangle(d, this.color);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
