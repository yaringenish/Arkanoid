package Sprites;
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class SpriteCollection {

    private List<Sprite> collection;

    /**
     * Constructor.
     */
    public SpriteCollection() {
        this.collection = new ArrayList<>();
    }

    /**
     * @return the sprites list of SpriteCollection
     */
    public List<Sprite> getSprites() {
        return this.collection;
    }

    /**
     * add sprite to sprties list.
     *
     * @param s sprite
     */
    public void addSprite(Sprite s) {
        this.collection.add(s);
    }

    /**
     * remove sprite to sprites list.
     *
     * @param s sprite
     */
    public void removeSprite(Sprite s) {
        this.collection.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<Sprite>(this.collection);
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.collection) {
            s.drawOn(d);
        }
    }
}
