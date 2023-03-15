package  Observers;
import Animation.GameLevel;
import Sprites.Collidables.Block;
import Sprites.Ball;
/**
 * BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain. It also implements HitListener.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Constructor.
     *
     * @param gameLevel          is the game it removes the blocks.
     * @param removedBlocks is the counter of the number of the blocks.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * @return the game of the remover.
     */
    public GameLevel getGame() {
        return gameLevel;
    }

    /**
     * @return the count of the remaining blocks of the remover.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (gameLevel.getRemainingBlocks().getValue() == 1) {
            gameLevel.getScore().increase(5);
            gameLevel.getScore().increase(100);
        } else {
            gameLevel.getScore().increase(5);
        }
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}
