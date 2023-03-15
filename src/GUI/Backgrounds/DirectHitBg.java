package GUI.Backgrounds;

import GUI.Circle;
import GUI.Point;
import GUI.Line;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class DirectHitBg extends BasicBackground {
    /**
     * Constructor.
     *
     * @param color of the general background.
     */
    public DirectHitBg(Color color) {
        super(color);
        Color blue = new Color(0x0000C4);
        super.addShape(new Circle(new Point(400, 160), 80, blue));
        super.addShape(new Circle(new Point(400, 160), 120, blue));
        super.addShape(new Circle(new Point(400, 160), 160, blue));
        super.addShape(new Line(220, 160, 580, 160, blue));
        super.addShape(new Line(400, 0, 400, 340, blue));
    }
}
