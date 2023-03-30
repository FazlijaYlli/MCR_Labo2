package ch.heig.factories;

import ch.heig.bouncers.Circle;
import ch.heig.bouncers.FilledCircle;
import ch.heig.bouncers.FilledSquare;
import ch.heig.bouncers.Square;

/**
 * Factory for filled bouncers.
 *
 * @version 1.0 - 30.03.2023
 */
public class FilledBouncersFactory implements BouncersFactory {
    private static FilledBouncersFactory instance;

    /**
     * Private constructor to prevent multiple instances.
     */
    private FilledBouncersFactory() {
    }

    /**
     * Get the unique instance of a FilledBouncersFactory singleton
     *
     * @return the unique instance of a FilledBouncersFactory singleton
     */
    public static FilledBouncersFactory getInstance() {
        if (instance == null) {
            instance = new FilledBouncersFactory();
        }
        return instance;
    }

    /**
     * Create a new filled square
     *
     * @return a new filled square
     */
    @Override
    public Square makeSquare() {
        return new FilledSquare();
    }

    /**
     * Create a new filled circle
     *
     * @return a new filled circle
     */
    @Override
    public Circle makeCircle() {
        return new FilledCircle();
    }
}
