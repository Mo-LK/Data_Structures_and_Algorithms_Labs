package Letter;

import Interface.Transform;
import Point.Point2d;
import Shape.*;
import org.ejml.dense.row.linsol.qr.BaseLinearSolverQrp_DDRM;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventListener;

public final class LetterFactory {
    final static Double maxHeight = 150.0;
    final static Double maxWidth = maxHeight / 2.5;
    final static Double halfMaxHeight = maxHeight / 2;
    final static Double halfMaxWidth = maxWidth / 2;
    final static Double stripeThickness = maxHeight / 8;
    final static Double halfStripeThickness = stripeThickness / 2;


    /** DONE
     * Create the letter A graphically
     * @return BaseShape containing the letter A
     */
    public static BaseShape create_A()  {
        int angle = 10;
        BaseShape leftStripe = new Rectangle(halfStripeThickness, maxHeight);
        leftStripe.rotate(leftStripe.getCoords(), Math.toRadians(angle));

        BaseShape rightStripe = new Rectangle(halfStripeThickness, maxHeight);
        rightStripe.rotate(rightStripe.getCoords(), Math.toRadians(-angle));
        rightStripe.translate(rightStripe.getCoords(), new Point2d(halfMaxWidth, 0.0));

        BaseShape middleStripe = new Rectangle(stripeThickness, halfStripeThickness);
        middleStripe.translate(middleStripe.getCoords(), new Point2d(stripeThickness, 0.0));

        BaseShape letterA = new BaseShape();
        letterA.addAll(leftStripe.getCoords());
        letterA.addAll(rightStripe.getCoords());
        letterA.addAll(middleStripe.getCoords());
        return letterA;
    }

    /** DONE
     * Create the letter B graphically
     * @return BaseShape containing the letter B
     */
    public static BaseShape create_B() {
        BaseShape circleUp = new Circle(halfMaxHeight);
        BaseShape innerEdgeRemoval = new Circle(halfMaxHeight - stripeThickness);
        circleUp.remove(innerEdgeRemoval);
        circleUp.translate(circleUp.getCoords(), new Point2d(halfMaxWidth,halfMaxHeight / 2));

        BaseShape circleDown = circleUp.clone();
        circleDown.translate(circleDown.getCoords(), new Point2d(0.0, -halfMaxHeight));

        BaseShape leftStripe = new Rectangle(stripeThickness, maxHeight);

        BaseShape letterB = new BaseShape();
        letterB.addAll(circleUp.getCoords());
        letterB.addAll(circleDown.getCoords());
        letterB.addAll(leftStripe.getCoords());
        return letterB;
    }

    /** DONE
     * Create the letter C graphically
     * @return BaseShape containing the letter C
     */
    public static BaseShape create_C() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);

        Ellipse innerEllipse = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);

        BaseShape rectangle = new Rectangle(halfMaxWidth + stripeThickness, halfMaxHeight + stripeThickness);
        rectangle.translate(rectangle.getCoords(), new Point2d(stripeThickness,0.0));

        BaseShape letterC = new BaseShape();
        letterC.addAll(ellipse.getCoords());
        letterC.remove(innerEllipse);
        letterC.remove(rectangle);
        return letterC;
    }

    /** DONE
     * Create the letter E graphically
     * @return BaseShape containing the letter E
     */
    public static BaseShape create_E() {
        BaseShape leftStripe = new Rectangle(halfStripeThickness,maxHeight);

        BaseShape topStripe = new Rectangle(maxWidth,halfStripeThickness);
        double adjustment = 5.0;
        topStripe.translate(topStripe.getCoords(), new Point2d(halfMaxWidth - adjustment, adjustment - halfMaxHeight));

        BaseShape middleStripe = topStripe.clone();
        middleStripe.translate(middleStripe.getCoords(), new Point2d(0.0, halfMaxHeight - adjustment));

        BaseShape bottomStripe = middleStripe.clone();
        adjustment = 4.0;
        middleStripe.translate(middleStripe.getCoords(), new Point2d(0.0, halfMaxHeight - adjustment));

        BaseShape letterE = new BaseShape();
        letterE.addAll(leftStripe.getCoords());
        letterE.addAll(topStripe.getCoords());
        letterE.addAll(middleStripe.getCoords());
        letterE.addAll(bottomStripe.getCoords());
        return letterE;
    }

    /** DONE
     * Create the letter H graphically
     * @return BaseShape containing the letter H
     */
    public static BaseShape create_H() {
        BaseShape leftStripe = new Rectangle(stripeThickness,maxHeight);

        BaseShape middleStripe = new Rectangle(maxWidth,stripeThickness);
        middleStripe.translate(middleStripe.getCoords(), new Point2d(halfMaxWidth, 0.0));

        BaseShape rightStripe = leftStripe.clone();
        rightStripe.translate(rightStripe.getCoords(), new Point2d(maxWidth, 0.0));

        BaseShape letterH = new BaseShape();
        letterH.addAll(leftStripe.getCoords());
        letterH.addAll(middleStripe.getCoords());
        letterH.addAll(rightStripe.getCoords());
        return letterH;
    }

    /** DONE
     * Create the letter N graphically
     * @return BaseShape containing the letter N
     */
    public static BaseShape create_N() {
        BaseShape leftStripe = new Rectangle(halfStripeThickness,maxHeight);

        int angle = -20;
        double adjustment = 6.0;
        BaseShape middleStripe = new Rectangle(halfStripeThickness,maxHeight + adjustment);
        middleStripe.rotate(middleStripe.getCoords(), Math.toRadians(angle));
        middleStripe.translate(middleStripe.getCoords(), new Point2d(halfMaxWidth, 0.0));

        BaseShape rightStripe = leftStripe.clone();
        rightStripe.translate(rightStripe.getCoords(), new Point2d(maxWidth, 0.0));

        BaseShape letterN = new BaseShape();
        letterN.addAll(leftStripe.getCoords());
        letterN.addAll(middleStripe.getCoords());
        letterN.addAll(rightStripe.getCoords());
        return letterN;
    }

    /** DONE
     * Create the letter O graphically
     * @return BaseShape containing the letter O
     */
    public static BaseShape create_O() {
        Ellipse ellipse = new Ellipse(maxWidth, maxHeight);
        Ellipse innerEllipse = new Ellipse(maxWidth-stripeThickness, maxHeight-stripeThickness);

        BaseShape letterO = new BaseShape();
        letterO.addAll(ellipse.getCoords());
        letterO.remove(innerEllipse);
        return letterO;
    }
}
