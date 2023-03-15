package Levels;

import GUI.Backgrounds.WideEasyBg;
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
public class WideEasy implements LevelInformation {
    //BALL
    private static final int NUM_BALLS = 10;
    private static final int SPEED = 5;
    private static final int ANGLES = 360;
    private static final int START_ANGLE = 330;
    private static final int PART = 5;


    //PADDLE
    private static final int PADDLE_WIDTH = 650;
    private static final int PADDLE_SPEED = 2;

    //BLOCKS
    private static final double BLOCK_WIDTH = 50;
    private static final double BLOCK_HEIGHT = 20;
    private static final int STARTING_NUM_OF_BLOCKS = 15;

    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        int k = 8;
        for (int i = 0; i < numberOfBalls(); i++) {
            if (i <= 4) {
                list.add(Velocity.fromAngleAndSpeed((START_ANGLE + (i * PART)) % ANGLES, SPEED));
            } else {
                list.add(Velocity.fromAngleAndSpeed((START_ANGLE + (k) * PART) % ANGLES, SPEED));
                k++;
            }
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
        return "Level Name: Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new WideEasyBg(Color.white);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Color[] colors = {Color.RED, Color.orange, Color.yellow, Color.green, Color.blue, Color.pink, Color.cyan};
        int k = 7;
        Block b;
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            if (i < 8) {
                b = new Block(new Point(25 + (i * BLOCK_WIDTH), 200), BLOCK_WIDTH, BLOCK_HEIGHT, colors[i / 2]);
            } else {
                b = new Block(new Point(25 + (i * BLOCK_WIDTH), 200), BLOCK_WIDTH, BLOCK_HEIGHT, colors[k / 2]);
                k++;
            }
            list.add(b);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return STARTING_NUM_OF_BLOCKS;
    }

}
