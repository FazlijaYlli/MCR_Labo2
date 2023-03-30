package ch.heig.factories;

import ch.heig.bouncers.BorderCircle;
import ch.heig.bouncers.BorderSquare;
import ch.heig.bouncers.Circle;
import ch.heig.bouncers.Square;

/**
 * Factory for border bouncers.
 *
 * @version 1.0 - 30.03.2023
 */
public class BorderBouncersFactory implements BouncersFactory {
    private static BorderBouncersFactory instance;

    /**
     * Private constructor to prevent multiple instances.
     */
    private BorderBouncersFactory() {
    }

    /**
     * Get the unique instance of a BorderBouncersFactory singleton
     *
     * @return the unique instance of a BorderBouncersFactory singleton
     */
    public static BorderBouncersFactory getInstance() {
        if (instance == null) {
            instance = new BorderBouncersFactory();
        }
        return instance;
    }

    /**
     * Create a new bordered square
     *
     * @return a new bordered square
     */
    @Override
    public Square makeSquare() {
        return new BorderSquare();
    }

    /**
     * Create a new bordered circle
     *
     * @return a new bordered circle
     */
    @Override
    public Circle makeCircle() {
        return new BorderCircle();
    }
}
