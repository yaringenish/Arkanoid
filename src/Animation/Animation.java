package Animation;
import biuoop.DrawSurface;
/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public interface Animation {
    /**
     * @param d is the surface that the animation works there.
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return true when the animation should stop and false otherwise.
     */
    boolean shouldStop();
}
