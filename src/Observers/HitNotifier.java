package  Observers;
/**
 * The HitNotifier interface indicate that objects that implement it send notifications to
 * a list of listeners when they are being hit.
 */
public interface HitNotifier {
    /**
     * @param hl add it as a listener to hit events.
     */
    void addHitListener(HitListener hl);

    /**
     * @param hl remove it from the list of listeners to hit events.
     */
    void removeHitListener(HitListener hl);
}
