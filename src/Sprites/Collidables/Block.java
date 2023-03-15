package Sprites.Collidables;

import Animation.GameLevel;
import GUI.Point;
import GUI.Rectangle;
import GUI.Velocity;
import Observers.HitListener;
import Observers.HitNotifier;
import Sprites.Ball;
import Sprites.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rect;
    private List<HitListener> hitListeners;

    /**
     * constructor.
     *
     * @param upperLeft is the upper left point of the Block.
     * @param width     is the width of the Block.
     * @param height    is the height of the Block.
     * @param color     is the color of the Block.
     */
    public Block(Point upperLeft, double width, double height, Color color) {
        this.rect = new Rectangle(upperLeft, width, height, color);
        this.hitListeners = new ArrayList<>();
    }

    /**
     * constructor by Rectangle.
     *
     * @param rect Rectangle
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * @return Block's rectrangle info.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * @return hitListeners of the block.
     */
    public List<HitListener> getHitListeners() {
        return hitListeners;
    }

    /**
     * drawing the block on d DrawSurface with black frame.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        this.getCollisionRectangle().drawRectangle(d, this.rect.getColor());
        this.getCollisionRectangle().drawFrame(d);
    }

    /**
     * part of interface Collidable contract, currently unused.
     */
    @Override
    public void timePassed() {
        return;
    }

    /**
     * adding the block to gm's(Game object) collidables list and sprites list.
     *
     * @param gm Game
     */
    public void addToGame(GameLevel gm) {
        gm.addCollidable(this);
        gm.addSprite(this);
    }

    /**
     * removing the block from gm's(Game object) collidables list and sprites list.
     *
     * @param gm Game
     */
    public void removeFromGame(GameLevel gm) {
        gm.removeCollidable(this);
        gm.removeSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * checking if the ball hitting one of the block corners, if not
     * checking on which of the lines of the Block is the collision point.
     * @param hitter the ball that hits the block.
     * @param collisionPoint  between the block and the ball.
     * @param currentVelocity of the ball that hit the block
     * @return updated velocity of the ball after the hit according to where it hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        // if ball hits the corner
        if (collisionPoint.cornerHit(this.getCollisionRectangle())) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy() * -1);
        }
        // if ball hits the top or bottom of the Block
        if (collisionPoint.pointOnLine(this.getCollisionRectangle().getTop())
                || collisionPoint.pointOnLine(this.getCollisionRectangle().getBottom())) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
        }
        // if ball hits the right or left bound of the Block
        if (collisionPoint.pointOnLine(this.getCollisionRectangle().getRight())
                || collisionPoint.pointOnLine(this.getCollisionRectangle().getLeft())) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        return currentVelocity;
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}

