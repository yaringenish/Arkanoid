package Levels;

import GUI.Backgrounds.Green3Bg;
import GUI.Point;
import GUI.Velocity;
import Sprites.Collidables.Block;
import Sprites.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Green3 implements LevelInformation {
    //BALL
    private static final int NUM_BALLS = 100;
    private static final int SPEED = 5;
    private static final int ANGLES = 360;
    private static final int START_ANGLE = 340;
    private static final int PART = 40;

    //PADDLE
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_SPEED = 5;
    //BLOCKS
    private static final double BLOCK_WIDTH = 50;
    private static final double BLOCK_HEIGHT = 20;
    private static final int LEFTEST_BLOCK = 10;
    private static final int RIGHT_EDGE = 775;
    private static final int STARTING_NUM_OF_BLOCKS = 40;
    private static final int HEIGHT_HIGHEST_BLOCK_LINE = 125;

    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            list.add(Velocity.fromAngleAndSpeed((START_ANGLE + (i * PART)) % ANGLES, SPEED));
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Level Name: Green 3";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(0x006E00);
        return new Green3Bg(color);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Color[] colors = {Color.gray, Color.RED, Color.yellow, Color.BLUE, Color.WHITE};
        int k = LEFTEST_BLOCK;
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j <= k; j++) {
                Point p = new Point(RIGHT_EDGE - BLOCK_WIDTH * j, HEIGHT_HIGHEST_BLOCK_LINE + BLOCK_HEIGHT * i);
                Block b = new Block(p, BLOCK_WIDTH, BLOCK_HEIGHT, colors[i]);
                list.add(b);
            }
            k--;
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return STARTING_NUM_OF_BLOCKS;
    }

}
