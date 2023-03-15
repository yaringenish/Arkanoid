package Sprites.Collidables;

import GUI.Point;
import GUI.Velocity;
import GUI.Rectangle;
import Sprites.Ball;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public interface Collidable {

    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param hitter          the ball that hits the object.
     * @param collisionPoint  between the collided object and the ball.
     * @param currentVelocity of the ball that hit the object
     * @return updated velocity of the ball after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
