package GUI;
/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Point {
    public static final double ALLOWED_ERROR = Math.pow(10, -10);

    private double x;

    private double y;

    /**
     * constructor.
     *
     * @param x double
     * @param y double
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * return the distance of this point to the other point.
     *
     * @param p Point
     * @return distance
     */
    public double distance(Point p) {
        return Math.sqrt(((this.x - p.x) * (this.x - p.x)) + ((this.y - p.y) * (this.y - p.y)));
    }

    /**
     * return true is the points are equal, false otherwise.
     *
     * @param p Point
     * @return true or false
     */
    public boolean equals(Point p) {
        return Math.abs(this.x - p.getX()) < ALLOWED_ERROR && Math.abs(this.y - p.getY()) < ALLOWED_ERROR;
    }

    /**
     * Return the x value of this point.
     *
     * @return x
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the y value of this point.
     *
     * @return y
     */
    public double getY() {
        return this.y;
    }

    /**
     * check if point is not on one of the edges of the Line.
     *
     * @param l Line
     * @return True or False
     */

    public boolean onEdge(Line l) {
        double maxX = Math.max(l.start().getX(), l.end().getX());
        double minX = Math.min(l.start().getX(), l.end().getX());
        double maxY = Math.max(l.start().getY(), l.end().getY());
        double minY = Math.min(l.start().getY(), l.end().getY());
        if (this.getX() < maxX || this.getX() > minX) {
            return false;
        }
        if (this.getY() < maxY || this.getY() > minY) {
            return false;
        }
        return true;
    }

    /**
     * check if point is on the wanted line.
     *
     * @param l Line
     * @return true if it does. Otherwise,false.
     */
    public boolean pointOnLine(Line l) {
        double maxX = Math.max(l.start().getX(), l.end().getX());
        double minX = Math.min(l.start().getX(), l.end().getX());
        double maxY = Math.max(l.start().getY(), l.end().getY());
        double minY = Math.min(l.start().getY(), l.end().getY());

        if (this.getX() > maxX || this.getX() < minX) {
            return false;
        }
        if (this.getY() > maxY || this.getY() < minY) {
            return false;
        }
        return true;
    }

    /**
     * @param rect Rectangle
     * @return true if the point on one of the rectangle corners.
     * Otherwise, false.
     */
    public boolean cornerHit(Rectangle rect) {
        if (this.equals(rect.getTop().start()) || this.equals(rect.getTop().end())
                ||
                this.equals(rect.getBottom().start()) || this.equals(rect.getBottom().end())) {
            return true;
        }
        return false;
    }

}
