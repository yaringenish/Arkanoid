package GUI.Backgrounds;

import GUI.FullCircle;
import GUI.Line;
import GUI.Point;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class WideEasyBg extends BasicBackground {
    /**
     * Constructor.
     *
     * @param color of the general background.
     */
    public WideEasyBg(Color color) {
        super(color);
        Color color1 = new Color(0xFFF978);
        Color color2 = new Color(0xFFF566);
        Color color3 = new Color(0xFCEDAB);
        for (int i = 0; i < 700; i = i + 10) {
            super.addShape(new Line(200, 100, i, 200, color3));
        }
        super.addShape(new FullCircle(new Point(200, 100), 60, color3));
        super.addShape(new FullCircle(new Point(200, 100), 50, color2));
        super.addShape(new FullCircle(new Point(200, 100), 40, color1));

    }

}
