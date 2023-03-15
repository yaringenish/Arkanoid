package  Observers;
import Sprites.Ball;
import Sprites.Collidables.Block;
/**
 * Objects that want to be notified of hit events, should implement the HitListener interface,
 * and register themselves with a HitNotifier object using its addHitListener method.
 */
public interface HitListener {
    /**
     * @param beingHit this method is called whenever the beingHit object is hit.
     * @param hitter   is the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
