package GUI;

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.List;

/**
 * ID: 206388092.
 * Name: Yarin Genish
 */
public class Line implements Shape {

    private final Point start;

    private final Point end;

    private Color color;

    /**
     * constructor by points.
     *
     * @param start point.
     * @param end   point.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor by doubles.
     *
     * @param x1 .
     * @param y1 .
     * @param x2 .
     * @param y2 .
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * constructor by doubles with color.
     *
     * @param x1 .
     * @param y1 .
     * @param x2 .
     * @param y2 .
     * @param color of the line.
     */

    public Line(double x1, double y1, double x2, double y2, Color color) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.color = color;
    }

    /**
     * Return the length of the line.
     *
     * @return length
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * Returns the middle point of the line.
     *
     * @return middle point
     */
    public Point middle() {
        double x = (this.start.getX() + this.end.getX()) / 2;
        double y = (this.start.getY() + this.end.getY()) / 2;
        return (new Point(x, y));
    }

    /**
     * Returns the start point of the line.
     *
     * @return start point
     */
    public Point start() {
        return this.start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return end point
     */
    public Point end() {
        return this.end;
    }

    /**
     * calculating the slope between 2 points.
     *
     * @return the slope
     */
    public double slope() {
        // Same Point.
        if (this.start.equals(this.end)) {
            return 0;
        }
        if (this.start.getX() == this.end.getX()) {
            // it will return infinity but in order to know if 2 lines have infinity slope value
            // i need them to be with the same sign (+).
            if (this.start.getY() > this.end.getY()) {
                return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            } else {
                return -1 * (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
            }

        } else {
            //if parallel to x-axis will return 0.
            return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        }
    }

    /**
     * calculating the b in each linear equation: y= a*x + b.
     *
     * @return b.
     */
    public double b() {
        if (this.start.getX() == this.end.getX()) {
            return this.start.getX();
        }
        return this.start.getY() - (this.slope() * this.start.getX());
    }

    /**
     * calculating supposed meeting point between 2 line
     * if only one of the lines are parallel to y-axis.
     *
     * @param l line.
     * @return supposed meeting point
     */
    public Point onlyOneParallelY(Line l) {
        double y = l.slope() * this.start.getX() + l.b();
        return new Point(this.start.getX(), y);
    }

    /**
     * calculating supposed meeting point between 2 line
     * if only one of the lines are parallel to x-axis.
     *
     * @param l line.
     * @return supposed meeting point
     */
    public Point onlyOneParallelX(Line l) {
        double x = (this.b() - l.b()) / l.slope();
        return new Point(x, this.start().getY());
    }

    /**
     * calculating the meeting point between 2 lines.
     *
     * @param l1 second line.
     * @return meeting point
     */
    public Point meeting(Line l1) {
        // vertical check
        if (this.start.getX() == this.end.getX()) {
            return this.onlyOneParallelY(l1);
        }
        if (l1.start.getX() == l1.end.getX()) {
            return l1.onlyOneParallelY(new Line(this.start(), this.end()));
        }
        if (this.start().getY() == this.end().getY()) {
            return this.onlyOneParallelX(l1);
        }
        if (l1.start.getY() == l1.end.getY()) {
            return l1.onlyOneParallelX(new Line(this.start(), this.end()));
        }
        //double x = (l1.b() - this.b()) / (this.slope() - l1.slope());
        //double y = x * this.slope() + this.b();
        double x = Math.round((((l1.b() - this.b()) / (this.slope() - l1.slope()) * 100.0) / 100.0));
        double y = Math.round(((x * this.slope() + this.b()) * 100.0) / 100.0);
        return (new Point(x, y));
    }

    /**
     * Return true if 2 lines are the equals else false.
     *
     * @param l second line.
     * @return true or false
     */
    public boolean equals(Line l) {
        Point start = this.start;
        Point end = this.end;
        return (start.equals(l.start) && end.equals(l.end) || start.equals(l.end) && end.equals(l.start));
    }

    /**
     * checking if both lines are parallel to y-axis.
     *
     * @param l second line.
     * @return true or false
     */
    public boolean parallelY(Line l) {
        return (this.b() == l.b() && this.slope() == l.slope() && this.start.getX() == this.end.getX());
    }

    /**
     * checking if both lines are parallel to x-axis.
     *
     * @param l line
     * @return true or false
     */
    public boolean parallelX(Line l) {
        return this.b() == l.b() && this.slope() == l.slope() && this.start.getY() == this.end.getY();
    }

    /**
     * checking if 2 lines are parallel.
     *
     * @param l line
     * @return true or false
     */
    public boolean twoPointsInOneLine(Line l) {
        return this.slope() == l.slope() && this.b() == l.b();
    }

    /**
     * Checking if 2 lines that are parallel to y-axis intersecting.
     *
     * @param l other line
     * @return true or false
     */
    public boolean checkIntersectionPY(Line l) {
        if (Math.min(this.start.getY(), this.end.getY()) <= Math.min(l.start.getY(), l.end.getY())
                &&
                Math.max(this.start.getY(), this.end.getY()) >= Math.min(l.start.getY(), l.end.getY())) {
            return true;
        }
        return Math.min(this.start.getY(), this.end.getY()) <= Math.max(l.start.getY(), l.end.getY())
                &&
                Math.max(this.start.getY(), this.end.getY()) >= Math.min(l.start.getY(), l.end.getY());
    }

    /**
     * Checking if 2 lines that are parallel to x-axis intersecting.
     *
     * @param l line
     * @return true or false
     */
    public boolean checkIntersectionPX(Line l) {
        if (Math.min(this.start.getX(), this.end.getX()) <= Math.min(l.start.getX(), l.end.getX())
                &&
                Math.max(this.start.getX(), this.end.getX()) >= Math.min(l.start.getX(), l.end.getX())) {
            return true;
        }
        return Math.min(this.start.getX(), this.end.getX()) <= Math.max(l.start.getX(), l.end.getX())
                &&
                Math.max(this.start.getX(), this.end.getX()) >= Math.min(l.start.getX(), l.end.getX());
    }

    /**
     * checking intersections in cases which 2 lines have different slopes.
     *
     * @param l       line.
     * @param meeting meeting point.
     * @return true or false.
     */
    public boolean generalCheckIntersection(Line l, Point meeting) {
        double thisStartMaxX = Math.max(this.start.getX(), this.end.getX());
        double thisStartMaxY = Math.max(this.start.getY(), this.end.getY());
        double lStartMaxX = Math.max(l.start.getX(), l.end.getX());
        double lStartMaxY = Math.max(l.start.getY(), l.end.getY());
        // checking if meetingX is on this Line
        if (meeting.getX() > thisStartMaxX || meeting.getX() < Math.min(this.start.getX(), this.end.getX())) {
            return false;
        }
        // checking if meetingY is on this Line
        if (meeting.getY() > thisStartMaxY || meeting.getY() < Math.min(this.start.getY(), this.end.getY())) {
            return false;
        }
        // checking if meetingX is on l Line
        if (meeting.getX() > lStartMaxX || meeting.getX() < Math.min(l.start.getX(), l.end.getX())) {
            return false;
        }
        // checking if meetingY is on l Line
        if (meeting.getY() > lStartMaxY || meeting.getY() < Math.min(l.start.getY(), l.end.getY())) {
            return false;
        }
        return true;
    }

    /**
     * if both lines parallel to x-axis or to y-axis or both have the same equation and
     * isIntersecting func returned true, this func will check if they have one intersection point
     * or more, if only one the func will return the point otherwise the func will return null.
     *
     * @param l Line.
     * @return the only existing intersection point or null.
     */
    public Point checkEdge(Line l) {
        if (this.start.equals(l.start)) {
            if (this.start().pointOnLine(l) || l.start().pointOnLine(this)) {
                return null;
            }
            return this.start;
        }
        if (this.end.equals(l.start)) {
            if (this.end.pointOnLine(l) || l.start.pointOnLine(this)) {
                return null;
            }
            return this.end;
        }
        if (this.start.equals(l.end)) {
            if (this.start.pointOnLine(l) || l.end.pointOnLine(this)) {
                return null;
            }
            return this.start;
        }
        if (this.end.equals(l.end)) {
            if (this.end.pointOnLine(l) || l.end.pointOnLine(this)) {
                return null;
            }
            return this.end;
        }
        return null;
    }

    /**
     * checking if 2 lines are intersecting.
     *
     * @param l Line.
     * @return true or false
     */
    public boolean isIntersecting(Line l) {
        // Same Lines.
        if (this.equals(l)) {
            return true;
        }
        // Both Lines Parallel Y.
        if (this.parallelY(l)) {
            return this.checkIntersectionPY(l);

        }
        // Both Lines Parallel X.
        if (this.parallelX(l)) {
            return this.checkIntersectionPX(l);
        }
        // Both Lines have the same equation.
        if (this.twoPointsInOneLine(l)) {
            return this.checkIntersectionPX(l) && this.checkIntersectionPY(l);
        }
        // Both Lines parallel but have different equations.
        if (this.slope() == l.slope() && this.b() != l.b()) {
            return false;
        }
        Point meeting = this.meeting(l);
        // Both Lines have different slopes.
        return this.generalCheckIntersection(l, meeting);
    }

    /**
     * Returns meeting point if 2 lines have different slopes 'and' they are intersecting,
     * else returning null.
     *
     * @param l Line
     * @return true or false
     */
    public Point intersectionWith(Line l) {
        if (this.equals(l)) {
            return null;
        }
        if (this.parallelY(l) || this.parallelX(l) || this.twoPointsInOneLine(l)) {
            // checking if they are touching on the tip.
            return this.checkEdge(l);
        }
        if (!this.isIntersecting(l)) {
            return null;
        }
        return this.meeting(l);
    }

    /**
     * calculating which point is closer to the start of the line.
     *
     * @param p1 Point
     * @param p2 Point
     * @return the closest point.
     */
    public Point compareDistanceFromStart(Point p1, Point p2) {
        // first time p1 entering he is null.
        if (p1 == null) {
            return p2;
        }
        //if (p2 == null) {
        //return p1;
        //}
        if (p1.distance(this.start()) > p2.distance(this.start())) {
            return p2;
        }
        return p1;
    }

    /**
     * @param rect Rectangle
     * @return If this line does not intersect with the rectangle, return null.
     * Otherwise, return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        }
        Point closest = null;
        for (Point p : list) {
            closest = compareDistanceFromStart(closest, p);
        }
        return closest;

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.drawLine((int) start.getX(), (int) start.getY(), (int) end.getX(), (int) end.getY());
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
