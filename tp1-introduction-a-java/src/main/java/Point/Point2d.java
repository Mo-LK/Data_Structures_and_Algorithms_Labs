package Point;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    /** DONE
     * 2D Point Constructor from coordinates
     * @param x X coordinate
     * @param y Y coordinate
     */

    public Point2d(Double x, Double y) {
        super(new double[] {x, y});
    }

    /** DONE
     * 2D Point Constructor from vector
     * @param vector Vector containing X and Y coordinates
     */
    public Point2d(Double[] vector) {
        // 0 and 1 are X and Y parameters respectfully
        super(new double[] {vector[0], vector[1]});
    }

    /**
     * @return X coordinate
     */
    public double X() { return vector[X];}

    /**
     * @return Y coordinate
     */
    public double Y() { return vector[Y];}

    /** DONE
     * Translate the point by the given vector
     * @param translateVector The vector by which to translate
     * @return Translated point
     */
    @Override
    public Point2d translate(Double[] translateVector) {
        PointOperator.translate(vector, translateVector);
        return this;
    }

    /** DONE
     * Translate the point by the given 2D Point
     * @param translateVector The 2D Point by which to translate
     * @return Translated point
     */
    public Point2d translate(Point2d translateVector) {
        PointOperator.translate(vector, translateVector.vector);
        return this;
    }

    /** DONE
     * Rotate the point by the given rotation Matrix
     * @param rotationMatrix Matrix by which to rotate
     * @return Rotated point
     */
    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        PointOperator.rotate(vector, rotationMatrix);
        return this;
    }

    /** DONE
     * Rotate the point by the given angle
     * @param angle Angle in radians
     * @return Rotated point
     */
    public Point2d rotate(Double angle) {
        Double x2 = Math.cos(angle) * vector[X] - Math.sin(angle) * vector[Y];
        Double y2 = Math.sin(angle) * vector[X] + Math.cos(angle) * vector[Y];
        vector[X] = x2;
        vector[Y] = y2;
        return this;
    }

    /** DONE
     * Divide the X and Y coordinates of a 2D point by a scalar
     * @param divider Scalar used to divide
     * @return Divided point
     */
    @Override
    public Point2d divide(Double divider) {
        PointOperator.divide(vector, divider);
        return this;
    }

    /** DONE
     * Multiply the X and Y coordinates of a 2D point by a scalar
     * @param multiplier Scalar used to multiply
     * @return Multiplied point
     */
    @Override
    public Point2d multiply(Double multiplier) {
        PointOperator.multiply(vector, multiplier);
        return this;
    }

    /** DONE
     * Add a scalar to the X and Y coordinates of a 2D point
     * @param adder Scalar to add
     * @return Added point
     */
    @Override
    public Point2d add(Double adder) {
        PointOperator.add(vector, adder);
        return this;
    }

    /** DONE
     * @return Deep copy of the 2D point
     */
    @Override
    public Point2d clone() {
        return new Point2d(vector);
    }

    //@return Deep copy of the vector of the 2D point
    public Double[] cloneVector() {
        Double[] deepCopy = new Double[vector.length];
        System.arraycopy(vector, 0, deepCopy, 0, vector.length);
        return deepCopy;
    }
}
