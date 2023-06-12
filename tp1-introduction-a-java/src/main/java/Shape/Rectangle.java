package Shape;

import Point.Point2d;

import java.util.Collection;

public class Rectangle extends BaseShape {
    /** DONE
     * Create a filled rectangle centered on (0, 0)
     * @param width Width of the rectangle
     * @param height Height of the rectangle
     */
    public Rectangle(Double width, Double height) {
        Double incrementalFactor = 0.5;
        Double maxCoordWidth = width/2.0;
        Double maxCoordHeight = height/2.0;
        for (Double posWidth = -maxCoordWidth; posWidth <= maxCoordWidth; posWidth += incrementalFactor){
            for (Double posHeight = -maxCoordHeight; posHeight <= maxCoordHeight; posHeight += incrementalFactor){
                add(new Point2d(posWidth,posHeight));
            }
        }
    }

    /** DONE
     * Create a filled rectangle centered on (0, 0)
     * @param dimensions 2D point containing the width and height of the rectangle
     */
    public Rectangle(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create a rectangle from a given collection of Points
     * @param coords The collection of 2D points
     */
    private Rectangle(Collection<Point2d> coords) {
        addAll(coords);
    }

    /** DONE
     * @return Deep copy of the rectangle
     */
    @Override
    public Rectangle clone() {
        return new Rectangle(cloneCoords());
    }
}
