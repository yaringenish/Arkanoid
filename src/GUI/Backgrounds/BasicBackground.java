package GUI.Backgrounds;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUI.Shape;
import GUI.Point;
import GUI.Rectangle;
import biuoop.DrawSurface;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class BasicBackground implements Background {
    //WALLS
    private static final int TOP_EDGE = 25;
    private static final int BOTTOM_EDGE = 575;
    private static final int LEFT_EDGE = 25;
    private static final int RIGHT_EDGE = 775;


    private List<Shape> shapes;
    private Rectangle rect;


    /**
     * Constructor.
     *
     * @param color of the general background.
     */
    public BasicBackground(Color color) {
        this.rect = new Rectangle(new Point(TOP_EDGE, LEFT_EDGE), RIGHT_EDGE, BOTTOM_EDGE, color);
        shapes = new ArrayList<>();
        shapes.add(rect);
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (Shape shape : shapes) {
            shape.drawOn(d);
        }
    }

    @Override
    public void timePassed() {
        return;
    }
}
