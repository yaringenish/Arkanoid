package Levels;

import GUI.Backgrounds.DirectHitBg;
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
public class DirectHit implements LevelInformation {
    //BALL
    private static final int NUM_BALLS = 1;
    private static final int SPEED = 5;

    //PADDLE
    private static final int PADDLE_WIDTH = 80;
    private static final int PADDLE_SPEED = 5;
    //BLOCKS
    private static final double BLOCK_WIDTH = 20;
    private static final double BLOCK_HEIGHT = 20;
    private static final int STARTING_NUM_OF_BLOCKS = 1;

    @Override
    public int numberOfBalls() {
        return NUM_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(Velocity.fromAngleAndSpeed(0, SPEED));
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
        return "Level Name: Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new DirectHitBg(Color.black);
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block b = new Block(new Point(390, 150), BLOCK_WIDTH, BLOCK_HEIGHT, Color.RED);
        list.add(b);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return STARTING_NUM_OF_BLOCKS;
    }

}
