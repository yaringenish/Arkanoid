package Sprites.Collidables;

import GUI.Line;
import GUI.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class GameEnvironment {
    private List<Collidable> envierment;
    // constructor

    /**
     * constructor.
     */
    public GameEnvironment() {
        this.envierment = new ArrayList<>();
    }

    /**
     * @return GameEnvironment list of collidables.
     */
    public List<Collidable> getEnvierment() {
        return this.envierment;
    }

    /**
     * add the given collidable to the environment.
     *
     * @param c collidable
     */
    public void addCollidable(Collidable c) {
        this.envierment.add(c);
    }


    /**
     * remove the given collidable to the environment.
     *
     * @param c collidable.
     */
    public void removeCollidable(Collidable c) {
        this.envierment.remove(c);
    }

    /**
     * @param trajectory line starting at current location of this object,
     *                   and ending where the velocity will take the object if no collisions will occur.
     * @return information about the closest collision that is going to occur
     * if this objetct will collide with one of the collidables.
     * Otherwise return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        // no coliidables existing.
        if (this.envierment.isEmpty()) {
            return null;
        }
        Point closestPoint = null;
        Collidable closesCollisionObject = null;
        List<Collidable> collidables = new ArrayList<Collidable>(this.envierment);
        for (Collidable c : collidables) {
            // closet collision point between ball and Collidable c.
            Point next = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());

            // if there is any collision with current Coliidable in the list.
            if (next != null) {

                // first check
                if (closestPoint == null) {
                    closestPoint = next;
                    closesCollisionObject = c;

                    // second check and further
                } else if (closestPoint.distance(trajectory.start()) > next.distance(trajectory.start())) {
                    closestPoint = next;
                    closesCollisionObject = c;
                }
            }
        }
        // if wasn't any collision with any of the Coliidables
        if (closestPoint == null) {
            return null;
        }
        return new CollisionInfo(closestPoint, closesCollisionObject);

    }
}
