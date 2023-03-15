package Animation;

import GUI.Point;
import GUI.Rectangle;
import Levels.LevelInformation;
import Observers.BallRemover;
import Observers.BlockRemover;
import Observers.Counter;
import Sprites.Ball;
import Sprites.Collidables.Block;
import Sprites.Collidables.Collidable;
import Sprites.Collidables.GameEnvironment;
import Sprites.Collidables.Paddle;
import Sprites.Indicators.LevelNameIndicator;
import Sprites.Indicators.ScoreIndicator;
import Sprites.Sprite;
import Sprites.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;


/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class GameLevel implements Animation {
    private KeyboardSensor keyboard;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Sleeper sleeper;
    private Counter remainingBlocks;
    private Counter remainingBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation level;

    //CONSTS

    //GUI
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int WALLS_WIDTH = 25;
    //WALLS
    private static final int LEFT_EDGE = 25;
    private static final int RIGHT_EDGE = 775;
    //BALL
    private static final int RADIUS = 5;
    private static final Point START_BALL = new Point(400, 540);
    private static final Color COLOR = Color.white;
    //PADDLE
    private static final int PADDLE_HEIGHT = 20;

    /**
     * @param level
     * @param score
     * @param ar
     */
    public GameLevel(LevelInformation level, Counter score, AnimationRunner ar) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.runner = ar;
        this.gui = ar.getGui();
        this.keyboard = gui.getKeyboardSensor();
        this.sleeper = new Sleeper();
        this.remainingBlocks = new Counter();
        this.remainingBalls = new Counter();
        this.score = score;
        this.level = level;
    }

    /**
     * @return sprites list of Game
     */
    public SpriteCollection getSprites() {
        return sprites;
    }

    /**
     * @return collidables list of Game
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * @return number of blocks remain in game.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    /**
     * @return number of balls remain in game.
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }

    /**
     * @return score of the player
     */
    public Counter getScore() {
        return score;
    }

    /**
     * add sprite to sprites list.
     *
     * @param s Sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * add collidable to collidables list.
     *
     * @param c Collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * remove sprite from sprites list.
     *
     * @param s Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * remove collidable from collidables list.
     *
     * @param c Collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * generating the 4 blocks that supposed to be the walls ot the game,
     * and adding them to game.
     */
    public void generateWalls() {
        Block[] walls = new Block[4];
        walls[0] = new Block(new Point(0, 25), 800, 25, Color.gray);
        walls[1] = new Block(new Point(775, 25), 25, 575, Color.gray);
        walls[2] = new Block(new Point(0, 605), 750, 25, Color.cyan);
        walls[3] = new Block(new Point(0, 25), 25, 575, Color.gray);
        for (int i = 0; i < 4; i++) {
            walls[i].addToGame(this);
        }
        walls[2].addHitListener(new BallRemover(this, getRemainingBalls()));
    }

    /**
     * generating blocks and adding them to the game.
     */
    public void generateBlocks() {
        this.remainingBlocks.increase(level.numberOfBlocksToRemove());
        for (int i = 0; i < level.numberOfBlocksToRemove(); i++) {
            Block b = level.blocks().get(i);
            b.addHitListener(new BlockRemover(this, remainingBlocks));
            b.addToGame(this);
        }

    }

    /**
     * generating paddle and adding him to the game.
     */
    public void generatePaddle() {
        Point start = new Point(WIDTH / 2 - level.paddleWidth() / 2, HEIGHT - PADDLE_HEIGHT - WALLS_WIDTH);
        Rectangle rect = new Rectangle(start, level.paddleWidth(), PADDLE_HEIGHT, Color.yellow);
        Paddle p = new Paddle(rect, this.keyboard, level.paddleSpeed(), LEFT_EDGE, RIGHT_EDGE);
        p.addToGame(this);
    }
    /**
     * generating balls and adding them to the game.
     */
    public void generateBall() {
        this.remainingBalls.increase(level.numberOfBalls());
        for (int i = 0; i < level.numberOfBalls(); i++) {
            Ball ball = new Ball(START_BALL, RADIUS, COLOR);
            ball.setVelocity(level.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
        }
    }

    /**
     * generating ScoreIndicator.
     */
    public void generateLiveScore() {
        ScoreIndicator liveScore = new ScoreIndicator(getScore());
        this.addSprite(liveScore);
    }

    /**
     * generating LevelName.
     */
    public void generateLevelName() {
        LevelNameIndicator levelName = new LevelNameIndicator(level.levelName());
        this.addSprite(levelName);
    }

    /**
     * generating BackGround.
     */
    public void generateBackGround() {
        this.addSprite(level.getBackground());
    }

    /**
     * Initialize a new game.
     */
    public void initialize() {
        generateBackGround();
        generatePaddle();
        generateBall();
        generateWalls();
        generateBlocks();
        generateLiveScore();
        generateLevelName();

    }

    /**
     * @return true if theres no balls or blocks otherwise false.
     */
    public Boolean checkFinish() {
        if (this.remainingBlocks.getValue() == 0) {
            return true;
        }
        if (this.remainingBalls.getValue() == 0) {
            return true;
        }
        return false;
    }
    @Override
    public boolean shouldStop() {
        return !this.running;
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            PauseScreen p = new PauseScreen();
            this.runner.run(new KeyPressStoppableAnimation(keyboard, keyboard.SPACE_KEY, p));
            this.runner.run(new CountdownAnimation(2, 3, sprites));
        }
        if (checkFinish()) {
            running = false;
        }
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.running = true;
        this.runner.run(this);
    }
}


