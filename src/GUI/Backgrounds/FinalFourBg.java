package GUI.Backgrounds;

import java.awt.Color;

import GUI.Line;
import GUI.FullCircle;
import GUI.Point;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class FinalFourBg extends BasicBackground {
    private static final int LEFT_START_X  = 90;
    private static final int LEFT_END_X  = 70;
    private static final int LEFT_START_Y = 400;
    private static final int RIGHT_START_X = 620;
    private static final int RIGHT_END_X  = 600;
    private static final int RIGHT_START_Y = 530;

    /**
     * Constructor.
     *
     * @param color of the general background.
     */
    public FinalFourBg(Color color) {
        super(color);
        Color color1 = new Color(0xC4BDBD);
        Color color2 = new Color(0xA9A9A9);
        Color color3 = new Color(0x8C8B8B);
        //lines
        for (int i = 0; i < 10; i++) {
            super.addShape(new Line(LEFT_START_X + (i * 10), LEFT_START_Y, LEFT_END_X + (i * 10), 600, Color.white));
            super.addShape(new Line(RIGHT_START_X + (i * 10), RIGHT_START_Y, RIGHT_END_X + (i * 10), 600, Color.white));
        }
        //left cloud
        super.addShape(new FullCircle(new Point(90, 400), 20, color1));
        super.addShape(new FullCircle(new Point(110, 420), 25, color1));
        super.addShape(new FullCircle(new Point(130, 390), 25, color2));
        super.addShape(new FullCircle(new Point(150, 420), 20, color3));
        super.addShape(new FullCircle(new Point(170, 400), 30, color3));

        //right cloud
        super.addShape(new FullCircle(new Point(620, 510), 20, color1));
        super.addShape(new FullCircle(new Point(640, 540), 25, color1));
        super.addShape(new FullCircle(new Point(660, 515), 25, color2));
        super.addShape(new FullCircle(new Point(680, 530), 20, color3));
        super.addShape(new FullCircle(new Point(700, 520), 30, color3));

    }
}
