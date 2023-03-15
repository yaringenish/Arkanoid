package Animation;
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;
/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class AnimationRunner {
    private GUI gui;

    private static final int FRAME_RATE = 60;
    /**
     * Constructor.
     *
     * @param gui is the gui board in the game.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
    }
    /**
     * @return the GUI in the game.
     */
    public GUI getGui() {
        return gui;
    }
    /**
     * @param animation is the animation we run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / FRAME_RATE;
        Sleeper sleeper = new Sleeper();
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
