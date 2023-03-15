package GUI.Backgrounds;

import GUI.FullCircle;
import GUI.Point;
import GUI.Rectangle;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Green3Bg extends BasicBackground {

    /**
     * Constructor.
     *
     * @param color of the general background.
     */
    public Green3Bg(Color color) {
        super(color);
        Color color1 = new Color(0x363636);
        Color color2 = new Color(0x424242);
        Color color3 = new Color(0xFFEC62);
        Color color4 = new Color(0xCE5C5C);
        Color color5 = new Color(0xFFD5B2);
        super.addShape(new Rectangle(new Point(60, 450), 90, 150, Color.black));
        super.addShape(new Rectangle(new Point(93, 405), 24, 45, color1));
        super.addShape(new Rectangle(new Point(100, 175), 10, 230, color2));
        super.addShape(new FullCircle(new Point(105, 160), 15, color5));
        super.addShape(new FullCircle(new Point(105, 160), 10, color4));
        super.addShape(new FullCircle(new Point(105, 160), 5, color3));
        for (int i = 0; i < 4; i++) {
            for (int k = 0; k < 5; k++) {
                super.addShape(new Rectangle(new Point(65 + (k * 17), 456 + (i * 36)), 12, 30, Color.WHITE));
            }
        }

    }
}
