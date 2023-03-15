import Animation.AnimationRunner;
import Animation.GameFlow;
import Levels.LevelInformation;
import Levels.Green3;
import Levels.DirectHit;
import Levels.FinalFour;
import Levels.WideEasy;
import Observers.Counter;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Ass6Game {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    /**
     * starting the game.
     *
     * @param args
     */
    public static void main(String[] args) {
        int count = 0;
        List<LevelInformation> levels = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            try {
                int level = Integer.parseInt(args[i]);
                switch (level) {
                    case 1:
                        levels.add(new DirectHit());
                        break;
                    case 2:
                        levels.add(new WideEasy());
                        break;
                    case 3:
                        levels.add(new Green3());
                        break;
                    case 4:
                        levels.add(new FinalFour());
                    default:
                        continue;
                }
            } catch (Exception e) {
                count++;
            }
        }
        if (count == args.length) {
            List<LevelInformation> list = Arrays.asList(new DirectHit(), new WideEasy(), new Green3(), new FinalFour());
            levels.addAll(list);
        }
        AnimationRunner ar = new AnimationRunner(new GUI("Arkanoid", WIDTH, HEIGHT));
        GameFlow game = new GameFlow(ar, new Counter(), ar.getGui().getKeyboardSensor());
        game.runLevels(levels);
    }
}
