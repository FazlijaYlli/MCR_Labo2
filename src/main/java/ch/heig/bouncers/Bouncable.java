package ch.heig.bouncers;

import java.awt.Color;
import java.awt.Shape;

/**
 * Interface for all bouncers
 *
 * @version 1.0 - 30.03.2023
 */
public interface Bouncable {
    /**
     * Draw the bouncer
     */
    void draw();

    /**
     * Move the bouncer accordingly to its existing movement
     */
    void move();

    /**
     * Get the color of the bouncer
     *
     * @return the color of the bouncer
     */
    Color getColor();

    /**
     * Get the shape of the bouncer
     *
     * @return the shape of the bouncer
     */
    Shape getShape();
}
