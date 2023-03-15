package  Observers;
import Sprites.Ball;
import Sprites.Collidables.Block;
/**
 * ScoreTrackingListener is in charge to update the counter of the score when blocks are being hit and removed.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * Constructor.
     *
     * @param scoreCounter is counter of the score.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

    }
}
