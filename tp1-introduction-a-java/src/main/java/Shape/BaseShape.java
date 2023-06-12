package Shape;

import Interface.Transform;
import Point.Point2d;

import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

public class BaseShape extends Transform implements Cloneable {
    private final Collection<Point2d> coords;

    /** DONE
     * Create a BaseShape with empty coordinates
     */
    public BaseShape() {
        coords = new ArrayList<Point2d>();
    }

    /** DONE
     * Create a BaseShape from a collection of 2D points
     * @param coords The collection of 2D points
     */
    public BaseShape(Collection<Point2d> coords) {
        this.coords = new ArrayList<Point2d>();
        for (Point2d point : coords)
            this.coords.add(point.clone());
    }

    /** DONE
     * Add a deep copy of the 2D point to the Shape
     * @param coord 2D point to add
     * @return Updated BaseShape
     */
    public BaseShape add(Point2d coord) {
        coords.add(coord.clone());
        return this;
    }

    /** DONE
     * Add a deep copy of the 2D points of the shape to the current shape
     * @param shape Shape to add to the current shape
     * @return Updated BaseShape
     */
    public BaseShape add(BaseShape shape) {
        coords.addAll(shape.cloneCoords());
        return this;
    }

    /** DONE
     * Add a deep copy of the points in the collection to the shape
     * @param coords Collections of point to add
     * @return Updated BaseShape
     */
    public BaseShape addAll(Collection<Point2d> coords) {
        for (Point2d point: coords)
            this.coords.add(point.clone());
        return this;
    }

    /** DONE
     * Remove the 2D point from the shape
     * @param coord Point to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(Point2d coord) {
        coords.remove(coord);
        return this;
    }

    /** DONE
     * Remove the 2D points in the shape from the current shape
     * @param shape Shape containing the points to remove
     * @return Updated BaseShape
     */
    public BaseShape remove(BaseShape shape) {
        for (Point2d point : shape.coords)
            coords.remove(point);
        return this;
    }

    /** DONE
     * Remove the 2D points in the collection from the current shape
     * @param coords Collection of 2D points to remove
     * @return Updated BaseShape
     */
    public BaseShape removeAll(Collection<Point2d> coords) {
        for( Point2d point : coords )
            this.coords.remove(point);
        return this;
    }

    /** DONE
     *  Replace all the coords in a shape with new ones
     * @param newCoords new coords to replace the old one
     * @return Updated BaseShape
     * */
    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        coords.clear();
        coords.addAll(newCoords);
        return this;
    }

    /** DONE
     * Return a DEEP copy of the coordinates of the shape
     * @return DEEP copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> getCoords() {
        Collection<Point2d> deepCopy = new ArrayList<Point2d>();
        deepCopy.addAll(coords);
        return deepCopy;
    }

    /** DONE
     * Create and return a deep copy of the coordinates of the shape
     * @return Deep copy of all coordinates contained by this BaseShape
     */
    public Collection<Point2d> cloneCoords() {
        Collection<Point2d> deepCopyCoords = new ArrayList<Point2d>();
        for (Point2d point : coords)
            deepCopyCoords.add(point.clone());
        return deepCopyCoords;
    }

    public Collection<Double> getCoordinates(Integer positionOfCoordinateInVector) {
        Collection<Double> coordinates = new ArrayList<Double>();
        for( Point2d point : coords ) {
            Double[] vectorCopy = point.cloneVector();
            coordinates.add(vectorCopy[positionOfCoordinateInVector]);
        }
        return coordinates;
    }

    /** DONE
     * @return Maximum X coordinate of the shape
     */
    public Double getMaxX() {
        if (coords.isEmpty()) {
            return -Double.MAX_VALUE;
        }
        Integer positionOfCoordinateInVector = 0;
        Collection<Double> xCoordinates = getCoordinates(positionOfCoordinateInVector);
        return Collections.max(xCoordinates);
    }

    /** DONE
     * @return Maximum Y coordinate of the shape
     */
    public Double getMaxY() {
        if (coords.isEmpty()) {
            return -Double.MAX_VALUE;
        }
        Integer positionOfCoordinateInVector = 1;
        Collection<Double> yCoordinates = getCoordinates(positionOfCoordinateInVector);
        return Collections.max(yCoordinates);
    }

    /** DONE
     * @return 2D Point containing the maximum X and Y coordinates of the shape
     */
    public Point2d getMaxCoord() {
        return new Point2d(getMaxX(), getMaxY());
    }

    /** DONE
     * @return Minimum X coordinate of the shape
     */
    public Double getMinX() {
        if (coords.isEmpty()) {
            return Double.MAX_VALUE;
        }
        Integer positionOfCoordinateInVector = 0;
        Collection<Double> xCoordinates = getCoordinates(positionOfCoordinateInVector);
        return Collections.min(xCoordinates);
    }

    /** DONE
     * @return Minimum Y coordinate of the shape
     */
    public Double getMinY() {
        if (coords.isEmpty()) {
            return Double.MAX_VALUE;
        }
        Integer positionOfCoordinateInVector = 1;
        Collection<Double> yCoordinates = getCoordinates(positionOfCoordinateInVector);
        return Collections.min(yCoordinates);
    }

    /** DONE
     * @return 2D point containing the minimum X and Y coordinate of the shape
     */
    public Point2d getMinCoord() {
        return new Point2d(getMinX(), getMinY());
    }

    /** DONE
     * @return Deep copy of the current shape
     */
    public BaseShape clone() {
        return new BaseShape(cloneCoords());
    }
}