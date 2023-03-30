package ch.heig.bouncers;

import java.awt.geom.Ellipse2D;

/**
 * Abstract class representing a circle.
 * It contains the necessary information for filled and empty circles.
 *
 * @version 1.0 - 30.03.2023
 */
public abstract class Circle extends Bouncer {
    /**
     * Get the shape of the circle.
     *
     * @return the shape of the circle
     */
    public Ellipse2D.Double getShape() {
        // Creation of the data concerning the rectangle.
        return new Ellipse2D.Double(
                position.getX(), position.getY(), getSize(), getSize()
        );
    }
}
