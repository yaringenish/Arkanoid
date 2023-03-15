package Animation;
import biuoop.DrawSurface;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class PauseScreen implements Animation {

    private boolean stop;

    /**
     * Constructor.
     */
    public PauseScreen() {
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
