package Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;
    /**
     * Constructor.
     *
     * @param sensor    is the keyboard of the game.
     * @param key       is the key we are waiting for it.
     * @param animation is the animation we run until the press.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
        this.stop = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);

        if (!sensor.isPressed(key)) {
            isAlreadyPressed = false;
        }

        if (sensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

}
