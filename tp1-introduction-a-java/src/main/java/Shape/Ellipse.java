package Shape;

import Point.Point2d;
import java.lang.Math;
import java.util.Collection;
import java.util.EventListener;

public class Ellipse extends BaseShape {
    /** DONE
     * Create a filled Ellipse that is centered on (0, 0)
     * @param widthDiameter Width of the Ellipse
     * @param heightDiameter Height of the Ellipse
     */
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        super();
        Double incrementalFactor = 0.5;
        Double x = -widthDiameter/2.0;
        Double maxWidth = widthDiameter/2.0;
        Double maxHeight = heightDiameter/2.0;

        while ( x <= maxWidth ) {
            Double y = Math.sqrt( (1.0 - Math.pow(x/maxWidth,2.0) ) * Math.pow(maxHeight, 2.0) );
            for (Double i = -y; i <= y; i += incrementalFactor) {
                add(new Point2d(x, i));
            }
            x += incrementalFactor;
        }
    }

    /** DONE
     * Create a filled Ellipse that is centered on (0,0)
     * @param dimensions 2D point containing the width and height of the Ellipse
     */
    public Ellipse(Point2d dimensions) {
        this(dimensions.X(), dimensions.Y());
    }

    /**
     * Create an Ellipse from a given collection of 2D points
     * @param coords Collection of 2D points
     */
    private Ellipse(Collection<Point2d> coords) {
        addAll(coords);
    }

    /** DONE
     * @return Deep Copy of the Ellipse
     */
    @Override
    public Ellipse clone() {
        return new Ellipse(cloneCoords());
    }
}
