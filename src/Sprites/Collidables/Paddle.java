package Sprites.Collidables;
import Animation.GameLevel;
import GUI.Line;
import GUI.Point;
import GUI.Rectangle;
import GUI.Velocity;
import Sprites.Ball;
import Sprites.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Paddle implements Sprite, Collidable {
    private Rectangle rect;
    private KeyboardSensor keyboard;
    private int moveLength;
    private int leftBorder;
    private int rightBorder;

    //CONSTS
    private static final int TOTAL_DEGREES = 360;
    private static final int START_ANGLE = 300;
    private static final int PART = 30;


    /**
     * constructor.
     *
     * @param rect        Rectangle
     * @param keyboard    KeyboardSensor
     * @param moveLength  of each type of move.
     * @param leftBorder  of the paddle movement
     * @param rightBorder of the paddle movement
     */
    public Paddle(Rectangle rect, KeyboardSensor keyboard, int moveLength, int leftBorder, int rightBorder) {
        this.rect = rect;
        this.keyboard = keyboard;
        this.moveLength = moveLength;
        this.leftBorder = leftBorder;
        this.rightBorder = rightBorder;
    }

    /**
     * @return the KeyboardSensor of paddle.
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * @return the Rectangle of paddle.
     */
    public Rectangle getRect() {
        return rect;
    }

    /**
     * @return the moveLength of paddle.
     */
    public double getMovementLength() {
        return moveLength;
    }

    /**
     * @return the left Border of paddle.
     */
    public int getLeftBorder() {
        return leftBorder;
    }

    /**
     * @return the right Border of paddle.
     */
    public int getRightBorder() {
        return rightBorder;
    }

    /**
     * spliting the width of the paddle to 5 part (the leftest is part 1).
     *
     * @param collisionPoint of the ball and paddle.
     * @return the number of the part conatining the collision point.
     */
    public int getHitRegion(Point collisionPoint) {
        double part = getRect().getWidth() / 5;
        Point left = this.getRect().getUpperLeft();
        // every time the loop extends the line till it reaches to the end of the Paddle.
        for (int i = 1; i <= 5; i++) {
            Point right = new Point(left.getX() + (part * i), left.getY());
            Line l = new Line(left, right);
            if (collisionPoint.pointOnLine(l)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * setting new rectangle for the paddle by new upper left point.
     *
     * @param x double (the paddel's new upper left point).
     */
    public void setPaddleLocation(double x) {
        Rectangle old = this.getCollisionRectangle();
        rect = new Rectangle(new Point(x, old.getUpperLeft().getY()), old.getWidth(), old.getHeight(), old.getColor());
    }

    /**
     * move the paddle one step left.
     */
    public void moveLeft() {
        if (getRect().getStartX() - this.moveLength >= this.leftBorder) {
            setPaddleLocation(getRect().getStartX() - this.moveLength);
        } else {
            setPaddleLocation(getLeftBorder());
        }
    }

    /**
     * move the paddle one step right.
     */
    public void moveRight() {
        if (getRect().getFinishX() + this.moveLength <= this.rightBorder) {
            setPaddleLocation(getRect().getStartX() + this.moveLength);
        } else {
            setPaddleLocation(getRightBorder() - getRect().getWidth());
        }
    }

    /**
     * checks if the user wanted to do any move with the paddle.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draw the paddle's on the DrawSurface.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        getRect().drawRectangle(d, getRect().getColor());
        getRect().drawFrame(d);
    }

    /**
     * @return the Rectangle of paddle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * checking if the ball hit the top line of the ball,
     * if it does , checking on which region of the top line of the paddle it
     * hit and acorrding to the region returning updated velocity of the ball.
     * if did not hit the top line of the paddle, changing it's velocity only
     * in x axis.
     * @param hitter the ball that hits the block.
     * @param collisionPoint  between the paddle and the ball.
     * @param currentVelocity of the ball that hit the paddle.
     * @return updated velocity of the ball after the hit according to where it hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        // hits the top of paddle
        if (collisionPoint.pointOnLine(this.getRect().getTop())) {
            int region = getHitRegion(collisionPoint);
            if (region == 3) {
                return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            }
            double temp = (START_ANGLE + (PART * (region - 1))) % TOTAL_DEGREES;
            Velocity v = currentVelocity.fromAngleAndSpeed(temp, currentVelocity.getSpeed());
            return v;
        }
        // hits the left or right sides of the paddle.
        Line left = this.getRect().getLeft();
        Line right = this.getRect().getRight();
        if (collisionPoint.pointOnLine(left) || collisionPoint.pointOnLine(right)) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        // not hits the paddle.
        return currentVelocity;
    }

    /**
     * add the paddle to the game.
     *
     * @param g Game object
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}
