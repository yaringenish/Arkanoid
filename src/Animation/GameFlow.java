package Animation;

import Levels.LevelInformation;

import java.util.List;

import Observers.Counter;
import biuoop.KeyboardSensor;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class GameFlow {
    private AnimationRunner ar;
    private Counter score;
    private KeyboardSensor ks;

    /**
     * Constructor.
     *
     * @param ar    ar is the animation we put.
     * @param score total score in the game.
     * @param ks    ks is the keyboard in the game.
     */
    public GameFlow(AnimationRunner ar, Counter score, KeyboardSensor ks) {
        this.ar = ar;
        this.score = score;
        this.ks = ks;
    }

    /**
     * @param levels is the levels we run in the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean flag = true;
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, score, ar);
            level.initialize();
            while (!level.checkFinish()) {
                level.run();
            }
            if (level.getRemainingBalls().getValue() == 0) {
                flag = false;
                break;
            }
        }
        ar.run(new KeyPressStoppableAnimation(ks, KeyboardSensor.SPACE_KEY, new EndGameScreen(score, flag)));
        ar.getGui().close();

    }
}
