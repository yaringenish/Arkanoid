package  Observers;
import Animation.GameLevel;
import Sprites.Ball;
import Sprites.Collidables.Block;
/**
 * Ball remover listner.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param gameLevel           .
     * @param remainingBalls .
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        gameLevel.getRemainingBalls().decrease(1);
    }
}
