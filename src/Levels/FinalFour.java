package Levels;

import GUI.Backgrounds.FinalFourBg;
import GUI.Point;
import GUI.Velocity;
import Sprites.Collidables.Block;
import Sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class FinalFour implements LevelInformation {
    //BALL
    private static final int NUM_BALLS = 100;
    private static final int SPEED = 5;
    private static final int ANGLES = 360;
    private static final int START_ANGLE = 340;
    private static final int PART = 20;

    //PADDLE
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_SPEED = 5;
    //BLOCKS
    private static final double BLOCK_WIDTH = 50;
    private static final double BLOCK_HEIGHT = 20;
    private static final int STARTING_NUM_OF_BLOCKS = 105;
    private static final int LEFT_EDGE = 25;

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
        return "Level Name: Final Four";
    }

    @Override
    public Sprite getBackground() {
        Color color = new Color(0x4787E3);
        return new FinalFourBg(color);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Color[] colors = {Color.gray, Color.RED, Color.yellow, Color.green, Color.WHITE, Color.pink, Color.cyan};
        for (int i = 0; i < 7; i++) {
            for (int k = 0; k < 15; k++) {
                Point p = new Point(LEFT_EDGE + (BLOCK_WIDTH * k), 100 + (i * BLOCK_HEIGHT));
                Block b = new Block(p, BLOCK_WIDTH, BLOCK_HEIGHT, colors[i]);
                list.add(b);
            }
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return STARTING_NUM_OF_BLOCKS;
    }

}
