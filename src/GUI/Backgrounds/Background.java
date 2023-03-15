package GUI.Backgrounds;

import GUI.Rectangle;
import GUI.Shape;
import Sprites.Sprite;

import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public interface Background extends Sprite {
    /**
     * @return Background size.
     */
    Rectangle getRect();

    /**
     * adding shape objects to list of shapes that each of the backgrounds have.
     *
     * @param shape object.
     */
    void addShape(Shape shape);

    /**
     * @return background list of shapes.
     */
    List<Shape> getShapes();

}
