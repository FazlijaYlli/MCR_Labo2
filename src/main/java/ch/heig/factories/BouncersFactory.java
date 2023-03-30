package ch.heig.factories;

import ch.heig.bouncers.Circle;
import ch.heig.bouncers.Square;

/**
 * Interface for bouncers factories.
 *
 * @version 1.0 - 30.03.2023
 */
public interface BouncersFactory {
    /**
     * Create a new square
     *
     * @return a new square
     */
    Square makeSquare();

    /**
     * Create a new circle
     *
     * @return a new circle
     */
    Circle makeCircle();
}
