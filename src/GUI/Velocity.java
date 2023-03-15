package GUI;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Velocity {
    private double dx;

    private double dy;

    /**
     * constructor.
     *
     * @param dx speed and direction on x-axis
     * @param dy speed and direction on y-axis
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * @return speed and direction on x-axis
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return speed and direction on y-axis
     */
    public double getDy() {
        return dy;
    }

    /**
     * @return speed of the ball by caluclating it with his x and y
     * velocity vectors.
     */
    public double getSpeed() {
        return Math.sqrt(Math.pow(this.dx, 2) + Math.pow(this.dy, 2));
    }

    /**
     * setting velocity by wanted angle(up is angle 0) and speed.
     *
     * @param angle .
     * @param speed .
     * @return new velocity variable.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //double dx = Math.round(Math.sin(Math.toRadians(angle)) * speed);
        //double dy = Math.round(-Math.cos(Math.toRadians(angle)) * speed);
        double dx = (Math.sin(Math.toRadians(angle)) * speed);
        double dy = (-Math.cos(Math.toRadians(angle)) * speed);
        return new Velocity(dx, dy);
    }

    /**
     * moving the ball(center Point of the ball) according to his speed and direction on y-axis and x-axis.
     *
     * @param p current center point.
     * @return new center Point.
     */
    public Point applyToPoint(Point p) {
        double x = this.dx + p.getX();
        double y = this.dy + p.getY();
        return new Point(x, y);
    }
}
