package Sprites;

import Animation.GameLevel;
import GUI.Line;
import GUI.Point;
import GUI.Velocity;
import Sprites.Collidables.CollisionInfo;
import Sprites.Collidables.GameEnvironment;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Ball implements Sprite {
    private Point center;

    private final int r;

    private final java.awt.Color color;

    private Velocity v;

    private GameEnvironment environment;

    /**
     * constructor.
     *
     * @param center .
     * @param r      raduis.
     * @param color  .
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.setVelocity(0, 0);
    }

    /**
     * constructor.
     *
     * @param x     x value of center point
     * @param y     y value of center point
     * @param r     radius
     * @param color .
     */
    public Ball(double x, double y, int r, Color color) {
        this(new Point(x, y), r, color);
    }

    /**
     * @return x value of center point.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * @return y value of center point.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * @return the game environment the ball can move there
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * @param environment the new game environment of the ball
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.environment = environment;
    }

    /**
     * @return the ball radius.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * @return the ball center point.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * @return the ball color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * setting velocity by Velocity variable.
     *
     * @param v Velocity.
     */
    public void setVelocity(Velocity v) {
        this.v = v;

    }

    /**
     * setting velocity by dx(speed and direction) and dy(speed and direction).
     *
     * @param dx speed and direction on x-axis
     * @param dy speed and direction on y-axis
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * @return ball velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * draw the ball on the given drawsurface.
     *
     * @param d drawsurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.getColor());
        d.fillCircle(this.getX(), this.getY(), this.r);
        d.setColor(Color.black);
        d.drawCircle(this.getX(), this.getY(), this.r);
    }

    /**
     * checking if in the next move of the ball ,on the same direction and speed, he will collide with
     * one or more of the collidables. if it does , moving it close to the collision point with the object
     * and setting its new velocity with hit func. Otherwise, moving it with the same velocity.
     */
    public void moveOneStep() {
        CollisionInfo collisionID = this.getEnvironment().getClosestCollision(this.getBallTrajectory());
        if (collisionID != null) {
            this.moveNearCollision(collisionID);
            this.setVelocity(collisionID.collisionObject().hit(this, collisionID.collisionPoint(), this.getVelocity()));
        } else {
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     * notify the ball that it's time to move by activating moveOneStep.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * move the ball to "almost" the hit point, but just slightly before it.
     *
     * @param ci CollisionInfo object holds info about point of collision and info
     *           about the collided object.
     */
    public void moveNearCollision(CollisionInfo ci) {
        Line top = ci.collisionObject().getCollisionRectangle().getTop();
        Line bottom = ci.collisionObject().getCollisionRectangle().getBottom();
        Line right = ci.collisionObject().getCollisionRectangle().getRight();
        Line left = ci.collisionObject().getCollisionRectangle().getLeft();
        int deltaX = 0;
        int deltaY = 0;

        // if the ball not hitting in the corner
        if (ci.collisionPoint().pointOnLine(top)) {
            deltaY = -1 * getSize();
        } else if (ci.collisionPoint().pointOnLine(bottom)) {
            deltaY = getSize();
        } else if (ci.collisionPoint().pointOnLine(right)) {
            deltaX = getSize();
        } else if (ci.collisionPoint().pointOnLine(left)) {
            deltaX = -1 * getSize();
            // if the ball hitting one of corners
        } else {
            // if the ball is under the Collidable.
            if (ci.collisionPoint().getY() > this.center.getY()) {
                deltaY = -1 * getSize();

                // if the ball is above the Collidable.
            } else {
                deltaY = getSize();
            }
            // if the ball is left to the Collidable.
            if (ci.collisionPoint().getX() > this.center.getX()) {
                deltaX = -1 * getSize();

                // if the ball is right to the Collidable
            } else {
                deltaX = getSize();
            }
        }
        this.center = new Point(ci.collisionPoint().getX() + deltaX, ci.collisionPoint().getY() + deltaY);
    }

    /**
     * @return line starting at current location of the ball,
     * and ending where the velocity will take the ball if no collisions will occur
     */
    public Line getBallTrajectory() {
        Point start = getCenter();
        int deltaX = 0;
        int deltaY = 0;
        if (this.getVelocity().getDx() > 0) {
            deltaX += this.getSize();
        } else if (this.getVelocity().getDx() < 0) {
            deltaX -= this.getSize();
        }
        if (this.getVelocity().getDy() > 0) {
            deltaY += this.getSize();
        } else if (getVelocity().getDy() < 0) {
            deltaY -= this.getSize();
        }
        double x = start.getX() + getVelocity().getDx() + deltaX;
        double y = start.getY() + getVelocity().getDy() + deltaY;
        return new Line(start, new Point(x, y));
    }


    /**
     * add the ball to the game.
     *
     * @param gm Game Object
     */
    public void addToGame(GameLevel gm) {
        gm.addSprite(this);
    }

    /**
     * @param gm is the game where we move from the ball.
     */
    public void removeFromGame(GameLevel gm) {
        gm.removeSprite(this);
    }
}



