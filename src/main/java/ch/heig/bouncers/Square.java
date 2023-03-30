package ch.heig.bouncers;

import java.awt.geom.Rectangle2D;

/**
 * Abstract class representing a square.
 * It contains the necessary information for filled and empty squares.
 *
 * @version 1.0 - 30.03.2023
 */
public abstract class Square extends Bouncer {
    /**
     * Get the shape of the square.
     *
     * @return the shape of the square
     */
    @Override
    public Rectangle2D.Double getShape() {
        // Creation of the data concerning the rectangle.
        return new Rectangle2D.Double(
                position.getX(), position.getY(), getSize(), getSize()
        );
    }
}
